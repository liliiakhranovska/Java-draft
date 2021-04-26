package Board.javafx;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class BoxImpl extends Group {

    int size = 200;


    public BoxImpl() {
    };

    public BoxImpl (String resName) {
        final PhongMaterial material = new PhongMaterial();
//        System.out.println(resName);
        material.setDiffuseMap(new Image(ChessBoardImpl.class.getClassLoader().getResourceAsStream(resName)));
        final Box box = new Box(this.size, this.size, this.size);
        box.setMaterial(material);
        this.getChildren().addAll(box);
    }


    public void setBox(int stepX, int stepY) {
        this.translateXProperty().set(stepX-800);
        this.translateYProperty().set(-stepY+600);
    }

}
