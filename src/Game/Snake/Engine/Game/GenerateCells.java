package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Home on 2021-06-12.
 */
public class GenerateCells {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private ArrayList<Cell> cells = new ArrayList<>();
    private ArrayList<Cell> snakeCells = new ArrayList<>();
    private Dimension cellDimension = new Dimension(15, 15);
    private ArrayList<Integer> cellsNumberToDelete = new ArrayList<>();

    private Cell cell[][] = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];

    public GenerateCells(int numberOfColumnsInPanel, int numberOfRowsInPanel) {
        this.numberOfColumnsInPanel = numberOfColumnsInPanel;
        this.numberOfRowsInPanel = numberOfRowsInPanel;
    }


    public void moveSnake(int addToNumberOfColumn, int addToNumberOfRow){
        for (int i = 0;i<cellsNumberToDelete.size();i++){
            cellsNumberToDelete.remove(i);
        }
        int snakeHeadNumberOfColumnBeforeMove = snakeCells.get(0).getNumberOfColumn();
        int snakeHeadNumberOfRowBeforeMove = snakeCells.get(0).getNumberOfRow();
        moveSnakeHeadCell(addToNumberOfColumn,addToNumberOfRow);
//        moveNextSnakeCell(snakeHeadNumberOfColumnBeforeMove,snakeHeadNumberOfRowBeforeMove);
    }

    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }

    public ArrayList<Integer> getCellsNumberToDelete() {
        return cellsNumberToDelete;
    }

    private void moveNextSnakeCell(int snakeHeadNumberOfColumnBeforeMove,int snakeHeadNumberOfRowBeforeMove){
        int numberOfColumn = snakeHeadNumberOfColumnBeforeMove;
        int numberOfRow = snakeHeadNumberOfRowBeforeMove;
        for (int cellNumberInSnakeCellsList = 1;cellNumberInSnakeCellsList<snakeCells.size();cellNumberInSnakeCellsList++){
            int snakeCellNumberOfColumn = snakeCells.get(cellNumberInSnakeCellsList).getNumberOfColumn();
            int snakeCellNumberOfRow = snakeCells.get(cellNumberInSnakeCellsList).getNumberOfRow();
            int cellNumberInCellList = cells.indexOf(cell[snakeCellNumberOfColumn][snakeCellNumberOfRow]);
            cell[numberOfColumn][numberOfRow] = new NextSnakeCells(numberOfColumn,numberOfRow,cellDimension);
            cells.set(cellNumberInCellList,cell[numberOfColumn][numberOfRow]);
            snakeCells.set(cellNumberInSnakeCellsList,cell[numberOfColumn][numberOfRow]);
            cellsNumberToDelete.add(cellNumberInCellList);
            numberOfColumn = snakeCellNumberOfColumn;
            numberOfRow = snakeCellNumberOfRow;
        }
    }
    private void moveSnakeHeadCell(int addToNumberOfColumn, int addToNumberOfRow){


        //Actual snake head position
        int snakeHeadNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
        int snakeHeadNumberOfRow = snakeCells.get(0).getNumberOfRow();
        //Snake position after move
        int snakeHeadNumberOfColumnAfterMove = snakeHeadNumberOfColumn + addToNumberOfColumn;
        int snakeHeadNumberOfRowAfterMove = snakeHeadNumberOfRow + addToNumberOfRow;
        int cellNumberInCellsList = cells.indexOf(cell[snakeHeadNumberOfColumnAfterMove][snakeHeadNumberOfRowAfterMove]);
        cell[snakeHeadNumberOfColumnAfterMove][snakeHeadNumberOfRowAfterMove] = new FirstSnakeCell(snakeHeadNumberOfColumnAfterMove,snakeHeadNumberOfRowAfterMove, cellDimension);
        cells.set(cellNumberInCellsList,cell[snakeHeadNumberOfColumnAfterMove][snakeHeadNumberOfRowAfterMove]);
        snakeCells.set(0,cell[snakeHeadNumberOfColumnAfterMove][snakeHeadNumberOfRowAfterMove]);
        cellsNumberToDelete.add(cellNumberInCellsList);
    }
    public void generateCellToCatch() {
        Random random = new Random();
        boolean cellIsGray = false;
        while (!cellIsGray) {
            int randomNumberOfColumn = random.nextInt(numberOfColumnsInPanel);
            int randomNumberOfRow = random.nextInt(numberOfRowsInPanel);
            /**
             * If on cells list is this graybox then change it to green
             */
            if (!cell[randomNumberOfColumn][randomNumberOfRow].isCatchCell() && !cell[randomNumberOfColumn][randomNumberOfRow].isPartOfSnake()) {
                cells.remove(cell[randomNumberOfColumn][randomNumberOfRow]);
                cell[randomNumberOfColumn][randomNumberOfRow] = new GreenCell(randomNumberOfColumn, randomNumberOfRow, cellDimension);
                cells.add(cell[randomNumberOfColumn][randomNumberOfRow]);
                cellIsGray = true;
            }
        }
    }
    /**
     * Generate cells for game panel
     */
    public void generateAllGrayCells(){
        for (int columnNumber = 0; columnNumber < numberOfColumnsInPanel; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRowsInPanel; rowNumber++) {
                cell[columnNumber][rowNumber] = new GrayCell(columnNumber, rowNumber, cellDimension);
                cells.add(cell[columnNumber][rowNumber]);
            }
        }
    }
    /**
     * Generate snake
     */
    public void generateThreeInitialSnakeCells() {
        /**
         * Create first snake cell(moveable)
         */
        int firstBoxNumberOfColumn = 45;
        int firstBoxNumberOfRow = 26;
        cells.remove(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        cell[firstBoxNumberOfColumn][firstBoxNumberOfRow] = new FirstSnakeCell(firstBoxNumberOfColumn, firstBoxNumberOfRow, cellDimension);
        snakeCells.add(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        cells.add(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        /**
         * Create two next snake cells
         */
        generateTwoNextSnakeCells(firstBoxNumberOfColumn, firstBoxNumberOfRow - 1);
        generateTwoNextSnakeCells(firstBoxNumberOfColumn, firstBoxNumberOfRow - 2);
    }
    /**
     * Create next snake cell
     */
    private void generateTwoNextSnakeCells(int numberOfColumn, int numberOfRow) {
        cells.remove(cell[numberOfColumn][numberOfRow]);
        cell[numberOfColumn][numberOfRow] = new NextSnakeCells(numberOfColumn, numberOfRow, cellDimension);
        snakeCells.add(cell[numberOfColumn][numberOfRow]);
        cells.add(cell[numberOfColumn][numberOfRow]);
    }
    /**
     *Get all cells for game panel
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }
}
