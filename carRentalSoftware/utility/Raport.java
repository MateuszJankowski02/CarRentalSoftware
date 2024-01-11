package utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Raport {

    public static void saveToFile(String message) {
        try {
            Date currentDate = new Date();
            FileWriter fileWriter = new FileWriter("raport.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(currentDate + ": " + message);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
