package com.example.crypto_arbitrage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.crypto_arbitrage.data.GET_CP_AsyncResponse;
import com.example.crypto_arbitrage.data.Get_Crypto_Prices;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Get_Crypto_Prices  getCryptoPrices = new Get_Crypto_Prices();
        getCryptoPrices.Get_Crypto_Prices(new GET_CP_AsyncResponse() {

            @Override
            public void processFinished() {
                Log.d("tag", "processFinished: ");
            }
        });
    }
}