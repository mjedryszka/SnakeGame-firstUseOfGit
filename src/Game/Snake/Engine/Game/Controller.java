package Game.Snake.Engine.Game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        view.setupBoxes(engine.getBoxesList(), new KeyboardListener());
        for (int i=0;i<=10;i++){
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    startGame(37);
                }
            }, 0, 2, TimeUnit.SECONDS);

    }
    }
    private void startGame(int direction){
        engine.moveSnake(direction);
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
