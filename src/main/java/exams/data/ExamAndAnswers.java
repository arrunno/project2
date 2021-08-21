package exams.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamAndAnswers implements Serializable{

    protected Exam exam;
    protected List<Answer> answers = new ArrayList<>();

    public ExamAndAnswers(){
    }

    public ExamAndAnswers(Exam exam, List<Answer> answers) {
        this.exam = exam;
        this.answers = answers;
    }

    public Exam getExam() {
        return exam;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers){ this.answers = answers; }

    @Override
    public String toString() {
        return "ExamAndAnswers{" +
                ", exam=" + exam +
                ", answers=" + answers +
                '}';
    }
}
