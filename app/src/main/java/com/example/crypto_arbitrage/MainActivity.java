package com.example.crypto_arbitrage;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crypto_arbitrage.data.GET_CP_AsyncResponse;
import com.example.crypto_arbitrage.data.GET_ER_AsyncResponse;
import com.example.crypto_arbitrage.data.Get_Crypto_Prices;
import com.example.crypto_arbitrage.data.Get_Exchange_Rates;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchdata();
    }

    private void fetchdata() {
        Get_Crypto_Prices getCryptoPrices = new Get_Crypto_Prices();
        getCryptoPrices.Get_crypto_Prices(new GET_CP_AsyncResponse() {

            @Override
            public void processFinished() {
                Log.d("tag", "processFinished: ");
            }
        });

        Get_Exchange_Rates get_exchange_rates = new Get_Exchange_Rates();
        get_exchange_rates.Get_Exchange_Rates(new GET_ER_AsyncResponse() {
            @Override
            public void processFinished() {

                Log.d("tag", "processFinished: ER");
            }
        });
    }
}
