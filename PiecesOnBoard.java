package Board;

import Board.chessPieces.Pawn;
import javafx.scene.Group;
import java.util.ArrayList;

public class PiecesOnBoard extends Group {

    private Group[][] pieces = new Group[8][8]; // db: Piece[][] instead of Group[][] or not

    public PiecesOnBoard() {
        for (int i = 0; i < 8; i++) {
            final Pawn pawn = Pawn.createWhitePawn();
            pawn.movePawn(-4 + i, 2);
            getChildren().add(pawn);
            pieces[1][i] = pawn;
        }
        for (int i = 0; i < 8; i++) {
            final Pawn pawn = Pawn.createBlackPawn();
            pawn.movePawn(-4 + i, -3);
            getChildren().add(pawn);
            pieces[6][i] = pawn;
        }

        }
    }



