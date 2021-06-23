package Game.Snake.Account.Manage.Account.Manage;

import Game.Snake.Account.Manage.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-23.
 */
public class HighscoresFrame implements ActionListener{
    private JFrame highscoresFrame;
    private JTextArea nameTextArea;
    private JTextArea scoresTextArea;
    private JButton backButton;
    private JPanel highscoresPanel;

    public HighscoresFrame(){
        highscoresFrame = new JFrame("Highscores");
        highscoresFrame.setContentPane(highscoresPanel);
        highscoresFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        highscoresFrame.setLocation(500, 300);
        highscoresFrame.setPreferredSize(new Dimension(250, 300));
        //add action listener to button
        backButton.addActionListener(this);
        //show highscores
        showHighscores();

        highscoresFrame.pack();
        highscoresFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        highscoresFrame.dispose();
        MainMenu mainMenu = new MainMenu();
    }
    private void showHighscores(){
        Highscores highscores = new Highscores();
        //Show name list
        highscores.getDataFromFileDataBase();
        for (String name : highscores.getNamesList()) nameTextArea.append(name + "\n");
        //Show highscores
        for (String highscore : highscores.getHighscoresList()) scoresTextArea.append(highscore + "\n");
    }
}
