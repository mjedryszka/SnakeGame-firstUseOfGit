package Game.Snake.Account.Manage;

import Game.Snake.Account.Manage.Account.Manage.CreateAccountFrame;
import Game.Snake.Account.Manage.Account.Manage.HighscoresFrame;
import Game.Snake.Account.Manage.Account.Manage.LoginFrame;
import Game.Snake.Account.Manage.Account.Manage.PlayerName;
import Game.Snake.Engine.Game.Controller;
import Game.Snake.Engine.Game.Engine;
import Game.Snake.Engine.Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-19.
 */
public class MainMenu {
    private JFrame mainMenuFrame;
    private JButton exitButton;
    private JButton loginButton;
    private JButton logoutButton;
    private JButton createAccountButton;
    private JButton hihgscoresButton;
    private JButton settingsButton;
    private JPanel labelsPanel;
    private JPanel buttonsPanel;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel showNameLabel;
    private JButton startGameButton;

    public MainMenu(){
        /**
         * Main menu frame appearance
         */
        mainMenuFrame = new JFrame("Menu");
        mainMenuFrame.setContentPane(mainPanel);
        mainMenuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainMenuFrame.setLocation(500,200);
        mainMenuFrame.setPreferredSize(new Dimension(250,350));
        //Add actions listeners to buttons
        startGameButton.addActionListener(new MenuButtonListener());
        startGameButton.setActionCommand("start");
        loginButton.addActionListener(new MenuButtonListener());
        loginButton.setActionCommand("login");
        logoutButton.addActionListener(new MenuButtonListener());
        logoutButton.setActionCommand("logout");
        createAccountButton.addActionListener(new MenuButtonListener());
        createAccountButton.setActionCommand("create");
        hihgscoresButton.addActionListener(new MenuButtonListener());
        hihgscoresButton.setActionCommand("highscores");
        settingsButton.addActionListener(new MenuButtonListener());
        settingsButton.setActionCommand("settings");
        exitButton.addActionListener(new MenuButtonListener());
        exitButton.setActionCommand("exit");

        setPlayerName();

        mainMenuFrame.pack();
        mainMenuFrame.setVisible(true);
    }

    public class MenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command){
                case "start":
                    if (!showNameLabel.getText().equals("please login")) {
                        Engine engine = new Engine();
                        View view = new View();
                        Controller controller = new Controller(engine, view);
                        mainMenuFrame.dispose();
                    } else {
                        showNameLabel.setForeground(Color.RED);
                    }
                    break;
                case "login":
                    mainMenuFrame.dispose();
                    LoginFrame loginFrame = new LoginFrame();
                    break;
                case "logout":
                    PlayerName playerName = new PlayerName();
                    playerName.setPlayerName(null);
                    mainMenuFrame.dispose();
                    new MainMenu();
                    break;
                case "create":
                    CreateAccountFrame createAccountFrame = new CreateAccountFrame();
                    mainMenuFrame.dispose();
                    break;
                case "highscores":
                    HighscoresFrame highscoresFrame = new HighscoresFrame();
                    break;
                case "settings":
                    System.out.println("settings");
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }
    private void setPlayerName(){
        if (PlayerName.getPlayerName() != null) {
            showNameLabel.setText(PlayerName.getPlayerName());
            showNameLabel.setForeground(Color.GREEN);
        }
    }
}
