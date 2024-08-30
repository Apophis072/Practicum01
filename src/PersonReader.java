import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        String line;

        Path target = new File(System.getProperty("user.dir")).toPath();
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                in = new Scanner(target);
                System.out.println("Opening File: " + target.getFileName());
                while (in.hasNextLine()) {
                    line = in.nextLine();
                    list.add(line);
                }
                in.close();
            } else {
                System.out.println("You must select a file, try again ");
            }
        } catch (IOException e) {
            System.out.println("IOException Error ");
        }
        System.out.println("ID  Firstname  Lastname Title  YOB");
        System.out.println("==================================");
        for (int e = 0; e < list.size(); e++)
        {
            System.out.println(list.get(e));
        }
    }
}
