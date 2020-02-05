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
		Rule whiteRule = new ColorRule(true);
		Rule blackRule = new ColorRule(false);

		moves.put(Directions.N, whiteRule);
		moves.put(Directions.NN, whiteRule);
		moves.put(Directions.NE, whiteRule);
		moves.put(Directions.NW, whiteRule);
		moves.put(Directions.SS, blackRule);
		moves.put(Directions.S, blackRule);
		moves.put(Directions.SW, blackRule);
		moves.put(Directions.SE, blackRule);
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
		System.out.println("getPossMovesRun");
		if (location == null) {
			return null;
		} else if (isWhite() == true) {
			System.out.println("remove");
			if (getHasMoved() == true) {
				moves.remove(Directions.NN);
			}
			moves.remove(Directions.S);
			moves.remove(Directions.SS);
			moves.remove(Directions.SW);
			moves.remove(Directions.SE);
		} else {
			if (getHasMoved() == true) {
				moves.remove(Directions.SS);
			}
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
		System.out.println("getlegalMoves run");
		if (location == null) {
			return null;
		}
		ArrayList<Location> legalMoves = new ArrayList<Location>();
		for (Directions d : moves.keySet()) {
			Location l = location.getLocation(d);
			Rule r = moves.get(d);
			if (l != null) {
				System.out.println("null run");

				if (r.isValid(this, l)) {
					legalMoves.add(l);
				}

			}
//			if (l.getyTile() != 1 || l.getyTile() != 6) {
//				System.out.println("hasmovedrun");
////				Iterator i = new Iterator();
////				i.remove(Directions.NN);
////				i.remove(Directions.SS);
//			}

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
			}
			if (p.getHasMoved() == true) {
				getPossibleMoves();
				return true;
			} else {
				return false;
			}

		}

	}

	class ColorRule extends PieceColorRule {
		ColorRule(boolean white) {
			super(white);

		}

	}

	public String getType() {
		return type;
	}
}
