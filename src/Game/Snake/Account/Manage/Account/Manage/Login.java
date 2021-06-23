package Game.Snake.Account.Manage.Account.Manage;

import java.io.*;

/**
 * Created by Home on 2021-06-23.
 */
public class Login {
    private String name;
    private String password;
    private String passwordFromFile;
    private File file = new File("fileDataBase.txt");

    public Login (String name,String password){
        this.name = name;
        this.password = password;
    }

    public boolean checkIfNameExistInFile(){
        boolean isNameExist = false;
        try (FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line = bufferedReader.readLine();
            while (line != null){
                String existName = line.split("\\.",3)[0];//takeName
                if (name.equals(existName)){
                    passwordFromFile = line.split("\\.",3)[1];//Save password from file in passwordFromFile
                    isNameExist = true;
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exc){
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        }
        return isNameExist;
    }

    public boolean comparePassword(){
        if (password.equals(passwordFromFile)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set player name in PlayerName class
     */
    public void setPlayerName(){
        PlayerName playerName = new PlayerName();
        playerName.setPlayerName(name);
    }
}

