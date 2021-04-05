package Board.logic;

public interface HardwareV2 {
    Application3D createApplication3D();
    Environment3D getEnvironment3D();
    Pawn createWhitePawn();
    Pawn createBlackPawn();
//    ChessBoard createChessBoard();
}
