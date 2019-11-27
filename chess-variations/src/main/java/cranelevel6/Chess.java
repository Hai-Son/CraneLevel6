package cranelevel6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess implements ActionListener {

	int introWidth = 950;
	int introHeight = 975;
	JFrame frame;
	JPanel panel;
	JButton multiplayer;
	JButton singleplayer;
	JButton startGame;

	public void intro() {
		System.out.println("running intro");
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(introWidth, introHeight);

		// buttons

		multiplayer = new JButton();
		singleplayer = new JButton();
		startGame = new JButton();

		multiplayer.addActionListener(this);
		singleplayer.addActionListener(this);
		startGame.addActionListener(this);

		multiplayer.setText("Multiplayer");
		singleplayer.setText("Singleplayer");
		startGame.setText("Start Game");
		//

		frame.add(panel);
		panel.add(singleplayer);
		panel.add(multiplayer);
		panel.add(startGame);

		frame.setVisible(true);

	}

	public void setup() {
		System.out.println("running setup");
		// create and place squares
		// create and place pieces
		// start game
		frame.setVisible(false);
		Board board = new Board();
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.intro();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGame) {
			setup();
		}
	}
}
