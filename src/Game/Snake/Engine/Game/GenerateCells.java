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
    private Cell cell[][] = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];

    public GenerateCells(int numberOfColumnsInPanel, int numberOfRowsInPanel) {
        this.numberOfColumnsInPanel = numberOfColumnsInPanel;
        this.numberOfRowsInPanel = numberOfRowsInPanel;
    }

    /**
     * Generate cell to catch
     */
    public void generateCellToCatch() {
        Random random = new Random();
        boolean cellIsGray = false;
        while (!cellIsGray) {
            int randomNumberOfColumn = random.nextInt(numberOfColumnsInPanel);
            int randomNumberOfRow = random.nextInt(numberOfRowsInPanel);
            Cell cellToCatch = cell[randomNumberOfColumn][randomNumberOfRow];
            /**
             * If on cell list is this graybox then change it to green
             */
            if (!cellToCatch.isCatchCell() && !cellToCatch.isPartOfSnake()) {
                cellToCatch.setBackground(Color.GREEN);
                cellToCatch.setIsCatchCell(true);
                cellIsGray = true;
            }
        }
    }

    /**
     * Generate cell for game panel
     */
    public void generateAllGrayCells() {
        for (int columnNumber = 0; columnNumber < numberOfColumnsInPanel; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRowsInPanel; rowNumber++) {
                cell[columnNumber][rowNumber] = new Cell(columnNumber, rowNumber, cellDimension);
            }
        }
    }

    /**
     * Generate snake
     */
    public void generateThreeInitialSnakeCells() {
        /**
         * Create first snake cell
         */
        int firstCellNumberOfColumn = 45;
        int firstCellNumberOfRow = 26;
        Cell firstSnakeCell = cell[firstCellNumberOfColumn][firstCellNumberOfRow];

        firstSnakeCell.setBackground(Color.GREEN);
        firstSnakeCell.setIsPartOfSnake(true);
        snakeCells.add(firstSnakeCell);
        /**
         * Create two next snake cell
         */
        Cell secondSnakeCell = cell[firstCellNumberOfColumn][firstCellNumberOfRow - 1];
        Cell thirdSnakeCell = cell[firstCellNumberOfColumn][firstCellNumberOfRow - 2];
        generateNextSnakeCells(secondSnakeCell);
        generateNextSnakeCells(thirdSnakeCell);
    }

    /**
     * Create next snake cell
     */
    private void generateNextSnakeCells(Cell cell) {
        cell.setBackground(Color.GREEN);
        cell.setIsPartOfSnake(true);
        snakeCells.add(cell);
    }

    /**
     * Get all cell
     */
    public Cell[][] getCell() {
        return cell;
    }

    /**
     * Get all snakeCells
     */
    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }
}
