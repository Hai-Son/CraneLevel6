package cranelevel6;

import java.awt.Graphics2D;
import java.util.List;

public class Bishop extends Piece {

	Bishop(Board board) {
		super(board);
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
	List getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
