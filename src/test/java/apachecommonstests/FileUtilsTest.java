package apachecommonstests;

import com.google.common.collect.ImmutableList;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.testng.Assert.assertTrue;

public class FileUtilsTest {

    @Test(priority = -4999)
    public void createAndWriteToNewFileOrOverrideContentOfFile() throws IOException {
        //create a new file in the specified location
        //if the file already exists, override all of its content with some new text
        //add only a String
        FileUtils.writeStringToFile(new File("C:/fileUtilsExample/firstFile.txt"), "Look at this nice text", Charset
                .defaultCharset());
        //add several lines of Strings
        FileUtils.writeLines(new File("C:/fileUtilsExample/firstFile.txt"), ImmutableList.of("1", "2", "this"));
    }

    @Test(priority = -4998)
    public void createAndWriteToNewFileOrAppendToExistingFile() throws IOException {
        //append string to existing file or create a new file
        //add only a String
        FileUtils.writeStringToFile(new File("C:/fileUtilsExample/firstFile.txt"), "+Writing new text:" + System
                .currentTimeMillis(), Charset.defaultCharset(), true);
        //add several lines
        FileUtils.writeLines(new File("C:/fileUtilsExample/firstFile.txt"), ImmutableList.of("1", "2", "this"), true);
    }

    @Test(priority = -4997)
    public void copyContentOfOneFileToAnotherFile() throws IOException {
        //copy contents of one file to another one, creating the second once if it does not exist
        FileUtils.copyFile(new File("C:/fileUtilsExample/firstFile.txt"), new File("C:/fileUtilsExample/copyFile.txt"));
        assertTrue(FileUtils.contentEquals(new File("C:/fileUtilsExample/firstFile.txt"), new File
                ("C:/fileUtilsExample/copyFile.txt")));
    }

    @Test(priority = -4996)
    public void copyFileToDirectory() throws IOException {
        //copy the contents of a file to a file with the same name found inside the destinationFolder
        FileUtils.copyFileToDirectory(new File("C:/fileUtilsExample/firstFile.txt"), new File
                ("C:/fileUtilsExample/destinationFolder"));
    }

    @Test(priority = -4995)
    public void copyDirectoryContentsToAnotherDirectory() throws IOException {
        FileUtils.copyDirectoryToDirectory(new File("C:/fileUtilsExample/destinationFolder"), new File
                ("C:/fileUtilsExample/newFolderInside"));
    }
}
