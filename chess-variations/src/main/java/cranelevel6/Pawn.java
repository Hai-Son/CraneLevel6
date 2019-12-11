package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	ArrayList<Directions> moves = new ArrayList<Directions>();

	Pawn(Board board) {
		super(board);

	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String pawnPNG = "";
		if (isWhite() == true) {
			pawnPNG = "images/WhitePawn.png";
			moves.add(Directions.N);
			moves.add(Directions.NE);
			moves.add(Directions.NW);
		} else {
			pawnPNG = "images/BlackPawn.png";
			moves.add(Directions.S);
			moves.add(Directions.SE);
			moves.add(Directions.SW);
		}
		return pawnPNG;

	}

	public ArrayList<Location> getPossibleMove() {

		if (location == null) {
			return null;
		}
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for (Directions d : moves) {
			Location l = location.getLocation(d);
			if (l != null) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
			if (d == Directions.N || d == Directions.S) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}

		}
		return possibleMoves;
	}

//	public ArrayList<Location> getPotential() {
//		if (location == null) {
//			return null;
//		}
//		ArrayList<Location> potentialMoves = new ArrayList<Location>();
//		int xcoord = location.getxTile();
//		int ycoord = location.getyTile();
//		for (Directions d : moves) {
//			run = 0;
//			Location l = location.getLocation(d);
//			while (l != null && run < 1) {
//				potentialMoves.add(l);
//				l = l.getLocation(d);
//				if (d == Directions.N && isWhite() == true && ycoord == 1 && l.getyTile() == 3) {
//					run--;
//				}
//				if (d == Directions.N && isWhite() == true && ycoord == 7 && l.getyTile() == 5) {
//					run--;
//				}
//				run += 1;
//				// Error on Black and White Pieces
//			}
//		}
//
//		return potentialMoves;
//
//	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(getImage(), location.getxCord(), location.getyCord(), 100, 100, null);
	}

	@Override
	List<Location> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
