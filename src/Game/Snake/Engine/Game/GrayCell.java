package Game.Snake.Engine.Game;

import java.awt.*;

/**
 * Created by Home on 2021-05-31.
 */
public class GrayCell extends Cell {

    public GrayCell(int numberOfColumn, int numberOfRow, Dimension cellDimension) {
        super(numberOfColumn, numberOfRow, cellDimension);
        setBackground(Color.GRAY);
    }
}
