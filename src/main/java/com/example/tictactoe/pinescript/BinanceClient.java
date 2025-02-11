package com.example.tictactoe.pinescript;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class BinanceClient {

    private static final String BASE_URL = "https://api.binance.com";
    private static final String KLINE_ENDPOINT = "/api/v3/klines";
    private OkHttpClient client;
    private Gson gson;

    private DateTimeFormatter formatter;


    public BinanceClient() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
    }

    public List<Kline> getKlines(String symbol, String interval, int limit) throws IOException {
        String url = String.format("%s%s?symbol=%s&interval=%s&limit=%d", BASE_URL, KLINE_ENDPOINT, symbol, interval, limit);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            Type listType = new TypeToken<List<List<Object>>>() {}.getType();
            List<List<Object>> rawKlines = gson.fromJson(responseBody, listType);
            List<Kline> klines = new ArrayList<>();
            for (List<Object> rawKline : rawKlines) {
                Kline kline = new Kline(
                        ((Number) rawKline.get(0)).longValue(),
                        (String) rawKline.get(1),
                        (String) rawKline.get(2),
                        (String) rawKline.get(3),
                        (String) rawKline.get(4),
                        (String) rawKline.get(5),
                        ((Number) rawKline.get(6)).longValue(),
                        (String) rawKline.get(7),
                        ((Number) rawKline.get(8)).intValue(),
                        (String) rawKline.get(9),
                        (String) rawKline.get(10)
                );
                klines.add(kline);
            }
            return klines;
        }
    }

//    public static void main(String[] args) {
//        BinanceClient binanceClient = new BinanceClient();
//        try {
//            List<Kline> klines = binanceClient.getKlines("BTCUSDT", "1h", 10);
//            for (Kline kline : klines) {
//                System.out.println(kline);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public List<String> getClosePrices(String symbol, String interval, int limit) throws IOException {
        String url = String.format("%s%s?symbol=%s&interval=%s&limit=%d", BASE_URL, KLINE_ENDPOINT, symbol, interval, limit);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            Type listType = new TypeToken<List<List<Object>>>() {}.getType();
            List<List<Object>> rawKlines = gson.fromJson(responseBody, listType);
            List<String> closePrices = new ArrayList<>();
            for (List<Object> rawKline : rawKlines) {
                String close = (String) rawKline.get(4); // Close price is the fifth element
                closePrices.add(close);
            }
            return closePrices;
        }
    }

//    public static void main(String[] args) {
//        BinanceClient binanceClient = new BinanceClient();
//        try {
//            List<String> closePrices = binanceClient.getClosePrices("BTCUSDT", "1h", 10);
//            for (String closePrice : closePrices) {
//                System.out.println(closePrice);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public List<Object[]> getClosePricesAndTimes(String symbol, String interval, int limit) throws IOException {
//        String url = String.format("%s%s?symbol=%s&interval=%s&limit=%d", BASE_URL, KLINE_ENDPOINT, symbol, interval, limit);
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code " + response);
//            }
//
//            String responseBody = response.body().string();
//            Type listType = new TypeToken<List<List<Object>>>() {}.getType();
//            List<List<Object>> rawKlines = gson.fromJson(responseBody, listType);
//            List<Object[]> closePricesAndTimes = new ArrayList<>();
//            for (List<Object> rawKline : rawKlines) {
//                long closeTime = ((Number) rawKline.get(6)).longValue(); // Close time is the seventh element
//                String closePrice = (String) rawKline.get(4); // Close price is the fifth element
//                closePricesAndTimes.add(new Object[]{closeTime, closePrice});
//            }
//            return closePricesAndTimes;
//        }
//    }

    public List<Object[]> getClosePricesAndTimes(String symbol, String interval, int limit) throws IOException {
        String url = String.format("%s%s?symbol=%s&interval=%s&limit=%d", BASE_URL, KLINE_ENDPOINT, symbol, interval, limit);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            Type listType = new TypeToken<List<List<Object>>>() {}.getType();
            List<List<Object>> rawKlines = gson.fromJson(responseBody, listType);
            List<Object[]> closePricesAndTimes = new ArrayList<>();
            for (List<Object> rawKline : rawKlines) {
                long closeTimeMillis = ((Number) rawKline.get(0)).longValue(); // Close time in milliseconds
                String closePrice = (String) rawKline.get(4); // Close price

                // Convert milliseconds to Instant and format it
                String closeTimeFormatted = formatter.format(Instant.ofEpochMilli(closeTimeMillis));

                closePricesAndTimes.add(new Object[]{closeTimeFormatted, closePrice});
            }
            return closePricesAndTimes;
        }
    }

    public static void main(String[] args) {
        BinanceClient binanceClient = new BinanceClient();
        try {
            List<Object[]> closePricesAndTimes = binanceClient.getClosePricesAndTimes("BTCUSDT", "1h", 10);
            for (Object[] closePriceAndTime : closePricesAndTimes) {
                System.out.println("OPEN Time: " + closePriceAndTime[0] + ", Close Price: " + closePriceAndTime[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
