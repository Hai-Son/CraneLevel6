package cranelevel6;

public class Board {
	private final static int LENGTH = 900;
	private final static int WIDTH = 900;
	private Location[][] tiles;

	Board() {
		tiles = new Location[8][8];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; i++) {
				tiles[i][j] = new Location(i, j);
			}
		}
	}
}
