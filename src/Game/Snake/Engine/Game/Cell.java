package Game.Snake.Engine.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Home on 2021-05-30.
 */
public class Cell extends JPanel {
    private int numberOfColumn;
    private int numberOfRow;
    private boolean isCatchCell;
    private boolean isPartOfSnake;

    public Cell(int numberOfColumn, int numberOfRow, Dimension cellDimension) {
        this.numberOfColumn = numberOfColumn;
        this.numberOfRow = numberOfRow;
        this.isCatchCell = false;
        this.isPartOfSnake = false;
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(cellDimension);
    }

    public boolean isCatchCell() {
        return isCatchCell;
    }

    public void setIsCatchCell(boolean isGreen) {
        this.isCatchCell = isGreen;
    }

    public boolean isPartOfSnake() {
        return isPartOfSnake;
    }

    public void setIsPartOfSnake(boolean isPartOfSnake) {
        this.isPartOfSnake = isPartOfSnake;
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

}
