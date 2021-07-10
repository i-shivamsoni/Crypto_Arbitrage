package com.example.crypto_arbitrage;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityres);
        Bundle extra = getIntent().getExtras();
        double gbpinr = 0, amt = 0, btcinr = 0, btcamt = 0,btcgbpinr=0;
        if (extra != null) {
            gbpinr = extra.getDouble("GBP/INR");
            amt = extra.getDouble("amount");
            btcinr = extra.getDouble("btc/inr");
            btcamt = extra.getDouble("btc_amt");
            btcgbpinr = extra.getDouble("btc_pr_gpb");
        }
        TextView convr = findViewById(R.id.textView_gbpinr);
        String hv = getString(R.string.gbp_to_inr_rate);
        hv = hv + gbpinr;
        convr.setText(hv);

        TextView  inramt = findViewById(R.id.textView_amtInr);
        String inra = getString(R.string.amount_in_currency_inr);
        inra = inra+": "+ (int) (gbpinr*amt);
        inramt.setText(inra);

        TextView  inrcamt = findViewById(R.id.textView_amtcinr);
        String inrca = getString(R.string.amount_in_crypto_inr);
        inrca = inrca+": "+ (int) (btcinr * btcamt);
        inrcamt.setText(inrca);

        // calulate the arbi
        double arb = (btcinr - btcgbpinr) * btcamt;
        int arbint = (int)arb;
        Log.d("final", "onCreate: arb "+arbint+" btcinr "+btcinr+" btcgbpinr "+btcgbpinr+" btcamt "+btcamt);
        TextView  abri = findViewById(R.id.TextView_arbi);
        String abris =  getString(R.string.the_arbitrage_is);
        abris = abris+arbint;
        abri.setText(abris);
    }
}