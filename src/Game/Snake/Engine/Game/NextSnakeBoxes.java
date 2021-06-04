package Game.Snake.Engine.Game;

/**
 * Created by Home on 2021-05-31.
 */
public class NextSnakeBoxes extends Box implements NextMove {
    public NextSnakeBoxes(int numberOfColumn, int numberOfRow, boolean isGreen, boolean isPartOfSnake) {
        super(numberOfColumn, numberOfRow, isGreen, isPartOfSnake);
    }

    @Override
    public void makeNextMove() {

    }
}
