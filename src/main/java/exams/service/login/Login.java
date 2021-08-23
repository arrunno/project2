package exams.service.login;

import exams.data.RegisteredUserInterface;
import exams.data.RegisteredUsers;
import exams.data.Student;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

public class Login {

    public  static boolean userIdExists(int id, Map<Integer, RegisteredUserInterface> registeredUsers){
        if(registeredUsers.containsKey(id))
            return true;

        return false;
    }

    public static boolean checkPassword(String password, RegisteredUserInterface regUser){
        String encodedPassword = DigestUtils.sha256Hex(password);
//        System.out.println("inp passw: " + encodedPassword);
//        System.out.println("sys pwd: " + regUser.getPassword());
        return encodedPassword.equals(regUser.getPassword());
    }

    public static Map<Integer, RegisteredUserInterface> getRegisteredStudents(){
        return RegisteredUsers.getRegisteredStudentsMap();
    }

    public static Student getLoggedInStudent(int studentId, String password){

        Map<Integer, RegisteredUserInterface> regUsers = RegisteredUsers.getRegisteredStudentsMap();
        RegisteredUserInterface loggedInStudent = RegisteredUsers.getRegisteredStudentsMap().get(studentId);
        if(loggedInStudent == null){
            throw new UserNotFoundException("Vartotojas nerastas, registruokites");}

        if(loggedInStudent != null && (!DigestUtils.sha256Hex(password).equals(loggedInStudent.getPassword())))
            throw new BadPasswordException("Blogas slaptazodis, pameginkite dar karta");

//        System.out.println(loggedInStudent);
        return (Student) loggedInStudent;
    }

    // (1256,new Student(1256, "Vardenis", "Pavardenis", DigestUtils.sha256Hex("stuvar")));


}
