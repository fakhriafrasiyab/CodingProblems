//package com.example.tictactoe.pinescript;
//
//import java.io.IOException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        BinanceClient binanceClient = new BinanceClient();
//        try {
//            List<Candlestick> candlesticks = binanceClient.getCandlestickData("BTCUSDT", "1h", 100);
//
//            // Assume you want to use the close prices as the source
//            double[] closePrices = new double[candlesticks.size()];
//            for (int i = 0; i < candlesticks.size(); i++) {
//                closePrices[i] = candlesticks.get(i).getClose();
//            }
//
//            // Example calculation using the close prices
//            double source = closePrices[closePrices.length - 1];
//            int lengthCorrection = 14;
//            double momentumSmoothing = 0.5;
//            int postSmoothing = 4;
//            String postSmoothingStyle = "WMA";
//
//            double sinc = ltiSinc(source, lengthCorrection, momentumSmoothing);
//            int offset = offset(lengthCorrection);
//
//            double delta = filter(new double[]{(source - sinc) / offset}, postSmoothing, postSmoothingStyle);
//
//            System.out.println("Delta: " + delta);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Add your existing methods here: isEven, sinc, blackman, midPoint, offset, getData, sincCoefficients, toeplitzMatrixValid, convolution, ltiSinc, ema, dema, tema, wma, sma, filter
//}
