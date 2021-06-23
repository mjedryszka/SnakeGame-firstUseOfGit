package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-06-14.
 */
public class MoveSnake {
    private ArrayList<Cell> snakeCells;
    private Cell cells[][];
    private boolean endGame = false;
    private int numberOfColumnsInGamePanel;
    private int numberOfRowsInGamePanel;

    public MoveSnake(ArrayList<Cell> snakeCells, Cell cells[][]) {
        this.snakeCells = snakeCells;
        this.cells = cells;
    }

    public void moveSnake(int addToNumberOfColumn, int addToNumberOfRow) {
        //Get cells
        int currentFirstSnakeCellNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
        int currentFirstSnakeCellNumberOfRow = snakeCells.get(0).getNumberOfRow();
        int afterMoveFirstSnakeNumberOfColumn = currentFirstSnakeCellNumberOfColumn + addToNumberOfColumn;
        int afterMoveFirstSnakeNumberOfRow = currentFirstSnakeCellNumberOfRow + addToNumberOfRow;

        Cell currentFirstSnakeCell = snakeCells.get(0);
        Cell afterMoveFirstSnakeCell = cells[afterMoveFirstSnakeNumberOfColumn][afterMoveFirstSnakeNumberOfRow];
        /**
         * Check if it is not game over
         */
        checkIfAfterMoveCellIsSnakeCell(afterMoveFirstSnakeCell);
        checkIfAfterMoveCellIsOutsideGamePanel(afterMoveFirstSnakeCell);
        /**
         * If game is not end make move
         */
        if (!endGame) {
            if (checkIfAfterMoveCellIsCellToCatch(afterMoveFirstSnakeCell)) {
                addCellToCatchAsFirstCellOfSnake(afterMoveFirstSnakeCell);
            } else {
                moveFirstSnakeCell(afterMoveFirstSnakeCell);
                moveNextSnakeCells(currentFirstSnakeCell);
            }
        }
    }

    /**
     * Additional methods
     */
    private void checkIfAfterMoveCellIsOutsideGamePanel(Cell cell) {
        int numberOfColumn = cell.getNumberOfColumn();
        int numberOfRow = cell.getNumberOfRow();
        if (numberOfColumn <= 0 || numberOfColumn >= numberOfColumnsInGamePanel) {
            endGame = true;
        }
        if (numberOfRow <= 0 || numberOfRow >= numberOfRowsInGamePanel) {
            endGame = true;
        }
    }

    private void checkIfAfterMoveCellIsSnakeCell(Cell cell) {
        if (cell.isPartOfSnake()) {
            endGame = true;
        }
    }

    private void addCellToCatchAsFirstCellOfSnake(Cell cell) {
        cell.setIsCatchCell(false);
        snakeCells.add(0, cell);
    }

    private boolean checkIfAfterMoveCellIsCellToCatch(Cell cell) {
        if (cell.isCatchCell()) {
            return true;
        } else {
            return false;
        }
    }

    private void moveNextSnakeCells(Cell cell) {
        for (int cellNumber = 1; cellNumber < snakeCells.size(); cellNumber++) {//loop starts from second cells in snake(first is moved)
            cell.setBackground(Color.GREEN);//change colors and parameters on first snake cells(moved in moveFirstSnakeCell method
            cell.setIsPartOfSnake(true);
            Cell currentNextSnakeCell = snakeCells.get(cellNumber);//change colors and parameters on next snake cells (in previous line cells is moved)
            currentNextSnakeCell.setBackground(Color.LIGHT_GRAY);
            currentNextSnakeCell.setIsPartOfSnake(false);
            snakeCells.set(cellNumber, cell);//replace cells in snakeCells list
            cell = currentNextSnakeCell;
        }
    }

    private void moveFirstSnakeCell(Cell cell) {
        //Change color, boolean parameters and replace cells in snakeCells list
        cell.setIsPartOfSnake(true);
        cell.setIsCatchCell(false);
        cell.setBackground(Color.GREEN);
        snakeCells.set(0, cell);
    }

    /**
     * Getters and setters
     */

    public boolean isEndGame() {
        return endGame;
    }

    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setNumberOfColumnsInGamePanel(int numberOfColumnsInGamePanel) {
        this.numberOfColumnsInGamePanel = numberOfColumnsInGamePanel;
    }

    public void setNumberOfRowsInGamePanel(int numberOfRowsInGamePanel) {
        this.numberOfRowsInGamePanel = numberOfRowsInGamePanel;
    }
}
