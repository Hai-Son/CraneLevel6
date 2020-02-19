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

	class ColorRule extends PieceColorRule {
		ColorRule(boolean white) {
			super(white);

		}

	}

	class AdvanceRule extends ColorRule {
		AdvanceRule(boolean white) {
			super(white);
			// TODO Auto-generated constructor stub
		}

		boolean isValid(Piece p, Location l) {
			if (!super.isValid(p, l)) {
				return false;
			}
			Piece lPiece = l.getPiece();
			if (lPiece == null) {
				return true;
			} else {
				return false;
			}

		}

	}

	Pawn(Board board) {
		super(board);
		Rule whiteRule = new ColorRule(true);
		Rule blackRule = new ColorRule(false);
		Rule whiteTakeRule = new TakeRule(true);
		Rule blackTakeRule = new TakeRule(false);
		Rule whiteAdvanceRule = new AdvanceRule(true);
		Rule blackAdvanceRule = new AdvanceRule(false);

		moves.put(Directions.N, whiteAdvanceRule);
		moves.put(Directions.NN, whiteRule);
		moves.put(Directions.NE, whiteTakeRule);
		moves.put(Directions.NW, whiteTakeRule);
		moves.put(Directions.SS, blackRule);
		moves.put(Directions.S, blackAdvanceRule);
		moves.put(Directions.SW, blackTakeRule);
		moves.put(Directions.SE, blackTakeRule);
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

		if (location.getPiece().hasMoved == true) {
			if (location.getPiece().isWhite() == true) {
				moves.remove(Directions.NN);
			} else if (location.getPiece().isWhite() == false) {
				moves.remove(Directions.SS);
			}
		}

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
//				Iterator i = new Iterator();
//				i.remove(Directions.NN);
//				i.remove(Directions.SS);
//			}

		}
		return legalMoves;
	}

	class TakeRule extends ColorRule {
		TakeRule(boolean white) {
			super(white);
			// TODO Auto-generated constructor stub
		}

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

				if (lPiece != null && lPiece.isWhite() != p.isWhite()) {

					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		}

//	class DoubleAdvanceRule extends AdvanceRule {
//		DoubleAdvanceRule(boolean white) {
//			super(white);
//			// TODO Auto-generated constructor stub
//		}
//
//		boolean isValid(Piece p, Location l) {
//			if (!super.isValid(p, l)) {
//				return false;
//			}
//			Piece lPiece = l.getPiece();
//			if (lPiece == null && p.get) {
//				return true;
//			} else {
//				return false;
//			}
//
//		}
//
//	}

		public String getType() {
			return type;
		}
	}
}
