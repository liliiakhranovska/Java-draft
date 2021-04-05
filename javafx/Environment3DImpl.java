package Board.javafx;

import Board.logic.Environment3D;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Environment3DImpl extends Group implements Environment3D {
    private static final float WIDTH = 700;
    private static final float HEIGHT = 700;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleZ = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(-30);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private final DoubleProperty angleZ = new SimpleDoubleProperty(15);


    public Environment3DImpl(Stage primaryStage) {
        final Camera camera = new PerspectiveCamera();
        final Scene scene = new Scene(this, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        this.translateXProperty().set(WIDTH / 2 + 150);
        this.translateYProperty().set(HEIGHT / 2);
        this.translateZProperty().set(3500);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
        initMouseControl(this, scene, primaryStage);

        final ChessBoardImpl chessBoard = new ChessBoardImpl();
        final PiecesOnBoardImpl piecesOnBoard = new PiecesOnBoardImpl();
        piecesOnBoard.initBoard();
        final RookImpl rookImpl = new RookImpl();
        MeshView rook = rookImpl.getRook();
        Rotate rotate = new Rotate(-90, 0, 0, 0, Rotate.X_AXIS);
        rook.getTransforms().add(rotate);

//        this.getChildren().add(chessBoard);
        this.getChildren().add(piecesOnBoard);
        this.getChildren().add(rook);

    }


    private void initMouseControl(Group chess, Scene scene, Stage stage) {
        final Rotate xRotate;
        final Rotate yRotate;
        final Rotate zRotate;
        this.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS),
                zRotate = new Rotate(0, Rotate.Z_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        zRotate.angleProperty().bind(angleZ);


        scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleZ = angleZ.get();

        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleZ.set(anchorAngleZ + anchorX - event.getSceneX());
        });

        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            this.translateZProperty().set(chess.getTranslateZ() + delta);
        });
    }

}
