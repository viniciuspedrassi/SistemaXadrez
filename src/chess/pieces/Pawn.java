package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position (0, 0);
		
		//peao branco'
		if (getColor() == Color.BRANCO) {
			
			//testa se pode avançar para frente 1 casa
			p.setValues(position.getRow() - 1 , position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é a primeira jogada desse peao e avança 2 casas
			p.setValues(position.getRow() - 2 , position.getColumn());
			Position p2 = new Position(position.getRow() - 1 , position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é possivel avançar para diagonal esquerda
			p.setValues(position.getRow() - 1 , position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é possivel avançar para diagonal  direita
			p.setValues(position.getRow() - 1 , position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		//peao preto
		else {
			//testa se pode avançar para frente 1 casa
			p.setValues(position.getRow() + 1 , position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é a primeira jogada desse peao e avança 2 casas
			p.setValues(position.getRow() + 2 , position.getColumn());
			Position p2 = new Position(position.getRow() + 1 , position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é possivel avançar para diagonal esquerda
			p.setValues(position.getRow() + 1 , position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// testa se é possivel avançar para diagonal  direita
			p.setValues(position.getRow() + 1 , position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
