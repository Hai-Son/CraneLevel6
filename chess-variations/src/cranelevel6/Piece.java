package cranelevel6;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Piece {
	Board board;
	boolean captured;
	boolean white;
	// add getter and setter for hasMoved
	boolean hasMoved;
	Location location;
	String type;
	BufferedImage image;

	Piece(Board board) {
		this.board = board;

		refreshImage();
	}

	public void refreshImage() {
		try {
			File image2 = new File(getImageFile());
			image = ImageIO.read(image2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract String getImageFile();

	abstract List<Location> getPossibleMoves();

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

	public BufferedImage getImage() {
		return image;
	}

	protected abstract void draw(Graphics2D g2);

}
