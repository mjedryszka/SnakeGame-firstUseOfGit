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

    public Cell cell[][] = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];

    public GenerateCells(int numberOfColumnsInPanel, int numberOfRowsInPanel) {
        this.numberOfColumnsInPanel = numberOfColumnsInPanel;
        this.numberOfRowsInPanel = numberOfRowsInPanel;
    }

    public Cell[][] getCell() {
        return cell;
    }
 

    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
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
                cell[randomNumberOfColumn][randomNumberOfRow].setBackground(Color.GREEN);
                cell[randomNumberOfColumn][randomNumberOfRow].setIsCatchCell(true);
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
                cell[columnNumber][rowNumber] = new Cell(columnNumber, rowNumber, cellDimension);
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
        int firstCellNumberOfColumn = 45;
        int firstCellNumberOfRow = 26;
        cell[firstCellNumberOfColumn][firstCellNumberOfRow].setBackground(Color.GREEN);
        cell[firstCellNumberOfColumn][firstCellNumberOfRow].setIsPartOfSnake(true);
        snakeCells.add(cell[firstCellNumberOfColumn][firstCellNumberOfRow]);
        /**
         * Create two next snake cells
         */
        generateTwoNextSnakeCells(firstCellNumberOfColumn, firstCellNumberOfRow - 1);
        generateTwoNextSnakeCells(firstCellNumberOfColumn, firstCellNumberOfRow - 2);
    }
    /**
     * Create next snake cell
     */
    private void generateTwoNextSnakeCells(int numberOfColumn, int numberOfRow) {
        cell[numberOfColumn][numberOfRow].setBackground(Color.GREEN);
        cell[numberOfColumn][numberOfRow].setIsPartOfSnake(true);
        snakeCells.add(cell[numberOfColumn][numberOfRow]);
    }
    /**
     *Get all cells for game panel
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }
}
