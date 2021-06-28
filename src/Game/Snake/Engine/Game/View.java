package Game.Snake.Engine.Game;

import Game.Snake.Account.Manage.Account.Manage.PlayerName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by Home on 2021-05-30.
 */
public class View {
    private JFrame viewFrame;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JLabel bestPlayerNameLabel;
    private JLabel bestPlayerNumberOfPointsLabel;
    private JLabel yourNameLabel;
    private JLabel yourNumberOfPointsLabelLabel;
    private JButton startGameButton;
    private JButton backButton;
    private JPanel menuItemsPanel;
    private JLabel bestPlayerLabel;
    private int numberOfColumnsInPanel;
    private int numberOfRowInPanel;

    /**
     * Create frame
     */
    public View() {
        viewFrame = new JFrame("View");
        viewFrame.setContentPane(mainPanel);
        viewFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        gamePanel.setLayout(new GridBagLayout());
        //show results panel
        showHighscoresOnGamePanel();
        showPlayerNameOnGamePanel();
        showPlayerPointsOnGamePanel();

        viewFrame.pack();
        gamePanel.requestFocusInWindow();
        viewFrame.setVisible(true);
    }

    public void getNumberOfColumnsAndRowsInPanel(int numberOfColumn, int numberOfRow) {
        this.numberOfColumnsInPanel = numberOfColumn;
        this.numberOfRowInPanel = numberOfRow;
    }

    public void showPlayerPointsOnGamePanel() {
        yourNumberOfPointsLabelLabel.setText(String.valueOf(CountPlayerPoints.getPlayerPoints()));
    }

    private void showPlayerNameOnGamePanel() {
        yourNameLabel.setText(PlayerName.getPlayerName());
    }

    private void showHighscoresOnGamePanel() {
        ShowHighscores showHighscores = new ShowHighscores();
        bestPlayerNameLabel.setText(showHighscores.getName());
        bestPlayerNumberOfPointsLabel.setText(showHighscores.getNumberOfPoints());
    }

    public void addActionListenerToButtons(ActionListener buttonListener) {
        startGameButton.addActionListener(buttonListener);
        startGameButton.setActionCommand("start");
        backButton.addActionListener(buttonListener);
        backButton.setActionCommand("back");
    }

    public void closeGameFrame() {
        viewFrame.dispose();
    }

    /**
     * Add focus on game panel, game panel is key listener
     */
    public void focusOnGamePanel() {
        gamePanel.requestFocus();
    }

    /**
     * Create cells and add kye listener to game panel
     */
    public void setUpCells(Cell[][] cells, KeyListener keyListener) {
        gamePanel.removeAll();
        for (int i = 0; i < numberOfColumnsInPanel; i++) {
            for (int j = 0; j < numberOfRowInPanel; j++) {
                GridBagConstraints gamePanelConstraints = new GridBagConstraints();
                gamePanelConstraints.gridx = i;
                gamePanelConstraints.gridy = j;
                gamePanel.add(cells[i][j], gamePanelConstraints);
            }
        }
        gamePanel.addKeyListener(keyListener);
        gamePanel.setFocusable(true);

        viewFrame.pack();
        gamePanel.requestFocusInWindow();
    }
}
