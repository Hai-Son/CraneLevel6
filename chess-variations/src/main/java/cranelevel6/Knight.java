package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knight extends Piece {
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();

	Knight(Board board) {
		super(board);
		Rule knightRule = new KnightRule();
		moves.put(Directions.NNW, knightRule);
		moves.put(Directions.NNE, knightRule);
		moves.put(Directions.SSE, knightRule);
		moves.put(Directions.SSW, knightRule);
		moves.put(Directions.EEN, knightRule);
		moves.put(Directions.EES, knightRule);
		moves.put(Directions.WWN, knightRule);
		moves.put(Directions.WWS, knightRule);
	}
//	ArrayList<Directions> moves = new ArrayList<Directions>();
//
//	Knight(Board board) {
//		super(board);
//		moves.add(Directions.NNW);
//		moves.add(Directions.NNE);
//		moves.add(Directions.SSE);
//		moves.add(Directions.SSW);
//		moves.add(Directions.EEN);
//		moves.add(Directions.EES);
//		moves.add(Directions.WWN);
//		moves.add(Directions.WWS);
//	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String knightPNG = "";
		if (isWhite() == true) {
			knightPNG = "images/WhiteKnight.png";
		} else {
			knightPNG = "images/BlackKnight.png";
		}
		return knightPNG;

	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(getImage(), location.getxCord(), location.getyCord(), 100, 100, null);
	}

	@Override
	List<Location> getPossibleMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			if (l != null) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}

		return possibleMoves;
	}

	@Override
	List<Location> getLegalMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> legalMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			Rule r = moves.get(d);
			if (l != null) {
				if (r.isValid(this, l)) {
					legalMoves.add(l);
				}
			}
		}
		return legalMoves;
	}

	class KnightRule extends Rule {
		boolean isValid(Piece p, Location l) {
			if (!super.isValid(p, l)) {
				return false;
			}
			Piece lPiece = l.getPiece();
			if (lPiece == null || lPiece.isWhite() != p.isWhite()) {
				return true;
			} else {
				return false;
			}

		}

	}
}
