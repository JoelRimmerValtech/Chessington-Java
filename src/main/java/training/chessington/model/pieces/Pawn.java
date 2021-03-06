package training.chessington.model.pieces;

import org.apache.logging.log4j.core.Core;
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
            if (from.getRow() > 0) {
                Move move = new Move(from, from.plus(-1, 0));
                if (board.get(move.getTo()) == null) {
                    pawnMoves.add(move);
                }
            }
        }
        if (colour.equals(PlayerColour.BLACK)) {
            if (from.getRow() < 7) {
                Move move = new Move(from, from.plus(1, 0));
                if (board.get(move.getTo()) == null) {
                    pawnMoves.add(move);
                }
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
        if (colour.equals(PlayerColour.WHITE)) {
            if (from.getRow() != 0 && from.getCol() != 7) {
                Move move = new Move(from, from.plus(-1, 1));
                Coordinates enemyCoords = move.getTo();
                if (board.get(enemyCoords) != null && board.get(enemyCoords).getColour().equals(PlayerColour.BLACK)) {
                    pawnMoves.add(move);
                }
            }
            if (from.getRow() != 0 && from.getCol() != 0) {
                Move move = new Move(from, from.plus(-1, -1));
                Coordinates enemyCoords = move.getTo();
                if (board.get(enemyCoords) != null && board.get(enemyCoords).getColour().equals(PlayerColour.BLACK)) {
                    pawnMoves.add(move);
                }
            }
        }
        if (colour.equals(PlayerColour.BLACK)) {
            if (from.getRow() != 7 && from.getCol() != 7) {
                Move move = new Move(from, from.plus(1, 1));
                Coordinates enemyCoords = move.getTo();
                if (board.get(enemyCoords) != null && board.get(enemyCoords).getColour().equals(PlayerColour.WHITE)) {
                    pawnMoves.add(move);
                }
            }
            if (from.getRow() != 7 && from.getCol() != 0) {
                Move move = new Move(from, from.plus(1, -1));
                Coordinates enemyCoords = move.getTo();
                if (board.get(enemyCoords) != null && board.get(enemyCoords).getColour().equals(PlayerColour.WHITE)) {
                    pawnMoves.add(move);
                }
            }
        }


        return pawnMoves;
    }
}
