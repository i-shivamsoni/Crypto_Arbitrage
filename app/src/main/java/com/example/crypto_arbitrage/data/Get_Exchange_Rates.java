package com.example.crypto_arbitrage.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.crypto_arbitrage.controller.AppController;
import com.example.crypto_arbitrage.model.Exchanges_Rates;

import org.json.JSONException;
import org.json.JSONObject;

public class Get_Exchange_Rates {
    private String url = "https://free.currconv.com/api/v7/convert?q=GBP_INR&compact=ultra&apiKey=e5f93be173b5fee6cb32";
    public void Get_Exchange_Rates(final GET_ER_AsyncResponse callBack) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAGc", "onResponse: "+response);
                Exchanges_Rates obj = new Exchanges_Rates();
                try {
                    obj.setGBP_INR(response.getDouble("GBP_INR"));
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
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
