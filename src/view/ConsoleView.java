package view;

import controller.ChronikController;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * ConsoleView provides a menu-driven interface for interacting with ChronikController.
 */
public class ConsoleView {
    private final ChronikController controller;
    private final Scanner scanner;

    public ConsoleView(ChronikController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main menu for the console application.
     */
    public void menu() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Show all mitglieds whose names start with a specific letter");
            System.out.println("2. Show all Hauses mitglieds");
            System.out.println("3. Show haus results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    handleMitgliedsByLetter();
                    break;
                case "2":
                    printMitglieds(controller.getStrkMitglieds());
                    break;
                case "3":
                    printHausResults();
                    break;
                case "4":
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Handles the option to display mitglieds whose names start with a specific letter.
     */
    private void handleSMitgliedsByLetter() {
        System.out.print("Enter a capital letter: ");
        String letter = scanner.nextLine();
        controller.getMitgliedsByLetter(letter).forEach(System.out::println);
    }

    /**
     * Prints a list of mitglieds.
     *
     * @param mitglieds The list of student names.
     */
    private void printMitgliedsname(List<String> mitglieds) {
        if (mitglieds.isEmpty()) {
            System.out.println("No Mitgliedsname found.");
        } else {
            mitglieds.forEach(System.out::println);
        }
    }

    /**
     * Prints the haus results.
     */
    private void printHausResults() {
        controller.getHausResults("src/logs/ergebnis.txt");
    }
}
