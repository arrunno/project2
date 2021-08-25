package exams.service.login;

import exams.data.RegisteredUserInterface;
import exams.data.RegisteredUsers;
import exams.data.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    Map<Integer, RegisteredUserInterface> registeredUsersMap = RegisteredUsers.getRegisteredStudentsMap();

    @Test
    void userIdExistsTest() {
        Assertions.assertTrue(Login.userIdExists(1256, registeredUsersMap));
    }

    @Test
    void userIdDoesNotExistTest() {
        Assertions.assertFalse(Login.userIdExists(998765, registeredUsersMap));
    }

    @Test
    void checkPasswordTest() {
        Student loggedInStudent = Login.getLoggedInStudent(1256, "stuvar");
        Assertions.assertTrue(Login.checkPassword("stuvar", loggedInStudent));
    }

    @Test
    void getLoggedInStudentWhenCredentialsRightTest() {
        Student loggedInStudent = Login.getLoggedInStudent(1257, "stujan");
        Assertions.assertTrue(loggedInStudent.getClass().getSimpleName().equals("Student"));
    }


}