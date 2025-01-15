package controller;

import model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * The Controller manages the application logic.
 */
public class ChronikController {
    private final List<Log> logEntries;

    public ChronikController(List<Log> logEntries) {
        this.logEntries = logEntries;
    }

    //b
    /**
     * Returns all the students whose names begin with a specified letter.
     */
    public List<String> getStudentsByLetter(String letter) {
        Set<String> uniqueStudents = new HashSet<>(); // Eliminating students that show up more than once
        for (Log entry : logEntries) {
            String studentName = entry.getMitgliedsname();
            if (studentName.startsWith(String.valueOf(letter))) {
                uniqueStudents.add(studentName);
            }
        }
        return new ArrayList<>(uniqueStudents); // Converting to List, printStudents needs a List parameter
    }

    //c
    /**
     * Returns all the Gryffindor in alphabetical order.
     */
    public List<String> getGryffindorStudents() {
        Set<String> uniqueStudents = new HashSet<>();
        for (Log entry : logEntries) {
            if (entry.getHaus() == Haus.STARK) {
                uniqueStudents.add(entry.getMitgliedsname());
            }
        }
        List<String> sortedStudents = new ArrayList<>(uniqueStudents);
        Collections.sort(sortedStudents);

        return sortedStudents;
    }

    //d
    /**
     * Calculates the haus scores and sorts them in descending order.
     */
    public void getHausResults(String filePath) {
        Map<Haus, Integer> hausScores = new HashMap<>();

    //     // 1. Calculate the scores for each haus
    //     for (Log entry : logEntries) {
    //         Haus haus = entry.getHaus();
    //           int datum = entry.getDatum();
    //
    //        // Add datum to the corresponding haus
    //        hausdatum.put(haus, hausScores.getOrDefault(haus, ) + datum);
    //    }

        // 2. Sort the hauss by their datum in descending order
        List<Map.Entry<Haus, Integer>> sortedHausScores = new ArrayList<>(hausScores.entrySet());
        sortedHausScores.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // Descending order

        // 3. Write the sorted results to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<Haus, Integer> entry : sortedHausScores) {
                writer.write(entry.getKey() + "#" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Results have been successfully saved to " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}