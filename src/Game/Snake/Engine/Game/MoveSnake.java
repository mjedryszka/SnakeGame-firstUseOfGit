package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-06-14.
 */
public class MoveSnake {
    private ArrayList<Cell> snakeCells;
    private Cell cell[][];

    public MoveSnake(ArrayList<Cell> snakeCells, Cell cell[][]) {
        this.snakeCells = snakeCells;
        this.cell = cell;
    }

    public void moveSnake(int addToNumberOfColumn, int addToNumberOfRow) {
        int currentFirstSnakeCellNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
        int currentFirstSnakeCellNumberOfRow = snakeCells.get(0).getNumberOfRow();
        int afterMoveFirstSnakeNumberOfColumn = currentFirstSnakeCellNumberOfColumn + addToNumberOfColumn;
        int afterMoveFirstSnakeNumberOfRow = currentFirstSnakeCellNumberOfRow + addToNumberOfRow;

        Cell currentFirstSnakeCell = snakeCells.get(0);
        Cell afterMoveFirstSnakeCell = cell[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow];

        if (checkIfAfterMoveCellIsCellToCatch(afterMoveFirstSnakeCell)) {
            addCellToCatchAsFirstCellOfSnake(afterMoveFirstSnakeCell);
        } else {
            moveFirstSnakeCell(afterMoveFirstSnakeCell);
            moveNextSnakeCells(currentFirstSnakeCell);
        }
    }

    private void addCellToCatchAsFirstCellOfSnake(Cell afterMoveFirstSnakeCell) {
        afterMoveFirstSnakeCell.setIsCatchCell(false);
        snakeCells.add(0, afterMoveFirstSnakeCell);
    }

    private boolean checkIfAfterMoveCellIsCellToCatch(Cell afterMoveFirstSnakeCell) {
        if (afterMoveFirstSnakeCell.isCatchCell()) {
            return true;
        } else {
            return false;
        }
    }

    private void moveNextSnakeCells(Cell currentFirstSnakeCell) {
        for (int cellNumber = 1; cellNumber < snakeCells.size(); cellNumber++) {//loop starts from second cell in snake(first is moved)
            currentFirstSnakeCell.setBackground(Color.GREEN);//change colors and parameters on first snake cell(moved in moveFirstSnakeCell method
            currentFirstSnakeCell.setIsPartOfSnake(true);
            Cell currentNextSnakeCell = snakeCells.get(cellNumber);//change colors and parameters on next snake cell (in previous line cell is moved)
            currentNextSnakeCell.setBackground(Color.LIGHT_GRAY);
            currentNextSnakeCell.setIsPartOfSnake(false);
            snakeCells.set(cellNumber, currentFirstSnakeCell);//replace cells in snakeCells list
            currentFirstSnakeCell = currentNextSnakeCell;
        }
    }

    private void moveFirstSnakeCell(Cell afterMoveFirstSnakeCell) {
        //Change color, boolean parameters and replace cell in snakeCells list
        afterMoveFirstSnakeCell.setIsPartOfSnake(true);
        afterMoveFirstSnakeCell.setIsCatchCell(false);
        afterMoveFirstSnakeCell.setBackground(Color.GREEN);
        snakeCells.set(0, afterMoveFirstSnakeCell);
    }

    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }

    public Cell[][] getCell() {
        return cell;
    }
}
