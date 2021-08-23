package exams.data;

import java.io.Serializable;

public class ExamStudentGrade implements Serializable {
    private Exam exam;
    private Student student;
    private int grade;

    public ExamStudentGrade(){};

    public ExamStudentGrade(Exam exam, Student student, int grade) {
        this.exam = exam;
        this.student = student;
        this.grade = grade;
    }

    public Exam getExam() {
        return exam;
    }

    public Student getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }
}
