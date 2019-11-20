package cranelevel6;

import java.util.ArrayList;

public class TestCastleMoves2 {

	public static void main(String[] args) {
		Board b = new Board();
		Castle c = new Castle(b);
		c.setLocation(b.getTiles()[0][0]);
		b.addPiece(c);
		DisplayGame dg = b.getDg();
		
		dg.repaint();
		}
	
}
