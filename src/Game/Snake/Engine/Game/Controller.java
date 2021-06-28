package Game.Snake.Engine.Game;


import Game.Snake.Account.Manage.MainMenu;

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
    private ScheduledExecutorService executorService;
    private EndGameFrame endGameFrame;


    public Controller(Engine engine, View view) {
        this.engine = engine;
        this.view = view;
        //Get game panel size
        engine.getGamePanelSizeFromSettings();
        //Initialize generate cells class
        engine.setNumbersOfColumnsAndRowsInGenerateCellsClass();
        //Send number of columns and rows to view class
        view.getNumberOfColumnsAndRowsInPanel(engine.getNumberOfColumnsInPanel(), engine.getNumberOfRowsInPanel());
        //Create initial cells
        engine.generateInitialSetUpOfCells();
        view.setUpCells(engine.getCellsList(), new KeyboardListenerOnGamePanel());
        //Add action listener
        view.addActionListenerToButtons(new ButtonListenerOnGamePanel());
        //Start points counter
        CountPlayerPoints countPlayerPoints = new CountPlayerPoints();
    }

    private void startGame(int direction) {
        engine.moveSnakeEngine(direction);
        view.focusOnGamePanel();
        view.showPlayerPointsOnGamePanel();
        if (engine.isEndGame()) {
            closeMoveSnakeThread();
            endGameFrame = new EndGameFrame();
            endGameFrame.addActionListenersToButtons(new ButtonListenerOnGamePanel());
            SavePlayerPointsToFile savePlayerPointsToFile = new SavePlayerPointsToFile();
            savePlayerPointsToFile.savePoints();
            CountPlayerPoints.resetCounter();
        }
    }

    private void closeMoveSnakeThread() {
        executorService.shutdown();
    }

    public class ButtonListenerOnGamePanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "start":
                    moveDirection = 37;
                    executorService = Executors.newSingleThreadScheduledExecutor();
                    executorService.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            startGame(moveDirection);
                        }
                    }, 150, 150, TimeUnit.MILLISECONDS);
                    break;
                case "back":
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                    view.closeGameFrame();
                    MainMenu mainMenu = new MainMenu();
                    break;
                case "backToMenu":
                    endGameFrame.closeEndGameFrame();
                    view.closeGameFrame();
                    MainMenu mainMenu1 = new MainMenu();
                    break;
                case "playAgain":
                    endGameFrame.closeEndGameFrame();
                    view.closeGameFrame();
                    Engine engine = new Engine();
                    View view = new View();
                    Controller controller = new Controller(engine, view);
            }
        }
    }

    public class KeyboardListenerOnGamePanel implements KeyListener {
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
