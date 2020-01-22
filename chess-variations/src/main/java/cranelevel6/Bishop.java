package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {
	String type = "bishop";
	// START HERE
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();
	int x;
	int y;

	Bishop(Board board) {
		super(board);
		Rule bishopRule = new BishopRule();
		moves.put(Directions.NE, bishopRule);
		moves.put(Directions.SE, bishopRule);
		moves.put(Directions.SW, bishopRule);
		moves.put(Directions.NW, bishopRule);
	}

//	ArrayList<Directions> moves = new ArrayList<Directions>();
//
//	Bishop(Board board) {
//		super(board);
//		moves.add(Directions.NE);
//		moves.add(Directions.SE);
//		moves.add(Directions.SW);
//		moves.add(Directions.NW);
//	}

	@Override
	List<Location> getPossibleMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			while (l != null) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}

		return possibleMoves;
	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String bishopPNG = "";
		if (isWhite() == true) {
			bishopPNG = "images/WhiteBishop.png";
		} else {
			bishopPNG = "images/BlackBishop.png";
		}
		return bishopPNG;

	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(getImage(), location.getxCord(), location.getyCord(), 100, 100, null);
	}

	List<Location> getLegalMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> legalMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			Rule r = moves.get(d);
			while (l != null && r.isValid(this, l)) {
				legalMoves.add(l);
				l = l.getLocation(d);
			}
		}
		return legalMoves;
	}

	public String getType() {
		return type;
	}

	class BishopRule extends Rule {
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
