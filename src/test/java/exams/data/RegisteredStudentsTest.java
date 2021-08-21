package exams.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisteredStudentsTest {

    RegisteredUsers regUsers = new RegisteredUsers();

    @Test
    void registerStudentWithExistingId() {
        boolean registration = regUsers.registerStudent(1256, "Petras", "Petraitis", "slaptazodis");
        assertFalse(registration);
    }

    @Test
    void registerStudentWithUnique() {
        boolean registration = regUsers.registerStudent(999999, "Petras", "Petraitis", "slaptazodis");
        assertTrue(registration);
    }

}