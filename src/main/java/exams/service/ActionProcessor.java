package exams.service;

import exams.data.RegisteredUsers;
import exams.data.Student;
import exams.service.login.Login;
import exams.utils.utils;

import java.util.Map;
import java.util.Scanner;

public class ActionProcessor {
    //// Pradinio lango informacija
    // 1 Prisijungti
    // 2 Registruotis

//    private String userChoice

    public static void startGUI(Scanner sc){
        System.out.println(" ___________________________________");
        System.out.println("|          Egzaminu sistema         |");
        System.out.println("| 1 - Prisijungti dėstytojams       |");
        System.out.println("| 2 - Prisijungti studentams        |");
        System.out.println("| 3 - Registruotis studentams       |");
        System.out.println("| 0 - Išeiti                        |");
        System.out.println("|___________________________________|");
//        return utils.getInpInt(sc, "");
    }

    public static void processFirstMenu(Scanner sc){
        int firstChoice = utils.getInpInt(sc, "");
        switch (firstChoice) {
//            case 1 -> userLogin(sc, "instructor");
//            case 2 -> userLogin(sc, "student");
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
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            studentRegistrationMenu(sc);
        }
        ActionProcessor.registerStudent(sc, newUserInfo);
    }

//    public void registerStudent(Scanner sc){
//
//        Student newStudent = getNewStudent(sc);
//
//    }

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
                    Student loggedInStudent = Login.getLoggedInStudent(studentId,password);
                    chooseExam(sc,loggedInStudent);
//                    System.out.println(RegisteredUsers.getRegisteredStudentsMap());
                } else {
                    System.out.println("slaptazodziai nesutapma, pakartokite slaptazodziu vedima");
                    registerStudent( sc, newUserInfo);

                }
            }
        }
    }

    public static void chooseExam(Scanner sc, Student student){
        System.out.println("Prisijunges studentas: " + student.getName() + " " + student.getSurname());
        System.out.println("Choose exam to take");
    }

    public static void userLogin(Scanner sc, String userType){
//        Map<String, String> dataSource = userType.equals("instructor") ? IntructorsCredentialsData.getCredentials() : StudentsCredentialsData.getCredentials();
//        CredentialsProcessor crp = new CredentialsProcessor();
//        System.out.println("   Prisijungimas   ");
//        String email = utils.getInpString(sc, "Iveskite el. pasta:   ");
//        if(!crp.isEmailPresent(dataSource, email)) {
//            userNotFound(sc, userType, email);
//        }
//        else {
//            String inputPwd = utils.getInpString(sc, "Įveskite slaptažodį");
//            if(crp.isPasswordRight(dataSource,email, inputPwd))
//                System.out.println("OK, go to usertypes menu");
//            else {
//                inputPwd = utils.getInpString(sc, "Neteisingas slaptažodis, Bandykite dar karta.");
//                if(crp.isPasswordRight(dataSource,email, inputPwd))
//                    System.out.println("OK, go to usertypes menu");
//                else{
//                    System.out.println("Slaptažodis neteisingas. Grįžtame į pagrindinį meniu");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    startGUI(sc);
//                }
//            }
//        }
    }

    public static void rightEmailOrFirstMenu(Scanner sc, Map<String, String> dataSource, CredentialsProcessor crp) {
        String email = utils.getInpString(sc, "Iveskite el. pasta:   ");
        if (!crp.isEmailPresent(dataSource, email)) {
            System.out.println("Vartotojas nerastas.");
        }
    }

    public static void userNotFound(Scanner sc,  String userType, String missingEmail){
        System.out.println(missingEmail +  " vartotojas nerastas.");
        System.out.println("1 - Bandyti prisijungti dar kartą.");
        if(!userType.equals("instructor"))
            System.out.println("2 - Registruotis.");
        System.out.println("7 - Grįžti į pradinį meniu");
        System.out.println("0 - išeiti");
        int userChoice = utils.getInpInt(sc,"");
        switch(userChoice){
            case 1 -> userLogin(sc,userType);
            case 2 -> studentRegistrationMenu(sc);
            case 7 -> startGUI(sc);
            case 0 -> System.exit(10);
            default -> startGUI(sc);
        }
    }

    // shows menu, and passes user choice to needed method
    public static void instructorMenu1(Scanner sc){
        System.out.println(" ___________________________________");
        System.out.println("|          Destytojo meniu          |");
        System.out.println("| 1 - Patikrinti rezultatus         |");
        System.out.println("| 2 - Redaguoti egzamina            |");
        System.out.println("| 7 - Grįžti į pradinį meniu        |");
        System.out.println("| 0 - Išeiti                        |");
        System.out.println("|___________________________________|");
        String newUserInfo = sc.nextLine();
//        ActionProcessor.registerStudent(newUserInfo);
    }

    public static void showInstructorMenu2Results(Scanner sc){
        System.out.println(" ___________________________________");
        System.out.println("|          Destytojo meniu          |");
        System.out.println("|              Rezultatai           |");
        System.out.println("| 2 - Redaguoti egzamina            |");
        System.out.println("| 3 - Išeiti                        |");
        System.out.println("|___________________________________|");
    }

    public static void showStudentMenu(){

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }





    // Registruotis

        // Iveskite slaptazodi
        // Pakartokite slaptazodi

    // prisijungti
        // Iveskite vartotojo elektronini pasta
        // Iveskite slaptazodi
            // Neteisingi prisijungimo duomenys

    //// Studento pasirinkimai

    //// Destytojo pasirinkimai

}
