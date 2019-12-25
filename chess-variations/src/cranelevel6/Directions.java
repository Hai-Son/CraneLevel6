package cranelevel6;

public enum Directions {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0), NE(1, 1), SE(1, -1), SW(-1, -1), NW(-1, 1), NNE(1, 2), NNW(-1, 2), EEN(2, 1),
	EES(2, -1), SSE(1, -2), SSW(-1, -2), WWS(-2, -1), WWN(-2, 1), NN(0, 2), SS(0, -2), WW(-2, 0), EEE(3, 0);

	int x;

	int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	Directions(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
