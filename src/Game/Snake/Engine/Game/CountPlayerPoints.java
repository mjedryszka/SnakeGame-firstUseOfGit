package Game.Snake.Engine.Game;

/**
 * Created by Home on 2021-06-27.
 */
public class CountPlayerPoints {
    private static int playerPoints = 0;

    public static void addTenPoints() {
        playerPoints = playerPoints + 10;
    }

    public static int getPlayerPoints() {
        return playerPoints;
    }

}
