package Board.fileManagement;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle rect1 = new Rectangle (100, 40, 120, 120);
        rect1.setArcHeight(42);
        rect1.setArcWidth(42);
        rect1.setFill(Color.AQUA);
//
//        TranslateTransition tt1;
//        tt1 = new TranslateTransition(Duration.millis(3000), rect1);
//        tt1.setByX(200);
//        tt1.setByY(-200);
//        tt1.setCycleCount(2);
//        tt1.setAutoReverse(true);
//        tt1.play();

//        rect1.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override public void handle(MouseEvent event) {
//                FadeTransition ft = new FadeTransition(Duration.millis(1000), rect1);
//                ft.setFromValue(1.0);
//                ft.setToValue(0.0);
//                ft.play();
//                event.consume();
//            }
//        });

//        tt1.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                tt1.play();
//                FadeTransition ft = new FadeTransition(Duration.millis(1000), rect1);
//                ft.setToValue(1.0);
//                ft.play();
//            }
//        });

        Rectangle rect2 = new Rectangle (100, 40, 80, 80);
        rect2.setArcHeight(42);
        rect2.setArcWidth(42);
        rect2.setFill(Color.YELLOWGREEN);

//        TranslateTransition tt2;
//        tt2= new TranslateTransition(Duration.millis(6000), rect2);
//        tt2.setByX(-200);
//        tt2.setByY(200);
//        tt2.setCycleCount(2);
//        tt2.setAutoReverse(true);
//        tt2.play();

        rect1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), rect2);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.play();
                event.consume();
            }
        });

        rect2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), rect2);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.play();
                event.consume();
            }
        });

//        tt2.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                tt2.play();
//                FadeTransition ft = new FadeTransition(Duration.millis(1000), rect2);
//                ft.setToValue(1.0);
//                ft.play();
//            }
//        });

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(rect1,rect2);
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}