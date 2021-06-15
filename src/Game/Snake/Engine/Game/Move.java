package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-06-14.
 */
public class Move {
    private ArrayList<Cell> cellList = new ArrayList<>();
    private ArrayList<Cell> snakeCells = new ArrayList<>();
    private Cell cell[][];
//    private Cell cell[][] = new Cell[100][100];

    public Move (ArrayList<Cell> cellList,ArrayList<Cell> snakeCells,Cell cell[][]){
        this.cellList = cellList;
        this.snakeCells = snakeCells;
        this.cell = cell;
    }


    public void moveSnake(int addToNumberOfColumn, int addToNumberOfRow){
        int currentFirstSnakeCellNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
        int currentFirstSnakeCellNumberOfRow = snakeCells.get(0).getNumberOfRow();

        moveFirstSnakeCell(addToNumberOfColumn,addToNumberOfRow);
        moveNextSnakeCells(currentFirstSnakeCellNumberOfColumn,currentFirstSnakeCellNumberOfRow);
    }
    private void checkIfNextCellIsCellToCatch(){

    }
    private void moveNextSnakeCells(int currentFirstSnakeCellNumberOfColumn,int currentFirstSnakeCellNumberOfRow){
        int precedingCellNumberOfColumn = currentFirstSnakeCellNumberOfColumn;
        int precedingCellNumberOfRow = currentFirstSnakeCellNumberOfRow;

        for (int cellNumber = 1; cellNumber<snakeCells.size();cellNumber++){
            cell[precedingCellNumberOfColumn][precedingCellNumberOfRow].setBackground(Color.GREEN);
            cell[precedingCellNumberOfColumn][precedingCellNumberOfRow].setIsPartOfSnake(true);
            int currentCellNumberOfColumn = snakeCells.get(cellNumber).getNumberOfColumn();
            int currentCellNumberOfRow = snakeCells.get(cellNumber).getNumberOfRow();
            cell[currentCellNumberOfColumn][currentCellNumberOfRow].setBackground(Color.LIGHT_GRAY);
            cell[currentCellNumberOfColumn][currentCellNumberOfRow].setIsPartOfSnake(false);
            snakeCells.set(cellNumber,cell[precedingCellNumberOfColumn][precedingCellNumberOfRow]);
            precedingCellNumberOfColumn = currentCellNumberOfColumn;
            precedingCellNumberOfRow = currentCellNumberOfRow;
        }
    }
    private void moveFirstSnakeCell(int addToNumberOfColumn,int addToNumberOfRow){
        int currentFirstSnakeCellNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
        int currentFirstSnakeCellNumberOfRow = snakeCells.get(0).getNumberOfRow();

        int afterMoveFirstSnakeNumberOfColumn = currentFirstSnakeCellNumberOfColumn + addToNumberOfColumn;
        int afterMoveFirstSnakeNumberOfRow = currentFirstSnakeCellNumberOfRow + addToNumberOfRow;

        cell[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow].setIsPartOfSnake(true);
        cell[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow].setIsCatchCell(false);
        cell[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow].setBackground(Color.GREEN);

        snakeCells.set(0,cell[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow]);
    }
}
