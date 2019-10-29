package com.example.quizapp;

import java.util.List;

public class Quiz {
    private int score;
    private List<Question> questions;
    private int currentQuestion;

    public Quiz(List<Question> questions){
        this.questions = questions;
        currentQuestion = 0;
    }

    public String nextQuestion() {
        currentQuestion++;
      return questions.get(currentQuestion).getQuestion();
}



    public boolean checkAnswer(boolean selectedAnswer) {
        return questions.get(currentQuestion).getAnswer() == selectedAnswer;
    }



    public boolean hasMoreQuestions() {
        if (questions.size() - 1 > currentQuestion)
            return true;
        else
            return false;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List getQuestionList() {
        return questions;
    }

    public void setQuestionList(List questionList) {
        this.questions = questionList;
    }


    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void score(){
        score++;
    }


    public String getQuestionText(){
        return questions.get(currentQuestion).getQuestion();
    }


}