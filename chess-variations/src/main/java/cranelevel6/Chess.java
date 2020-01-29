package cranelevel6;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chess implements ActionListener {

	int introWidth = 950;
	int introHeight = 975;
	JFrame frame;
	JPanel panel;
	JButton singleplayer;
	JButton multiplayer;
	JButton help;
	JButton quit;
	Chess c;

	public void intro() {
		c = this;
		frame = new JFrame("Game Menu");
		panel = new JPanel(new GridLayout(2, 2));
		panel.setBackground(Color.BLACK);
		frame.setSize(introWidth, introHeight);
		// buttons
		Font f = new Font("Times New Roman", 50, 50);
		singleplayer = new JButton("Singleplayer");
		singleplayer.addActionListener(this);
		singleplayer.setFont(f);
		singleplayer.setBackground(new Color(255, 215, 0));
		singleplayer.setOpaque(true);
		singleplayer.setBorderPainted(false);
		multiplayer = new JButton("Multiplayer");
		multiplayer.addActionListener(this);
		multiplayer.setFont(f);
		multiplayer.setBackground(new Color(255, 105, 180));
		multiplayer.setOpaque(true);
		multiplayer.setBorderPainted(false);
		help = new JButton("Learn to Play");
		help.addActionListener(this);
		help.setFont(f);
		help.setBackground(new Color(204, 255, 229));
		help.setOpaque(true);
		help.setBorderPainted(false);
		quit = new JButton("Quit Game");
		quit.addActionListener(this);
		quit.setFont(f);
		quit.setBackground(new Color(255, 99, 71));
		quit.setOpaque(true);
		quit.setBorderPainted(false);
		frame.add(panel);
		panel.add(singleplayer);
		panel.add(multiplayer);
		panel.add(help);
		panel.add(quit);
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
		Board board = new Board(c);
		frame.setVisible(false);
	}

	public void multiSetup() {
		String[] options = { "Join", "Host" };
		int option = JOptionPane.showOptionDialog(null, "Are You Hosting Or Joining A Game", "Multiplayer Connect",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if (option == 0) {
			String hostIP = JOptionPane.showInputDialog(""); // ask what opposing ip is
		} else if (option == 1) {
			String hostIP = ""; // find ip of computer
			JOptionPane.showMessageDialog(null, "Your IP Address is " + hostIP, "Multiplayer Connect",
					JOptionPane.PLAIN_MESSAGE, null);
		}
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.intro();

	}

	public void backPressed() {
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == singleplayer) {
			setup();
		}
		if (e.getSource() == multiplayer) {
			multiSetup();
		}
		if (e.getSource() == help) {
			learningChess();
		}
		if (e.getSource() == quit) {
			System.exit(0);
		}
	}
}
