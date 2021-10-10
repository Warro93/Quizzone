package com.example.quizzone;

public class Quiz {

    private final String question;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final String answer4;
    private int trueAnswer;

    public Quiz(String question, String answer1, String answer2, String answer3, String answer4, int trueAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        if(trueAnswer > 0 && trueAnswer < 5)
            this.trueAnswer = trueAnswer;
        else
            System.out.println("Valore inserito non compreso tra 1 e 4!");
    }

    public boolean isCorrectAnswer(int myAnswer){
        return trueAnswer == myAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }
}
