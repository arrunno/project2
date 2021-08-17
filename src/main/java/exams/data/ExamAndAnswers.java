package exams.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamAndAnswers implements Serializable {
    private Exam exam;
    private List<Answer> answers = new ArrayList<>();

    ExamAndAnswers(){}

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

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "ExamAnswers{" +
                "exam=" + exam +
                ", answers=" + answers +
                '}';
    }
}
