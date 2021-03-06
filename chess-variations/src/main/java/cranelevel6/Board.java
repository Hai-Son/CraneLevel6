package cranelevel6;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Board {
	private final static int WIDTH = 950;
	private final static int HEIGHT = 975;
	private Location[][] tiles;
	private List<Piece> pieces = new ArrayList<>();
	Chess c;
	JFrame frame;
	DisplayGame dg;
	boolean isMultiplayer;
	private String transferString = "";

	public DisplayGame getDg() {
		return dg;
	}

	Board(Chess c, boolean isMultiplayer) {
		this.isMultiplayer = isMultiplayer;
		tiles = new Location[8][8];
		this.c = c;
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Location(i, j);
				tiles[i][j].setBoard(this);
			}
		}
		dg = new DisplayGame(this, c);
		frame = new JFrame();
		frame.add(dg);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		dg.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardSetup();
	}

	// type, B/W, L/R
	public void boardSetup() {
		// white pieces
		Castle rookWL = new Castle(this);
		rookWL.setWhite(true);
		Location l = new Location(0, 0);
		rookWL.setLocation(this.getTiles()[0][0]);
		l.setHasPiece(true);
		rookWL.refreshImage();
		this.addPiece(rookWL);

		Knight knightWL = new Knight(this);
		knightWL.setWhite(true);
		knightWL.setLocation(this.getTiles()[1][0]);
		knightWL.refreshImage();
		this.addPiece(knightWL);

		Bishop bishopWL = new Bishop(this);
		bishopWL.setWhite(true);
		bishopWL.setLocation(this.getTiles()[2][0]);
		bishopWL.refreshImage();
		this.addPiece(bishopWL);

		King kingW = new King(this);
		kingW.setWhite(true);
		kingW.setLocation(this.getTiles()[4][0]);
		kingW.refreshImage();
		this.addPiece(kingW);

		Queen queenW = new Queen(this);
		queenW.setWhite(true);
		queenW.setLocation(this.getTiles()[3][0]);
		queenW.refreshImage();
		this.addPiece(queenW);

		Bishop bishopWR = new Bishop(this);
		bishopWR.setWhite(true);
		bishopWR.setLocation(this.getTiles()[5][0]);
		bishopWR.refreshImage();
		this.addPiece(bishopWR);

		Knight knightWR = new Knight(this);
		knightWR.setWhite(true);
		knightWR.setLocation(this.getTiles()[6][0]);
		knightWR.refreshImage();
		this.addPiece(knightWR);

		Castle rookWR = new Castle(this);
		rookWR.setWhite(true);
		rookWR.setLocation(this.getTiles()[7][0]);
		rookWR.refreshImage();
		this.addPiece(rookWR);

		ArrayList<Pawn> WhitePawns = new ArrayList<Pawn>();
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(this);
			pawn.setWhite(true);
			pawn.setLocation(this.getTiles()[i][1]);
			pawn.refreshImage();
			this.addPiece(pawn);
			WhitePawns.add(pawn);
		}

		// black pieces
		Castle rookBL = new Castle(this);
		Location l2 = new Location(0, 7);
		rookBL.setWhite(false);
		rookBL.setLocation(this.getTiles()[0][7]);
		l2.setHasPiece(true);
		rookBL.refreshImage();
		this.addPiece(rookBL);

		Knight knightBL = new Knight(this);
		knightBL.setWhite(false);
		knightBL.setLocation(this.getTiles()[1][7]);
		knightBL.refreshImage();
		this.addPiece(knightBL);

		Bishop bishopBL = new Bishop(this);
		bishopBL.setWhite(false);
		bishopBL.setLocation(this.getTiles()[2][7]);
		bishopBL.refreshImage();
		this.addPiece(bishopBL);

		King kingB = new King(this);
		kingB.setWhite(false);
		kingB.setLocation(this.getTiles()[4][7]);
		kingB.refreshImage();
		this.addPiece(kingB);

		Queen queenB = new Queen(this);
		queenB.setWhite(false);
		queenB.setLocation(this.getTiles()[3][7]);
		queenB.refreshImage();
		this.addPiece(queenB);

		Bishop bishopBR = new Bishop(this);
		bishopBR.setWhite(false);
		bishopBR.setLocation(this.getTiles()[5][7]);
		bishopBR.refreshImage();
		this.addPiece(bishopBR);

		Knight knightBR = new Knight(this);
		knightBR.setWhite(false);
		knightBR.setLocation(this.getTiles()[6][7]);
		knightBR.refreshImage();
		this.addPiece(knightBR);

		Castle rookBR = new Castle(this);
		rookBR.setWhite(false);
		rookBR.setLocation(this.getTiles()[7][7]);
		rookBR.refreshImage();
		this.addPiece(rookBR);

		ArrayList<Pawn> BlackPawns = new ArrayList<Pawn>();
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(this);
			pawn.setWhite(false);
			pawn.setLocation(this.getTiles()[i][6]);
			pawn.refreshImage();
			this.addPiece(pawn);
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

	// piece movement
	public void movePieceTo(Piece piece, Location location) {
		Piece targetPiece = getPiece(location);
		if (targetPiece != null) {
			removePiece(targetPiece);
		}
		piece.setLocation(location);
		piece.setHasMoved(true);
		dg.toggleTurn();
	}

	private void removePiece(Piece targetPiece) {
		if (targetPiece == null) {
			return;
		}
		targetPiece.setLocation(null);
		targetPiece.setCaptured(true);
		boolean whitePoints = !targetPiece.isWhite();
		String pieceType = targetPiece.getType();
		if (pieceType.equals("pawn")) {
			dg.updateScore(whitePoints, 1);
		} else if (pieceType.equals("bishop")) {
			dg.updateScore(whitePoints, 3);
		} else if (pieceType.equals("knight")) {
			dg.updateScore(whitePoints, 3);
		} else if (pieceType.equals("castle")) {
			dg.updateScore(whitePoints, 5);
		} else if (pieceType.equals("queen")) {
			dg.updateScore(whitePoints, 9);
		} else {
			if (whitePoints) {
				JOptionPane.showMessageDialog(null, "White Wins!");
				this.backPressed();
				c.backPressed();
			} else {
				JOptionPane.showMessageDialog(null, "Black Wins!");
				this.backPressed();
				c.backPressed();
			}
		}
	}

	public void addPiece(Piece p) {
		if (p == null) {
			return;
		}
		if (pieces == null) {
			pieces = new ArrayList<>();
		}
		if (!pieces.contains(p)) {
			pieces.add(p);
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	// give location, get piece
	public Piece getPiece(Location l) {
		if (l == null) {
			return null;
		}
		List<Piece> allPieces = getPieces();
		if (allPieces == null || allPieces.isEmpty()) {
			return null;
		}
		for (Piece p : allPieces) {
			if (p.getLocation() == l) {
				return p;

			}
		}
		return null;
	}

	public void backPressed() {
		frame.setVisible(false);
	}

	public String getTransfer() {
		return transferString;
	}

	public void setTransfer(String ts) {
		transferString = ts;
	}
}
