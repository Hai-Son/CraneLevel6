package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Castle extends Piece {
	// Location location;
	int x; // (0,0) or (7,0)for white?
	int y = 0;

	ArrayList<Directions> moves = new ArrayList<Directions>();

	Castle(Board b) {
		super(b);
		moves.add(Directions.N);
		moves.add(Directions.S);
		moves.add(Directions.E);
		moves.add(Directions.W);

	}

	public ArrayList<Location> getPossibleMoves() {

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

}
