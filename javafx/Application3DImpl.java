package Board.javafx;

import Board.logic.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Application3DImpl extends Application implements Application3D {

    private Environment3DImpl env;
    private final ChessBoard chessBoard = new ChessBoardImpl();
    private final PiecesOnBoard piecesOnBoard = new PiecesOnBoardImpl();


    @Override
    public void start(Stage primaryStage) throws Exception {
        env = new Environment3DImpl(primaryStage);

    }

    @Override
    public void start3D(String[] args) {
        Application.launch(args); /*launch is static method*/
    }

    @Override
    public Environment3D getEnvironment3D() {
        return env;
    }

    @Override
    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    @Override
    public PiecesOnBoard getPiecesOnBoard() {
        return piecesOnBoard;
    }

}
