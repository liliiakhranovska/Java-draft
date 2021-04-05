package Board.javafx;

import Board.logic.ChessBoard;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;

class ChessBoardImpl extends Group implements ChessBoard {

    private static final int SIZE_OF_SINGLE_BOX_IN_BOARD = 200;

    public ChessBoardImpl() {
        for (int i = -4; i < 4; i++) {
            for (int j = -4; j < 4; j++) {
                int stepX = i * SIZE_OF_SINGLE_BOX_IN_BOARD;
                int stepY = j * SIZE_OF_SINGLE_BOX_IN_BOARD;
                if ((i + j) % 2 != 0) {
                    getChildren().add(prepareBlackBox(stepX, stepY));
                } else {
                    getChildren().add(prepareWhiteBox(stepX, stepY));
                }
            }
        }

        getChildren().add(prepareBoardFrame());

    }

    private Group prepareBoardFrame() {
        final Group boardFrame = new Group();
        final Box leftBox;
        final Box rightBox;
        final Box topBox;
        final Box bottomBox;
        final String[] lettersLeftRight;
        final String[] lettersRightLeft;
        final String[] numbersDownUp;
        final String[] numbersUpDown;

        boardFrame.getChildren().addAll(
                  leftBox = new Box(100, 1800, 200),
                  rightBox = new Box(100, 1800, 200),
                  topBox = new Box(1800, 100, 200),
                  bottomBox = new Box(1800, 100, 200));


        boardFrame.setTranslateZ(-10);
        PhongMaterial blackMaterial = new PhongMaterial();
        blackMaterial.setDiffuseColor(Color.BLACK);
        leftBox.setMaterial(blackMaterial);
        leftBox.translateXProperty().set(750);
        leftBox.translateYProperty().set(-100);
        leftBox.translateZProperty().set(10);

        rightBox.setMaterial(blackMaterial);
        rightBox.translateXProperty().set(-950);
        rightBox.translateYProperty().set(-100);
        rightBox.translateZProperty().set(10);

        topBox.setMaterial(blackMaterial);
        topBox.translateXProperty().set(-100);
        topBox.translateYProperty().set(750);
        topBox.translateZProperty().set(10);

        bottomBox.setMaterial(blackMaterial);
        bottomBox.translateXProperty().set(-100);
        bottomBox.translateYProperty().set(-950);
        bottomBox.translateZProperty().set(10);

        lettersLeftRight = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
        lettersRightLeft = new String[] {"h", "g", "f", "e", "d", "c", "b", "a"};
        numbersDownUp = new String[] {"8", "7", "6", "5", "4", "3", "2", "1"};
        numbersUpDown = new String[] {"1", "2", "3", "4", "5", "6", "7", "8"};


        getChildren().add(prepareLettersOnBoard(lettersLeftRight, -830, 700, -101, 0));
        getChildren().add(prepareLettersOnBoard(lettersRightLeft, -870, -1200, -101, 180));
        getChildren().add(prepareNumbersOnBoard(numbersDownUp, -970, -870, -101, 0));
        getChildren().add(prepareNumbersOnBoard(numbersUpDown, 470, -830, -101, 180));

        return boardFrame;
    }

    private static Canvas prepareLettersOnBoard(String[] letters, int X, int Y, int Z, int rotate){
        javafx.scene.canvas.Canvas Letters = new Canvas(1500, 300);
        GraphicsContext gc = Letters.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        Font tr = new Font("TimesRoman", 80);
        gc.setFont(tr);
        gc.fillText(prepareString(letters, 7), 0, 77);
        Letters.setTranslateX(X);
        Letters.setTranslateY(Y);
        Letters.setTranslateZ(Z);
        Letters.rotateProperty().set(rotate);
        return Letters;
    }

    private static Canvas prepareNumbersOnBoard (String[] numbers, int X, int Y, int Z, int rotate) {
        javafx.scene.canvas.Canvas Numbers = new Canvas(300, 1500);
        GraphicsContext gc = Numbers.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        Font tr = new Font("TimesRoman", 80);
        gc.setFont(tr);
        int i = 0;
        for (String number : numbers) {
            gc.fillText(number, 0, 100 + 200 * i);
            i++;
        }
        Numbers.setTranslateZ(Z);
        Numbers.setTranslateX(X);
        Numbers.setTranslateY(Y);
        Numbers.rotateProperty().set(rotate);
        return Numbers;
    }



    private static String prepareString(String[] letters, int step) {
        String string = new String();
        String space;
        space = new String(new char[step]).replace("\0", " ");
        for (String letter: letters) {
            string = string.concat(letter);
            string = string.concat(space);
        }
        return string;
    }


    private static Box prepareBlackBox(int stepX, int stepY) {
        return prepareBox(stepX, stepY, "/resources/black.jpg");
    }

    private static Box prepareWhiteBox(int stepX, int stepY) {
        return prepareBox(stepX, stepY, "/resources/white.jpg");
    }

    private static Box prepareBox(int stepX, int stepY, String resName) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(ChessBoardImpl.class.getResourceAsStream(resName)));
        final Box box = new Box(SIZE_OF_SINGLE_BOX_IN_BOARD, SIZE_OF_SINGLE_BOX_IN_BOARD, SIZE_OF_SINGLE_BOX_IN_BOARD);
        box.setMaterial(material);
        box.translateXProperty().set(stepX);
        box.translateYProperty().set(stepY);
        return box;
    }
}
