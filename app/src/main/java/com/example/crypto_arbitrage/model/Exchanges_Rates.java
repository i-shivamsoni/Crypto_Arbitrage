package com.example.crypto_arbitrage.model;

import android.app.Application;

public class Exchanges_Rates  {
    private static Exchanges_Rates mInstance;
    private double GBP_INR;
    public static synchronized com.example.crypto_arbitrage.model.Exchanges_Rates  getInstance() {
        if (mInstance == null) {
            mInstance = new Exchanges_Rates();
        }
        return mInstance;
    }

    public Exchanges_Rates() {
    }

    public double getGBP_INR() {
        return GBP_INR;
    }

    public void setGBP_INR(double GBP_INR) {
        this.GBP_INR = GBP_INR;
    }
}
