package exams.data;

import java.io.Serializable;
import java.util.List;

public class ExamsStudentsGrades implements Serializable {
    private List<ExamStudentGrade> exams;

    public ExamsStudentsGrades(List<ExamStudentGrade> exams) {
        this.exams = exams;
    }

    public List<ExamStudentGrade> getExams() {
        return exams;
    }
}
