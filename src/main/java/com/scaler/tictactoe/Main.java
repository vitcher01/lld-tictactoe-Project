package com.scaler.tictactoe;


import com.scaler.tictactoe.Controller.GameController;
import com.scaler.tictactoe.models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("what is the Dimension of the Board?");
        int dimension=sc.nextInt();
        sc.nextLine();
        System.out.println("Do you want to have a bot in the game?");
        String isBot=sc.nextLine();

        List<Player> players = new ArrayList<>();

        int numberOfPlayer = dimension - 1;
        if (isBot.charAt(0) == 'y') {
            numberOfPlayer = dimension - 2;
        }

        //TODO player symobol validation
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("What is the name of the player :");
            String name = sc.nextLine();

            System.out.println("What is the symbol of the player :");
            String symbol = sc.nextLine();

            players.add(new Player(symbol.charAt(0),name, PlayerType.HUMAN));
        }

        if (isBot.charAt(0) == 'y') {
            System.out.println("What is the name of the bot :");
            String name = sc.nextLine();

            System.out.println("What is the symbol of the bot :");
            String symbol = sc.nextLine();
            players.add(new Bot(symbol.charAt(0),name, PlayerType.BOT, BotDifficultyLevel.EASY));
        }

        //Now the player list is Complete. We can start the Game.

        GameController gameController=new GameController();
        Game game=gameController.createGame(dimension,players);
        gameController.displayBoard(game.getBoard());
        System.out.println(game.getPlayers());

        while (game.getGameStatus()==GameStatus.IN_PROGRESS){
            game.makeNextMove();
            game.displayBoard();
        }
    }
}