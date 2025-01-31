package com.scaler.tictactoe.strategies.gamewinningstrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Cell;
import com.scaler.tictactoe.models.Player;
import java.util.*;

public class OrderOfOneWinningStratergy implements GameWinningStrategy{

    private List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();
    private List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();
    private HashMap<Character, Integer> topLeftDiagSymbolCounts = new HashMap<>();
    private HashMap<Character, Integer> topRightDiagSymbolCounts = new HashMap<>();

    public OrderOfOneWinningStratergy(int dimension)
    {
        for(int i=0;i<dimension;i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {
        char symbol=player.getSymbol();
        int row=cell.getRow();
        int col=cell.getCol();
        int dimension=board.getBoard().size();

        if(!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol,rowSymbolCounts.get(row).get(symbol)+1);

        if(!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol,colSymbolCounts.get(col).get(symbol)+1);

        if(row==col){
            if(!topRightDiagSymbolCounts.containsKey(symbol)){
                topLeftDiagSymbolCounts.put(symbol, 0);
            }
            topLeftDiagSymbolCounts.put(symbol, topLeftDiagSymbolCounts.get(symbol) + 1);
        }


        if (row + col == dimension - 1){
            if(!topRightDiagSymbolCounts.containsKey(symbol)){
                topRightDiagSymbolCounts.put(symbol, 0);
            }
            topRightDiagSymbolCounts.put(symbol, topRightDiagSymbolCounts.get(symbol) + 1);
        }


        if (rowSymbolCounts.get(row).get(symbol) == dimension ||
                colSymbolCounts.get(col).get(symbol) == dimension) {
            return true;
        }

        if (row == col && topLeftDiagSymbolCounts.get(symbol) == dimension) {
            return true;
        }

        if (row + col == dimension - 1 && topRightDiagSymbolCounts.get(symbol) == dimension)  {
            return true;
        }
        return false;
    }
}
