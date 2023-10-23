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

        //TODO player symbol validation
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("What is the name of the player :");
            String name = sc.nextLine();

            System.out.println("What is the symbol of the player :");
            String symbol = sc.nextLine();

            players.add(new Player(symbol.charAt(0),name, PlayerType.HUMAN));
        }

        if (isBot.charAt(0) == 'y') {
            String name="BOT TicTacToe";

            System.out.println("What is the symbol of the bot :");
            String symbol = sc.nextLine();
            players.add(new Bot(symbol.charAt(0),name, BotDifficultyLevel.EASY));
        }

        //Now the player list is Complete. We will now create Game.
        GameController gameController=new GameController();
        Game game=gameController.createGame(dimension,players);
        gameController.displayBoard(game.getBoard());

        //Now we will run the Game.
        while (gameController.getGameStatus(game)==GameStatus.IN_PROGRESS){
            Player player=game.getPlayers().get(game.getNextPlayerIndex());
            System.out.println("It is "+player.getName()+"'s turn");
            System.out.println("What do want to do?");
            System.out.println("1. Make a move\n2. Undo");
            char choice=sc.nextLine().charAt(0);

            switch (choice){
                case '1':
                  gameController.makeNextMove(game);
                  break;
                case '2':
                    gameController.undo(game);
                break;
                default:
                    System.out.println("Wrong choice! Please select from options above");
            }
            gameController.displayBoard(game.getBoard());
        }
    }
}