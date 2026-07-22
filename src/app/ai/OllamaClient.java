package app.ai;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaClient {

    private final HttpClient client = HttpClient.newHttpClient();

    public String generate(String prompt) {

        String json = """
        {
            "model": "llama3.2:latest",
            "prompt": "%s",
            "stream": false
        }
        """.formatted(prompt);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:11434/api/generate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            return getResponse(response.body());
        } catch (Exception e){
            throw new RuntimeException("Erro ao comunicar com o Ollama", e);
        }
    }

    private String getResponse(String jsonBody) {

        String responseStart = "\"response\":\"";
        String responseEnd = "\",\"done\":";

        int responseStartIndex = jsonBody.indexOf(responseStart) + responseStart.length();
        int responseEndIndex = jsonBody.indexOf(responseEnd);

        return jsonBody.substring(
                responseStartIndex,
                responseEndIndex
        );
    }


}
