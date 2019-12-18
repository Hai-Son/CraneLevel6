package cranelevel6;

import java.awt.Font;
import java.awt.GridLayout;
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
	JButton singleplayer;
	JButton multiplayer;
	JButton help;

	public void intro() {
		System.out.println("running intro");
		frame = new JFrame("Game Menu");
		panel = new JPanel(new GridLayout(1, 3));
		frame.setSize(introWidth, introHeight);

		// buttons
		Font f = new Font("Times New Roman", 50, 50);
		singleplayer = new JButton();
		singleplayer.addActionListener(this);
		singleplayer.setFont(f);
		singleplayer.setText("Singleplayer");
		multiplayer = new JButton();
		multiplayer.addActionListener(this);
		multiplayer.setFont(f);
		multiplayer.setText("Multiplayer");
		help = new JButton();
		help.addActionListener(this);
		help.setFont(f);
		help.setText("Learn to Play!");

		//

		frame.add(panel);
		panel.add(singleplayer);
		panel.add(multiplayer);
		panel.add(help);

		frame.setVisible(true);

	}

	public void learningChess() {
		System.out.println("Running Instructions");
		LearnScreen learn = new LearnScreen();
	}

	public void setup() {
		System.out.println("running setup");
		// create and place squares
		// create and place pieces
		// start game
		Board board = new Board();
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.intro();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == singleplayer) {
			setup();
		}
		if (e.getSource() == help) {
			learningChess();
		}
	}
}
