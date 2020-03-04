package cranelevel6;

import java.util.List;

public class TestPawnMoves {

	public static void main(String[] args) {
		Board b = new Board(new Chess(), false);
		Pawn p = new Pawn(b);
		p.setLocation(b.getTiles()[5][1]);
		b.addPiece(p);
		DisplayGame dg = b.getDg();

		dg.repaint();
		List<Location> pMoves = p.getPossibleMoves();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : p.getPossibleMoves()) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}

	}

}

//public class TestPawnMoves {
//
//	public static void main(String[] args) {
//		Board b = new Board();
//		Pawn p = new Pawn(b);
//		p.setWhite(true);
//		p.setLocation(b.getTiles()[4][6]);
//
//		ArrayList<Location> pMoves = p.getPotential();
//		if (pMoves == null) {
//			System.out.println("null moves");
//		}
//		for (Location l : p.getPotential()) {
//			System.out.println(l.getxTile() + ", " + l.getyTile());
//		}
//	}
//
//}
//>>>>>>> refs/remotes/origin/master
