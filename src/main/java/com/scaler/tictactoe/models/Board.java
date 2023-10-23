package com.scaler.tictactoe.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int Dimension){
        this.board=new ArrayList<>();
        for(int i=0;i<Dimension;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<Dimension;j++)
                this.board.get(i).add(new Cell(i,j));
        }

        /* Using JAVA 8 Streams:
           this.board = IntStream.range(0, dimension)
            .mapToObj(i -> IntStream.range(0, dimension)
                .mapToObj(j -> new Cell(i, j))
                .collect(Collectors.toList()))
            .collect(Collectors.toList());
         */
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void display(){
        for(int i=0;i< board.size();i++){
            for(int j=0;j< board.size();j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY))
                {
                    System.out.print("|   |");
                }
                else
                    System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol()+" |");
            }
            System.out.println();
        }
    }
}
