package exams.service.actions;

import exams.data.Answer;
import exams.data.Exam;
import exams.data.ExamAndAnswers;
import exams.utils.utils;

import java.util.ArrayList;
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
        ExamAndAnswers examAndAnswers =  dataActions.readExamAndAnswers();
        System.out.println(examAndAnswers);
        List<Answer> correctAnswers = examAndAnswers.getAnswers();
        int nextQuestion = correctAnswers.size() + 1;
        String nextCorrectAnswer = utils.getInpString(sc, "Enter answer to question number " + nextQuestion);
        correctAnswers.add(new Answer(nextQuestion, nextCorrectAnswer));
        examAndAnswers.setAnswers(correctAnswers);
        dataActions.writeExamAndAnswers(examAndAnswers);
    }

//    public void (){
//
//    }




}
