package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class King extends Piece {
	int x;
	int y;

	ArrayList<Directions> moves = new ArrayList<Directions>();

	King(Board b) {
		super(b);
		moves.add(Directions.N);
		moves.add(Directions.S);
		moves.add(Directions.E);
		moves.add(Directions.W);
		moves.add(Directions.NE);
		moves.add(Directions.NW);
		moves.add(Directions.SE);
		moves.add(Directions.SW);
		moves.add(Directions.EE);
		moves.add(Directions.WW);
	}

	public ArrayList<Location> getPossibleMoves() {

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
		}

		return possibleMoves;
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

}
