package Board.javafx;

import Board.logic.PiecesOnBoard;
import javafx.scene.Group;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class PiecesOnBoardImpl extends Group implements PiecesOnBoard {

    private Group[][] pieces = new Group[8][8]; // db: Piece[][] instead of Group[][] or not
    final String[] letters = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};

    public PiecesOnBoardImpl() {
    }

    @Override
    public void initBoard() {
        int i = 0;
        for (String letter: letters) {
            final PawnImpl pawnImpl = PawnImpl.createWhitePawn();
            pawnImpl.setToBoard(letter, 2);
            getChildren().add(pawnImpl);
            pieces[1][i] = pawnImpl;
            i++;
        }
        int j = 0;
        for (String letter: letters) {
            final PawnImpl pawnImpl = PawnImpl.createBlackPawn();
            pawnImpl.setToBoard(letter, 7);
            getChildren().add(pawnImpl);
            pieces[6][j] = pawnImpl;
            j++;
        }
    }
}
