package Game.Snake.Account.Manage.Account.Manage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Home on 2021-06-21.
 */
public class CreateAccount {
    private String name;
    private String password;
    private ArrayList<String> fileNames = new ArrayList<>();
    private File file = new File("fileDataBase.txt");

    public CreateAccount(String name, String password) {
        this.name = name;
        this.password = password;
        /**
         * Check if file to save data exist
         */
        try {
            if (!file.isFile()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isNameExist() {
        boolean isNameExist = false;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            fileNames.clear();
            while (line != null) {
                fileNames.add(line);
                line = bufferedReader.readLine();
            }
            for (String fileName : fileNames) {
                String existName = fileName.split("\\.", 3)[0];
                if (!existName.isEmpty()) {
                    if (name.equals(existName)) {
                        isNameExist = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isNameExist;
    }

    public void createAccount() {
        String dataToWrite = name + "." + password + "." + "0";
        fileNames.add(dataToWrite);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String fileName : fileNames) {
                bufferedWriter.append(fileName);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set player name in PlayrName class
     */
    public void setPlayerName() {
        PlayerName playerName = new PlayerName();
        playerName.setPlayerName(name);
    }
}
