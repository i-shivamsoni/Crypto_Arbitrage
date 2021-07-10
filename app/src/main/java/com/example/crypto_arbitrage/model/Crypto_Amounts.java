package com.example.crypto_arbitrage.model;

import android.app.Application;

public class Crypto_Amounts extends Application {
    private static Crypto_Amounts mInstance;
    private double buy_amount;
    private double BTC_Balance;
    private double fees;
    public static synchronized com.example.crypto_arbitrage.model.Crypto_Amounts  getInstance() {

        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public Crypto_Amounts() {
        fees = 0;
        buy_amount = 0;
        BTC_Balance = 0;
    }

    public double cal_amt(double gbp_price, double gbp_amount, double fee) {
        return ((gbp_amount / gbp_price) - fee);
    }

    public double getBuy_amount() {
        return buy_amount;
    }

    public void setBuy_amount(double buy_amount) {
        this.buy_amount = buy_amount;
    }

    public double getBTC_Balance() {
        return BTC_Balance;
    }

    public void setBTC_Balance(double gbp_price, double gbp_amount, double fee) {
       BTC_Balance = (gbp_amount / gbp_price) - fee;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
