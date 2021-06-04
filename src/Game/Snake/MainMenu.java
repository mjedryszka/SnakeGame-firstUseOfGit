package Game.Snake;

import Game.Snake.Engine.Game.Controller;
import Game.Snake.Engine.Game.Engine;
import Game.Snake.Engine.Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2021-05-30.
 */
public class MainMenu{
    private JFrame mainMenu;
    private JButton startGameButton;
    private Dimension dimension = new Dimension(150,30);

    public MainMenu() {
        mainMenu = new JFrame("Menu");
        mainMenu.setSize(300,500);
        mainMenu.setLocation(200,400);
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainMenu.setLayout(null);

        startGameButton = new JButton("Start");
        startGameButton.setSize(dimension);
        startGameButton.setLocation(50, 50);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine engine = new Engine();
                View view = new View();
                Controller controller = new Controller(engine,view);
            }
        });
        mainMenu.add(startGameButton);

        mainMenu.setVisible(true);
    }
}
