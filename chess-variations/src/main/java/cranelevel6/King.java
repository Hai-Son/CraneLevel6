package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class King extends Piece {
	boolean potentialCastle = true;
	String type = "king";
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();
	int x;
	int y;
	// ArrayList<Directions> moves = new ArrayList<Directions>();

//	King(Board b) {
//		super(b);
//		moves.add(Directions.N);
//		moves.add(Directions.S);
//		moves.add(Directions.E);
//		moves.add(Directions.W);
//		moves.add(Directions.NE);
//		moves.add(Directions.NW);
//		moves.add(Directions.SE);
//		moves.add(Directions.SW);
//		moves.add(Directions.EE);
//		moves.add(Directions.WW);
//	}

	King(Board b) {
		super(b);
		Rule kingRule = new kingRule();
		moves.put(Directions.N, kingRule);
		moves.put(Directions.S, kingRule);
		moves.put(Directions.E, kingRule);
		moves.put(Directions.W, kingRule);
		moves.put(Directions.NE, kingRule);
		moves.put(Directions.SW, kingRule);
		moves.put(Directions.SE, kingRule);
		moves.put(Directions.NW, kingRule);
		moves.put(Directions.EE, kingRule);
		moves.put(Directions.WW, kingRule);
	}

	public ArrayList<Location> getPossibleMoves() {

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

	List<Location> getLegalMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> legalMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			Rule r = moves.get(d);
			if (l != null && r.isValid(this, l)) {
				legalMoves.add(l);
				l = l.getLocation(d);
			}
		}
		return legalMoves;
	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String kingPNG = "";
		if (isWhite() == true) {
			kingPNG = "images/WhiteKing.png";
		} else {
			kingPNG = "images/BlackKing.png";
		}
		return kingPNG;

	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(getImage(), location.getxCord(), location.getyCord(), 100, 100, null);
	}

	public String getType() {
		return type;
	}

	class kingRule extends Rule {

		boolean isValid(Piece p, Location l) {
			System.out.println("isValid runs");
			if (!super.isValid(p, l)) {
				return false;
			}
			Piece lPiece = l.getPiece();
			if (lPiece == null) {
				return true;
			}

			if (lPiece.isWhite() != p.isWhite()) {
				return true;

			} else {
				return false;
			}

		}

	}

}
