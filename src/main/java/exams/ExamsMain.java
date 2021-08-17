package exams;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.data.*;
import exams.service.ActionProcessor;
import exams.service.actions.InstructorActions;
import exams.service.results.Results;

import java.io.*;
import java.util.*;

import static exams.service.ActionProcessor.startGUI;

// Tests
// Exceptions
// Enums, Generics

public class ExamsMain {
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
        //Person person = new Person("Anders", "Jonaitis", 35, new Address(Country.LIETUVA, "Vilnius", "Savanoriu 55"));

        Student student = new Student(1256, "Vardenis", "Pavardenis");
        Exam exam = new Exam(124, "OOP pagrindai", "testas", "2020-10-10 12:00");

        List<Answer> ansList = new ArrayList<>();
        ansList.add(new Answer(1,"a"));
        ansList.add(new Answer(2, "b"));
        ansList.add(new Answer(3, "e"));
        ansList.add(new Answer(4, "c"));

        ExamTake examTake = new ExamTake(student, exam, ansList);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("file.json");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Write Json file");
            mapper.writeValue(file, examTake);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///// READING
        System.out.println("Read Json file");
        String pathToExamsDirectory = "D:\\Arunas\\Documents\\Java_Studijos\\Project2_Exams\\exams";
        String pathToAnswersFile = "D:\\Arunas\\Documents\\Java_Studijos\\Project2_Exams\\Answers\\123_oop_basics_answers.json";
        ActionProcessor.startGUI(sc);

        try {
/*
            File answersFile = new File(examsPath + "\\oop_basics_answers.json"); //"ReadDirectory/read.json");
            File studentAnswersFile = new File("file.json");
            examTake = mapper.readValue(studentAnswersFile, ExamTake.class);
            List<Answer> studentAnswers = examTake.getAnswers();
            System.out.println("student answers: ");
            System.out.println(studentAnswers);

//            File readFolder = new File("ReadDirectory");
            //            System.out.println("List of read files: ");
//            List <File> files = ExamsMain.getFolderFilesList(readFolder);
//            for(File fileR : files){
//                examTake = mapper.readValue(fileR, ExamTake.class);
//                System.out.println("Student: " + examTake.getStudent().getName() + " " + examTake.getStudent().getSurname());
//                System.out.println("Exam: " + examTake.getExam().getCourseName());
//                System.out.println("Answers:");
//                List<Answer> answers = examTake.getAnswers();
//                answers.forEach(ans -> System.out.println(ans.getQuestion() + ": " + ans.getAnswer()));
//            }

            ExamAndAnswers rightAnswers = mapper.readValue(answersFile, ExamAndAnswers.class);
            System.out.println("right answers");
            System.out.println(rightAnswers.getAnswers());

            //// GRADING
            Results grade = new Results(rightAnswers.getAnswers(),studentAnswers);
            int res = grade.getGrade();
*/
            // WRITE RESULTS FILE


            //// INSTRUCTOR APPEND TO ANSWER FILE
            InstructorActions instructorActions = new InstructorActions(pathToExamsDirectory,pathToAnswersFile);
            instructorActions.addAnswerToExam(sc);


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
