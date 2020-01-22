package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();
	int x;
	int y;
	String type = "pawn";

	Pawn(Board board) {
		super(board);
		Rule pawnRule = new PawnRule();
		moves.put(Directions.N, pawnRule);
		moves.put(Directions.NN, pawnRule);
		moves.put(Directions.NE, pawnRule);
		moves.put(Directions.NW, pawnRule);
		moves.put(Directions.SS, pawnRule);
		moves.put(Directions.S, pawnRule);
		moves.put(Directions.SW, pawnRule);
		moves.put(Directions.SE, pawnRule);
	}
//	ArrayList<Directions> moves = new ArrayList<Directions>();
//	Pawn(Board board) {
//		super(board);
//		moves.add(Directions.N);
//		moves.add(Directions.NN);
//		moves.add(Directions.NE);
//		moves.add(Directions.NW);
//		moves.add(Directions.SS);
//		moves.add(Directions.S);
//		moves.add(Directions.SW);
//		moves.add(Directions.SE);
//	}

	public ArrayList<Location> getPossibleMoves() {

		if (location == null) {
			return null;
		}
		if (isWhite() == true) {
			moves.remove(Directions.S);
			moves.remove(Directions.SS);
			moves.remove(Directions.SW);
			moves.remove(Directions.SE);
		} else {
			moves.remove(Directions.N);
			moves.remove(Directions.NE);
			moves.remove(Directions.NW);
			moves.remove(Directions.NN);
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
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String pawnPNG = "";
		if (isWhite() == true) {
			pawnPNG = "images/WhitePawn.png";
		} else {
			pawnPNG = "images/BlackPawn.png";
		}
		return pawnPNG;

	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(getImage(), location.getxCord(), location.getyCord(), 100, 100, null);
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

	class PawnRule extends Rule {
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

	public String getType() {
		return type;
	}
}
