package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"Any Category","General Knowledge","Entertainment:Books","Entertainment:Film","Entertainment:Music","Science:Computer","Science:Mathematics","Science & Nature","Sports","History","Politics","Art"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spinner difficultyDropdown = findViewById(R.id.difficulty);
        String[] difficulty = new String[]{"Any Difficulty","Easy","Medium","Hard"};
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  difficulty);
        difficultyDropdown.setAdapter(difficultyAdapter);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String category=String.valueOf(dropdown.getSelectedItem());
                String difficulty=String.valueOf(difficultyDropdown.getSelectedItem());
                String url=getUrl(category,difficulty);
                apiRequest(v.getContext(),url);
                Log.d("test","test");
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