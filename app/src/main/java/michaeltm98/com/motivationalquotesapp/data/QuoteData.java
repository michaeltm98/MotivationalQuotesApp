package michaeltm98.com.motivationalquotesapp.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import michaeltm98.com.motivationalquotesapp.controller.AppController;
import michaeltm98.com.motivationalquotesapp.model.Quote;

public class QuoteData {
    private ArrayList<Quote> quoteArrayList = new ArrayList<>();

    public void getQuotes(final QuoteListAsyncResponse callBack) {
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/" +
                "Quotes.json%20";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Stuff: ", response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject quoteObject = response.getJSONObject(i);
                        Quote quote = new Quote();
                        quote.setQuote(quoteObject.getString("quote"));
                        quote.setAuthor(quoteObject.getString("name"));

                        Log.d("Stuff: ", quoteObject.getString("name"));

                        quoteArrayList.add(quote);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(null != callBack) callBack.processFinished(quoteArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Stuff: ", error.toString());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
