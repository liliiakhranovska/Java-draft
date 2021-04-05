package Board.javafx;

import Board.geometryPrimitive.Cone;
import Board.logic.Pawn;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

public class PawnImpl extends Group implements Pawn {

    public PawnImpl(String resName) {
        final Cone cone = new Cone(resName, 360, 80, 20, 200);
        final Sphere sphere = prepareSphere(resName);
        final Cylinder cylinder = prepareCylinder(resName);
        getChildren().add(sphere);
        getChildren().add(cylinder);
        getChildren().add(cone);
    }

    public static PawnImpl createWhitePawn() {
        PawnImpl whitePawnImpl = new PawnImpl("/resources/white.jpg");
        return whitePawnImpl;
    }

    public static PawnImpl createBlackPawn() {
        PawnImpl whitePawnImpl = new PawnImpl("/resources/black.jpg");
        return whitePawnImpl;
    }


    public Sphere prepareSphere(String resName) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(PawnImpl.class.getResourceAsStream(resName)));
        final Sphere sphere = new Sphere(80);
        sphere.setMaterial(material);
        sphere.translateXProperty().set(0);
        sphere.translateYProperty().set(0);
        sphere.translateZProperty().set(-300);
        return sphere;
    }

    public Cylinder prepareCylinder(String resName) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(PawnImpl.class.getResourceAsStream(resName)));
        final Cylinder cylinder = new Cylinder(90, 40, 8);
        cylinder.setMaterial(material);
        cylinder.translateXProperty().set(0);
        cylinder.translateYProperty().set(0);
        cylinder.translateZProperty().set(-120);
        Rotate rotate = new Rotate(90, 0, 0, 0, Rotate.X_AXIS);
        cylinder.getTransforms().add(rotate);
        return cylinder;
    }

    public void setToBoard(String letter, int number) {
        int stepX = letter.charAt(0) - 96;
        int stepY = number;
        this.translateXProperty().set(stepX * 200 - 1000);
        this.translateYProperty().set((-stepY + 4) * 200);

    }

}