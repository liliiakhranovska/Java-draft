package Board.chessPieces;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;


public class HardwareFactory {
     public static Hardware getHardware() {
        return new Hardware() {
            Group g = new Group();
            @Override
            public Group getGroup() {
                return g;
            }

            @Override
            public void addFigure(Group figure) {
                g.getChildren().add(figure);
            }

            @Override
            public void addFigure(Shape3D figure) {
                g.getChildren().add(figure);
            }

            @Override
            public void addFigure(MeshView figure) {
                g.getChildren().add(figure);
            }

            @Override
            public void addFigure(Hardware figure) {
                g.getChildren().add((Node) figure);
            }

            @Override
            public void setX(double x) {
                g.translateXProperty().set(x);
            }

            @Override
            public void setY(double y) {
                g.translateYProperty().set(y);
            }

            @Override
            public void setZ(double z) {
                g.translateZProperty().set(z);
            }

            @Override
            public void addAllRotations(Rotate xRotate, Rotate yRotate, Rotate zRotate) {
                g.getTransforms().addAll(xRotate, yRotate, zRotate);
            }

            @Override
            public void addRotation(Rotate rotation) {
                g.getTransforms().add(rotation);
            }


            @Override
            public double getTranslateZ() {
                return g.getTranslateZ();
            }
        };
    }
}
