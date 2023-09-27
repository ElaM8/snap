package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Snap game = new Snap();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        game.addPlayer(player1);
        game.addPlayer(player2);

        ComandRunner commands = new ComandRunner(game);

        game.shuffleDeck();

        int currentPlayerIndex = 0;

        while (!commands.quitProgramme) {
            Player currentPlayer = game.getPlayers().get(currentPlayerIndex);
            int playerIndex = game.getPlayerIndex(currentPlayer);

            System.out.println(currentPlayer.getName() + ", it's your turn!");
            commands.takeTurnCommand(playerIndex);
            game.checkPlayerWin(playerIndex);
            currentPlayerIndex = (currentPlayerIndex + 1) % game.getPlayers().size();
        }
    }
}

