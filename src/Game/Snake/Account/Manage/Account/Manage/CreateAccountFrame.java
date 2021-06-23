package Game.Snake.Account.Manage.Account.Manage;

import Game.Snake.Account.Manage.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-21.
 */
public class CreateAccountFrame implements ActionListener {
    private MainMenu mainMenu;
    private JFrame createAccountFrame;
    private JPanel createAccountPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel buttomPanel;
    private JTextField nameTextField;
    private JPasswordField passwordTextField;
    private JPasswordField repeatPasswordTextField;
    private JButton createButton;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel paswordLabel;
    private JLabel repeatPasswordLabel;
    private JLabel statusLabel;

    private String name;
    private String password;
    private String repeatPassword;

    public CreateAccountFrame() {
        //Frame appearance
        createAccountFrame = new JFrame("Create Account");
        createAccountFrame.setContentPane(createAccountPanel);
        createAccountFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        createAccountFrame.setLocation(500, 200);
        createAccountFrame.setPreferredSize(new Dimension(350, 220));
        //Add action listeners
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        createButton.addActionListener(this);
        createButton.setActionCommand("create");

        createAccountFrame.pack();
        createAccountFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "back":
                createAccountFrame.dispose();
                mainMenu = new MainMenu();
                break;
            case "create":
                setName(nameTextField.getText());
                setPassword(passwordTextField.getText());
                setRepeatPassword(repeatPasswordTextField.getText());
                //Check if name and password have three signs and don't contain '.'
                //Next Compare password with repeated password
                //Next check if name exists in file
                //If name not exists create account
                if (hasNameThreeSigns() && hasPasswordThreeSings() && isRepeatPasswordEqualPassword() && !areNameAndPasswordHaveDot()) {
                    CreateAccount createAccount = new CreateAccount(name, password);
                    if (createAccount.isNameExist()) {
                        statusLabel.setText("Name exist, choose another");
                        statusLabel.setForeground(Color.RED);
                    } else {
                        createAccount.createAccount();
                        createAccount.setPlayerName();
                        statusLabel.setText("Account created");
                        statusLabel.setForeground(Color.GREEN);
                        nameTextField.setText(null);
                        passwordTextField.setText(null);
                        repeatPasswordTextField.setText(null);
                    }
                }
                break;
        }
    }

    private boolean isRepeatPasswordEqualPassword() {
        if (repeatPassword.equals(password)) {
            return true;
        } else {
            statusLabel.setText("Password and repeat password are not the same");
            statusLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean hasPasswordThreeSings() {
        if (password.length() >= 3) {
            return true;
        } else {
            statusLabel.setText("Password does not have three signs");
            statusLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean hasNameThreeSigns() {

        if (name.length() >= 3) {
            return true;
        } else {
            statusLabel.setText("Name does not have three signs");
            statusLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean areNameAndPasswordHaveDot() {
        if (name.contains(".") || password.contains(".")) {
            statusLabel.setText("Name or pasword can not contain '.'");
            statusLabel.setForeground(Color.RED);
            return true;
        } else {
            return false;
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
