package Game.Snake.Account.Manage.Account.Manage;

import Game.Snake.Account.Manage.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-22.
 */
public class LoginFrame implements ActionListener{
    private JFrame loginFrame;
    private JButton loginButton;
    private JButton backButton;
    private JPanel loginPanel;
    private JLabel statusLable;
    private JLabel nameLabel;
    private JLabel passwordLable;
    private JTextField nameTextField;
    private JPasswordField passwordTextField;

    public LoginFrame(){
        loginFrame = new JFrame("Login");
        loginFrame.setContentPane(loginPanel);
        loginFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        loginFrame.setLocation(500,200);
        loginFrame.setPreferredSize(new Dimension(250,180));
        //Add action listener
        loginButton.addActionListener(this);
        loginButton.setActionCommand("login");
        backButton.addActionListener(this);
        backButton.setActionCommand("back");

        loginFrame.pack();
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "login":
                String name = nameTextField.getText();
                String password = passwordTextField.getText();
                Login login = new Login(name, password);
                if (login.checkIfNameExistInFile()){
                    if (login.comparePassword()){
                        loginFrame.dispose();
                        login.setPlayerName();
                        MainMenu mainMenu = new MainMenu();
                    } else {
                        statusLable.setText("Password is not correct");
                        statusLable.setForeground(Color.RED);
                    }
                } else {
                    statusLable.setText("Name not exist");
                    statusLable.setForeground(Color.RED);
                }
                break;
            case "back":
                loginFrame.dispose();
                MainMenu mainMenu = new MainMenu();
                break;
        }
    }
}
