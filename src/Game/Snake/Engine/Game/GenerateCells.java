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
    private ArrayList<Cell> snakeCells = new ArrayList<>();
    private Dimension cellDimension = new Dimension(15, 15);
    private Cell cells[][] = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];

    public GenerateCells(int numberOfColumnsInPanel, int numberOfRowsInPanel) {
        this.numberOfColumnsInPanel = numberOfColumnsInPanel;
        this.numberOfRowsInPanel = numberOfRowsInPanel;
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
            if (!cells[randomNumberOfColumn][randomNumberOfRow].isCatchCell() && !cells[randomNumberOfColumn][randomNumberOfRow].isPartOfSnake()) {
                cells[randomNumberOfColumn][randomNumberOfRow].setBackground(Color.GREEN);
                cells[randomNumberOfColumn][randomNumberOfRow].setIsCatchCell(true);
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
                cells[columnNumber][rowNumber] = new Cell(columnNumber, rowNumber, cellDimension);
            }
        }
    }
    /**
     * Generate snake
     */
    public void generateThreeInitialSnakeCells() {
        /**
         * Create first snake cells(moveable)
         */
        int firstCellNumberOfColumn = 45;
        int firstCellNumberOfRow = 26;
        cells[firstCellNumberOfColumn][firstCellNumberOfRow].setBackground(Color.GREEN);
        cells[firstCellNumberOfColumn][firstCellNumberOfRow].setIsPartOfSnake(true);
        snakeCells.add(cells[firstCellNumberOfColumn][firstCellNumberOfRow]);
        /**
         * Create two next snake cells
         */
        generateTwoNextSnakeCells(firstCellNumberOfColumn, firstCellNumberOfRow - 1);
        generateTwoNextSnakeCells(firstCellNumberOfColumn, firstCellNumberOfRow - 2);
    }
    /**
     * Create next snake cells
     */
    private void generateTwoNextSnakeCells(int numberOfColumn, int numberOfRow) {
        cells[numberOfColumn][numberOfRow].setBackground(Color.GREEN);
        cells[numberOfColumn][numberOfRow].setIsPartOfSnake(true);
        snakeCells.add(cells[numberOfColumn][numberOfRow]);
    }
    /**
     *Get all cells
     */
    public Cell[][] getCells() {
        return cells;
    }
    /**
     *Get all snakeCells
     */
    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }
}
