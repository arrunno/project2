package exams.data;

import java.io.Serializable;

public class Answer implements Serializable {
    private int question;
    private String answer;

    public Answer(){}

    public Answer(int question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}
