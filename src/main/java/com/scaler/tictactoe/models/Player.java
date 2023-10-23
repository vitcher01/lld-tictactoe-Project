package com.scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(char symbol,String name,PlayerType type){

        this.symbol=symbol;
        this.name=name;
        this.type=type;
    }
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move makeMove() {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter row and column");
        int row=sc.nextInt();
        int col=sc.nextInt();

        Cell cell=new Cell(row,col);

        Move move=new Move();
        move.setCell(cell);
        move.setPlayer(this);
        return move;
    }
}
