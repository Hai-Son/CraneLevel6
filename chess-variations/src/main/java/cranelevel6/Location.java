package cranelevel6;

public class Location {
	private int xTile;
	private int yTile;
	private int xCord;
	private int yCord;

	Location(int x, int y) {
		xTile = x;
		yTile = y;
		xCord = (100 * x) + 50;
		yCord = (100 * x) + 50;
	}

	public int getxTile() {
		return xTile;
	}

	public int getyTile() {
		return yTile;
	}

	public int getxCord() {
		return xCord;
	}

	public int getyCord() {
		return yCord;
	}
	
	public Location getLocation(Directions d) {
		Board board = getBoard();
		return board.getLocation(this, d);
	}

	Board board;
	
	public Board getBoard() {
		return board;
	}

}
