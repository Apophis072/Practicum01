import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        String line;

        Path target = new File(System.getProperty("user.dir")).toPath();
        chooser.setCurrentDirectory(target.toFile());

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            target = chooser.getSelectedFile().toPath();
            String fileName = String.valueOf(target.getFileName());
            System.out.println("ID  Firstname  Lastname Title  YOB");
            System.out.println("==================================");
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
