package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Castle extends Piece {
	boolean stop = false;
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();
	// ArrayList<Directions> moves = new ArrayList<Directions>();
	// added to create legal moves
	String type = "castle";
	ArrayList<Location> possibleMoves;

	Castle(Board board) {
		super(board);
		Rule castleRule = new CastleRule();
		moves.put(Directions.N, castleRule);
		moves.put(Directions.S, castleRule);
		moves.put(Directions.W, castleRule);
		moves.put(Directions.E, castleRule);
		moves.put(Directions.EEE, castleRule);
	}
//	Castle(Board b) {
//		super(b);
//		moves.add(Directions.N);
//		moves.add(Directions.S);
//		moves.add(Directions.E);
//		moves.add(Directions.W);
//
//		moves.add(Directions.EEE);
//
//	}

	public ArrayList<Location> getPossibleMoves() {

		if (location == null) {
			return null;
		}
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			while (l != null && l.getHasPiece() == false) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}

		return possibleMoves;
	}

//	public ArrayList<Location> getLegalMoves() {
//
//		if (location == null) {
//			return null;
//		}
//		ArrayList<Location> legalMoves = new ArrayList<Location>();
//		for (Location p : possibleMoves) {
//			if (p != null) {
//				if (!p.getHasPiece()) {
//					legalMoves.add(p);
//					System.out.println("passed");
//				} else {
//					System.out.println("no moves here");
//				}
//			}
//		}
//
//		return legalMoves;
//	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String castlePNG = "";
		if (isWhite() == true) {
			castlePNG = "images/WhiteCastle.png";
		} else {
			castlePNG = "images/BlackCastle.png";
		}
		return castlePNG;

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
			while (l != null && r.isValid(this, l) && l.getHasPiece() == false) {
				legalMoves.add(l);
				l = l.getLocation(d);
				System.out.print(l);

				if (stop == true) {
					break;
				}
			}
			stop = false;
		}
		return legalMoves;
	}

	class CastleRule extends Rule {
		boolean isValid(Piece p, Location l) {
			if (!super.isValid(p, l)) {
				return false;
			}
			Piece lPiece = l.getPiece();
			if (lPiece == null) {
				return true;

			}
			if (lPiece == null || lPiece.isWhite() != p.isWhite()) {
				stop = true;
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
