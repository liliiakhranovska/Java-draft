package Board.chessPieces;

import Board.geometryPrimitive.Cone;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

public class Pawn implements Piece{

    private Hardware hv = HardwareFactory.getHardware();

    public Pawn(String resName) {
        final Cone cone = new Cone(resName);
        final Sphere sphere = prepareSphere(resName);
        final Cylinder cylinder = prepareCylinder(resName);
        getChildren().add(sphere);
        getChildren().add(cylinder);
        getChildren().add(cone);
    }

    public static Pawn createWhitePawn () {
        Pawn whitePawn = new Pawn("/resources/white.jpg");
        return whitePawn;
    }

    public static Pawn createBlackPawn () {
        Pawn whitePawn = new Pawn("/resources/black.jpg");
        return whitePawn;
    }


    public Sphere prepareSphere(String resName) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(Pawn.class.getResourceAsStream(resName)));
        final Sphere sphere = new Sphere(80);
        sphere.setMaterial(material);
        sphere.translateXProperty().set(0);
        sphere.translateYProperty().set(0);
        sphere.translateZProperty().set(-300);
        return sphere;
    }

    public Cylinder prepareCylinder(String resName) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(Pawn.class.getResourceAsStream(resName)));
        final Cylinder cylinder = new Cylinder(90, 40, 8);
        cylinder.setMaterial(material);
        cylinder.translateXProperty().set(0);
        cylinder.translateYProperty().set(0);
        cylinder.translateZProperty().set(-120);
        Rotate rotate = new Rotate(90, 0, 0, 0, Rotate.X_AXIS);
        cylinder.getTransforms().add(rotate);
        return cylinder;
    }

    public void movePawn(int stepX, int stepY) {
        this.translateXProperty().set(stepX*200);
        this.translateYProperty().set(stepY*200);

    }

    @Override
    public void move(String position) {
        char b = position.charAt(0);
        char c = position.charAt(1);
//        int let = letter.charAt(0)-96;
//        TODO: MORE CAREFULLY
    }

    @Override
    public Hardware getHardware() {
        return hv.getGroup();
    }

}



