package exams.service.actions;

import exams.data.StudentsExams;

import java.io.File;
import java.util.Scanner;

public class StudentActions {
    private String pathToExamsDirectory;
//    private String pathToAnswersFile;

    public StudentActions(String pathToExamsDirectory) {
        this.pathToExamsDirectory = pathToExamsDirectory;
//        this.pathToAnswersFile = pathToAnswersFile;
    }

//    public String getStudentFilePath(int studentId){
//
//    }

    public void TakeExam(Scanner sc, int examId, int studentId){
        StudentDataActions dataActions = new StudentDataActions(this.pathToExamsDirectory);
        System.out.println("Students files: " + dataActions.getStudentFilesList());

        StudentsExams examsInfo = dataActions.getStudentExamsData(studentId);
        System.out.println(examsInfo);

//        ExamAndAnswers examAndAnswers =  dataActions.readExamAndAnswers();
//        System.out.println(examAndAnswers);
//        List<Answer> correctAnswers = examAndAnswers.getAnswers();
//        int nextQuestion = correctAnswers.size() + 1;
//        String nextCorrectAnswer = utils.getInpString(sc, "Enter answer to question number " + nextQuestion);
//        correctAnswers.add(new Answer(nextQuestion, nextCorrectAnswer));
//        examAndAnswers.setAnswers(correctAnswers);
//        dataActions.writeExamAndAnswers(examAndAnswers);



    // GET STUDENT EXAM TAKES INFORMATION


    // IF EXAM RETAKEN AND 2 DAYS HAVENT PASSED, PASS WARNING

    // IF NO FILE CREATE IT

    // TAKE ANSWERS

    //

    }
}
