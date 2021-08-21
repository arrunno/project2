package exams.service.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exams.ExamsMain;
import exams.data.ExamAndAnswers;
import exams.data.ExamTake;
import exams.data.RunMode;
import exams.data.StudentsExams;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentDataActions implements DirectoryFilesList{

    private List<File> studentFilesList;
    private String pathToExamsDirectory;
    private ObjectMapper mapper = new ObjectMapper();

    public StudentDataActions(String pathToExamsDirectory) {
        this.pathToExamsDirectory = pathToExamsDirectory;
        this.studentFilesList = getStudentFilesList();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public List<File> getStudentFilesList() {
        final File directory = new File(this.pathToExamsDirectory);
        List<File> studentFilesList = this.getFolderFilesList(directory);
        return studentFilesList;
    }

    //// GET CREATED STUDENT EXAMS FILE
    //// USED STREAMS
    public File getStudentExamsFile(int studentId) {
        File studExamFile;
        studExamFile = this.studentFilesList.stream()
                .filter(e -> e.getName().
                        contains(String.valueOf(studentId)))
                .findFirst()
                .orElse(null);
        return studExamFile;
    }

    public File createStudentExamsFile(int studentId){
          File studExamFile = new File(this.pathToExamsDirectory+"\\student_" + studentId + ".json");
            try {
                studExamFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return studExamFile;
    }

    public StudentsExams getStudentExamsData(int studentId){
        File studExamFile = this.getStudentExamsFile(studentId);
        if(studExamFile == null){
            return null;
        }

        StudentsExams studentsExams = null;
        try {
            studentsExams = this.mapper.readValue(studExamFile, StudentsExams.class);
        } catch (IOException e) {
            if (ExamsMain.executionMode.equals(RunMode.DEBUG))
                e.printStackTrace();
            else{
                //// Create new object and prefill with data

            }

        }
        System.out.println(studentsExams);

        return null;
    }

    public ExamTake getStudentExamTake(){

        return null;
    }

    public void setStudentFilesList(List<File> studentFilesList) {
        this.studentFilesList = studentFilesList;
    }
}
