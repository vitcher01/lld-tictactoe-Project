package com.scaler.tictactoe;


import com.scaler.tictactoe.models.Bot;
import com.scaler.tictactoe.models.BotDifficultyLevel;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.PlayerType;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("what is the Dimension of the Board?");
        int dimension=sc.nextInt();
        sc.nextLine();
        System.out.println("Do you want to have a bot in the game?");
        String isBot=sc.nextLine();

        Map<Character,Player> players = new HashMap<>();

        int numberOfPlayer = dimension - 1;
        if (isBot.charAt(0) == 'y') {
            numberOfPlayer = dimension - 2;
        }
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("What is the name of the player :");
            String name = sc.nextLine();

            System.out.println("What is the symbol of the player :");
            String symbol = sc.nextLine();
            while(players.containsKey(symbol.charAt(0))){
                System.out.println("Symbol already assigned to other player, Enter another");
                symbol=sc.nextLine();
            }

            players.put(symbol.charAt(0),new Player(symbol.charAt(0),name, PlayerType.HUMAN));
        }

        if (isBot.charAt(0) == 'y') {
            System.out.println("What is the name of the bot :");
            String name = sc.nextLine();

            System.out.println("What is the symbol of the bot :");
            String symbol = sc.nextLine();
            while(players.containsKey(symbol.charAt(0))){
                System.out.println("Symbol already assigned to other player, Enter another");
                symbol=sc.nextLine();
            }
            players.put(symbol.charAt(0),new Bot(symbol.charAt(0),name, PlayerType.BOT, BotDifficultyLevel.EASY));
        }

        //Now the player list is Complete. We can start the Game.


    }
}