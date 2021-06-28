package Game.Snake.Engine.Game;

import Game.Snake.Account.Manage.Account.Manage.PlayerName;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-06-28.
 */
public class SavePlayerPointsToFile {
    private int playerPoints;
    private String playerName;
    private boolean playerSetNewRecord = false;
    private File file = new File("fileDataBase.txt");
    private ArrayList<String> dataFromFile = new ArrayList<>();

    public void savePoints() {
        getPlayerName();
        getPlayerPoints();
        getDataFromFile();
        changePointsNumberInArrayList();
        if (playerSetNewRecord) {
            saveDataToFile();
        }
    }

    private void getPlayerPoints() {
        this.playerPoints = CountPlayerPoints.getPlayerPoints();
    }

    private void getPlayerName() {
        this.playerName = PlayerName.getPlayerName();
    }

    private void getDataFromFile() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                dataFromFile.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private void changePointsNumberInArrayList() {
        //Compare lists name with player name
        for (int i = 0; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            String name = line.split("\\.", 3)[0];
            if (name.equals(playerName)) { //If names are the same
                int points = Integer.parseInt(line.split("\\.", 3)[2]);//Get points
                if (playerPoints > points) {//Compare points with player points
                    String password = line.split("\\.", 3)[1];
                    String newLine = name + "." + password + "." + playerPoints;//Create new 'record'
                    dataFromFile.set(i, newLine);
                    playerSetNewRecord = true;
                }
            }
        }
    }

    private void saveDataToFile() {
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String newData : dataFromFile) {
                bufferedWriter.append(newData);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

}
