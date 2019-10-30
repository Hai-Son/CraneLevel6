package cranelevel6;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	int x = 5;
	int y = 2;
	String coordinates = "";
	List<Directions> legalmoves = new ArrayList<Directions>();

	public static void main(String[] args) {
		Queen Test = new Queen();
		Test.getPotential();
	}

	Queen() {
		// Given coordinate point of queen.
		// This assumes coordinates are from 0-7
		legalmoves.add(Directions.N);
		legalmoves.add(Directions.S);
		legalmoves.add(Directions.W);
		legalmoves.add(Directions.E);
	}

	public List<Location> getPotential() {
//		// return coordinates;
//		int index = 0;
//		//List<Location> moves = new ArrayList<>();
//		Location current = getLocation(); // Gets position of piece.
//		for (Directions d : legalmoves) {
//			Location n = current.getLocation(d); // Location of object
//			while (index < 1) {
//				Location s = new Location(n.getxTile() + 1, n.getyTile());
//				if (s.getHasPiece() == false) {
//					moves.add(s);
//				} else {
//					index += 1; //Break 
//				}
//			}
//		}
		if(Directions.N) {
			
		}

	}
	// recursively add another item as we go
	// until null or smth is hit
}
