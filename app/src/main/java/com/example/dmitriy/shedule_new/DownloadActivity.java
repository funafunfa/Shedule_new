package com.example.dmitriy.shedule_new;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DownloadActivity extends ListActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> productsList;

    // url to get all products list
    private static String url_all_products = "http://193.151.106.187/schedule/get_product.php?day_num=3&group=PS_1401";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_DAY = "day";
    private static final String TAG_FIRST = "first";
    private static final String TAG_SECOND = "second";
    private static final String TAG_THIRD = "third";
    private static final String TAG_FOURTH = "fourth";
    private static final String TAG_FIFTH = "fifth";
    private static final String TAG_SIXTH = "sixth";
    private static final String TAG_SEVENTH = "seventh";
    private static final String TAG_EDIT = "edit_time";
    private static final String TAG_GROUP = "group";


    // products JSONArray
    JSONArray products = null;

    /**
     * Background Async Task to Load all product by making HTTP Request
     * */
    class LoadAllProducts extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DownloadActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);

            // Check your log cat for JSON reponse
            Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    products = json.getJSONArray(TAG_PRODUCTS);

                    // looping through All Products
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);

                        // Storing each json item in variable
                        String day = c.getString(TAG_DAY);
                        String first = c.getString(TAG_FIRST);
                        String second = c.getString(TAG_SECOND);
                        String third = c.getString(TAG_THIRD);
                        String fourth = c.getString(TAG_FOURTH);
                        String fifth = c.getString(TAG_FIFTH);
                        String sixth = c.getString(TAG_SIXTH);
                        String seventh = c.getString(TAG_SEVENTH);
                        String edit_time = c.getString(TAG_EDIT);
                        String group_name = c.getString(TAG_GROUP);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                }
            });

        }

    }
}