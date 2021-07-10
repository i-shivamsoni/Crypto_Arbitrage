package com.example.crypto_arbitrage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crypto_arbitrage.data.GET_CP_AsyncResponse;
import com.example.crypto_arbitrage.data.GET_ER_AsyncResponse;
import com.example.crypto_arbitrage.data.Get_Crypto_Prices;
import com.example.crypto_arbitrage.data.Get_Exchange_Rates;
import com.example.crypto_arbitrage.model.Crypto_Amounts;
import com.example.crypto_arbitrage.model.Crypto_Prices;
import com.example.crypto_arbitrage.model.Exchanges_Rates;

public class MainActivity extends AppCompatActivity {
    EditText fee;
    EditText amt;
    Button cal;
    Crypto_Prices CP_obj;
    Crypto_Amounts CA_obj;
    Exchanges_Rates ER_obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CP_obj = Crypto_Prices.getInstance();
        CA_obj = Crypto_Amounts.getInstance();
        ER_obj = Exchanges_Rates.getInstance();
        fee = findViewById(R.id.editTextfee);
        amt = findViewById(R.id.editTextNumberamt);
        cal = findViewById(R.id.button);
        fetchdata();
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amts = 0.0, fees = 0.0;
                if (TextUtils.isEmpty(amt.getText().toString())) {
                    Log.d("TAG", "onClick: null ");
                } else {
                    amts = Double.parseDouble(amt.getText().toString());
                    CA_obj.setBuy_amount(amts);
                }
                if (TextUtils.isEmpty(fee.getText().toString())) {
                    Log.d("TAG", "onClick: null ");
                } else {
                    fees = Double.parseDouble(fee.getText().toString());
                CA_obj.setFees(fees);
                }
                Log.d("btn", "onClick: "+ CP_obj.getBTC_GBP()+" "+CA_obj.getBuy_amount()+" "+CA_obj.getFees());
                CA_obj.setBTC_Balance(CP_obj.getBTC_GBP(),CA_obj.getBuy_amount(),CA_obj.getFees());
                Log.d("TAG", "onClick: "+CA_obj.getBTC_Balance());
                }
        });
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
