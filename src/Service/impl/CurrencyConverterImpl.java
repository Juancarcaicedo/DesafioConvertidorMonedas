package Service.impl;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Service.Interface.ICurrencyConverter;
import com.google.gson.Gson;

public class CurrencyConverterImpl implements ICurrencyConverter {

    private static final String API_KEY = "3d8e68ef50fbee17deec4f8c";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    @Override
    public double getConversionRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlString = BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error en la solicitud HTTP: " + responseCode);
        }
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        ConversionResponse response = gson.fromJson(reader, ConversionResponse.class);
        reader.close();
        return response.getConversion_rate();
    }

    @Override
    public double convertAmount(String baseCurrency, String targetCurrency, double amount) throws Exception {
        String urlString = BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error en la solicitud HTTP: " + responseCode);
        }

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());

        Gson gson = new Gson();
        ConversionResponse response = gson.fromJson(reader, ConversionResponse.class);
        reader.close();

        return response.getConversion_result();
    }
}
