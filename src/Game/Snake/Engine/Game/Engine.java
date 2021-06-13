package Game.Snake.Engine.Game;

import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;

    private GenerateCells generateCells = new GenerateCells(numberOfColumnsInPanel,numberOfRowsInPanel);

    public void moveSnake(int direction){
        if (direction == 37){ //left
            int addToNumberOfColumn = -1;
            int addToNumberOfRow = 0;
            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 38){ //up
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = -1;
            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 39){ //right
            int addToNumberOfColumn = 1;
            int addToNumberOfRow = 0;
            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 40){ //down
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = 1;
            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        }
    }
    /**
     * Create initial cells
     */
    public void generateInitialSetUpOfCells() {
        generateCells.generateAllGrayCells();
        generateCells.generateThreeInitialSnakeCells();
        generateCells.generateCellToCatch();
    }

    /**
     * Send list with cells
     */
    public ArrayList<Cell> getAllCellsList() {
        return generateCells.getCells();
    }
    public ArrayList<Cell> getSnakeCellList(){
        return generateCells.getSnakeCells();
    }
    public ArrayList<Integer> getCellsNumberToDelete(){
        return generateCells.getCellsNumberToDelete();
    }
}
