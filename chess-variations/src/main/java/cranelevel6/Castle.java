package cranelevel6;

import java.awt.Graphics;
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
				// System.out.println(n);
			}
		}

		return possibleMoves;
	}

	void draw(Graphics g) {
		// g.drawImage(/*name goes here*//*, x, y, width, height, null*/);
	}

	public static void main(String[] args) {

	}

}
