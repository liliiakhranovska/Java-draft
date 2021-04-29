package Board.fileManagement;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(100.0, 100.0);
        rect.setOpacity(0.0);
        rect.setX(200);
        rect.setY(100);

        Group sp = new Group();
        sp.getChildren().add(rect);
        Scene scene = new Scene(sp, 500.0, 300.0);

        FadeTransition animation = new FadeTransition(Duration.millis(200.0), rect);
        animation.setFromValue(0.0);
        animation.setToValue(1.0);

        rect.setOnMouseEntered(event -> {
            animation.setRate(1.0);
            animation.play();
        });
        rect.setOnMouseExited(event -> {
            animation.setRate(-2.0);
            animation.play();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
