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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Category Drop-Downs setting
        AutoCompleteTextView cat=findViewById(R.id.category_selection);
        ImageView cat_img=findViewById(R.id.drop1);
        String[] items = new String[]{"Any Category","General Knowledge","Entertainment:Books","Entertainment:Film","Entertainment:Music","Science:Computer","Science:Mathematics","Science & Nature","Sports","History","Politics","Art"};
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category=cat.getText().toString();
                String difficulty=difficulty_level.getText().toString();
                String url=getUrl(category,difficulty);
                apiRequest(v.getContext(),url);
                Intent quiz=new Intent(MainActivity.this,Question.class);
                Log.d("test",category);
                startActivity(quiz);
            }
        });
    }

    //utility functions
    void apiRequest(Context context,String url)
    {
        Log.d("url",url);
    }

    String getUrl(String category,String difficulty)
    {
        String url="https://opentdb.com/api.php?amount=10";
        if(!difficulty.equalsIgnoreCase("Any Difficulty"))
            url=url+"&difficulty="+difficulty.toLowerCase();
        switch (category)
        {
            case"General Knowledge":{
                url=url+"&category=9";
                break;
            }
            case "Entertainment:Books":{
                url=url+"&category=10";
                break;
            }
            case "Entertainment:Film":{
                url=url+"&category=11";
                break;
            }
            case "Entertainment:Music":{
                url=url+"&category=12";
                break;
            }
            case "Science:Computer":{
                url=url+"&category=18";
                break;
            }
            case "Science:Mathematics":{
                url=url+"&category=19";
                break;
            }
            case "Science & Nature":{
                url=url+"&category=17";
                break;
            }
            case "Sports":{
                url=url+"&category=21";
                break;
            }
            case "History":{
                url=url+"&category=23";
                break;

            }
            case "Politics":{
                url=url+"&category=24";
                break;

            }
            case "Art":{
                url=url+"&category=25";
                break;

            }
        }

        return url;
    }

}