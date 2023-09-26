package org.example;

import org.example.Card;

import java.util.Collections;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame();

        ComandRunner commands = new ComandRunner();

        game.shuffleDeck();

        while(!commands.quitProgramme) {
            commands.takeTurnCommand();
        }
    }
}
