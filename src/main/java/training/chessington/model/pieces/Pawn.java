package training.chessington.model.pieces;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> pawnMoves = new ArrayList<>();
        if (colour.equals(PlayerColour.WHITE)) {
            Move move = new Move(from, from.plus(-1, 0));
            if (board.get(move.getTo()) == null) {
                pawnMoves.add(move);
            }
        }
        if (colour.equals(PlayerColour.BLACK)) {
            Move move = new Move(from, from.plus(1, 0));
            if (board.get(move.getTo()) == null) {
                pawnMoves.add(move);
            }
        }
        if (colour.equals(PlayerColour.WHITE)) {
            if (from.getRow() == 6) {
                Move move = new Move(from, from.plus(-2, 0));
                if (board.get(move.getTo()) == null) {
                    pawnMoves.add(move);
                }
            }
        }
        if (colour.equals(PlayerColour.BLACK)) {
            if (from.getRow()== 1) {
                Move move = new Move(from, from.plus(2, 0));
                if (board.get(move.getTo()) == null) {
                    pawnMoves.add(move);
                }
            }
        }

        return pawnMoves;
    }
}
