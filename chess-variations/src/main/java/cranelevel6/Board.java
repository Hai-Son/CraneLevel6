package cranelevel6;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private final static int WIDTH = 900;
	private final static int HEIGHT = 900;
	private Location[][] tiles;
	JFrame frame;
	JPanel panel;
	

	Board() {
		tiles = new Location[8][8];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Location(i, j);
			}
		}
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);		
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Location[][] getTiles() {
		return tiles;
	}

	public Location getLocation(Location location, Directions d) {
		switch(d) {
		case N:
			return tiles[0][0];
		case W:
			return tiles[0][0];
		case S:
			return tiles[0][0];
		case E:
			return tiles[0][0];
			
		}
		// TODO Auto-generated method stub
		return null;
	}
}
