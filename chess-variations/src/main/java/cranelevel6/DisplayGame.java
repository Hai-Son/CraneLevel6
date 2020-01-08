package cranelevel6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DisplayGame extends JPanel implements MouseListener, ActionListener {
	Board board;
	Chess c;
	Location[][] tiles;
	int rectLength = 100;
	int rectHeight = 100;
	JButton back;

	DisplayGame(Board board, Chess c) {
		this.board = board;
		this.tiles = board.getTiles();
		this.c = c;
		this.addMouseListener(this);
		this.setLayout(null);
		Font f = new Font("Times New Roman", 30, 30);
		back = new JButton();
		back.addActionListener(this);
		back.setFont(f);
		back.setText("Back");
		back.setBackground(Color.CYAN);
		back.setOpaque(true);
		back.setBorderPainted(false);
		back.setSize(105, 45);
		back.setLocation(0, 0);
		this.add(back);
		repaint();
	}

	Color light = new Color(254, 206, 157);
	Color dark = new Color(150, 75, 0);
	Color possible = new Color(0, 215, 0);
	Color selected = new Color(30, 145, 255);
	boolean showMoves = false;
	Location selectedLocation;
	List<Location> pMoves;

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		Location[][] tiles = board.getTiles();
		g2.setColor(dark);
		g2.fillRect(0, 0, 950, 975);
		g2.setColor(light);
		g2.fillRect(75, 75, 800, 800);
		g2.setColor(dark);
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				if ((tiles[i][j].getxTile() + tiles[i][j].getyTile()) % 2 == 0) {
					g2.fillRect(tiles[i][j].getxCord(), tiles[i][j].getyCord(), rectLength, rectHeight);
				}
			}
		}
		g2.setStroke(new BasicStroke(10));
		g2.setColor(light);
		g2.drawRect(70, 70, 810, 810);
		String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8" };
		String[] chars = { "A", "B", "C", "D", "E", "F", "G", "H" };
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		for (int i = 0; i < nums.length; i++) {
			g2.drawString(nums[i], 35, tiles[0][i].getyCord() + 55);
		}
		for (int i = 0; i < nums.length; i++) {
			g2.drawString(nums[i], 905, tiles[0][i].getyCord() + 55);
		}
		for (int i = 0; i < chars.length; i++) {
			g2.drawString(chars[i], tiles[i][0].getxCord() + 40, 45);
		}
		for (int i = 0; i < chars.length; i++) {
			g2.drawString(chars[i], tiles[i][0].getxCord() + 40, 915);
		}
		List<Piece> pieces = board.getPieces();
		if (pieces != null) {
			for (Piece p : pieces) {
				p.draw(g2);
			}
		}
		System.out.println("repainted");
		if (showMoves) {
			g2.setStroke(new BasicStroke(4));
			g2.setColor(possible);
			if (pMoves != null) {
				for (Location l : pMoves) {
					g2.drawRect(l.getxCord() + 2, l.getyCord() + 2, rectLength - 4, rectHeight - 4);
				}
			} else {
				System.out.println("no possible moves");
			}
			g2.setColor(selected);
			g2.drawRect(selectedLocation.getxCord() + 2, selectedLocation.getyCord() + 2, rectLength - 4,
					rectHeight - 4);
			// showMoves = false;
		}
	}

	private Location getLocation(MouseEvent e) {
		Point p = e.getLocationOnScreen();
		return getLocation(p.getX(), p.getY());
	}

	// takes X and Y values, returns location
	private Location getLocation(double x, double y) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				Location l = tiles[i][j];
				if (l.getxCord() < x && l.getxCord() + rectLength > x) {
					if (l.getyCord() + 50 < y && l.getyCord() + 50 + rectHeight > y) {
						return l;
					}
				}

			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mouseClicked(MouseEvent e) {
		Location thisSquare = getLocation(e);

		if (showMoves) {
			for (Location l : pMoves) {
				if (thisSquare.equals(l)) {
					System.out.println("second click");
					for (Piece p : board.getPieces()) {
						if (p.getLocation() == selectedLocation) {
							board.movePieceTo(p, thisSquare);
						}
					}
					showMoves = false;
				}
			}

			repaint();
		} else if (!showMoves) {

			if (thisSquare == null) {
				System.out.println("out of bounds");
				return;
			} else {
				System.out.println(thisSquare.getxTile() + "," + thisSquare.getyTile());
			}

			for (Piece p : thisSquare.getBoard().getPieces()) {
				if (thisSquare == p.getLocation()) {
					pMoves = p.getPossibleMoves();
					// pMoves = p.getLegalMoves();
					selectedLocation = thisSquare;
					showMoves = true;
					break;
				}
			}
			repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(back)) {
			c.backPressed();
			board.backPressed();
		}
	}
}
