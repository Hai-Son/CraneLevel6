package cranelevel6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.sun.glass.ui.Pixels;

public class GridSetup {

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;

	// 1. Create a 2D array of pixels. Do not initialize it yet.
	Pixels[][] pixel;

	private Color color;

	public GridSetup() {
		this.windowWidth = 800;
		this.windowHeight = 800;
		this.rows = 8;
		this.cols = 8;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		color = Color.BLACK;

		new Dimension(windowWidth, windowHeight);

		// 2. Initialize the pixel array using the rows and cols variables.
		pixel = new Pixels[rows][cols];

		// 3. Iterate through the array and initialize each element to a new pixel.
		for (int i = 0; i < pixel.length; i++) {
			for (int j = 0; j < pixel[i].length; j++) {
				pixel[i][j] = (i*100, j*100);
			}
		}

	}

	public void setColor(Color c) {
		color = c;
	}

	
	public void paintComponent(Graphics g) {
		// 4. Iterate through the array.√
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				g.setColor(pixel[i][j].color);
				g.fillRect(pixel[i][j].x, pixel[i][j].y, pixelWidth, pixelHeight);
				g.setColor(Color.BLACK);
				g.drawRect(pixel[i][j].x, pixel[i][j].y, pixelWidth, pixelHeight);
			}
		}

	}
	
}
