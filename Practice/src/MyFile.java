import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) {
        File file = new File("D:/git.txt"); // used to check file existence
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file); // used to read the file i.e git.txt
                FileWriter writer = new FileWriter("D:/copyGit.txt"); // used to write in a file
                int data;
                data = reader.read();
                while (data != -1) { // -1 indicates no further data
                    // System.out.print((char) data); // it will print each and every character
                    writer.append((char) data); // it will copy all the data from Git file to copyGit file in D:/
                    data = reader.read(); // it is used to read next data, again and again
                }
                System.out.println("\nData copied successfully!\n");
                reader.close(); // reading and writing files must be closed at end
                writer.close();
            } catch (IOException e) { // the exceptions are very necessary to handle the errors generated
                e.printStackTrace();
            }
        } else
            System.err.println("Error: Dedicated file not found!\n");
    }
}
