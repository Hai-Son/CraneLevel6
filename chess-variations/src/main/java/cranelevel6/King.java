package cranelevel6;

import java.awt.Graphics2D;

public class King extends Piece {

	King(Board board) {
		super(board);
	}
	// public void move(seelcted )

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
