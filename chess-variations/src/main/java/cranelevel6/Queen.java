package cranelevel6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	int x = 5;
	int y = 2;
	String coordinates = "";
	List<Directions> legalmoves = new ArrayList<>();

	public static void main(String[] args) {
		Queen Test = new Queen(null);
		Test.getPotential();
	}

	Queen(Board board) {
		super(board);
		// Given coordinate point of queen.
		// This assumes coordinates are from 0-7
		legalmoves.add(Directions.N);
		legalmoves.add(Directions.S);
		legalmoves.add(Directions.W);
		legalmoves.add(Directions.E);
		legalmoves.add(Directions.NE);
		legalmoves.add(Directions.SE);
		legalmoves.add(Directions.SW);
		legalmoves.add(Directions.NW);
	}

	public List<Location> getPotential() {
		
		if(location==null) {
			return null;
		}
		// return coordinates;
		List<Location> moves = new ArrayList<>();
		Location current = getLocation(); // Gets position of piece.
		for (Directions d : legalmoves) {
			Location n = current.getLocation(d); // Location of object
		//	Location s = new Location(n.getxTile(), n.getyTile());
			System.out.println(n);
			while(n != null) {
				moves.add(n);
				n = n.getLocation(d);
			}
	
		}
		return moves;
	}
	// recursively add another item as we go
	// until null or smth is hit

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
}
