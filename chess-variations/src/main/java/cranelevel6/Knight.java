package cranelevel6;

import java.awt.Graphics2D;

public class Knight extends Piece {

	Knight(Board board) {
		super(board);
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
}
