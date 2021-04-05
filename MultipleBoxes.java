package Board;

import Board.javafx.HardwareFactoryV2;
import Board.logic.Application3D;
import Board.logic.HardwareV2;

public class MultipleBoxes {

    public static void main(String[] args) {
        final HardwareV2 hw = HardwareFactoryV2.getHardware();
        final Application3D app = hw.createApplication3D();
        app.start3D(args);
    }
}
