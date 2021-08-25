package exams.data;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;

public class RegisteredUsers {

    private static Map<Integer, RegisteredUserInterface> registeredStudentsMap = new HashMap<>() {{
            put(1256,new Student(1256, "Vardenis", "Pavardenis", "stuvar"));
            put(1257,new Student(1257, "Jane", "Janyte","stujan"));
    }};


    public static boolean registerStudent(int userId, String name, String surname, String password){
        if(!registeredStudentsMap.containsKey(userId)) {
            registeredStudentsMap.put(userId, new Student(userId, name, surname, password));
            return true;
        }
        else {
            System.out.println("Studentas su tokiu id Jau yra sistemoje");
            return false;
        }
    }

    public static Map<Integer, RegisteredUserInterface> getRegisteredStudentsMap() {
        return registeredStudentsMap;
    }

    public void setRegisteredStudentsMap(Map<Integer, RegisteredUserInterface> registeredStudentsMap) {
        this.registeredStudentsMap = registeredStudentsMap;
    }

}
