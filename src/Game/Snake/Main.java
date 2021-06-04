package Game.Snake;

import java.awt.*;

/**
 * Created by Home on 2021-05-30.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu();
            }
        });
    }
}
