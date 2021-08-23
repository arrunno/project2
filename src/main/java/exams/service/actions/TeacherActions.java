package exams.service.actions;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.ExamsMain;
import exams.data.*;
import exams.service.ActionProcessor;
import exams.utils.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherActions {

    public void teacherMenu1(Scanner sc, String message) throws IOException {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        System.out.println(" ___________________________________");
        System.out.println("|          Destytojo meniu          |");
        System.out.println("| 1 - Patikrinti rezultatus         |");
        System.out.println("| 2 - Prideti atsakyma prie egzamino|");
        System.out.println("| 7 - Grizti i pradini meniu        |");
        System.out.println("| 0 - Iseiti                        |");
        System.out.println("|___________________________________|");
        int choice = utils.getInpInt(sc, "");

        switch (choice) {
            case 1 -> this.getStudentsExamsResults();
            case 2 -> addAnswerToExam(sc);
            case 7 -> ActionProcessor.startGUI(sc);
            case 0 -> {
                System.out.println("Viso gero");
                System.exit(55);
            }
            default -> teacherMenu1(sc, "negalimas pasirinkimas, pasirinkite dar karta");

        }
    }

    public void instructorMenu2AppendToExam(Scanner sc){
        System.out.println(" ___________________________________");
        System.out.println("|          Destytojo meniu          |");
        System.out.println("|  Prideti atsakyma prie egzamino   |");
        System.out.println("| 7 - Grizti i pradini meniu        |");
        System.out.println("| 0 - Iseiti                        |");
        System.out.println("|___________________________________|");
    }

    public void addAnswerToExam(Scanner sc){
        DataActions dataActions = new DataActions();
        ExamAndAnswers examAndAnswers =  dataActions.readExamAndAnswers( "124_geography.json");
//        System.out.println(examAndAnswers);
        List<Answer> correctAnswers = examAndAnswers.getAnswers();
        int nextQuestion = correctAnswers.size() + 1;
        String nextCorrectAnswer = utils.getInpString(sc, "Iveskite atsakymo raide " + nextQuestion + " klausimui");
        correctAnswers.add(new Answer(nextQuestion, nextCorrectAnswer));
        examAndAnswers.setAnswers(correctAnswers);
        dataActions.writeExamAndAnswers(examAndAnswers);
    }


    public void getStudentsExamsResults() throws IOException {
        List<StudentsExams> studentsExamsList = new ArrayList<>();
        Path examsFilesPath = Paths.get(ExamsMain.getExamsPath());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();

        /////  Studentu rezultatai
        try {
            Files.walk(examsFilesPath)
                    .filter(Files::isRegularFile)
                    .forEach(examFile -> {
                        try {
                            studentsExamsList.add(mapper.readValue(examFile.toFile(), StudentsExams.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Studentu rezultatai");
        List<ExamStudentGrade> examStudentGradeL = new ArrayList<>();
        for (StudentsExams stEx : studentsExamsList) {
            Student student = stEx.getStudent();
            stEx.getExamTakes().forEach((key, val) -> {
                examStudentGradeL.add(new ExamStudentGrade(val.getExam(), student, val.getGrade()));
                System.out.println("Egzaminas: " + val.getExam().getCourseName() + ", Studentas: "
                        + student.getName() + " " + student.getSurname() + ", Ivertinimas: " + val.getGrade());
            });
        }

        ExamsStudentsGrades examsStudentsGrades = new ExamsStudentsGrades(examStudentGradeL);

        File examRezFile = new File(ExamsMain.getAnswersPath() + "examResults.json");
        if (!examRezFile.exists()) {
            try {
                examRezFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
//            System.out.println("Write exams results file");
            mapper.writeValue(examRezFile, examsStudentsGrades);
        } catch (
                JsonGenerationException e) {
            e.printStackTrace();
        } catch (
                JsonMappingException e) {
            e.printStackTrace();
        }
    }

}
