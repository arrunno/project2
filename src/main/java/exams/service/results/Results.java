package exams.service.results;

import exams.data.Answer;

import java.util.List;

public class Results implements QuestionAnswer{
    private List<Answer> correctAnswers;
    private List<Answer> studentAnswers;

    public Results(List<Answer> correctAnswers, List<Answer> studentAnswers) {
        this.correctAnswers = correctAnswers;
        this.studentAnswers = studentAnswers;
    }

    public int getGrade(){
        int res = 0;
        double ansProportion = 10.0 / correctAnswers.size();
        int ansNum;
        String rightAnswer;
        int numberOfGoodAnswers = 0;
        for(Answer correctAnswer : this.correctAnswers){
            ansNum = correctAnswer.getQuestion();
            rightAnswer = correctAnswer.getAnswer();
            if(rightAnswer.equals(this.getQuestionAnswer(studentAnswers,ansNum))){
                numberOfGoodAnswers ++;
            }
        }
        res = (int) (ansProportion * numberOfGoodAnswers + 0.5);
        return res;
    }

}
