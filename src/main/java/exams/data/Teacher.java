package exams.data;

import org.apache.commons.codec.digest.DigestUtils;

public class Teacher implements RegisteredUserInterface{
    private Integer id;
    private String password;

    public Teacher(Integer id, String password) {
        this.id = id;
        this.password = DigestUtils.sha256Hex(password);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
