package cranelevel6;

import javax.swing.JOptionPane;

public class Chess {

	public void setup(){
		//Opening screen?
		//create and place squares
		//create and place pieces
		//start game
		Board board = new Board();
		int x = Integer.parseInt(JOptionPane.showInputDialog("Enter Test Tile X"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("Enter Test Tile Y"));
		JOptionPane.showMessageDialog(null, (board.getTiles()[x][y].getxCord() + ", " + board.getTiles()[x][y].getyCord()));
	}
	
	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.setup();
		
	}
}
