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
