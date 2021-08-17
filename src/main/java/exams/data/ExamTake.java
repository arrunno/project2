package exams.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamTake implements Serializable{

    protected Student student;
    protected Exam exam;
    protected List<Answer> answers = new ArrayList<>();

    public ExamTake(){
    }

    public ExamTake(Student student, Exam exam, List<Answer> answers) {
        this.student = student;
        this.exam = exam;
        this.answers = answers;
    }

    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "ExamTake{" +
                "student=" + student +
                ", exam=" + exam +
                ", answers=" + answers +
                '}';
    }
}
