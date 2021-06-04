package Game.Snake.Engine.Game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Home on 2021-05-30.
 */
public class Controller {
    private Engine engine;
    private View view;

    public Controller(Engine engine, View view) {
        this.engine = engine;
        this.view = view;

        engine.createBoxInEngine();
        view.setupBoxes(engine.getBoxesList(),new KeyboardListener());


    }
    public class KeyboardListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("bbb");
            System.out.println(e.getKeyChar());
            System.out.println(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
