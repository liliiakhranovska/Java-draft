package Board.fileManagement;

import Board.javafx.PieceImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class Test2 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle rect1 = new Rectangle(200, 200, 120, 120);
        rect1.setArcHeight(42);
        rect1.setArcWidth(42);
        rect1.setFill(Color.AQUA);

        Group group = new Group();
        group.getChildren().addAll(rect1);
        Scene scene = new Scene(group, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        Canvas selection = new Canvas(200, 200);
        selection.setTranslateX(160);
        selection.setTranslateY(160);
        GraphicsContext gc = selection.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(20);
        gc.strokeRoundRect(0, 0, 200, 200, 50, 50);
        group.getChildren().add(selection);


        rect1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), selection);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.play();
//                group.getChildren().add(selection);
            }
        });

        selection.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), selection);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.play();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}