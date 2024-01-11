package utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


// create a class that saves all the data you give it during execution to a file named "raport.txt"
// the method should be static
// the method should append the data to the file
// the method should be called "saveToFile"
// the data from the file should not be overwritten
// the message should be follower by current date and time
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
