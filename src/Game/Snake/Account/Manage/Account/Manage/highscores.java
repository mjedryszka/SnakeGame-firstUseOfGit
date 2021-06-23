package Game.Snake.Account.Manage.Account.Manage;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Home on 2021-06-23.
 */
public class Highscores {
    private File file = new File("fileDataBase.txt");
    private ArrayList<String> fileNamesAndScores = new ArrayList<>();

    public void getDataFromFileDataBase() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                fileNamesAndScores.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public ArrayList<String> getNamesList() {
        ArrayList<String> namesList = new ArrayList<>();
        for (String lines : fileNamesAndScores) {
            String name = lines.split("\\.", 3)[0];
            namesList.add(name);
        }
        return namesList;
    }

    public ArrayList<String> getHighscoresList() {
        ArrayList<String> highscoresList = new ArrayList<>();
        for (String lines : fileNamesAndScores) {
            String highscore = lines.split("\\.", 3)[2];
            highscoresList.add(highscore);
        }
        return highscoresList;
    }
}
