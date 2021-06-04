package Game.Snake.Engine.Game;

/**
 * Created by Home on 2021-05-31.
 */
public class FirstSnakeBox extends Box implements FirstMove {
    public FirstSnakeBox(int numberOfColumn, int numberOfRow, boolean isGreen, boolean isPartOfSnake) {
        super(numberOfColumn, numberOfRow, isGreen, isPartOfSnake);
    }

    @Override
    public void makeFirstMove() {

    }
}
