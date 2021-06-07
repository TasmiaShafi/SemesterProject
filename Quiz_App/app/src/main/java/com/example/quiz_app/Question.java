package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Question extends AppCompatActivity {
    private RecyclerView questionView;
    private TextView question_count,cateogry;
    private Button submit,clr_btn;
    private ImageButton prev,next;
    ArrayList<QuestionModel>list;
    public static JSONArray response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This code is used to hide Default Title Bar of Project
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_question);
        init();
        createObjects();
        //Due to this Code the recyclerView ANd items in recyclerview will Appear in your Activity

        QuestionAdapter adapter=new QuestionAdapter(list);
        questionView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        questionView.setLayoutManager(linearLayoutManager);
    }
    private void init(){
        questionView=findViewById(R.id.questionView);
        submit=findViewById(R.id.submit_btn);
        clr_btn=findViewById(R.id.clr_btn);
        prev=findViewById(R.id.previous);
        next=findViewById(R.id.next);
    }

    private void createObjects()
    {
        list=new ArrayList<>();
        question_count=findViewById(R.id.questionNo);
        cateogry=findViewById(R.id.category);
        try {
            for(int i=0;i<10;i++)
            {
                question_count.setText(i+"/10");
                JSONObject object=response.getJSONObject(i);
                cateogry.setText(object.getString("category"));
                JSONObject options=object.getJSONObject("answers");
                String correct_asnwers=object.getString("correct_answer");
                list.add(new QuestionModel(object.getString("question"),options.getString("answer_a"),options.getString("answer_b"),options.getString("answer_c"),options.getString("answer_d")));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}