package com.scaler.tictactoe.models;

import com.scaler.tictactoe.Exceptions.InvalidGameBuildException;
import com.scaler.tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategy.OrderOfOneWinningStratergy;

import java.util.*;

//We will use builder pattern to create Object of game class
public class Game {
    private Board board;
    private List<Player> players;
    private LinkedList<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

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

    public void setMoves(LinkedList<Move> moves) {
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

    public void displayBoard(){
        board.display();
    }

    public void makeNextMove() {
        Player player=players.get(nextPlayerIndex);
        Move move=player.makeMove();
        moves.add(move);

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        System.out.println("player is making move to "+row+","+col);

        board.getBoard().get(row)
                .get(col).setPlayer(player);
        board.getBoard().get(row)
                .get(col).setCellState(CellState.FILLED);

        this.setNextPlayerIndex((++nextPlayerIndex)%(board.getBoard().size()-1));

        if(gameWinningStrategy.checkWinner(board,player,move.getCell())){
            System.out.println(player.getName()+" Wins the Game!!");
            gameStatus=GameStatus.ENDED;
        }
    }

    public void undo(){
        Move move=moves.pop();

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        System.out.println("Undoing move at "+row+","+col);

        board.getBoard().get(row)
                .get(col).setPlayer(null);
        board.getBoard().get(row)
                .get(col).setCellState(CellState.EMPTY);

        this.setNextPlayerIndex((--nextPlayerIndex)%(board.getBoard().size()-1));
    }

    /* This is static because otherwise you can't create a builder class without creating a game class
    if you thought by making the getBuilder method only static why aren't we able to access builder object.
    Then think of builder object as a property of class Game. and just like any other property of a class
    you cant use it without first creating an object of the main class.
     */
    public static class Builder{

        private int Dimension;

        private List<Player> players;

        private boolean isValid() {
            return Dimension >= 3;

            //TODO logic
        }

        List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getDimension() {
            return Dimension;
        }

        public Builder setDimension(int dimension) {
            Dimension = dimension;
            return this;
        }

        public Game build() throws InvalidGameBuildException {

            if(!isValid()){
                throw new InvalidGameBuildException("Incorrect Dimension Provided!!");
            }

            Game game=new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(Dimension));
            game.setMoves(new LinkedList<>());
            game.setPlayers(this.players);
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOfOneWinningStratergy(Dimension));

            return game;
        }
    }
}
