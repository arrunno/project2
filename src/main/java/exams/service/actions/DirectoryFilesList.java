package exams.service.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface DirectoryFilesList {
    default  public List<File> getFolderFilesList(final File folder) {
        List<File> fileList = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getFolderFilesList(fileEntry);
            } else {
                fileList.add(fileEntry);
            }
        }
        return fileList;
    }
}
