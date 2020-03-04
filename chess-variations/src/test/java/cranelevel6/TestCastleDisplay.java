package cranelevel6;

public class TestCastleDisplay {

	public static void main(String[] args) {
		Board b = new Board(new Chess(), false);
		Castle c = new Castle(b);
		c.setWhite(true);
		c.setLocation(b.getTiles()[0][0]);
		b.addPiece(c);
		DisplayGame dg = b.getDg();
		c.refreshImage();
		dg.repaint();
	}

}
