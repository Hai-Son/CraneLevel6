package cranelevel6;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Board {
	private final static int WIDTH = 950;
	private final static int HEIGHT = 975;
	private Location[][] tiles;
	JFrame frame;

	Board() {
		tiles = new Location[8][8];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Location(i, j);
				tiles[i][j].setBoard(this);
			}
		}
		DisplayGame dg = new DisplayGame(this);
		frame = new JFrame();
		frame.add(dg);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		dg.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// type, B/W, L/R
	public void boardSetup() {
		// creation of pieces
		Castle rookWL = new Castle(this);
		rookWL.setWhite(true);

		Knight knightWL = new Knight(this);

		Bishop bishopWL = new Bishop(this);

		King kingW = new King(this);

		Queen queenW = new Queen(this);

		Castle rookWR = new Castle(this);

		Knight knightWR = new Knight(this);

		Bishop bishopWR = new Bishop(this);

		ArrayList<Pawn> WhitePawns = new ArrayList<Pawn>();
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(this);
			WhitePawns.add(pawn);
		}

		Castle rookBL = new Castle(this);
		Knight knightBL = new Knight(this);
		Bishop bishopBL = new Bishop(this);
		King kingB = new King(this);
		Queen queenB = new Queen(this);
		Castle rookBR = new Castle(this);
		Knight knightBR = new Knight(this);
		Bishop bishopBR = new Bishop(this);

		ArrayList<Pawn> BlackPawns = new ArrayList<Pawn>();
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(this);
			BlackPawns.add(pawn);
		}

		// starting piece locations

	}

	public Location[][] getTiles() {
		return tiles;
	}

	public Location getLocation(Location location, Directions d) {
		// is it a real location
		if (location == null || d == null) {
			return null;
		}
		// new location
		int x = location.getxTile() + d.getX();
		int y = location.getyTile() + d.getY();

		// is it out of bounds
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return null;
		} else {
			return tiles[x][y];
		}
	}

}
