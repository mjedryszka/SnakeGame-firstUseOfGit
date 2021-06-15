package Game.Snake.Engine.Game;

import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private ArrayList<Cell> snakeCellList = new ArrayList<>();

    private GenerateCells generateCells = new GenerateCells(numberOfColumnsInPanel,numberOfRowsInPanel);
    private MoveSnake moveSnake;

    public void moveSnake(int direction){
        if (direction == 37){ //left
            int addToNumberOfColumn = -1;
            int addToNumberOfRow = 0;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
//            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 38){ //up
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = -1;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
//            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 39){ //right
            int addToNumberOfColumn = 1;
            int addToNumberOfRow = 0;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
//            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 40){ //down
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = 1;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
//            generateCells.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        }

    }
    /**
     * Create initial cells
     */
    public void generateInitialSetUpOfCells() {
        generateCells.generateAllGrayCells();
        generateCells.generateThreeInitialSnakeCells();
        generateCells.generateCellToCatch();
        setSnakeCellList(generateCells.getSnakeCells());
    }
    /**
     *Get and sett snake cells list
     */
    public ArrayList<Cell> getSnakeCellList() {
        return snakeCellList;
    }
    private void setSnakeCellList(ArrayList<Cell> snakeCellList) {
        this.snakeCellList = snakeCellList;
    }
    /**
     * Send list with cells
     */
    public  Cell[][] getCellsList(){
        return generateCells.getCells();
    }

}
