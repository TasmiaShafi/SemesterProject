package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"Any Category","Linux","SQL","CODE","Docker","Bash","DevOps","CMS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spinner difficultyDropdown = findViewById(R.id.difficulty);
        String[] difficulty = new String[]{"Any Difficulty","Easy","Medium","Hard"};
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  difficulty);
        difficultyDropdown.setAdapter(difficultyAdapter);
        Button btn=findViewById(R.id.button);
        requestQueue= Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category=String.valueOf(dropdown.getSelectedItem());
                String difficulty=String.valueOf(difficultyDropdown.getSelectedItem());
                String url=getUrl(category,difficulty);
                apiRequest(v.getContext(),url);
            }
        });
    }

    //utility functions
    void apiRequest(Context context,String url)
    {
        JsonArrayRequest arrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                intent=new Intent(context,Question.class);
                Question.response=response;
                context.startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("JsonError","Some error",error);
            }
        });

        requestQueue.add(arrayRequest);

    }

    String getUrl(String category,String difficulty)
    {
        String url="https://quizapi.io/api/v1/questions?apiKey=jnRVQh23Gl1YUK1lCakWqb1esoODueSiol1ubscB&limit=10";
        if(!difficulty.equalsIgnoreCase("Any Difficulty"))
            url=url+"&difficulty="+difficulty;
        if(!category.equalsIgnoreCase("Any Category"))
            url=url+"&category="+category;


        return url;
    }

}