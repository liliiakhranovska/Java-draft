package Board.javafx;

import Board.fileManagement.ReadPointsByName;
import Board.logic.Piece;
import Board.logic.PiecesOnBoardImpl;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class PieceImpl extends Group implements Piece {

    private String color;
    private String name;
    private int[] position;

    TriangleMesh pieceMesh = new TriangleMesh();
    ReadPointsByName readPointsByNameInst = new ReadPointsByName("coordinates.txt");


    public PieceImpl(String pieceName, String resName) {
        this.color = trim(resName.split("\\.")[0]);
        this.name = pieceName;
        switch (pieceName) {
            case "queen": {
                addTexCoords("QUEENTEXCOORDS");
                addPoints("QUEENPOINTS");
                addFaces("QUEENFACES");
                break;
            }
            case "king": {
                addTexCoords("KINGTEXCOORDS");
                addPoints("KINGPOINTS");
                addFaces("KINGFACES");
                break;
            }
            case "rook": {
                addTexCoords("ROOKTEXCOORDS");
                addPoints("ROOKPOINTS");
                addFaces("ROOKFACES");
                break;
            }
            case "bishop": {
                addTexCoords("BISHOPTEXCOORDS");
                addPoints("BISHOPPOINTS");
                addFaces("BISHOPFACES");
                break;
            }
            case "knight": {
                addTexCoords("KNIGHTTEXCOORDS");
                addPoints("KNIGHTPOINTS");
                addFaces("KNIGHTFACES");
                break;
            }
            case "pawn": {
                addTexCoords("PAWNTEXCOORDS");
                addPoints("PAWNPOINTS");
                addFaces("PAWNFACES");
                break;
            }
        }


        MeshView piece = new MeshView(pieceMesh);
        piece.setDrawMode(DrawMode.FILL);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(PieceImpl.class.getClassLoader().getResourceAsStream(resName)));
//        material.setSpecularColor(Color.DARKGRAY);
        piece.setMaterial(material);
        piece.setTranslateX(0);
        piece.setTranslateY(0);
        piece.setTranslateZ(250);
        Rotate rotate = new Rotate(-90, 0, 0, 0, Rotate.X_AXIS);
        piece.getTransforms().add(rotate);


        Canvas selection = selectPiece();
        selection.setOpacity(1);
//        getChildren().add(selection);


//        PieceImpl[][] piecesOnBoard = PiecesOnBoardImpl.getPieces();

        Group possibleMoves = selectPossibleMoves(coordinates);
        possibleMoves.setOpacity(0);
        possibleMoves.getChildren().add(selection);
        getChildren().add(possibleMoves);

        FadeTransition transition = new FadeTransition(Duration.millis(1), possibleMoves);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);


//        FadeTransition transition = new FadeTransition(Duration.millis(1), selection);
//        transition.setFromValue(0.0);
//        transition.setToValue(1.0);

        piece.hoverProperty().addListener((obs, wasHover, isHover) -> {
            transition.setRate(isHover ? 1.0 : -1.0);
            transition.play();
//            System.out.println(Arrays.toString(getPositionOfPiece()));
        });
        possibleMoves.setOpacity(transition.getFromValue());

        getChildren().add(piece);

    }

//        piece.hoverProperty().addListener((obs, wasHover, isHover) -> {
//            transition.setRate(isHover ? 1.0 : -1.0);
//            transition.play();
////            System.out.println(Arrays.toString(getPositionOfPiece()));
//        });
//        selection.setOpacity(transition.getFromValue());
//
//        getChildren().add(piece);
//
//    }

    public String getPieceName (){
        return name;
    }

    public String getPieceColor (){
        return color;
    }

    public Canvas selectPiece(){
        Canvas selection = new Canvas(200, 200);
        GraphicsContext gc = selection.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(20);
        gc.strokeRoundRect(0, 0, 200, 200, 50, 50);
        selection.setTranslateX(-100);
        selection.setTranslateY(-100);
        selection.setTranslateZ(-101);
//        selectPossibleMoves(coordinates);
        return selection;
    }

    int[][] coordinates = {
            {0, 2},
            {0, 3}
    };


    public Group selectPossibleMoves(int[][] coordinates){
        Group possibleMovesSelection = new Group();
        for (int[] coordinate: coordinates) {
//            System.out.println(Arrays.toString(coordinate));
            int x = coordinate[0];
            int y = coordinate[1];
            Canvas selection = new Canvas(200, 200);
            GraphicsContext gc = selection.getGraphicsContext2D();
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(20);
            gc.strokeRoundRect(0, 0, 200, 200, 50, 50);
            selection.setTranslateX(-100 + 200*x);
            selection.setTranslateY(-300+ 200*y);
            selection.setTranslateZ(-101);
            possibleMovesSelection.getChildren().add(selection);
        }
        return possibleMovesSelection;
    }


    public void setToBoard(char letter, int number) {
        int stepX = letter - 96;
        int stepY = number;
        this.translateXProperty().set(stepX * 200 - 1000);
        this.translateYProperty().set((-stepY + 4) * 200);

    }

    public void addTexCoords(String nameOfPiece) {
        float[] TEXCOORDS = this.readPointsByNameInst.ExtractPointsToFloatArray(nameOfPiece);
        multiplyArrayAndInteger(TEXCOORDS, 10);
        pieceMesh.getTexCoords().addAll(TEXCOORDS);
    }

    public void addFaces(String nameOfPoints) {
        int[] FACES = this.readPointsByNameInst.ExtractPointsToIntArray(nameOfPoints);
        pieceMesh.getFaces().addAll(FACES);
    }

    public void addPoints(String nameOfPiece) {
        float[] POINTS = this.readPointsByNameInst.ExtractPointsToFloatArray(nameOfPiece);
        multiplyArrayAndInteger(POINTS, 10);
        pieceMesh.getPoints().addAll(POINTS);
    }

    public float[] multiplyArrayAndInteger(float[] numbers, int scale) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * scale;
        }
        return numbers;
    }

    public String getColorOfPiece() {
        return this.color;
    }

    public String getNameOfPiece() {
        return this.name;
    }

    public void setPositionOfPiece(int x, int y) {
        int[] pos = {x, y};
        this.position = pos;
    }

    public int[] getPositionOfPiece() {
        return this.position;
    }

    public void addPiece() {
        getChildren().add(this);
    }
}


