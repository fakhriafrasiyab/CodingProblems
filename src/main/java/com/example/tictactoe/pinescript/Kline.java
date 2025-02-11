package com.example.tictactoe.pinescript;

public class Kline {
    private long openTime;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private long closeTime;
    private String quoteAssetVolume;
    private int numberOfTrades;
    private String takerBuyBaseAssetVolume;
    private String takerBuyQuoteAssetVolume;

    public Kline(long openTime, String open, String high, String low, String close, String volume,
                 long closeTime, String quoteAssetVolume, int numberOfTrades,
                 String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume) {
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

    // Getters and setters

    @Override
    public String toString() {
        return "Kline{" +
                "openTime=" + openTime +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                ", closeTime=" + closeTime +
                ", quoteAssetVolume='" + quoteAssetVolume + '\'' +
                ", numberOfTrades=" + numberOfTrades +
                ", takerBuyBaseAssetVolume='" + takerBuyBaseAssetVolume + '\'' +
                ", takerBuyQuoteAssetVolume='" + takerBuyQuoteAssetVolume + '\'' +
                '}';
    }
}
