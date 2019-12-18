package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Pawn extends Piece {
	int x;
	int y;

	ArrayList<Directions> moves = new ArrayList<Directions>();

	Pawn(Board board) {
		super(board);
		moves.add(Directions.N);
		moves.add(Directions.NN);
		moves.add(Directions.NE);
		moves.add(Directions.NW);
		moves.add(Directions.S);
		moves.add(Directions.SS);
		moves.add(Directions.SE);
		moves.add(Directions.SW);
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

}
