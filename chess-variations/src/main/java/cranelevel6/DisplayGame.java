package cranelevel6;

import java.awt.*;

import javax.swing.*;

public class DisplayGame extends JPanel{
	Board board;
	DisplayGame(Board board){
		this.board = board;
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Location[][] tiles = board.getTiles();
		g.setColor(new Color(255,205,150));
		g.fillRect(50, 50, 800, 800);
		g.setColor(new Color(150,75,0));
		for (int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				if((tiles[i][j].getxTile() + tiles[i][j].getyTile())%2==0) {
					g.fillRect(tiles[i][j].getxCord(), tiles[i][j].getyCord(), 100, 100);
				}	
			}
		}
		g.setColor(Color.black);
		g.drawRect(50, 50, 800, 800);
	}
}
