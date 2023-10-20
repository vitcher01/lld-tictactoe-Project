package com.scaler.tictactoe;


import com.scaler.tictactoe.models.Bot;
import com.scaler.tictactoe.models.BotDifficultyLevel;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("what is the Dimension of the Board?");
        int dimension=sc.nextInt();

        System.out.println("Do you want to have a bot in the game?");
        String isBot=sc.nextLine();

        List<Player> players = new ArrayList<>();

        int numberOfPlayer = dimension - 1;
        if (isBot.charAt(0) == 'y') {
            numberOfPlayer = dimension - 2;
        }
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

    }
}