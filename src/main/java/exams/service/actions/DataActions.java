package exams.service.actions;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.data.Answer;
import exams.data.ExamAndAnswers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataActions {

    private String pathToExamsDirectory;
    private String pathToAnswersFile; // = "D:\\Arunas\\Documents\\Java_Studijos\\Project2_Exams\\Answers";
    private ExamAndAnswers examAndAnswers;


    public DataActions(String pathToExamsDirectory, String pathToAnswersFile) {
        this.pathToExamsDirectory = pathToExamsDirectory;
        this.pathToAnswersFile = pathToAnswersFile;
    }

    public ExamAndAnswers readExamAnswersData(){
        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File examAnswersFile = new File(this.pathToAnswersFile);
        ExamAndAnswers examAndAnswers = null;
            try {

                    examAndAnswers = mapper.readValue(examAnswersFile, ExamAndAnswers.class);
////                System.out.println("Student: " + examTake.getStudent().getName() + " " + examTake.getStudent().getSurname());
//                    System.out.println("Exam: " + examAndAnswers);
//                    System.out.println("Answers:");
//                    List<Answer> answers = examAndAnswers.getAnswers();
//                    answers.forEach(ans -> System.out.println(ans.getQuestion() + ": " + ans.getAnswer()));
            }
            catch (JsonMappingException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        return examAndAnswers;
    }

    public void writeExamAnswersData(int examId, List<Answer> examAnswers){

    }

    public ExamAndAnswers getExamAndAnswers(int examId){

        return null;
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
