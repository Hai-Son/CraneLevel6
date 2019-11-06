package cranelevel6;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private final static int WIDTH = 950;
	private final static int HEIGHT = 975;
	private Location[][] tiles;
	JFrame frame;
	
	Board() {
		tiles = new Location[8][8];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Location(i, j);
				tiles[i][j].setBoard(this);
			}
		}
		DisplayGame dg = new DisplayGame(this);
		frame = new JFrame();
		frame.add(dg);		
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		dg.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public Location[][] getTiles() {
		return tiles;
	}


	public Location getLocation(Location location, Directions d) {
		//is it a real location
		if(location == null || d == null) {
			return null;
		}
		//new location
		int x = location.getxTile()+d.getX();
		int y = location.getyTile()+d.getY();
		
		//is it out of bounds
		if(x<0 || x>7 || y<0 || y>7) {
			return null;
		}else {
			return tiles[x][y];
		}
	}

}
