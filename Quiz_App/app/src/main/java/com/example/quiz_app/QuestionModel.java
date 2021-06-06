package com.example.quiz_app;

public class QuestionModel {
    private String ques,OptionA,OptionB,OptionC,OptionD;
    QuestionModel(String ques,String OptionA,String OptionB,String OptionC,String OptionD){
        this.ques=ques;
        this.OptionA=OptionA;
        this.OptionB=OptionB;
        this.OptionC=OptionC;
        this.OptionD=OptionD;
    }
    public String getQuestion(){
        return ques;
    }
    public String getOptionA(){
        return OptionA;
    }
    public String getOptionB(){
        return OptionB;
    }
    public String getOptionC(){
        return OptionC;
    }
    public String getOptionD(){
        return OptionD;
    }
}
