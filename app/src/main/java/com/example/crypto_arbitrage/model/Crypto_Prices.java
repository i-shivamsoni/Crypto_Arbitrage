package com.example.crypto_arbitrage.model;

import android.app.Application;

public class Crypto_Prices extends Application {
    private static Crypto_Prices mInstance;
    private double BTC_GBP;
    private double BTC_INR;
    public static synchronized com.example.crypto_arbitrage.model.Crypto_Prices  getInstance() {

        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public Crypto_Prices() {
    }

    public double getBTC_GBP() {
        return BTC_GBP;
    }

    public void setBTC_GBP(double BTC_GBP) {
        this.BTC_GBP = BTC_GBP;
    }

    public double getBTC_INR() {
        return BTC_INR;
    }

    public void setBTC_INR(double BTC_INR) {
        this.BTC_INR = BTC_INR;
    }
}
