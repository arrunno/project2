package exams.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamTake implements Serializable{

//    protected Student student;
    protected String examinationDate;
    protected Exam exam;
    protected List<Answer> answers = new ArrayList<>();

    public ExamTake(){
    }

    public ExamTake(/*Student student,*/ Exam exam, List<Answer> answers, String examinationDate) {
//        this.student = student;
        this.examinationDate = examinationDate;
        this.exam = exam;
        this.answers = answers;
    }

    public Exam getExam() {
        return exam;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getExaminationDate() { return this.examinationDate;}

//    public Integer getExamId(){
//        return this.exam.getId();
//    }

    @Override
    public String toString() {
        return "ExamTake{" +
                ", examinationDate=" + examinationDate +
                ", exam=" + exam +
                ", answers=" + answers +
                '}';
    }
}
