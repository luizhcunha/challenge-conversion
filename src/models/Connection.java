package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {
    private final String base_code;
    private final String target_code;
    private final double amount;

    public Connection(Conversor valores) {
        this.base_code = valores.chosenCoin();
        this.target_code = valores.toConvertCoin();
        this.amount = valores.amountPrice();
    }

    public String ConsumoApi() {
        String APIKEY = "6cd078d1f607285278f52f5d";
        String url = STR."https://v6.exchangerate-api.com/v6/\{APIKEY}/pair/\{base_code}/\{target_code}/\{amount}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException();
        }
        var json = response.body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Conversor conversor = gson.fromJson(json, Conversor.class);
        String mensagemUsuario = STR."Resposta: \{amount} \{conversor.chosenCoin()} equivalem a \{conversor.amountPrice()} \{conversor.toConvertCoin()}";
        return mensagemUsuario;
    }
}
