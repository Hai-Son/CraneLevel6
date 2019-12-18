package cranelevel6;

import java.util.List;

public class TestQueenMoves {

	public static void main(String[] args) {
		Board b = new Board(new Chess());
		Queen q = new Queen(b);
		q.setLocation(b.getTiles()[5][2]);
		b.addPiece(q);
		DisplayGame dg = b.getDg();

		dg.repaint();
		List<Location> pMoves = q.getPossibleMoves();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : q.getPossibleMoves()) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}

	}

}
