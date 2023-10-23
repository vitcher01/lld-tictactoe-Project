package com.scaler.tictactoe.Controller;

import com.scaler.tictactoe.Exceptions.InvalidGameBuildException;
import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.GameStatus;
import com.scaler.tictactoe.models.Player;

import java.util.List;
import java.util.Map;

public class GameController {


    public Game createGame(int dimension, List<Player> playerList){
        try {
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(playerList)
                    .build();
        } catch (InvalidGameBuildException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayBoard( Board board){
        board.display();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void makeNextMove(Game game){
        game.makeNextMove();
    }
}
