package cranelevel6;

import java.util.List;

public class TestPawnMoves {

	public static void main(String[] args) {
		Board b = new Board();
		Pawn p = new Pawn(b);
		p.setLocation(b.getTiles()[5][1]);
		b.addPiece(p);
		DisplayGame dg = b.getDg();

		dg.repaint();
		List<Location> pMoves = p.getPossibleMove();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : p.getPossibleMove()) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}

	}

}
