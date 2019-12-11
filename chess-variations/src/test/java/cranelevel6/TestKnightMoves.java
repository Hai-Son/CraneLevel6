package cranelevel6;

import java.util.List;

public class TestKnightMoves {

	public static void main(String[] args) {
		Board b = new Board();
		Knight k = new Knight(b);
		k.setLocation(b.getTiles()[5][2]);
		b.addPiece(k);
		DisplayGame dg = b.getDg();

		// dg.repaint();
		List<Location> pMoves = k.possibleMoves();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : k.possibleMoves()) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}

	}

}
