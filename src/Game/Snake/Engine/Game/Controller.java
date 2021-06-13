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
        view.setUpCells(engine.getAllCellsList(), new KeyboardListener());
        view.addAct(new ButtonListener());
    }
    private void startGame(int direction){
        engine.moveSnake(direction);
        view.chagneSnakePosition(engine.getSnakeCellList(), engine.getCellsNumberToDelete());

    }
    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            moveDirection = 40;
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    startGame(moveDirection);
                }
            }, 1, 1, TimeUnit.SECONDS);
        }
    }
    public class KeyboardListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            moveDirection = e.getKeyCode();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
