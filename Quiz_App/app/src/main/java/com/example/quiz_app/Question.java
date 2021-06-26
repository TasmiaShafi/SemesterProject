package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.*;

public class Question extends AppCompatActivity {
    private RecyclerView questionView;
    private TextView question_count,cateogry;
    private Button submit,clr_btn,optA;
    private ImageButton prev,next;
    ArrayList<QuestionModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This code is used to hide Default Title Bar of Project
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();*/
        setContentView(R.layout.activity_question);
        init();
        setData("1/10","GK");
        //Due to this Code the recyclerView ANd items in recyclerview will Appear in your Activity

        QuestionAdapter adapter=new QuestionAdapter(list);
        questionView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        questionView.setLayoutManager(linearLayoutManager);

    }
    private void init(){
        questionView=findViewById(R.id.questionView);
        question_count=findViewById(R.id.questionNo);
        cateogry=findViewById(R.id.category);
        submit=findViewById(R.id.submit_btn);
        clr_btn=findViewById(R.id.clr_btn);
        prev=findViewById(R.id.previous);
        next=findViewById(R.id.next);
        list=new ArrayList<>();
        list.add(new QuestionModel("What is Your Name??","Budhoo","Moto","Pgl","Satiya Hua"));
        list.add(new QuestionModel("What is Your Favourite Color??","Budhoo","Moto","Pgl","Satiya Hua"));
    }
    private void setData(String count,String category){
        question_count.setText(count);
        cateogry.setText(category);
    }


}