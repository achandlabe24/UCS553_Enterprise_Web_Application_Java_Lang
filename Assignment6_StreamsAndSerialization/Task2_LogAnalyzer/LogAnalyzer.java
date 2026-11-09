import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogAnalyzer {

    public static void analyzeAndFilterLogs(String inputLogPath, String outputLogPath) {
        int totalLogs = 0;
        int errorCount = 0;
        int warningCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputLogPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputLogPath))) {

            String line;
            writer.write("=== FILTERED LOG ENTRIES (ERRORS & WARNINGS) ===\n\n");

            while ((line = reader.readLine()) != null) {
                totalLogs++;

                boolean hasError = line.contains("ERROR");
                boolean hasWarning = line.contains("WARNING");

                if (hasError) {
                    errorCount++;
                }
                if (hasWarning) {
                    warningCount++;
                }

                // Write matching lines to output file
                if (hasError || hasWarning) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("--- Log Analysis Report ---");
            System.out.println("Total Log Entries Processed: " + totalLogs);
            System.out.println("Total ERROR Entries: " + errorCount);
            System.out.println("Total WARNING Entries: " + warningCount);
            System.out.println("Filtered log saved to: " + outputLogPath);

        } catch (IOException e) {
            System.err.println("Error processing log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputLogFile = "app_activity.log";
        String filteredLogFile = "filtered_logs.txt";

        // Helper method to generate sample logs for testing
        createSampleLogFile(inputLogFile);

        // Run log analyzer
        analyzeAndFilterLogs(inputLogFile, filteredLogFile);
    }

    private static void createSampleLogFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("2026-03-30 10:00:01 INFO Application initialization started.\n");
            writer.write("2026-03-30 10:00:05 WARNING Memory utilization exceeded 80%.\n");
            writer.write("2026-03-30 10:01:12 INFO Database connection established.\n");
            writer.write("2026-03-30 10:02:45 ERROR Failed to connect to Payment API.\n");
            writer.write("2026-03-30 10:03:00 WARNING Disk write latency high.\n");
            writer.write("2026-03-30 10:04:15 ERROR NullPointerException in UserAuth.java:42\n");
        } catch (IOException e) {
            System.err.println("Error writing sample log file: " + e.getMessage());
        }
    }
}