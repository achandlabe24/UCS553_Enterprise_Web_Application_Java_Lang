import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class StudentFileManager {

    // Character Stream: Write student details to a text file
    public static void writeStudentDetails(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // append mode
            writer.write(data);
            System.out.println("Student details written successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing student details: " + e.getMessage());
        }
    }

    // Character Stream: Read student details from a text file
    public static void readStudentDetails(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading student details: " + e.getMessage());
        }
    }

    // Byte Stream: Copy any binary file (image, pdf, binary data)
    public static void copyBinaryFile(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("\nBinary file copied successfully from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.err.println("Error copying binary file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String textFile = "student_records.txt";

        // Writing student records
        String records = "ID: 101, Name: John Doe, Department: Computer Science\n" +
                         "ID: 102, Name: Jane Smith, Department: Information Technology\n";
        writeStudentDetails(textFile, records);

        // Reading student records
        readStudentDetails(textFile);

        // Copying a binary file (Ensure source file exists when testing)
        copyBinaryFile("source_image.png", "copied_image.png");
    }
}