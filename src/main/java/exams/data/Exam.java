package exams.data;

import java.io.Serializable;

public class Exam implements Serializable {
    protected Integer id;
    protected String courseName;
    protected String type;

    public Exam(){}

    public Exam(Integer id, String courseName, String type) {
        this.id = id;
        this.courseName = courseName;
        this.type = type;
//        this.examinationDate = examinationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
