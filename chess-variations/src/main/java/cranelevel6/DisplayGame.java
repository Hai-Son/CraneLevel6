package cranelevel6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

public class DisplayGame extends JPanel{
	Board board;
	DisplayGame(Board board){
		this.board = board;
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		Color light = new Color(254,206,157);
		Color dark = new Color(150,75,0);
		Location[][] tiles = board.getTiles();
		g2.setColor(dark);
		g2.fillRect(0, 0, 950, 975);
		g2.setColor(light);
		g2.fillRect(75, 75, 800, 800);
		g2.setColor(dark);
		for (int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				if((tiles[i][j].getxTile() + tiles[i][j].getyTile())%2==0) {
					g2.fillRect(tiles[i][j].getxCord(), tiles[i][j].getyCord(), 100, 100);
				}	
			}
		}
		g2.setStroke(new BasicStroke(10));
		g2.setColor(light);
		g2.drawRect(70, 70, 810, 810);
		String[] nums = {"1","2","3","4","5","6","7","8"};
		String[] chars = {"A","B","C","D","E","F","G","H"};
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		for(int i = 0; i < nums.length; i++) {
			g2.drawString(nums[i], 35, tiles[0][i].getyCord()+55);
		}
		for(int i = 0; i < nums.length; i++) {
			g2.drawString(nums[i], 905, tiles[0][i].getyCord()+55);
		}
		for(int i = 0; i < chars.length; i++) {
			g2.drawString(chars[i], tiles[i][0].getxCord()+40, 45);
		}
		for(int i = 0; i < chars.length; i++) {
			g2.drawString(chars[i], tiles[i][0].getxCord()+40, 915);
		}
		List<Piece> pieces = board.getPieces();
		if(pieces != null) {
			for(Piece p: pieces) {
				p.draw(g2);
			}
		}
	}
	
}
