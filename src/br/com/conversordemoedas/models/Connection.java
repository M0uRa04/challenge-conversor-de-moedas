package br.com.conversordemoedas.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public String createConnection (String url) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            }else {
                System.out.println("Falha na solicitação. Código de status: " + response.statusCode());
                return "error";
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("O programa apresentou a seguinte exceção: ");
            System.out.println(e.getMessage());
            return "error";
        }

    }

}
