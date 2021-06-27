package Game.Snake.Account.Manage.Account.Manage;

import Game.Snake.Account.Manage.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-06-26.
 */
public class SettingsFrame implements ActionListener {
    private JFrame settingsFrame;
    private JRadioButton a50x90Button;
    private JRadioButton a50x50Button;
    private JRadioButton a30x30Button;
    private JButton backButton;
    private JPanel settingsPanel;
    private JLabel tittleLabel;

    /**
     * Create initial settings
     */
    Settings settings = new Settings();

    public SettingsFrame() {
        settingsFrame = new JFrame("Settings");
        settingsFrame.setContentPane(settingsPanel);
        settingsFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        settingsFrame.setLocation(500, 300);
        settingsFrame.setPreferredSize(new Dimension(170, 210));
        //add action listener to buttons
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        a30x30Button.addActionListener(this);
        a30x30Button.setActionCommand("30x30");
        a50x50Button.addActionListener(this);
        a50x50Button.setActionCommand("50x50");
        a50x90Button.addActionListener(this);
        a50x90Button.setActionCommand("50x90");
        //add radio buttons to group
        ButtonGroup chooseBoardSizeGroup = new ButtonGroup();
        chooseBoardSizeGroup.add(a30x30Button);
        chooseBoardSizeGroup.add(a50x50Button);
        chooseBoardSizeGroup.add(a50x90Button);

        selectInitialSizeButton();

        settingsFrame.pack();
        settingsFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "30x30":
                settings.setGameBoardSize("30x30");
                break;
            case "50x50":
                settings.setGameBoardSize("50x50");
                break;
            case "50x90":
                settings.setGameBoardSize("50x90");
                break;
            case "back":
                settingsFrame.dispose();
                MainMenu mainMenu = new MainMenu();
                break;
        }
    }

    private void selectInitialSizeButton() {
        String initialButtonSelect = Settings.getGameBoardSize();
        switch (initialButtonSelect) {
            case "50x90":
                a50x90Button.setSelected(true);
                break;
            case "50x50":
                a50x50Button.setSelected(true);
                break;
            case "30x30":
                a30x30Button.setSelected(true);
                break;
        }
    }
}
