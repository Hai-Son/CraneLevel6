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
	Font regularFont = new Font("Times New Roman", Font.PLAIN, 18);
	JLabel pieces = new JLabel();
	JLabel titleLine = new JLabel();
	int xFrame = 400;
	int yFrame = 400;

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
		panel.setBackground(Color.green);
	}

	public void title() {
		titleLine.setForeground(Color.magenta);
		titleLine.setFont(fancyFont);
		titleLine.setText("How to play Chess:");
		titleLine.setBounds(50, 10, 300, 40);
		titleLine.setVisible(true);
	}

	public void pieceFunctions() {
		pieces.setText("hallo");
		pieces.setLocation(200, 200);
		pieces.setVisible(true);
	}

}
