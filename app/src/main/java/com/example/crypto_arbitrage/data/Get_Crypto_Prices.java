package com.example.crypto_arbitrage.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.crypto_arbitrage.controller.AppController;

import org.json.JSONObject;

public class Get_Crypto_Prices {
    private String urlc = "https://api.coinbase.com/v2/prices/spot?currency=GBP";
    private String urlw = "https://api.wazirx.com/api/v2/tickers/btcinr";

    public void Get_Crypto_Prices(final GET_CP_AsyncResponse callBack) {
        JsonObjectRequest objectRequestCB = new JsonObjectRequest(Request.Method.GET, urlc, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "onResponse: " + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        JsonObjectRequest objectRequestWRX = new JsonObjectRequest(Request.Method.GET, urlw, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "onResponse: " + response);
                callBack.processFinished();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(objectRequestCB);
        AppController.getInstance().addToRequestQueue(objectRequestWRX);


    }
}
