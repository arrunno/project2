package exams.service.actions;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.ExamsMain;
import exams.data.Answer;
import exams.data.ExamAndAnswers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataActions {

    private String pathToExamsDirectory;
    private String pathToAnswersFile;
//    private ExamAndAnswers examAndAnswers;

    public DataActions() {
        this.pathToExamsDirectory = ExamsMain.getExamsPath();
        this.pathToAnswersFile = ExamsMain.getAnswersPath() + "124_geography.json";
    }

    public void setPathToAnswersFile(String pathToAnswersFile) {
        this.pathToAnswersFile = pathToAnswersFile;
    }

    public ExamAndAnswers readExamAndAnswers(String answersFile){
        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File examAnswersFile = new File(ExamsMain.getAnswersPath() + answersFile);
        ExamAndAnswers examAndAnswers=new ExamAndAnswers();
            try {
                examAndAnswers = mapper.readValue(examAnswersFile, ExamAndAnswers.class);
//                System.out.println(examAndAnswers);
            }
            catch (JsonMappingException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        return examAndAnswers;
    }

    public void writeExamAndAnswers(ExamAndAnswers examAnswers){
        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File examAnswersFile = new File(this.pathToAnswersFile);
        if (!examAnswersFile.exists()){
            try {
                examAnswersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            //File examAnswersFile = new File(this.pathToAnswersFile);
            mapper.writeValue(examAnswersFile, examAnswers);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
