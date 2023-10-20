package com.scaler.tictactoe.models;

import com.scaler.tictactoe.Exceptions.InvalidGameBuildException;

import java.util.ArrayList;
import java.util.List;

//We will use builder pattern to create Object of game class
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    /* This is static because otherwise you can't create a builder class without creating a game class
    if you thought by making the getBuilder method only static why aren't we able to access builder object.
    Then think of builder object as a property of class Game. and just like any other property of a class
    you cant use it without first creating an object of the main class.
     */
    public static class Builder{

        public int getDimension() {
            return Dimension;
        }

        public Builder setDimension(int dimension) {
            Dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private int Dimension;

        private List<Player> players;

        private boolean isValid() {
            if(Dimension <3)
                return false;

            //TODO logic
            return true;
        }

        public Game build() throws InvalidGameBuildException {

            if(!isValid()){
                throw new InvalidGameBuildException("Incorrect Dimension Provided!!");
            }

            Game game=new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(Dimension));
            game.setMoves(new ArrayList<>());
            game.setPlayers(new ArrayList<>());
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}
