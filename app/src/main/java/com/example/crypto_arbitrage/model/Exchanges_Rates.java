package com.example.crypto_arbitrage.model;

import android.app.Application;

public class Exchanges_Rates extends Application {
    private static Exchanges_Rates mInstance;
    private double GBP_INR;
    public static synchronized com.example.crypto_arbitrage.model.Exchanges_Rates  getInstance() {

        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
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
