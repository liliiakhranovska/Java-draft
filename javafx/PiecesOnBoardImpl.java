package Board.javafx;

import Board.logic.PiecesOnBoard;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class PiecesOnBoardImpl extends Group implements PiecesOnBoard {

    private Group[][] pieces = new Group[8][8]; // db: Piece[][] instead of Group[][] or not
    final String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    public PiecesOnBoardImpl() {
    }

    @Override
    public void initBoard() {
        int i = 0;
        for (String letter : letters) {
            final PieceImpl whitePawn = new PieceImpl("pawn", "/resources/white.jpg");
            whitePawn.setToBoard(letter, 2);
            getChildren().add(whitePawn);
            pieces[1][i] = whitePawn;
            i++;
        }
        int j = 0;
        for (String letter : letters) {
            final PieceImpl blackPawn = new PieceImpl("pawn", "/resources/black.jpg");
            blackPawn.setToBoard(letter, 7);
            getChildren().add(blackPawn);
            pieces[6][j] = blackPawn;
            j++;
        }

        int k = 0;
        for (String letter : letters) {
            if (letter == "a" || letter == "h") {
                final PieceImpl whiteRook = new PieceImpl("rook", "/resources/white.jpg");
                whiteRook.setToBoard(letter, 1);
                getChildren().add(whiteRook);
                pieces[0][k] = whiteRook;
                k++;
            }
        }

        int l = 0;
        for (String letter : letters) {
            if (letter == "a" || letter == "h") {
                final PieceImpl blackRook = new PieceImpl("rook", "/resources/black.jpg");
                blackRook.setToBoard(letter, 8);
                getChildren().add(blackRook);
                pieces[7][l] = blackRook;
                l++;
            }
        }

        int m = 0;
        for (String letter : letters) {
            if (letter == "b" || letter == "g") {
                final PieceImpl whiteKnight = new PieceImpl("knight", "/resources/white.jpg");
                Rotate rotate = new Rotate(180, 0, 0, 0, Rotate.Z_AXIS);
                whiteKnight.getTransforms().add(rotate);
                whiteKnight.setToBoard(letter, 1);
                getChildren().add(whiteKnight);
                pieces[0][m] = whiteKnight;
                m++;
            }
        }

        int n = 0;
        for (String letter : letters) {
            if (letter == "b" || letter == "g") {
                final PieceImpl blackKnight = new PieceImpl("knight", "/resources/black.jpg");
                blackKnight.setToBoard(letter, 8);
                getChildren().add(blackKnight);
                pieces[7][n] = blackKnight;
                n++;
            }
        }

        int p = 0;
        for (String letter : letters) {
            if (letter == "c" || letter == "f") {
                final PieceImpl whiteBishop = new PieceImpl("bishop", "/resources/white.jpg");
                whiteBishop.setToBoard(letter, 1);
                getChildren().add(whiteBishop);
                pieces[0][p] = whiteBishop;
                p++;
            }
        }

        int o = 0;
        for (String letter : letters) {
            if (letter == "c" || letter == "f") {
                final PieceImpl blackBishop = new PieceImpl("bishop", "/resources/black.jpg");
                blackBishop.setToBoard(letter, 8);
                getChildren().add(blackBishop);
                pieces[7][o] = blackBishop;
                o++;
            }
        }

        int r = 0;
        for (String letter : letters) {
            if (letter == "e") {
                final PieceImpl whiteKing = new PieceImpl("king", "/resources/white.jpg");
                whiteKing.setToBoard(letter, 1);
                getChildren().add(whiteKing);
                pieces[0][r] = whiteKing;
                r++;
            }
        }

        int s = 0;
        for (String letter : letters) {
            if (letter == "e") {
                final PieceImpl blackKing = new PieceImpl("king", "/resources/black.jpg");
                blackKing.setToBoard(letter, 8);
                getChildren().add(blackKing);
                pieces[7][s] = blackKing;
                s++;
            }
        }

        int q = 0;
        for (String letter : letters) {
            if (letter == "d") {
                final PieceImpl whiteQueen = new PieceImpl("queen", "/resources/white.jpg");
                whiteQueen.setToBoard(letter, 1);
                getChildren().add(whiteQueen);
                pieces[0][q] = whiteQueen;
                q++;
            }
        }

        int t = 0;
        for (String letter : letters) {
            if (letter == "d") {
                final PieceImpl blackQueen = new PieceImpl("queen", "/resources/black.jpg");
                blackQueen.setToBoard(letter, 8);
                getChildren().add(blackQueen);
                pieces[7][t] = blackQueen;
                t++;
            }
        }

    }
}




