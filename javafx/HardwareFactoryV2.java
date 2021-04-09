package Board.javafx;

import Board.logic.*;

public class HardwareFactoryV2 {
    public static HardwareV2 getHardware() {
// anonymous class:
        return new HardwareV2() {

            Application3D app;

            @Override
            public Application3D createApplication3D() {
                app = new Application3DImpl();
                return app;
            }

            @Override
            public Environment3D getEnvironment3D() {
                return app.getEnvironment3D();
            }

        };
    }
}
