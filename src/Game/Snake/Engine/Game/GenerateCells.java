package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Home on 2021-06-12.
 */
public class GenerateCells {
    private int numberOfColumnsInPanel;
    private int numberOfRowsInPanel;
    private int firstSnakeCellNumberOfColumn;
    private int firstSnakeCellNumberOfRow;
    private int numberOfSnakeCells = 3; //How many initial snake cells we have
    private ArrayList<Cell> snakeCells = new ArrayList<>();
    private Dimension cellDimension = new Dimension(15, 15);
    private Cell[][] cells;


    public GenerateCells(int numberOfColumnsInPanel, int numberOfRowsInPanel) {
        this.numberOfColumnsInPanel = numberOfColumnsInPanel;
        this.numberOfRowsInPanel = numberOfRowsInPanel;
        this.firstSnakeCellNumberOfColumn = numberOfColumnsInPanel / 2;
        this.firstSnakeCellNumberOfRow = numberOfRowsInPanel / 2;
    }

    /**
     * Generate cells to catch
     */
    public void generateCellToCatch() {
        Random random = new Random();
        boolean cellIsGray = false;
        while (!cellIsGray) {
            int randomNumberOfColumn = random.nextInt(numberOfColumnsInPanel - 1);
            int randomNumberOfRow = random.nextInt(numberOfRowsInPanel - 1);
            Cell cellToCatch = cells[randomNumberOfColumn][randomNumberOfRow];
            /**
             * If on cells list is this graybox then change it to green
             */
            if (!cellToCatch.isCatchCell() && !cellToCatch.isPartOfSnake()) {
                cellToCatch.setBackground(Color.GREEN);
                cellToCatch.setIsCatchCell(true);
                cellIsGray = true;
            }
        }
    }

    /**
     * Generate cells for game panel
     */
    public void generateAllGrayCells() {
        cells = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];
        for (int columnNumber = 0; columnNumber < numberOfColumnsInPanel; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRowsInPanel; rowNumber++) {
                cells[columnNumber][rowNumber] = new Cell(columnNumber, rowNumber, cellDimension);
            }
        }
    }

    /**
     * Generate invisible cells around game panel
     */
    public void generateCellsAroundGamePanel() {
        for (int i = 0; i < numberOfColumnsInPanel; i++) {
            cells[i][0].setVisible(false);
            cells[i][numberOfRowsInPanel - 1].setVisible(false);
        }
        for (int i = 0; i < numberOfRowsInPanel; i++) {
            cells[0][i].setVisible(false);
            cells[numberOfColumnsInPanel - 1][i].setVisible(false);
        }
    }

    /**
     * Generate snake
     */
    public void generateThreeInitialSnakeCells() {
        /**
         * Create first snake cells
         */
        System.out.println(firstSnakeCellNumberOfColumn);
        System.out.println(firstSnakeCellNumberOfRow);
        Cell firstSnakeCell = cells[firstSnakeCellNumberOfColumn][firstSnakeCellNumberOfRow];
        for (int i = 0; i < numberOfSnakeCells; i++) {
            generateSnakeCells(firstSnakeCell);
            firstSnakeCellNumberOfRow -= 1;
            firstSnakeCell = cells[firstSnakeCellNumberOfColumn][firstSnakeCellNumberOfRow];
        }
    }

    /**
     * Create next snake cells
     */
    private void generateSnakeCells(Cell cell) {
        cell.setBackground(Color.GREEN);
        cell.setIsPartOfSnake(true);
        snakeCells.add(cell);
    }

    /**
     * Get all cells
     */
    public Cell[][] getCells() {
        return cells;
    }

    /**
     * Get all snakeCells
     */
    public ArrayList<Cell> getSnakeCells() {
        return snakeCells;
    }
}
