package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queen extends Piece {
	Map<Directions, Rule> moves = new HashMap<Directions, Rule>();
	int x = 5;
	int y = 2;
	String coordinates = "";
	// List<Directions> legalmoves = new ArrayList<>();

//CONFLICT BETWEEN LEGAL MOVES AND MOVES 

	public static void main(String[] args) {
		Queen Test = new Queen(null);
		Test.getPossibleMoves();
	}

	Queen(Board board) {
		super(board);
		Rule queenRule = new QueenRule();
		moves.put(Directions.N, queenRule);
		moves.put(Directions.S, queenRule);
		moves.put(Directions.W, queenRule);
		moves.put(Directions.E, queenRule);
		moves.put(Directions.NE, queenRule);
		moves.put(Directions.SE, queenRule);
		moves.put(Directions.SW, queenRule);
		moves.put(Directions.NW, queenRule);
	}

//	Queen(Board board) {
//		super(board);
//		// Given coordinate point of queen.
//		legalmoves.add(Directions.N);
//		legalmoves.add(Directions.S);
//		legalmoves.add(Directions.W);
//		legalmoves.add(Directions.E);
//		legalmoves.add(Directions.NE);
//		legalmoves.add(Directions.SE);
//		legalmoves.add(Directions.SW);
//		legalmoves.add(Directions.NW);
//	}

	public List<Location> getPossibleMoves() {

		// return coordinates;
		List<Location> moves = new ArrayList<>();
		Location current = getLocation(); // Gets position of piece.
		for (Directions d : legalmoves) {
			Location n = current.getLocation(d); // Location of object
			// Location s = new Location(n.getxTile(), n.getyTile());
			System.out.println(n);
			while (n != null) {
				moves.add(n);
				n = n.getLocation(d);
			}

		}
		return moves;
	}
	// recursively add another item as we go
	// until null or smth is hit

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String queenPNG = "";
		if (isWhite() == true) {
			queenPNG = "images/WhiteQueen.png";
		} else {
			queenPNG = "images/BlackQueen.png";
		}
		return queenPNG;

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

	class QueenRule extends Rule {
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
