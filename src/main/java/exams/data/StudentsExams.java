package exams.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsExams implements Serializable {
    protected Student student;
    protected Map<Integer, ExamTake> examTakes = new HashMap<>();

    public StudentsExams(){
    }

    public StudentsExams(Student student, Map<Integer, ExamTake> examTakes) {
        this.student = student;
        this.examTakes = examTakes;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setExamTakes(Map<Integer, ExamTake> examTakes) {
        this.examTakes = examTakes;
    }

    public Student getStudent() {
        return this.student;
    }

    public Map<Integer, ExamTake> getExamTakes() {
        return examTakes;
    }

    @Override
    public String toString() {
        return "StudentExams{" +
                "student=" + student +
                ", ExamTakes=" + examTakes +
                '}';
    }
}

