package exams.service.actions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import exams.service.login.BadPasswordException;
import exams.service.login.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherActionsTest {

    TeacherActions teacherActions = new TeacherActions();

    @Test
    void checkTeachersId() {
        Assertions.assertThrows(UserNotFoundException.class, () -> teacherActions.checkTeachersId(2222));
    }

    @Test
    void checkTeachersPassword() {
        Assertions.assertThrows(BadPasswordException.class, () -> teacherActions.checkTeachersPassword("2222"));
    }

    @Test
    void studentFailedExamWhenGrade0Test(){
        Assertions.assertFalse(TeacherActions.hasStudentPassedExam(0));
    }

    @Test
    void studentPassedExamWhenGrade10Test(){
        Assertions.assertTrue(TeacherActions.hasStudentPassedExam(10));
    }

}