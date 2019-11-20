package cranelevel6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess implements ActionListener {

	int introWidth = 950;
	int introHeight = 975;

	JButton multiplayer;
	JButton singleplayer;
	JButton startGame;
	JButton help;

	public void intro() {
		System.out.println("running intro");
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(introWidth, introHeight);

		// buttons

		multiplayer = new JButton();
		singleplayer = new JButton();
		startGame = new JButton();
		help = new JButton();

		multiplayer.addActionListener(this);
		singleplayer.addActionListener(this);
		startGame.addActionListener(this);
		help.addActionListener(this);

		multiplayer.setText("Multiplayer");
		singleplayer.setText("Singleplayer");
		startGame.setText("Start Game");
		help.setText("Learn to Play!");
		//

		frame.add(panel);
		panel.add(singleplayer);
		panel.add(multiplayer);
		panel.add(startGame);
		panel.add(help);

		frame.setVisible(true);

	}

	public void setup() {
		System.out.println("running setup");
		// create and place squares
		// create and place pieces
		// start game
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
