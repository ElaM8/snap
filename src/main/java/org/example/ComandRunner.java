package org.example;

import java.util.Scanner;

public class ComandRunner {
    Snap game;
    public boolean quitProgramme = false;
    private Scanner scanner = new Scanner(System.in);

    public ComandRunner(Snap game) {
        this.game = game;
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    public boolean takeTurnCommand(int playerIndex) {

        Player player = game.getPlayers().get(playerIndex);

            printMessage(player.getName() + ", press enter to take your turn, or type \"quit\" to end play.");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                quitProgramme = true;
            } else if (!input.trim().isEmpty()) {
                printMessage("Please only press enter to take your turn");
            } else {
                Object dealedCard = game.dealCard(playerIndex);
                printMessage(player.getName() + ", your card is: " + dealedCard + ". You need a card of the same value as the previous card to get a SNAP!!");
            }
        return true;
    }
}

