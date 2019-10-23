package cranelevel6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class DisplayGame extends JPanel{
	Board board;
	DisplayGame(Board board){
		this.board = board;
	}
	public void draw(Graphics g) {
		Location[][] tiles = board.getTiles();
		g.setColor(Color.black);
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				g.fillRect(tiles[i][j].getxCord(), tiles[i][j].getyCord(), 100, 100);
				System.out.println("working");
			}
		}
	}
}
