package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

	ArrayList<Directions> moves = new ArrayList<Directions>();

	Knight(Board board) {
		super(board);
		moves.add(Directions.NNW);
		moves.add(Directions.NNE);
		moves.add(Directions.SSE);
		moves.add(Directions.SSW);
		moves.add(Directions.EEN);
		moves.add(Directions.EES);
		moves.add(Directions.WWN);
		moves.add(Directions.WWS);
	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub

		String knightPNG = "";
		if (isWhite() == true) {
			knightPNG = "images/WhiteKnight.png";
		} else {
			knightPNG = "images/BlackKnight.png";
		}
		return knightPNG;

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
			if (l != null && l.getHasPiece() == false) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}

		return possibleMoves;

	}
}
