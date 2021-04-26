package Board.javafx;

import Board.fileManagement.ReadPointsByName;
import Board.logic.Piece;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class PieceImpl extends Group implements Piece {

    private String color;
    private String name;
    private int[] position;

    BoxImpl box = new BoxImpl();

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


//        piece.setOnMouseClicked(event -> {
//            ChessBoardImpl.insertCellsToMatrix();
//            ChessBoardImpl.addToGroup();
//            ChessBoardImpl.setCellsToBoard();
//            int[] pos = this.getPositionOfPiece();
//            ChessBoardImpl.selectBox(pos[0],pos[1],"/resources/green.png");
//            this.getChildren().add(ChessBoardImpl.cells[pos[0]][pos[1]]);
//        });


        piece.setOnMouseClicked(event -> {
            final Canvas selection = selectPiece(0, 0);
            final FadeTransition ft = new FadeTransition(Duration.millis(1000), selection);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
            getChildren().add(selection);
        });

        getChildren().add(piece);

    }

    public Canvas selectPiece(int x, int y){
        Canvas selection = new Canvas(1000, 1000);
        GraphicsContext gc = selection.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(20);
        gc.strokeRoundRect(200, 200, 200, 200, 50, 50);
        selection.setTranslateX(-300);
        selection.setTranslateY(-300);
        selection.setTranslateZ(-101);
        return selection;
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


