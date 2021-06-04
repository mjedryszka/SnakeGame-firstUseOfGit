package Game.Snake.Engine.Game;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public abstract class Box extends JPanel {
    private int numberOfColumn;
    private int numberOfRow;
    private boolean isGreen;
    private boolean isPartOfSnake;

    public Box(int numberOfColumn, int numberOfRow, boolean isGreen, boolean isPartOfSnake) {
        this.numberOfColumn = numberOfColumn;
        this.numberOfRow = numberOfRow;
        this.isGreen = isGreen;
        this.isPartOfSnake = isPartOfSnake;

    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setIsGreen(boolean isGreen) {
        this.isGreen = isGreen;
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
