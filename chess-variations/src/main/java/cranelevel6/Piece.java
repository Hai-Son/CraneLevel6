package cranelevel6;

public abstract class Piece{
	Board board;
	boolean captured;
	boolean white;
	//add getter and setter for hasMoved
	boolean hasMoved;
	Location location;
	String type;
	
	Piece(Board board){
		this.board = board;
	}
	
	public Location getTargetLocation(Directions direction) {
		return board.getLocation(location, direction);
	}
	

	public boolean isCaptured() {
		return captured;
	}
	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
	public boolean isWhite() {
		return white;
	}
	public void setWhite(boolean white) {
		this.white = white;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
