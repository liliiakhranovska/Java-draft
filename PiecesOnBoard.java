package Board;

import Board.chessPieces.Pawn;
import javafx.scene.Group;
import java.util.ArrayList;

public class PiecesOnBoard extends Group {

    private Group[][] pieces = new Group[8][8]; // db: Piece[][] instead of Group[][] or not
    final String[] letters = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};

    public PiecesOnBoard() {
        int i = 0;
        for (String letter: letters) {
            final Pawn pawn = Pawn.createWhitePawn();
            pawn.setToBoard(letter, 2);
            getChildren().add(pawn);
            pieces[1][i] = pawn;
            i++;
        }
        int j = 0;
        for (String letter: letters) {
            final Pawn pawn = Pawn.createBlackPawn();
            pawn.setToBoard(letter, 7);
            getChildren().add(pawn);
            pieces[6][j] = pawn;
            j++;
        }

    }

}
