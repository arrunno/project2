package exams;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.data.*;
import exams.service.ActionProcessor;
import exams.service.actions.StudentActions;
import exams.service.login.Login;
import exams.service.results.Results;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class ExamsMain {

    public static final RunMode executionMode = RunMode.DEBUG;
    private static String examsPath;
    private static String answersPath;

    public static String getExamsPath(){
        return ExamsMain.examsPath;
    }

    public static String getAnswersPath(){
        return ExamsMain.answersPath;
    }

    public static void main(String[] args) throws IOException {

        String examsPath;
        String answersPath;

        if(args.length == 2) {
            if(!Files.exists(Paths.get(args[0]))){
                System.out.println("Blogas egzaminu katalogo kelias, bus naudojamas standartinis - exams");
            } else {
                ExamsMain.examsPath = args[0];
            }

            if(!Files.exists(Paths.get(args[1]))){
                System.out.println("Blogas atsakymu katalogo kelias, bus naudojamas standartinis - answers");
            }  else {
                ExamsMain.answersPath = args[1];
            }
            System.out.println("egzamino failu katalogas: " + ExamsMain.examsPath + ", atsakymu failu katalogas: " + ExamsMain.answersPath);
        } else {
            ExamsMain.examsPath = System.getProperty("user.dir") + "\\exams\\";
            ExamsMain.answersPath = System.getProperty("user.dir") + "\\answers\\";
            System.out.println("Nepaduoti programos parametrai, bus naudojami standartiniai - exams ir answers katalogai.");
        }

        Scanner sc = new Scanner(System.in);
        int userChoice;

        ActionProcessor.startGUI(sc);
    }

}
