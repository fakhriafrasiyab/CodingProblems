package com.example.tictactoe.pinescript;
import java.util.ArrayList;
import java.util.List;

public class Candlestick {
    private long openTime;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private long closeTime;
    private double quoteAssetVolume;
    private int numberOfTrades;
    private double takerBuyBaseAssetVolume;
    private double takerBuyQuoteAssetVolume;

    public Candlestick(long openTime, double open, double high, double low, double close, double volume, long closeTime, double quoteAssetVolume, int numberOfTrades, double takerBuyBaseAssetVolume, double takerBuyQuoteAssetVolume) {
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public static List<Candlestick> fromRawData(List<List<Object>> rawData) {
        List<Candlestick> candlesticks = new ArrayList<>();
        for (List<Object> entry : rawData) {
            long openTime = ((Number) entry.get(0)).longValue();
            double open = Double.parseDouble(entry.get(1).toString());
            double high = Double.parseDouble(entry.get(2).toString());
            double low = Double.parseDouble(entry.get(3).toString());
            double close = Double.parseDouble(entry.get(4).toString());
            double volume = Double.parseDouble(entry.get(5).toString());
            long closeTime = ((Number) entry.get(6)).longValue();
            double quoteAssetVolume = Double.parseDouble(entry.get(7).toString());
            int numberOfTrades = ((Number) entry.get(8)).intValue();
            double takerBuyBaseAssetVolume = Double.parseDouble(entry.get(9).toString());
            double takerBuyQuoteAssetVolume = Double.parseDouble(entry.get(10).toString());

            candlesticks.add(new Candlestick(openTime, open, high, low, close, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume));
        }
        return candlesticks;
    }

    @Override
    public String toString() {
        return "Candlestick{" +
                "openTime=" + openTime +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", closeTime=" + closeTime +
                ", quoteAssetVolume=" + quoteAssetVolume +
                ", numberOfTrades=" + numberOfTrades +
                ", takerBuyBaseAssetVolume=" + takerBuyBaseAssetVolume +
                ", takerBuyQuoteAssetVolume=" + takerBuyQuoteAssetVolume +
                '}';
    }

    // Getters for fields
    public double getClose() {
        return close;
    }
}