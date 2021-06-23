package Game.Snake.Engine.Game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int moveDirection;

    public Controller(Engine engine, View view) {
        this.engine = engine;
        this.view = view;

        engine.generateInitialSetUpOfCells();
        view.setUpCells(engine.getCellsList(), new KeyboardListener());
        view.addActionListenerToButtons(new ButtonListener());
    }
    private void startGame(int direction){
        engine.moveSnakeEngine(direction);
        view.focusOnGamePanel();
        if (engine.isEndGame()){
            System.out.println("END");
            ButtonListener buttonListener = null;
            buttonListener.closeMoveSnakeThread();
        }
    }
    public class ButtonListener implements ActionListener{
        ScheduledExecutorService executorService;

        public void closeMoveSnakeThread(){
            executorService.shutdown();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            moveDirection = 37;
            executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    startGame(moveDirection);
                }
            }, 150, 150, TimeUnit.MILLISECONDS);
        }
    }
    public class KeyboardListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            moveDirection = e.getKeyCode();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
