package Game.Snake.Engine.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Home on 2021-05-30.
 */
public class Engine {
    private int numberOfColumnsInPanel = 90;
    private int numberOfRowsInPanel = 50;
    private ArrayList<Box> boxes = new ArrayList<>();
    private ArrayList<Box> snakeBoxes = new ArrayList<>();
    private Dimension boxDimension = new Dimension(15, 15);

    private Box box[][] = new Box[numberOfColumnsInPanel][numberOfRowsInPanel];

    /**
     * Move snake
     */
    public void moveSnake(int directionNumber) {
        int snakeHeadNumberOfColumn = snakeBoxes.get(0).getNumberOfColumn();
        int snakeHeadNumberOfRow = snakeBoxes.get(0).getNumberOfRow();
        if (directionNumber == 37) {           //left
            int snakeHeadAfterMoveNumberOfColumn = snakeHeadNumberOfColumn -1;
            int snakeHeadAfterMoveNumberOfRow = snakeHeadNumberOfRow;
            moveSnakeHead(snakeHeadAfterMoveNumberOfColumn,snakeHeadAfterMoveNumberOfRow);
        } else if (directionNumber == 38) {    //up

        } else if (directionNumber == 39) {    //right

        } else if (directionNumber == 40) {    //down

        }
    }
    /**
     * Move snake head (first snake box)
     */
    private void moveSnakeHead(int snakeHeadAfterMoveNumberOfColumn,int snakeHeadAfterMoveNumberOfRow){
        System.out.println(boxes.size());
        System.out.println(snakeBoxes.size());
        int snakeHeadBeforeMoveNumberOfColumn = snakeBoxes.get(0).getNumberOfColumn();
        int snakeHeadBeforeMoveNumberOfRow = snakeBoxes.get(0).getNumberOfRow();
        boxes.remove(box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow]);
        snakeBoxes.add(box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow] = new FirstSnakeBox(snakeHeadAfterMoveNumberOfColumn, snakeHeadAfterMoveNumberOfRow, true, true));
        box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow].setBackground(Color.GREEN);
        box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow].setPreferredSize(boxDimension);
        boxes.add(box[snakeHeadAfterMoveNumberOfColumn][snakeHeadAfterMoveNumberOfRow]);
        snakeBoxes.remove(0);
        for (int i=1;i<snakeBoxes.size();i++){
            boxes.remove(box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
            snakeBoxes.add(box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow] = new NextSnakeBoxes(snakeHeadBeforeMoveNumberOfColumn, snakeHeadBeforeMoveNumberOfRow, true, true));
            box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setBackground(Color.GREEN);
            box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setPreferredSize(boxDimension);
            boxes.add(box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
            System.out.println("aaa");

            snakeHeadBeforeMoveNumberOfColumn = snakeBoxes.get(0).getNumberOfColumn();
            snakeHeadBeforeMoveNumberOfRow = snakeBoxes.get(0).getNumberOfRow();
            snakeBoxes.remove(0);
            System.out.println("bbb");

        }
        boxes.remove(box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
        box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow] = new GrayBox(snakeHeadBeforeMoveNumberOfColumn,snakeHeadBeforeMoveNumberOfRow,false,false);
        box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setBackground(Color.LIGHT_GRAY);
        box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow].setPreferredSize(boxDimension);
        boxes.add(box[snakeHeadBeforeMoveNumberOfColumn][snakeHeadBeforeMoveNumberOfRow]);
        System.out.println(snakeBoxes.get(0));
        System.out.println(boxes.size());
        System.out.println(snakeBoxes.size());
    }
    /**
     * Create all boxes
     */
    public void createBoxInEngine() {
        for (int columnNumber = 0; columnNumber < numberOfColumnsInPanel; columnNumber++) {
            for (int rowNumber = 0; rowNumber < numberOfRowsInPanel; rowNumber++) {
                box[columnNumber][rowNumber] = new GrayBox(columnNumber, rowNumber, false, false);
                box[columnNumber][rowNumber].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                box[columnNumber][rowNumber].setBackground(Color.LIGHT_GRAY);
                box[columnNumber][rowNumber].setPreferredSize(boxDimension);
                boxes.add(box[columnNumber][rowNumber]);
            }
        }
        setColorInThreeStartBoxes();
        setColorInOneRandomBox();
    }

    /**
     * Set color in 1 random grayBox
     */
    private void setColorInOneRandomBox() {
        Random random = new Random();
        boolean boxIsGray = false;
        while (!boxIsGray) {
            int randomNumberOfColumn = random.nextInt(numberOfColumnsInPanel);
            int randomNumberOfRow = random.nextInt(numberOfRowsInPanel);
            /**
             * If on boxes list is this graybox then change it to green
             */
            if (!box[randomNumberOfColumn][randomNumberOfRow].isGreen()) {
                boxes.remove(box[randomNumberOfColumn][randomNumberOfRow]);
                box[randomNumberOfColumn][randomNumberOfRow] = new GreenBox(randomNumberOfColumn, randomNumberOfRow, true, false);
                box[randomNumberOfColumn][randomNumberOfRow].setBackground(Color.GREEN);
                box[randomNumberOfColumn][randomNumberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                box[randomNumberOfColumn][randomNumberOfRow].setPreferredSize(boxDimension);
                boxes.add(box[randomNumberOfColumn][randomNumberOfRow]);
                boxIsGray = true;
            }
        }
    }

    /**
     * Set color in 3 boxes (start snake)
     */
    private void setColorInThreeStartBoxes() {
        /**
         * Create first snake box(moveable)
         */
        int firstBoxNumberOfColumn = 45;
        int firstBoxNumberOfRow = 26;
        boxes.remove(box[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        box[firstBoxNumberOfColumn][firstBoxNumberOfRow] = new FirstSnakeBox(firstBoxNumberOfColumn, firstBoxNumberOfRow, true, true);
        box[firstBoxNumberOfColumn][firstBoxNumberOfRow].setBackground(Color.GREEN);
        box[firstBoxNumberOfColumn][firstBoxNumberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        box[firstBoxNumberOfColumn][firstBoxNumberOfRow].setPreferredSize(boxDimension);
        snakeBoxes.add(box[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        boxes.add(box[firstBoxNumberOfColumn][firstBoxNumberOfRow]);
        /**
         * Create two second snake boxes(follow first)
         */
        createNextSnakeBox(firstBoxNumberOfColumn, firstBoxNumberOfRow - 1);
        createNextSnakeBox(firstBoxNumberOfColumn, firstBoxNumberOfRow - 2);
    }

    /**
     * Create next snake box
     */
    private void createNextSnakeBox(int numberOfColumn, int numberOfRow) {
        boxes.remove(box[numberOfColumn][numberOfRow]);
        box[numberOfColumn][numberOfRow] = new NextSnakeBoxes(numberOfColumn, numberOfRow, true, true);
        box[numberOfColumn][numberOfRow].setBackground(Color.GREEN);
        box[numberOfColumn][numberOfRow].setPreferredSize(boxDimension);
        box[numberOfColumn][numberOfRow].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        snakeBoxes.add(box[numberOfColumn][numberOfRow]);
        boxes.add(box[numberOfColumn][numberOfRow]);
    }

    /**
     * Send list with boxes
     */
    public ArrayList<Box> getBoxesList() {
        return boxes;
    }
}
