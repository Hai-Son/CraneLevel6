package cranelevel6;

import java.awt.List;
import java.util.ArrayList;

public class Castle extends Piece{
	Location location;
	int x; // (0,0) or (8,0)
	int y = 0;
	
	ArrayList<Directions> moves = new ArrayList<Directions>();
	
	Castle(){
		moves.add(Directions.N);
		moves.add(Directions.S);
		moves.add(Directions.E);
		moves.add(Directions.W);
	}
	
	Castle c = new Castle();
	
	public void direction() {
		
		/////START HEREEE
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
