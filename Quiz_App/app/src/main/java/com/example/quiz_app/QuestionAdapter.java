package com.example.quiz_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private List<QuestionModel> list;
    QuestionAdapter(List<QuestionModel> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,
                parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull QuestionAdapter.ViewHolder holder, int position) {
        String Question=list.get(position).getQuestion();
        String A=list.get(position).getOptionA();
        String B=list.get(position).getOptionB();
        String C=list.get(position).getOptionC();
        String D=list.get(position).getOptionD();
        holder.setData(Question,A,B,C,D);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ques;
        private Button optA,optB,optC,optD;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            ques=itemView.findViewById(R.id.question);
            optA=itemView.findViewById(R.id.optA);
            optB=itemView.findViewById(R.id.optB);
            optC=itemView.findViewById(R.id.optC);
            optD=itemView.findViewById(R.id.optD);
        }
        public void setData(String Question,String A,String B,String C,String D){
            ques.setText(Question);
            optA.setText(A);
            optB.setText(B);
            optC.setText(C);
            optD.setText(D);
        }
    }
}
