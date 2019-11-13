package cranelevel6;

public enum Directions {
	N(0, 1),E(1, 0),S(0, -1),W(-1, 0),NE(1, 1),SE(1, -1),SW(-1, -1),NW(-1, 1);
	
	int x;
	
	int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	Directions(int x, int y){
		this.x = x;
		this.y = y;
	}
}
