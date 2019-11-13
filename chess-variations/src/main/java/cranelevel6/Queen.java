package cranelevel6;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Queen extends Piece {
	int x = 5;
	int y = 2;
	String coordinates = "";
	//String image;
	List<Directions> legalmoves = new ArrayList<>();

	Queen(Board board) {
		super(board);
		// Given coordinate point of queen.
		// This assumes coordinates are from 0-7
		legalmoves.add(Directions.N);
		legalmoves.add(Directions.S);
		legalmoves.add(Directions.W);
		legalmoves.add(Directions.E);
	}

	public List<Location> getPotential() {
		// return coordinates;
		List<Location> moves = new ArrayList<>();
		Location current = getLocation(); // Gets position of piece.
		for (Directions d : legalmoves) {
			Location n = current.getLocation(d); // Location of object
			Location s = new Location(n.getxTile(), n.getyTile());
			System.out.println(n);
			// if() {
			// moves.add(d);
			// }
		}
		return moves;
	}
	
//	void draw(Graphics g) {
//		g.drawImage(image, x, y, 60, 60, null);
//	}
//	
//	public static void main(String[] args) {
//		
//	}
//	
//	@Override
//	protected String getImageFile() {
//		// TODO Auto-generated method stub
//		
//		String queenPNG = "";
//		if(isWhite() == true) {
//			queenPNG = "images/WhiteQueen.png";
//		}
//		else {
//			queenPNG = "images/BlackQueen.png";
//		}
//		return queenPNG; 
//		
//	}
	
	// recursively add another item as we go
	// until null or smth is hit
}