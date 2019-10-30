package cranelevel6;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private final static int WIDTH = 900;
	private final static int HEIGHT = 925;
	private Location[][] tiles;
	JFrame frame;
	
	Board() {
		tiles = new Location[8][8];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Location(i, j);
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
	
	
}
