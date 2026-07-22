package app.ai;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaTest {

    public static void main(String[] args) throws Exception {

        OllamaClient client = new OllamaClient();

        String answer = client.generate("Qual o maior continente?");

        System.out.println(answer);

    }
}

