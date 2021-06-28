package Game.Snake.Engine.Game;

import jdk.nashorn.internal.ir.IfNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Home on 2021-06-26.
 */
public class ShowHighscores {
    private String name;
    private String numberOfPoints;
    private File file = new File("fileDataBase.txt");
    private HashMap<Integer, String> namesList = new HashMap<>();
    private HashMap<Integer, Integer> pointsList = new HashMap<>();

    public ShowHighscores() {
        getDataFromFileDataBaseAndAddToMap();
        getHighestResult();
    }

    private void getHighestResult() {
        int highestPlayerPoints = -1;
        int bestPlayerKey = 0;
        for (int playerKey = 0; playerKey < pointsList.size(); playerKey++) {
            int playerPoints = pointsList.get(playerKey);
            if (playerPoints > highestPlayerPoints) {
                highestPlayerPoints = playerPoints;
                bestPlayerKey = playerKey;
            }
        }
        numberOfPoints = pointsList.get(bestPlayerKey).toString();
        name = namesList.get(bestPlayerKey);
    }

    private void getDataFromFileDataBaseAndAddToMap() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            int placeInMap = 0;
            while (line != null) {
                String nameFromFile = line.split("\\.", 3)[0];
                int pointsFromFile = Integer.parseInt(line.split("\\.", 3)[2]);
                namesList.put(placeInMap, nameFromFile);
                pointsList.put(placeInMap, pointsFromFile);
                placeInMap++;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getNumberOfPoints() {
        return numberOfPoints;
    }
}
