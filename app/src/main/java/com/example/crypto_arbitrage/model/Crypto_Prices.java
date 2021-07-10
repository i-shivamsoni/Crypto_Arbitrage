package com.example.crypto_arbitrage.model;

import android.app.Application;

public class Crypto_Prices  {
    private static Crypto_Prices mInstance;
    private double BTC_GBP;
    private double BTC_INR;
    public static synchronized com.example.crypto_arbitrage.model.Crypto_Prices  getInstance() {
        if (mInstance == null) {
            mInstance = new Crypto_Prices();
        }
        return mInstance;
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
