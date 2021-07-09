package com.example.crypto_arbitrage.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.crypto_arbitrage.controller.AppController;
import com.example.crypto_arbitrage.model.Crypto_Prices;

import org.json.JSONException;
import org.json.JSONObject;

public class Get_Crypto_Prices {
    JsonObjectRequest objectRequestWRX;
    JsonObjectRequest objectRequestCB;
    private String urlc = "https://api.coinbase.com/v2/prices/spot?currency=GBP";
    private String urlw = "https://api.wazirx.com/api/v2/tickers/btcinr";
    Crypto_Prices obj = new Crypto_Prices();

    public void Get_crypto_Prices(final GET_CP_AsyncResponse callBack) {

        objectRequestCB = new JsonObjectRequest(Request.Method.GET, urlc, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "onResponse: " + response);
                try {
                    Log.d("TAG", "onResponse: " + response.getJSONObject("data").getDouble("amount"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                secondServiceCall( urlw);
            }

            private void secondServiceCall(String urlw) {
                objectRequestWRX = new JsonObjectRequest(Request.Method.GET, urlw, (JSONObject) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", "onResponse: " + response);
                        try {
                            Log.d("TAG", "onResponse: " + response.getJSONObject("ticker").getDouble("buy"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callBack.processFinished();

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                AppController.getInstance().addToRequestQueue(objectRequestWRX);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(objectRequestCB);
    }
}



