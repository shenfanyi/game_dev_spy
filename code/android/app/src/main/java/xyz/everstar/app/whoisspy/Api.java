package xyz.everstar.app.whoisspy;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

class Api {

    /**
     * Volley Request Queue
     */
    private static RequestQueue _requestQueue;
    private static final String BASE_URL = "http://192.168.1.3";
    static void initRequestQueue(Context ctx) {
        _requestQueue = Volley.newRequestQueue(ctx);
        _requestQueue.start();
    }

    private static Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("whoisspy", error.getMessage(), error);
        }
    };

    static void verifyUserId(Response.Listener<String> callbackFunc) {
        StringRequest stringRequest = new StringRequest(
                Method.GET,
                BASE_URL + "/account/verify",
                callbackFunc,
                errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("token", "123");
                return headers;
            }
        };
        _requestQueue.add(stringRequest);
    }

    static void fetchUserId(Response.Listener<JSONObject> callbackFunc) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Method.GET,
                BASE_URL + "/account/register",
                null,
                callbackFunc,
                errorListener);
        _requestQueue.add(jsonObjectRequest);
    }
}
