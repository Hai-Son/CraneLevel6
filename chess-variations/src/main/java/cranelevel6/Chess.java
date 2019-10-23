package cranelevel6;


import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess implements ActionListener {
	int introWidth = 800;
	int introHeight = 800;
	JButton multiplayer;
	JButton singleplayer;
	JButton startGame;
	
	public void intro() {
		System.out.println("running intro");
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(introWidth, introHeight);
		
		//buttons
		JButton multiplayer = new JButton();
		JButton singleplayer = new JButton();
		JButton startGame = new JButton();
		
		multiplayer.addActionListener(this);
		singleplayer.addActionListener(this);
		startGame.addActionListener(this);
		
		multiplayer.setText("Multiplayer");
		singleplayer.setText("Singleplayer");
		startGame.setText("Start Game");

		
		frame.add(panel);
		panel.add(singleplayer);
		panel.add(multiplayer);
		panel.add(startGame);
		

		
		frame.setVisible(true);
		
	}
	
	public void setup(){
		System.out.println("running setup");
		//Opening screen?
		//create and place squares
		//create and place pieces
		//start game
		Board board = new Board();
	}
	
	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.intro();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startGame){
			//this isn't running the setup yet, not sure why
			setup();
		}
	}
}
