package cranelevel6;

public class TestCastleMoves2 {

	public static void main(String[] args) {
		Board b = new Board();
		Castle c = new Castle(b);
		c.setWhite(true);
		c.setLocation(b.getTiles()[0][0]);
		b.addPiece(c);
		DisplayGame dg = b.getDg();
		c.refreshImage();
		dg.repaint();
	}

}
