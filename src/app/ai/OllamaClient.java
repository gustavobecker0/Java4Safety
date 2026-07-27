package app.ai;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaClient {

    private final HttpClient client = HttpClient.newHttpClient();

    public String generate(String prompt) {

        String json = buildRequestBody(prompt);

        HttpRequest request = buildRequest(json);

        String response = sendRequest(request);

        return getResponse(response);
    }

    private String getResponse(String jsonBody) {

        int responseStartIndex = jsonBody.indexOf("\"response\":\"") + ("\"response\":\"").length();
        int responseEndIndex = jsonBody.indexOf("\",\"done\":");

        return unescape(jsonBody.substring(
                responseStartIndex,
                responseEndIndex)
        );
    }

    private String unescape(String text) {
        return text
                .replace("\\n", "\n")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
    }

    private String buildRequestBody(String prompt){

        prompt = escape(prompt);

        return """
        {
            "model": "llama3.2:latest",
            "prompt": "%s",
            "stream": false
        }
        """.formatted(prompt);
    }

    private String escape(String text) {

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n");
    }

    private HttpRequest buildRequest(String json) {

        return HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:11434/api/generate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
    }

    private String sendRequest(HttpRequest request) {

        try {
            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao comunicar com o Ollama", e
            );
        }
    }
}
