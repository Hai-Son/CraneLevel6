package cranelevel6;

import java.awt.Graphics2D;

public class Pawn extends Piece {

	Pawn(Board board) {
		super(board);
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
