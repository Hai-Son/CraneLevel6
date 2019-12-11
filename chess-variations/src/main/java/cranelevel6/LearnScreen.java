package cranelevel6;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LearnScreen {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Font fancyFont = new Font("Times New Roman", Font.BOLD, 34);
	Font regularFont = new Font("Times New Roman", Font.PLAIN, 16);
	JLabel pieces = new JLabel();
	JLabel titleLine = new JLabel();
	int xFrame = 600;
	int yFrame = 800;

	LearnScreen() {
		panel.setLayout(null);
		setup();
		title();
		pieceFunctions();

	}

	public void setup() {
		frame.setVisible(true);
		frame.setSize(xFrame, yFrame);
		frame.add(panel);
		panel.add(pieces);
		panel.add(titleLine);
		// panel.setBackground(Color.green);
	}

	public void title() {
		titleLine.setForeground(Color.magenta);
		titleLine.setFont(fancyFont);
		titleLine.setText("How to play Chess:");
		titleLine.setBounds(50, 10, 300, 40);
		titleLine.setVisible(true);
	}

	public void pieceFunctions() {
		System.out.println("hi");
		pieces.setFont(regularFont);
		pieces.setText("<html> Pieces in the Game:<br>"
				+ "<br>King: This is the most important piece in the game and must be protected at all costs. "
				+ "It may only move in one step in all directions. It also has a special move with the Castle where the two cross and switch positions on the board. "
				+ "The King moves two directions in either the left or right direction and the castle 'jumps' over the King. "
				+ "However, this may only be done if either piece has not be moved and the king is not in check.<br>"
				+ "<br>Queen: This piece may move and capture pieces in all directions. <br>"
				+ "<br> Knight: This piece 'hops' over other pieces by moving in an L shape. <br>"
				+ "It moves three spaces in the vertical or horizontal direction and one in an adjacent direction. "
				+ "<br>Bishop: A bishop moves and captures on the diagonals.<br>"
				+ "<br>Castle: A Castle moves and captures opponents in the horizontal or vertical directions.<br>"
				+ "<br>Pawn: Pawns are capable of moving in the forward direction one square and can capture to the left and right. "
				+ "A pawn may move two spaces on its first move and can be promoted to another piece if it reaches the end of the board. "
				+ "Additionally, the pawn has a special move called 'En Passant' "
				+ "This allows pawns to capture an opponent's pawn that has taken two steps forward by moving as if that pawn had only moved one step.<br> </html>");
		pieces.setBounds(10, 90, 500, 600);
		pieces.setVisible(true);
	}

}
