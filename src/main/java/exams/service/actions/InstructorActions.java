package exams.service.actions;

import exams.data.Answer;
import exams.data.Exam;
import exams.data.ExamAndAnswers;
import exams.utils.utils;

import java.util.List;
import java.util.Scanner;

public class InstructorActions {

    private String pathToExamsDirectory;
    private String pathToAnswersFile;

    public InstructorActions(String pathToExamsDirectory, String pathToAnswersFile) {
        this.pathToExamsDirectory = pathToExamsDirectory;
        this.pathToAnswersFile = pathToAnswersFile;
    }

    public void addAnswerToExam(Scanner sc){
        DataActions dataActions = new DataActions(this.pathToExamsDirectory, this.pathToAnswersFile);
        ExamAndAnswers examAndAnswers =  dataActions.readExamAnswersData();
        Exam exam = examAndAnswers.getExam();
        List<Answer> correctAnswers = examAndAnswers.getAnswers();



        System.out.println(examAndAnswers);
        // read file

        // write appended answers back
    }

//    public void (){
//
//    }




}
