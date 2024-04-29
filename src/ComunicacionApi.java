import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class ComunicacionApi {

    public ConversorDatos ConversorDatos(String monedaInicial, String monedaFinal, double valor) {

        String direccion = "https://v6.exchangerate-api.com/v6/916253b4c669b50af426009d/pair/"+ monedaInicial+"/"+ monedaFinal +"/" + valor;

            HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorDatos.class);
        } catch (Exception e) {
            throw new RuntimeException("Código no encontrado");
        }
    }
}

