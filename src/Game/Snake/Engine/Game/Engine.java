package Game.Snake.Engine.Game;

import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private ArrayList<Cell> snakeCellList;
    private Cell cellsList[][];

    private GenerateCells generateCells = new GenerateCells(numberOfColumnsInPanel,numberOfRowsInPanel);
    private MoveSnake moveSnake;

    public void moveSnakeEngine(int direction){
        if (!isCellToCatchAvailable()){
            generateCells.generateCellToCatch();
            setCellsList(generateCells.getCell());
        }
        if (direction == 37){ //left
            int addToNumberOfColumn = -1;
            int addToNumberOfRow = 0;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 38){ //up
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = -1;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 39){ //right
            int addToNumberOfColumn = 1;
            int addToNumberOfRow = 0;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        } else if (direction == 40){ //down
            int addToNumberOfColumn = 0;
            int addToNumberOfRow = 1;
            moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
            moveSnake.moveSnake(addToNumberOfColumn,addToNumberOfRow);
        }
        setSnakeCellList(moveSnake.getSnakeCells());
        setCellsList(moveSnake.getCell());
    }

    private boolean isCellToCatchAvailable(){
        boolean isCellToCatchAvailable = false;
       for (int i =0;i<numberOfColumnsInPanel;i++){
           for (int j=0;j<numberOfRowsInPanel;j++){
               if (cellsList[i][j].isCatchCell()){
                   isCellToCatchAvailable = true;
               }
           }
       }
        return isCellToCatchAvailable;
    }
    /**
     * Create initial cells
     */
    public void generateInitialSetUpOfCells() {
        generateCells.generateAllGrayCells();
        generateCells.generateThreeInitialSnakeCells();
        generateCells.generateCellToCatch();
        setSnakeCellList(generateCells.getSnakeCells());
        setCellsList(generateCells.getCell());
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
     * Get and set cells list
     */
    public Cell[][] getCellsList() {
        return cellsList;
    }
    private void setCellsList(Cell[][] cellsList) {
        this.cellsList = cellsList;
    }
}
