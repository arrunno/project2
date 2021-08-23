package exams.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

public class Student implements Serializable, RegisteredUserInterface {
    protected Integer id;
    protected String name;
    protected String surname;
    protected String password;

    public Student() {}

    public Student(Integer id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = DigestUtils.sha256Hex(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
