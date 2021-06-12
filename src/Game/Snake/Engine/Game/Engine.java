package Game.Snake.Engine.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private ArrayList<Cell> cells = new ArrayList<>();
    private ArrayList<Cell> snakeCells = new ArrayList<>();
    private Dimension boxDimension = new Dimension(15, 15);

    private Cell cell[][] = new Cell[numberOfColumnsInPanel][numberOfRowsInPanel];

    /**
     * Move snake
     */
//    public void moveSnake(int directionNumber) {
//        int snakeHeadNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
//        int snakeHeadNumberOfRow = snakeCells.get(0).getNumberOfRow();
//        if (directionNumber == 37) {           //left
//            int snakeHeadAfterMoveNumberOfColumn = snakeHeadNumberOfColumn - 1;
//            int snakeHeadAfterMoveNumberOfRow = snakeHeadNumberOfRow;
////            moveSnakeHead(snakeHeadAfterMoveNumberOfColumn, snakeHeadAfterMoveNumberOfRow);
//        } else if (directionNumber == 38) {    //up
//
//        } else if (directionNumber == 39) {    //right
//
//        } else if (directionNumber == 40) {    //down
//
//        }
//    }

    /**
     * Move snake head (first snake cell)
     */
//    private void moveSnakeHead(int snakeHeadAfterMoveNumberOfColumn, int snakeHeadAfterMoveNumberOfRow) {
//        System.out.println(cells.size());
//        System.out.println(snakeCells.size());
//        int snakeHeadBeforeMoveNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
//        int snakeHeadBeforeMoveNumberOfRow = snakeCells.get(0).getNumberOfRow();
//        cells.remove(cell[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow]);
//        snakeCells.add(cell[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow] = new FirstSnakeCell(snakeHeadAfterMoveNumberOfColumn, snakeHeadAfterMoveNumberOfRow, boxDimension));
//        cells.add(cell[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow]);
//        snakeCells.remove(0);
//        for (int i = 1; i < snakeCells.size(); i++) {
//            cells.remove(cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
//            snakeCells.add(cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow] = new NextSnakeCells(snakeHeadBeforeMoveNumberOfColumn, snakeHeadBeforeMoveNumberOfRow, boxDimension));
//            cells.add(cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
//            System.out.println("aaa");
//
//            snakeHeadBeforeMoveNumberOfColumn = snakeCells.get(0).getNumberOfColumn();
//            snakeHeadBeforeMoveNumberOfRow = snakeCells.get(0).getNumberOfRow();
//            snakeCells.remove(0);
//            System.out.println("bbb");
//
//        }
//        cells.remove(cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
//        cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow] = new GrayCell(snakeHeadBeforeMoveNumberOfColumn, snakeHeadBeforeMoveNumberOfRow,boxDimension);
//        cells.add(cell[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
//        System.out.println(snakeCells.get(0));
//        System.out.println(cells.size());
//        System.out.println(snakeCells.size());
//    }

    /**
     * Create all cells
     */
    public void generateInitialSetUpOfCells() {
        for (int columnNumber = 0; columnNumber < numberOfColumnsInPanel; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRowsInPanel; rowNumber++) {
                cell[columnNumber][rowNumber] = new GrayCell(columnNumber, rowNumber,boxDimension);
                cells.add(cell[columnNumber][rowNumber]);
            }
        }
        setColorInThreeStartBoxes();
        setColorInOneRandomBox();
    }

    /**
     * Set color in 1 random grayBox
     */
    private void setColorInOneRandomBox() {
        Random random = new Random();
        boolean boxIsGray = false;
        while (!boxIsGray) {
            int randomNumberOfColumn = random.nextInt(numberOfColumnsInPanel);
            int randomNumberOfRow = random.nextInt(numberOfRowsInPanel);
            /**
             * If on cells list is this graybox then change it to green
             */
            if (!cell[randomNumberOfColumn][randomNumberOfRow].isCatchCell()) {
                cells.remove(cell[randomNumberOfColumn][randomNumberOfRow]);
                cell[randomNumberOfColumn][randomNumberOfRow] = new GreenCell(randomNumberOfColumn, randomNumberOfRow, boxDimension);
                cells.add(cell[randomNumberOfColumn][randomNumberOfRow]);
                boxIsGray = true;
            }
        }
    }

    /**
     * Set color in 3 cells (start snake)
     */
    private void setColorInThreeStartBoxes() {
        /**
         * Create first snake cell(moveable)
         */
        int firstBoxNumberOfColumn = 45;
        int firstBoxNumberOfRow = 26;
        cells.remove(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        cell[firstBoxNumberOfColumn][firstBoxNumberOfRow] = new FirstSnakeCell(firstBoxNumberOfColumn, firstBoxNumberOfRow, boxDimension);
        snakeCells.add(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        cells.add(cell[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        /**
         * Create two second snake cells(follow first)
         */
        createNextSnakeBox(firstBoxNumberOfColumn, firstBoxNumberOfRow - 1);
        createNextSnakeBox(firstBoxNumberOfColumn, firstBoxNumberOfRow - 2);
    }

    /**
     * Create next snake cell
     */
    private void createNextSnakeBox(int numberOfColumn, int numberOfRow) {
        cells.remove(cell[numberOfColumn][numberOfRow]);
        cell[numberOfColumn][numberOfRow] = new NextSnakeCells(numberOfColumn, numberOfRow, boxDimension);
        snakeCells.add(cell[numberOfColumn][numberOfRow]);
        cells.add(cell[numberOfColumn][numberOfRow]);
    }

    /**
     * Send list with cells
     */
    public ArrayList<Cell> getBoxesList() {
        return cells;
    }
}
