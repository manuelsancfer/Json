package com.example.manuelsanchezferna.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageview;
    private String imageHttpAddress = "http://unguled-flash.000webhostapp.com/foto.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button top = (Button) findViewById(R.id.top_videos);
        Button vid = (Button) findViewById(R.id.videos);
        imageview = (ImageView) findViewById(R.id.imageView);
        downloadFile(imageHttpAddress);


        textView = (TextView)findViewById(R.id.editText);
    }

    void downloadFile(String imageHttpAddress) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            Bitmap loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
            imageview.setImageBitmap(loadedImage);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error cargando la imagen: "+ e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**public void consulta(View view) {
        makeJsonRequest("https://unguled-flash.000webhostapp.com/Consultas/consulta.php");
    }

    private void makeJsonRequest(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        ConsultaResponse c = gson.fromJson(response.toString(),ConsultaResponse.class);
                        textView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                         textView.setText("Error: " + error.toString());
                    }
                });
        Volley.newRequestQueue(this).add(jsObjRequest);
    }**/
}
