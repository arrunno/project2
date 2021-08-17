package exams.service.results;

import exams.data.Answer;

import java.util.List;

public interface QuestionAnswer {
    default public String getQuestionAnswer(List<Answer> answers, int questionNumber){
        String res ="";
        for(Answer answer : answers){
            if(answer.getQuestion() == questionNumber)
                res = answer.getAnswer();
        }
        return res;
    }
}
