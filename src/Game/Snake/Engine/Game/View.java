package Game.Snake.Engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Home on 2021-05-30.
 */
public class View implements KeyListener{
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

    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private Dimension boxDimension = new Dimension(15,15);


    public View() {
        /**
         * Create frame
         */
        viewFrame = new JFrame("View");
        viewFrame.setContentPane(mainPanel);
        viewFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        /**
         * Create boxes
         */
        gamePanel.setLayout(new GridBagLayout());
        gamePanel.addKeyListener(this);
        gamePanel.setFocusable(true);

//        startGameButton.addKeyListener(this);
        viewFrame.pack();
        gamePanel.requestFocusInWindow();
        viewFrame.setVisible(true);
    }
    public void setupBoxes(ArrayList<Box> boxesList){
        for (Box box : boxesList){
            GridBagConstraints gamePanelConstraints = new GridBagConstraints();
            int columnNumber = box.getNumberOfColumn();
            int rowNumber = box.getNumberOfRow();
            gamePanelConstraints.gridx=columnNumber;
            gamePanelConstraints.gridy=rowNumber;
            gamePanel.add(box,gamePanelConstraints);
        }
        viewFrame.pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("aaaa");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("bbb");
        System.out.println(e.getExtendedKeyCode());
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
        System.out.println(e.getKeyLocation());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
