package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Question extends AppCompatActivity {
    private RecyclerView questionView;
    private TextView question_count,cateogry;
    private Button submit,clr_btn;
    private ImageButton prev,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_question);
        init();
    }
    private void init(){
        questionView=findViewById(R.id.questionView);
        question_count=findViewById(R.id.questionNo);
        cateogry=findViewById(R.id.category);
        submit=findViewById(R.id.submit_btn);
        clr_btn=findViewById(R.id.clr_btn);
        prev=findViewById(R.id.previous);
        next=findViewById(R.id.next);
    }
}