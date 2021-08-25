package exams.service.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.ExamsMain;
import exams.data.*;
import exams.service.login.Login;
import exams.service.results.Results;
import exams.utils.utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class StudentActions {

    private Student loggedInStudent;

    public StudentActions() {}

    public void studentLogin(Scanner sc, String message) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        System.out.println("   Prisijungimas   ");

        if (this.loggedInStudent == null){
            int studentId = checkStudentId(sc);
            String password = checkStudentPassword(sc, studentId);
            this.loggedInStudent = Login.getLoggedInStudent(studentId, password);
    }

        chooseExam(sc, this.loggedInStudent, "");
//        System.out.println("Logged in student: " + loggedInStudent);
    }

    public int checkStudentId(Scanner sc){
        int studentId = utils.getInpInt(sc, "Iveskite studento koda");
        if(!Login.getRegisteredStudents().containsKey(studentId)) {
            this.studentLogin(sc, "vartotojas nerastas, bandykite dar karta");
        }
        return studentId;
    }

    public String checkStudentPassword(Scanner sc, int studentId){
        String password = utils.getInpString(sc, "iveskite slaptazodi");
        if(!Login.checkPassword(password, Login.getRegisteredStudents().get(studentId))){
            studentLogin(sc, "Blogas slaptazodis, bandykite dar karta");
        }
        return  password;
    }

    public static void chooseExam(Scanner sc, Student loggedInStudent, String message) {

        System.out.println("Prisijunges studentas " + loggedInStudent.getName() + " " + loggedInStudent.getSurname());

        if (!message.isEmpty()) {
            System.out.println(message);
        }
        System.out.println("Pasirinkite egzamina:");
        int examChoice = utils.getInpInt(sc, "123 - OOP pagrindai \n124 - Geografija");

        if(examChoice != 123 && examChoice != 124) {
            message = examChoice + " -  neegzistuojantis pasirinkimas";
            chooseExam(sc, loggedInStudent, message);
        }

        takeExam(sc, loggedInStudent, PreparedExams.getExamObject(examChoice));

    }

    public static void takeExam(Scanner sc, Student loggedInStudent, Exam examNow){

        String[] examQuestions = null;
//        String answersDirectory = "answers";
        String pathToAnswersFile = "";
        int examId = examNow.getId();

        switch(examId){
            case 123 -> {
                examQuestions = PreparedExams.getOopBasics_123();
                pathToAnswersFile = ExamsMain.getAnswersPath() +  "123_oop_basics_answers.json";}
            case 124 -> {
                examQuestions = PreparedExams.getGeography_124();
                pathToAnswersFile = ExamsMain.getAnswersPath() +   "124_geography.json";}
        }

        try {
            ObjectMapper mapper= new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.findAndRegisterModules();

            File answersFile = new File(pathToAnswersFile);
            File studentExamsFile = new File(ExamsMain.getExamsPath() + "student_" + loggedInStudent.getId() + ".json");

            LocalDateTime thisExaminationTime = LocalDateTime.now();

//            System.out.println(thisExaminationTime);

            StudentsExams studentsExams = mapper.readValue(studentExamsFile, StudentsExams.class);

            if (studentsExams == null){
                //// create the whole object
            }

//            System.out.println("student exams: "+studentsExams);

            ExamTake examTake = studentsExams.getExamTakes().get(examId);
            Map<Integer, ExamTake> newExamTakes = new HashMap<>();

            if(examTake != null) { // && studentsExams.getExamTakes().size() >= 1) {

                LocalDateTime earlierExaminationTime = examTake.getExaminationDate();

                long timeDiff = earlierExaminationTime.until(thisExaminationTime, ChronoUnit.MINUTES);
                if (timeDiff < 3) {
                    chooseExam(sc, loggedInStudent, "Pabandykite vėliau, praejo tik " + timeDiff + " minutes nuo paskutinio laikymo. Turi praeiti maziausiai 3 minutes.");
                }
            }
                //// Lets save other Taken exams info
                studentsExams.getExamTakes().forEach((key,val) ->{
                    if(key != examId)
                        newExamTakes.put(key, val);
                });

            //// Get students answers
            List<Answer> studentAnswersL = new ArrayList<>();
            for(int i = 0; i < examQuestions.length; i++){
                System.out.println(examQuestions[i]);
                studentAnswersL.add(new Answer((i+1), sc.nextLine()));
            }

            //// GRADING
//            System.out.println("Student answers: " + studentAnswersL);
            ExamAndAnswers rightAnswers = mapper.readValue(answersFile, ExamAndAnswers.class);
            Results gradeOb = new Results(rightAnswers.getAnswers(),studentAnswersL);
            int grade = gradeOb.getGrade();

            //// prepare studentExams file for writing
            ExamTake newExamTake = new ExamTake(examNow, studentAnswersL, thisExaminationTime, grade);
            newExamTakes.put(examId, newExamTake);
            studentsExams.setExamTakes(newExamTakes);
            try {
                mapper.writeValue(studentExamsFile, studentsExams);
                if (ExamsMain.executionMode.equals(RunMode.DEBUG))
                    System.out.println("Exam data was written");
            } catch (Exception e){
                System.out.println("Error. Could not write to file: " + e.getMessage());
            }

            String examStatus = TeacherActions.hasStudentPassedExam(grade) ? "Islaikytas" : "Neislaikytas";
            System.out.println("Egzaminas " + examStatus);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
