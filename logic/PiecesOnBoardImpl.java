package Board.logic;

import Board.javafx.PieceImpl;
import javafx.scene.transform.Rotate;

public class PiecesOnBoardImpl implements PiecesOnBoard {
    static PieceImpl[][] pieces = new PieceImpl[8][8];

    String resBlack = "brown.jpg";
    String resWhite = "white.jpg";


    @Override
    public void insertPiecesToDefaultBoardMatrix() {
        for (int x = 0; x < 8; x++) {
            pieces[x][1] = new PieceImpl("pawn", resWhite);
            pieces[x][6] = new PieceImpl("pawn", resBlack);
        }

        pieces[0][0] = new PieceImpl("rook", resWhite);
        pieces[7][0] = new PieceImpl("rook", resWhite);
        pieces[0][7] = new PieceImpl("rook", resBlack);
        pieces[7][7] = new PieceImpl("rook", resBlack);

        pieces[1][0] = new PieceImpl("knight", resWhite);
        pieces[6][0] = new PieceImpl("knight", resWhite);
        pieces[1][7] = new PieceImpl("knight", resBlack);
        pieces[6][7] = new PieceImpl("knight", resBlack);

        pieces[2][0] = new PieceImpl("bishop", resWhite);
        pieces[5][0] = new PieceImpl("bishop", resWhite);
        pieces[2][7] = new PieceImpl("bishop", resBlack);
        pieces[5][7] = new PieceImpl("bishop", resBlack);

        pieces[3][0] = new PieceImpl("queen", resWhite);
        pieces[3][7] = new PieceImpl("queen", resBlack);

        pieces[4][0] = new PieceImpl("king", resWhite);
        pieces[4][7] = new PieceImpl("king", resBlack);
    }

    public static PieceImpl[][] getPieces() {
        return pieces;
    }

    @Override
    public void putPiecesToDefaultBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pieces[x][y] != null) {
                    char letter = Character.forDigit(x + 10, 18);
                    pieces[x][y].setToBoard(letter, y + 1);
                    pieces[x][y].setPositionOfPiece(x, y);
                }
            }
        }
        Rotate rotate = new Rotate(180, 0, 0, 0, Rotate.Z_AXIS);
        pieces[1][0].getTransforms().add(rotate);
        pieces[6][0].getTransforms().add(rotate);
    }
}






