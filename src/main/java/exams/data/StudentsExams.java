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

    public StudentsExams(Student student, List<ExamTake> examTakesList) {
        this.student = student;
//        this.examTakes = examTakes;
//        this.examTakes = examTakes.stream()
//                .collect(Collectors.toMap(examTake -> examTake.getExam().getId(), Add examTake -> examTake));
        for(ExamTake el : examTakesList){
            examTakes.put(el.getExam().getId(), el);
        }

        System.out.println(this.examTakes);
    }

    public Student getStudent() {
        return this.student;
    }

    public Map<Integer, ExamTake> getExamTakes() {
        return examTakes;
    }

    @Override
    public String toString() {
        return "ExamTake{" +
                "student=" + student +
//                ", examTakes=" + examTakes +
                ", takes=" + examTakes +
                '}';
    }
}

