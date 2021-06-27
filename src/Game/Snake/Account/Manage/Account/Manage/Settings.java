package Game.Snake.Account.Manage.Account.Manage;

/**
 * Created by Home on 2021-06-26.
 */
public class Settings {
    private static String gameBoardSize;

    public Settings(){
        if (gameBoardSize == null){
            gameBoardSize = "50x90";
        }
    }

    public static String getGameBoardSize() {
        if (gameBoardSize == null){
            Settings settings = new Settings();
        }
        return gameBoardSize;
    }

    public void setGameBoardSize(String gameBoardSize) {
        Settings.gameBoardSize = gameBoardSize;
    }
}
