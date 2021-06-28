package Game.Snake.Engine.Game;

import Game.Snake.Account.Manage.Account.Manage.PlayerName;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-27.
 */
public class EndGameFrame {
    private JFrame endGameFrame;
    private JButton playAgainButton;
    private JButton backToMenuButton;
    private JPanel endGamePanel;
    private JLabel nameLabel;
    private JLabel pointsLabel;
    private JLabel congratulationLabel;

    public EndGameFrame() {
        endGameFrame = new JFrame("End game");
        endGameFrame.setContentPane(endGamePanel);
        endGameFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        endGameFrame.setLocation(500, 200);
        endGameFrame.setPreferredSize(new Dimension(250, 250));

        setEndGameFrameText();

        endGameFrame.pack();
        endGameFrame.setVisible(true);
    }

    public void closeEndGameFrame() {
        endGameFrame.dispose();
    }

    public void addActionListenersToButtons(ActionListener actionListener) {
        playAgainButton.addActionListener(actionListener);
        playAgainButton.setActionCommand("playAgain");
        backToMenuButton.addActionListener(actionListener);
        backToMenuButton.setActionCommand("backToMenu");
    }

    private void setEndGameFrameText() {
        setNameInLabel();
        setPointsInLabel();
    }

    private void setNameInLabel() {
        String name = PlayerName.getPlayerName();
        nameLabel.setText(name + " you got");
    }

    private void setPointsInLabel() {
        String points = String.valueOf(CountPlayerPoints.getPlayerPoints());
        pointsLabel.setText(points);
    }
}
