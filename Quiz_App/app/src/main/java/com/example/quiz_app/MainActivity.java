package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
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
;
        //Category Drop-Downs setting
        AutoCompleteTextView cat=findViewById(R.id.category_selection);
        ImageView cat_img=findViewById(R.id.drop1);
        String[] items = new String[]{"Any Category","Linux","SQL","CODE","Docker","Bash","DevOps","CMS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        cat.setAdapter(adapter);

        //difficulty level drop down Setting
        AutoCompleteTextView difficulty_level=findViewById(R.id.difficulty_level);
        ImageView diff_img=findViewById(R.id.drop2);
        String[] diff_dropdown = new String[]{"Any Difficulty","Easy","Medium","Hard"};
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,  diff_dropdown);
        difficulty_level.setAdapter(difficultyAdapter);

        //ImageViews Click Listener
        cat_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cat.showDropDown();
            }
        });
        diff_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty_level.showDropDown();
            }
        });

        //button Click Event

        Button btn=findViewById(R.id.button);
        requestQueue= Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String category=cat.getText().toString();
                String difficulty=difficulty_level.getText().toString();
                String url=getUrl(category,difficulty);
                Log.d("url",url);
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