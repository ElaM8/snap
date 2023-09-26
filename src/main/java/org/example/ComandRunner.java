package org.example;

import java.util.Scanner;

public class ComandRunner {
    CardGame game = new CardGame();
    public boolean quitProgramme = false;
    private Scanner scanner = new Scanner(System.in);

    protected void printMessage(String message) {
        System.out.println(message);
    }

    public boolean takeTurnCommand() {
        while (!quitProgramme) {
            printMessage("Press enter to take your turn, or type \"quit\" to end play.");

            String input = scanner.nextLine();

            if (input.toLowerCase().equals("quit")) {
                quitProgramme = true;
            } else if (!input.trim().isEmpty()) {
                printMessage("Please only press enter to take your turn");
            } else {
                Object dealedCard = game.dealCard();
                System.out.println("Dealed card: " + dealedCard);
            }
        }
        return true;
    }
}