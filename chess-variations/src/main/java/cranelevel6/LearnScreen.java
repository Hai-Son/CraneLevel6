package cranelevel6;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LearnScreen {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Font fancyFont = new Font("Times New Roman", Font.BOLD, 34);
	Font regularFont = new Font("Times New Roman", Font.PLAIN, 16);
	JLabel pieces = new JLabel();
	JLabel specialMoves = new JLabel();
	JLabel basicPlay = new JLabel();
	JLabel titleLine = new JLabel();
	JLabel images = new JLabel();
	JLabel kingImg = new JLabel();
	JLabel queenImg = new JLabel();
	JLabel knightImg = new JLabel();
	JLabel bishopImg = new JLabel();
	JLabel castleImg = new JLabel();
	JLabel pawnImg = new JLabel();
	int xFrame = 1000;
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
		panel.add(basicPlay);
		frame.add(panel);
		panel.add(pieces);
		panel.add(specialMoves);
		panel.add(titleLine);

		panel.add(images);
		panel.add(kingImg);
		panel.add(queenImg);
		panel.add(knightImg);
		panel.add(bishopImg);
		panel.add(castleImg);
		panel.add(pawnImg);

		Color c = new Color(204, 255, 229);
		panel.setBackground(c);

	}

	public void title() {
		titleLine.setForeground(Color.magenta);
		titleLine.setFont(fancyFont);
		titleLine.setText("How to play Chess:");
		titleLine.setBounds(50, 10, 300, 40);
		titleLine.setVisible(true);

	}

	public void pieceFunctions() {
		basicPlay.setFont(regularFont);

		basicPlay.setText("<html> General rules: <br>" // was "Pieces in the Game"

				+ "<br>All pieces, with the exception of Knights and the Castle and King during castling, can only move over vacant spaces."
				+ "The player who is in control of the white pieces makes the first move. <br>"
				+ "<br> Chess game endings: <br>" + "Winning: A player wins when they checkmate their opponent's king. "
				+ "Putting a king in 'check' means that a piece is putting the opponent's king in danger of capture on the next move. "
				+ "A 'checkmate' is when a king is in check and cannot move out of danger, block the piece putting it in check, or capture the threatening piece. <br> "
				+ "<br> Draw: When no pawns have moved in the last 75 moves and no captures have occurred or when a stalemate occurs. <br>"
				+ "<br> Stalemate: When all of the spaces around a king are threatened and it cannot move but there are no other pieces that have the ability to move. <br>");
		basicPlay.setBounds(600, 50, 350, 600);

		images.setFont(regularFont);
		images.setText("<html> Piece images: <br>");
		images.setBounds(470, 20, 150, 220);

		kingImg.setIcon(new ImageIcon("images/WhiteKing.png"));
		kingImg.setBounds(470, 50, 150, 350);

		queenImg.setIcon(new ImageIcon("images/WhiteQueen.png"));
		queenImg.setBounds(470, 50, 150, 612);

		knightImg.setIcon(new ImageIcon("images/WhiteKnight.png"));
		knightImg.setBounds(470, 50, 150, 753);

		bishopImg.setIcon(new ImageIcon("images/WhiteBishop.png"));
		bishopImg.setBounds(470, 50, 150, 868);

		castleImg.setIcon(new ImageIcon("images/WhiteCastle.png"));
		castleImg.setBounds(470, 50, 150, 985);

		pawnImg.setIcon(new ImageIcon("images/WhitePawn.png"));
		pawnImg.setBounds(470, 50, 150, 1200);

		pieces.setFont(regularFont);
		pieces.setText("<html> Pieces in the Game:<br>"
				+ "<br>King: This is the most important piece in the game and must be protected at all costs. "
				+ "It may only move in one step in all directions. It also has a special move with the Castle where the two cross and switch positions on the board. "
				+ "The King moves two spaces in either the left or right direction and the castle on the corresponding side 'jumps' over the King, taking the space that it had passed. "
				+ "However, this may only be done if both pieces have not be moved, the spaces between the pieces are vacant, and the king is not in check.<br>"
				+ "<br>Queen: This piece may move and capture pieces in all directions (vertically, horizontally, diagonally). <br>"
				+ "<br> Knight: This piece 'hops' over other pieces by moving in an L shape. <br>"
				+ "It moves three spaces in the vertical or horizontal direction and one in an adjacent direction. <br>"
				+ "<br>Bishop: A bishop moves and captures on the diagonals.<br>"
				+ "<br>Castle: A Castle moves and captures opponents in the horizontal or vertical directions.<br>"
				+ "<br>Pawn: Pawns are capable of moving in the forward direction one square and can capture to the left and right. "
				+ "A pawn may move two spaces on its first move and can be promoted to a different piece if it reaches the end of the board. "
				+ "Pawns cannot move backward. " + "Additionally, the pawn has a special move called 'En Passant' "
				+ "This allows pawns to capture an opponent's pawn that has taken two steps forward by moving as if that pawn had only moved one step.<br> </html>");
		pieces.setBounds(10, 20, 450, 800);
		pieces.setVisible(true);
		basicPlay.setVisible(true);
	}

}
