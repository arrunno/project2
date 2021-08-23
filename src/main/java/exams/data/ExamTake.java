package exams.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExamTake implements Serializable{

    protected LocalDateTime examinationDate;
    protected Exam exam;
    protected List<Answer> answers = new ArrayList<>();
    protected int grade;

    public ExamTake(){
    }

    public ExamTake(Exam exam, List<Answer> answers, LocalDateTime examinationDate, int grade) {
        this.examinationDate = examinationDate;
        this.exam = exam;
        this.answers = answers;
        this.grade= grade;
    }

    public Exam getExam() {
        return exam;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public LocalDateTime getExaminationDate() { return this.examinationDate; }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ExamTake{" +
                ", examinationDate=" + examinationDate +
                ", exam=" + exam +
                ", answers=" + answers +
                '}';
    }
}
