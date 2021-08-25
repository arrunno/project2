package exams.service;

import exams.ExamsMain;
import exams.data.*;
import exams.service.actions.TeacherActions;
import exams.service.actions.StudentActions;
import exams.service.login.Login;
import exams.utils.utils;

import java.io.IOException;
import java.util.*;

public class ActionProcessor {

    private Scanner sc;
    private TeacherActions teacherActions;
    private StudentActions studentActions;

    public ActionProcessor(Scanner sc) {
        this.sc = sc;
        this.teacherActions = new TeacherActions();
        this.studentActions = new StudentActions();
    }

    public static void startGUI(Scanner sc) throws IOException {
        System.out.println(" ___________________________________");
        System.out.println("|          Egzaminu sistema         |");
        System.out.println("| 1 - Prisijungti destytojams       |");
        System.out.println("| 2 - Prisijungti studentams        |");
        System.out.println("| 3 - Registruotis studentams       |");
        System.out.println("| 0 - Iseiti                        |");
        System.out.println("|___________________________________|");
        ActionProcessor actions = new ActionProcessor(sc);
        actions.processFirstMenu(sc);
    }

    public void processFirstMenu(Scanner sc) throws IOException {
        int firstChoice = utils.getInpInt(sc, "");
        switch (firstChoice) {
            case 1 -> this.teacherActions.teacherMenu1(sc, "");
            case 2 -> this.studentActions.studentLogin(sc, "");
            case 3 -> studentRegistrationMenu(sc);
            case 0 -> System.exit(10);
            default -> {
                clearScreen();
                startGUI(sc);
//                System.out.println("Nežinomas pasirinkimas, prašome pasirinkti 1, 2, 3 arba 0");
            }
        }
    }

    public static void studentRegistrationMenu(Scanner sc) {
        System.out.println("   Studento registracija   ");
        System.out.println("Iveskite per kableli asmens koda, Varda ir Pavarde. Pvz: 76545654,Vardenis,Pavardenis ");
        String[] newUserInfo = sc.nextLine().split(",");
        if(newUserInfo.length != 3) {
            System.out.println("Blogas ivedimas, bandykite dar kartą");
            studentRegistrationMenu(sc);
        }
        ActionProcessor.registerStudent(sc, newUserInfo);
    }

    private Student getNewStudent(Scanner sc) {
        return null;
    }

    public static void registerStudent(Scanner sc, String[] newUserInfo){
        System.out.println("Studento registracija 2 ");
        int studentId = Integer.parseInt(newUserInfo[0].trim());
        if(!Login.userIdExists(studentId, Login.getRegisteredStudents())){
            System.out.println("Iveskite slaptazodi:");
            String password = sc.nextLine();
            if(password.length() > 0){
                System.out.println("Pakartokite slaptazodi:");
                String password2 = sc.nextLine();
                if(password.equals(password2)) {
                    RegisteredUsers.registerStudent(studentId, newUserInfo[1], newUserInfo[2], password);
                    System.out.println("Studentas sekmingai uzregistruotas");
//                    Student loggedInStudent = Login.getLoggedInStudent(studentId,password);
//                    StudentActions.chooseExam(sc,loggedInStudent);
                    if(ExamsMain.executionMode.equals(RunMode.DEBUG)){
                        System.out.println(RegisteredUsers.getRegisteredStudentsMap());
                    }
                } else {
                    System.out.println("slaptazodziai nesutapma, pakartokite slaptazodziu vedima");
                    registerStudent( sc, newUserInfo);

                }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
