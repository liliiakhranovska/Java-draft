package Board;

import Board.chessPieces.Pawn;
import javafx.scene.Group;
import java.util.ArrayList;

public class PiecesOnBoard extends Group {
    public PiecesOnBoard() {
        ArrayList<Pawn> whitePawns = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            whitePawns.add(Pawn.createWhitePawn());
            whitePawns.get(i).movePawn(-4 + i, 2);
            getChildren().add(whitePawns.get(i));
        }

        ArrayList<Pawn>  blackPawns = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            blackPawns.add(Pawn.createBlackPawn());
            blackPawns.get(i).movePawn(-4 + i, -3);
            getChildren().add(blackPawns.get(i));
        }

        }
    }



