package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
	ArrayList<Directions> moves = new ArrayList<Directions>();

	Bishop(Board board) {
		super(board);
		moves.add(Directions.NE);
		moves.add(Directions.SE);
		moves.add(Directions.SW);
		moves.add(Directions.NW);
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

	@Override
	List<Location> getPossibleMoves() {
		if (location == null) {
			return null;
		}
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for (Directions d : moves) {
			Location l = location.getLocation(d);
			while (l != null) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}

		return possibleMoves;
	}
}
