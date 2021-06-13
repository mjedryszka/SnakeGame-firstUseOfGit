package Game.Snake.Engine.Game;

import java.awt.*;

/**
 * Created by Home on 2021-05-31.
 */
public class NextSnakeCells extends Cell implements NextMove {

    public NextSnakeCells(int numberOfColumn, int numberOfRow, Dimension cellDimension) {
        super(numberOfColumn, numberOfRow, cellDimension);
        setBackground(Color.GREEN);
        setIsPartOfSnake(true);
    }

    @Override
    public void makeNextMove() {

    }
}
