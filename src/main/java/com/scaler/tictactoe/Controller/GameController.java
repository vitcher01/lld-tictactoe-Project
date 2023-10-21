package com.scaler.tictactoe.Controller;

import com.scaler.tictactoe.Exceptions.InvalidGameBuildException;
import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.Player;

import java.util.List;

public class GameController {


    public Game createGame(int dimesion, List<Player> playerList){
        try {
            Game game=Game.getBuilder()
                    .setDimension(dimesion)
                    .setPlayers(playerList)
                    .build();

        } catch (InvalidGameBuildException e) {
            throw new RuntimeException(e);
        }
    }
}
