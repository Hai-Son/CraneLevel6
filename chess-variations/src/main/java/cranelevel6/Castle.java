package cranelevel6;

import java.awt.List;
import java.util.ArrayList;

public class Castle extends Piece{
	Location location;
	int x; // (0,0) or (7,0)for white?
	int y = 0;
	
	ArrayList<Directions> moves = new ArrayList<Directions>();
	
	Castle(){
		moves.add(Directions.N);
		moves.add(Directions.S);
		moves.add(Directions.E);
		moves.add(Directions.W);
	}
	
	Castle c = new Castle();
	
	public void restrictions() {
		
		if(c.getLocation().getxTile() == 7) {
			moves.remove(Directions.E);
		}
		if(c.getLocation().getxTile() == 0) {
			moves.remove(Directions.W);
		}
		if(c.getLocation().getyTile() == 7) {
			moves.remove(Directions.S);
		}
		if(c.getLocation().getyTile() == 0) {
			moves.remove(Directions.N);
		}
		
	}

	public ArrayList<Location> getPossibleMoves(){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		for(Directions d: moves) {
			Location l = location.getLocation(d);
			while(l != null) {
				possibleMoves.add(l);
				l = l.getLocation(d);
			}
		}
		
		
		return possibleMoves;
	}
	
	public static void main(String[] args) {
		
	}
	
}
