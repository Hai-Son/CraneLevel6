package cranelevel6;


import java.util.ArrayList;
import java.util.List;

public class TestQueenMoves {

	public static void main(String[] args) {
		Board b = new Board();
		Queen q = new Queen(b);
		q.setLocation(b.getTiles()[5][2]);
		b.addPiece(q);
		DisplayGame dg = b.getDg();
		
		dg.repaint();
		List<Location> pMoves = q.getPotential();
		if(pMoves == null) {
			System.out.println("null moves");
		}
		for(Location l: q.getPotential()) {
			System.out.println(l.getxTile()+", " + l.getyTile());
		}	
	
	}
	
}
