package cranelevel6;

import java.util.ArrayList;

public class TestCastleMoves2 {

	public static void main(String[] args) {
		Board b = new Board();
		Castle c = new Castle(b);
		c.setLocation(b.getTiles()[0][0]);
		
		ArrayList <Location> pMoves = c.getPossibleMoves();
		if(pMoves == null) {
			System.out.println("null moves");
		}
		for(Location l: c.getPossibleMoves()) {
			System.out.println(l.getxTile()+", " + l.getyTile());
		}
	}
	
}
