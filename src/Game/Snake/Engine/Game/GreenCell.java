package Game.Snake.Engine.Game;

import java.awt.*;

/**
 * Created by Home on 2021-05-31.
 */
public class GreenCell extends Cell {

    public GreenCell(int numberOfColumn, int numberOfRow, Dimension cellDimension) {
        super(numberOfColumn, numberOfRow, cellDimension);
        setBackground(Color.GREEN);
    }
}
