package Game.Snake.Engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class View {
    private JFrame viewFrame;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JLabel highScoreLabel;
    private JLabel showHighScoreLabel;
    private JLabel yourScoreLabel;
    private JLabel showYourScoreLabel;
    private JButton startGameButton;
    private JButton backButton;
    private JPanel menuItemsPanel;

    /**
     * Create frame
     */
    public View() {
        viewFrame = new JFrame("View");
        viewFrame.setContentPane(mainPanel);
        viewFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        gamePanel.setLayout(new GridBagLayout());

        viewFrame.pack();
        gamePanel.requestFocusInWindow();
        viewFrame.setVisible(true);
    }
    /**
     *Create cells and add kye listener to game panel
     */
    public void setUpCells(ArrayList<Box> boxesList, KeyListener keyListener){
        gamePanel.removeAll();
        for (Box box : boxesList){
            GridBagConstraints gamePanelConstraints = new GridBagConstraints();
            int columnNumber = box.getNumberOfColumn();
            int rowNumber = box.getNumberOfRow();
            gamePanelConstraints.gridx=columnNumber;
            gamePanelConstraints.gridy=rowNumber;
            gamePanel.add(box,gamePanelConstraints);
        }
        gamePanel.remove(1);
        gamePanel.addKeyListener(keyListener);
        gamePanel.setFocusable(true);

        viewFrame.pack();
        gamePanel.requestFocusInWindow();
    }
    /**
     *Move snake
     */
    public void chagneSnakePosition(ArrayList<Box> boxesList,ArrayList<Integer> boxesNumberList){
        /**
         * Delete gray cells
         */
        boxesNumberList.stream()
                .forEach(gamePanel::remove);
        /**
         * Create new green cells
         */
        for (Box box : boxesList){
            GridBagConstraints gamePanelConstraints = new GridBagConstraints();
            int columnNumber = box.getNumberOfColumn();
            int rowNumber = box.getNumberOfRow();
            gamePanelConstraints.gridx=columnNumber;
            gamePanelConstraints.gridy=rowNumber;
            gamePanel.add(box,gamePanelConstraints);
        }
        gamePanel.setFocusable(true);
        viewFrame.pack();
        gamePanel.requestFocusInWindow();
    }
}
