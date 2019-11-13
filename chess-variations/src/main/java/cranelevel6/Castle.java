package cranelevel6;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Castle extends Piece{
	//Location location;
	int x; // (0,0) or (7,0)for white?
	int y = 0;

	
	
	ArrayList<Directions> moves = new ArrayList<Directions>();
	
	Castle(Board b){
		super (b);
		moves.add(Directions.N);
		moves.add(Directions.S);
		moves.add(Directions.E);
		moves.add(Directions.W);
		
		
	}
	
	public ArrayList<Location> getPossibleMoves(){
	
		if(location == null) {
			return null;
		}
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


	
	void draw(Graphics g) {
		g.drawImage(image, x, y, 60, 60, null);
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	protected String getImageFile() {
		// TODO Auto-generated method stub
		
		String castlePNG = "";
		if(isWhite() == true) {
			castlePNG = "images/WhiteCastle.png";
		}
		else {
			castlePNG = "images/BlackCastle.png";
		}
		return castlePNG; 
		
	}
	
}
