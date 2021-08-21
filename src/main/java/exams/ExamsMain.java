package exams;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.data.*;
import exams.service.ActionProcessor;
import exams.service.actions.StudentActions;
import exams.service.results.Results;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// Tests
// Exceptions
// Enums, Generics

public class ExamsMain {

    public static final RunMode executionMode = RunMode.DEBUG;

    public static void main(String[] args) {

        String examsPath;
        String answersPath;

        if(args.length >= 2) {
            examsPath = args[0];
            answersPath = args[1];
            System.out.println("egzamino failu kelias: " + examsPath + ", atsakymu failu kelias: " + answersPath);
        } else {
            System.out.println("Nepaduoti programos parametrai, bus naudojami standartiniai.");
        }

        Scanner sc = new Scanner(System.in);
        int userChoice;

        //ActionProcessor.startGUI(sc);

        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Person person = new Person("Anders", "Jonaitis", 35, new Address(Country.LIETUVA, "Vilnius", "Savanoriu 55"));

        Student student = new Student(1256, "Vardenis", "Pavardenis", "****");

        Exam exam = new Exam(123, "OOP pagrindai", "testas");
        List<Answer> ansList = new ArrayList<>();
        ansList.add(new Answer(1,"a"));
        ansList.add(new Answer(2, "b"));
        ansList.add(new Answer(3, "e"));
        ansList.add(new Answer(4, "c"));
        ansList.add(new Answer(5, "a"));
        ansList.add(new Answer(6, "d"));

        Exam exam2 = new Exam(124, "Java Duomenų struktūros", "testas");
        List<Answer> ansList2 = new ArrayList<>();
        ansList2.add(new Answer(1,"b"));
        ansList2.add(new Answer(2, "b"));
        ansList2.add(new Answer(3, "c"));
        ansList2.add(new Answer(4, "e"));
        ansList2.add(new Answer(4, "e"));
        ansList2.add(new Answer(4, "e"));

        ExamTake examTake = new ExamTake(exam, ansList, "2021-08-18 18:00");
//        System.out.println(examTake.getIdAndDate());
        ExamTake examTake2 = new ExamTake(exam2, ansList2, "2021-08-20 18:00");
        StudentsExams studentsExams = new StudentsExams(student,List.of(examTake,examTake2));

//        System.out.println("Takes: " + studentsExams);



        int studentId = 1256;
        String studFile = "student_" + studentId +".json";
        File file = new File("ReadDirectory\\"+ studFile);
//        File file2 = new File("RegStudents.json");
//        RegisteredUsers regStuds = new RegisteredUsers();
//// BEFORE LETTING STUDENT TO TAKE EXAM, CHECK IF STUDENTS_EXAMS FILE EXISTS, FIND EXAM,
// FIND TIME, COMPARE TIME AND THEN, IF OK LET TAKE EXAM. IF FILE DOES NOT EXIST, OR
// EXAM TAKE FOR A GIVEN EXAM DOES NOT EXIST, LET TAKE EXAM IMMEDIATELY


//// STUDENTS EXAM ANSWERS GO HERE
        if (!file.exists()){
////
//// CREATE NEW STUDENT EXAMS FILE, STUDENT OBJECT, EXAM TAKE OBJECT
        }
//        try {
////            System.out.println("Write Json file");
//            mapper.writeValue(file2, regStuds);
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Write Json file");
            mapper.writeValue(file, studentsExams);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///// READING
//        System.out.println("Read Json file");
        String pathToExamsDirectory = "D:\\Arunas\\Documents\\Java_Studijos\\Tasks\\Project2\\exams";
        String pathToAnswersFile = "D:\\Arunas\\Documents\\Java_Studijos\\Tasks\\Project2\\answers\\123_oop_basics_answers.json";

//        ActionProcessor.startGUI(sc);
//        ActionProcessor.processFirstMenu(sc);

        Map<String, String[]> preparedExams = PreparedExams.getPreparedExams();
        System.out.println("Pasirinkite egzamina (iveskite numeri esanti egzamino pavadinimo gale):");
        preparedExams.forEach((k,v)->{
            System.out.println(k);
        });

        String[] examQuestions = PreparedExams.getOopBasics_123();
        String[] studentAnswers = new String[examQuestions.length];
        List<Answer> studentAnswersL = new ArrayList<>();
        for(int i=0; i<2; i++ ){ //examQuestions.length; i++){
            System.out.println(examQuestions[i]);
            studentAnswersL.add(new Answer((i+1), sc.nextLine()));
        }
        System.out.println("Stttudent answers: " + studentAnswersL);

//        StudentActions studAct = new StudentActions(pathToExamsDirectory);
//        studAct.TakeExam(sc, 123, 1257);
//        studAct.

        try {

            File answersFile = new File("answers" + "\\123_oop_basics_answers.json"); //"ReadDirectory/read.json");
//            File studentAnswersFile = new File("file.json");
//            examTake = mapper.readValue(studentAnswersFile, ExamTake.class);
//            studentAnswersL = examTake.getAnswers();
            System.out.println("student answers: ");
            System.out.println(studentAnswersL);

            File readFolder = new File("ReadDirectory");
                        System.out.println("List of read files: ");
            List <File> files = ExamsMain.getFolderFilesList(readFolder);
            for(File fileR : files){
                studentsExams = mapper.readValue(fileR, StudentsExams.class);
                System.out.println("Student: " + studentsExams.getStudent().getName() + " " + studentsExams.getStudent().getSurname());
                Map<Integer, ExamTake> examTakes = studentsExams.getExamTakes();
                examTakes.forEach((key,val) ->{
                    System.out.println("Exam: " + val.getExam().getCourseName());
                    System.out.println("Answers:");
                    List<Answer> answers = val.getAnswers();
                    answers.forEach(ans -> System.out.println(ans.getQuestion() + ": " + ans.getAnswer()));
                });
            }

            ExamAndAnswers rightAnswers = mapper.readValue(answersFile, ExamAndAnswers.class);
            System.out.println("right answers");
            System.out.println(rightAnswers.getAnswers());

            //// GRADING
            System.out.println("Student answers: " + studentAnswersL);
            Results grade = new Results(rightAnswers.getAnswers(),studentAnswersL);
            int res = grade.getGrade();
            System.out.println("Egzamino ivertinimas: " + grade.getGrade());
            // WRITE RESULTS FILE

            //// INSTRUCTOR APPEND TO ANSWER FILE
//            InstructorActions instructorActions = new InstructorActions(pathToExamsDirectory,pathToAnswersFile);
//            instructorActions.addAnswerToExam(sc);


            //// FINISH GUI

//            if (!answersFile.exists()){
//                throw new FileNotFoundException();
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //*/
    }

    public static List<File> getFolderFilesList(final File folder) {
        List<File> fileList = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getFolderFilesList(fileEntry);
            } else {
//                System.out.println(fileEntry.getName());
                fileList.add(fileEntry);
            }
        }
        return fileList;
    }

}
