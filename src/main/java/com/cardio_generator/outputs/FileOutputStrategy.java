package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * The {@code FileOutputStrategy} class implements {@code OutputStrategy}
 * It createsa directory and then writes patient data to file 
 */
public class FileOutputStrategy implements OutputStrategy {

    private final String BaseDirectory; // added final since it isnt changed anywhere

    public final ConcurrentHashMap<String, String> fileMap = new ConcurrentHashMap<>(); // changed to camel case

    // Added Javadoc comment
    /**
     * Constructs a {@code FileOutputStrategy} with specified base directory path.
     *
     * @param baseDirectory the base directory where output files will be created
     */
    public FileOutputStrategy(String baseDirectory) {

        this.BaseDirectory = baseDirectory;
    }

    // Added Javadoc comment
    /**
     * Outputs patient data to a file named after the label in the base directory.
     * The method creates the directory if it does not exist and appends to the file.
     *
     * @param patientId the ID of the patient
     * @param timestamp the time the data was recorded
     * @param label     label of the data
     * @param data      the actual data value as a string
     */
    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {
            // Create the directory
            Files.createDirectories(Paths.get(BaseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        }

        // Set the FilePath variable
        String FilePath = fileMap.computeIfAbsent(
            label, 
            k -> Paths.get(BaseDirectory, label + ".txt").toString()
        );
        // moved part of the code to the new line for clarity of the code

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(
                Files.newBufferedWriter(Paths.get(FilePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + FilePath + ": " + e.getMessage());
        }
    }
}