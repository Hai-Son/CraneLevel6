package cranelevel6;

import java.util.ArrayList;

public class TestPawnMoves {

	public static void main(String[] args) {
		Board b = new Board();
		Pawn p = new Pawn(b);
		p.setWhite(true);
		p.setLocation(b.getTiles()[4][6]);

		ArrayList<Location> pMoves = p.getPotential();
		if (pMoves == null) {
			System.out.println("null moves");
		}
		for (Location l : p.getPotential()) {
			System.out.println(l.getxTile() + ", " + l.getyTile());
		}
	}

}