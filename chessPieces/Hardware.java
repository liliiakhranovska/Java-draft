package Board.chessPieces;

import javafx.scene.Group;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;

public interface Hardware {
    Group getGroup();
    void addFigure(Group figure);
    void addFigure(Shape3D figure);
    void addFigure(MeshView figure);
    void addFigure(Hardware figure);
    void setX(double x);
    void setY(double y);
    void setZ(double z);
    void addAllRotations(Rotate xRotate, Rotate yRotate, Rotate zRotate);
    void addRotation(Rotate rotation);
    double getTranslateZ();
}
