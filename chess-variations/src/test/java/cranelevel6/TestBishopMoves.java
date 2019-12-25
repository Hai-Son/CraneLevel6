package cranelevel6;

import java.util.List;

public class TestBishopMoves {

	public static void main(String[] args) {
		Board b = new Board(new Chess());
		Bishop bishop = new Bishop(b);
		bishop.setLocation(b.getTiles()[5][2]);
		b.addPiece(bishop);
		DisplayGame dg = b.getDg();

		// dg.repaint();
		List<Location> pMoves = bishop.getPossibleMoves();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : pMoves) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}

	}

}
