package Board;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class MultipleBoxes extends Application {

    private static final float WIDTH = 700;
    private static final float HEIGHT = 700;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private double anchorAngleZ = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(-30);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private final DoubleProperty angleZ = new SimpleDoubleProperty(15);



    @Override
    public void start(Stage primaryStage) throws Exception {
        final ChessBoard chessBoard = new ChessBoard();
        final Group chess = new Group();
        final Group piecesOnBoard = new PiecesOnBoard();
        chess.getChildren().add(chessBoard);
        chess.getChildren().add(piecesOnBoard);
        final Camera camera = new PerspectiveCamera();
        final Scene scene = new Scene (chess, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        chess.translateXProperty().set(WIDTH / 2 + 150);
        chess.translateYProperty().set(HEIGHT / 2);
        chess.translateZProperty().set(3500);


        initMouseControl(chess, scene, primaryStage);

        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



        private void initMouseControl(Group chess, Scene scene, Stage stage){
        final Rotate xRotate;
        final Rotate yRotate;
        final Rotate zRotate;
        chess.getTransforms().addAll(
            xRotate = new Rotate (0, Rotate.X_AXIS),
            yRotate = new Rotate (0, Rotate.Y_AXIS),
            zRotate = new Rotate (0, Rotate.Z_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        zRotate.angleProperty().bind(angleZ);


            scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
            anchorAngleZ = angleZ.get();

            });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleZ.set(anchorAngleZ + anchorX - event.getSceneX());
        });

        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            chess.translateZProperty().set(chess.getTranslateZ() + delta);
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}
