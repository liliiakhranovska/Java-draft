package Board.chessPieces;

import javafx.scene.Group;


public class HardwareFactory {
     public static Hardware getHardware() {
        return new Hardware() {
            Group g = new Group();
            @Override
            public Group getGroup() {
                return g;
            }
        };
    }
}
