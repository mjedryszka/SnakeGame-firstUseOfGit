package Game.Snake.Engine.Game;

import Game.Snake.Account.Manage.Account.Manage.Settings;

import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel;
    private int numberOfRowsInPanel;
    private int currentDirection;
    private boolean endGame = false;
    private ArrayList<Cell> snakeCellList;
    private Cell cellsList[][];
    private GenerateCells generateCells;
    private MoveSnake moveSnake;


    public void moveSnakeEngine(int direction) {
        boolean moveIsMade = false;
        moveSnake = new MoveSnake(getSnakeCellList(), getCellsList());
        moveSnake.setNumberOfColumnsInGamePanel(numberOfColumnsInPanel);
        moveSnake.setNumberOfRowsInGamePanel(numberOfRowsInPanel);
        if (!isCellToCatchAvailable()) {
            generateCells.generateCellToCatch();
            setCellsList(generateCells.getCells());
        }
        while (!moveIsMade) {
            if (direction == 37 && currentDirection != 39) { //left
                int addToNumberOfColumn = -1;
                int addToNumberOfRow = 0;
                currentDirection = direction;
                moveIsMade = true;
                moveSnake.moveSnake(addToNumberOfColumn, addToNumberOfRow);
            } else if (direction == 38 && currentDirection != 40) { //up
                int addToNumberOfColumn = 0;
                int addToNumberOfRow = -1;
                currentDirection = direction;
                moveIsMade = true;
                moveSnake.moveSnake(addToNumberOfColumn, addToNumberOfRow);
            } else if (direction == 39 && currentDirection != 37) { //right
                int addToNumberOfColumn = 1;
                int addToNumberOfRow = 0;
                currentDirection = direction;
                moveIsMade = true;
                moveSnake.moveSnake(addToNumberOfColumn, addToNumberOfRow);
            } else if (direction == 40 && currentDirection != 38) { //down
                int addToNumberOfColumn = 0;
                int addToNumberOfRow = 1;
                currentDirection = direction;
                moveIsMade = true;
                moveSnake.moveSnake(addToNumberOfColumn, addToNumberOfRow);
            }
            direction = currentDirection;
        }
        setSnakeCellList(moveSnake.getSnakeCells());
        setCellsList(moveSnake.getCells());
        setEndGame(moveSnake.isEndGame());
    }

    public void setNumbersOfColumnsAndRowsInGenerateCellsClass() {
        generateCells = new GenerateCells(numberOfColumnsInPanel, numberOfRowsInPanel);
    }

    public void getGamePanelSizeFromSettings() {
        String panelSize = Settings.getGameBoardSize();
        switch (panelSize) {
            case "30x30":
                this.numberOfColumnsInPanel = 30;
                numberOfRowsInPanel = 30;
                break;
            case "50x50":
                numberOfColumnsInPanel = 50;
                numberOfRowsInPanel = 50;
                break;
            case "50x90":
                this.numberOfColumnsInPanel = 90;
                this.numberOfRowsInPanel = 50;
                break;
        }
    }

    private boolean isCellToCatchAvailable() {
        boolean isCellToCatchAvailable = false;
        for (int i = 0; i < numberOfColumnsInPanel; i++) {
            for (int j = 0; j < numberOfRowsInPanel; j++) {
                if (cellsList[i][j].isCatchCell()) {
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
        generateCells.generateCellsAroundGamePanel();
        setSnakeCellList(generateCells.getSnakeCells());
        setCellsList(generateCells.getCells());
    }

    /**
     * Getters and setters
     */
    public ArrayList<Cell> getSnakeCellList() {
        return snakeCellList;
    }

    private void setSnakeCellList(ArrayList<Cell> snakeCellList) {
        this.snakeCellList = snakeCellList;
    }

    public Cell[][] getCellsList() {
        return cellsList;
    }

    private void setCellsList(Cell[][] cellsList) {
        this.cellsList = cellsList;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public int getNumberOfRowsInPanel() {
        return numberOfRowsInPanel;
    }

    public int getNumberOfColumnsInPanel() {
        return numberOfColumnsInPanel;
    }
}
