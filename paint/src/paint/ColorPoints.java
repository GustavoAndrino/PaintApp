package paint;

import java.awt.Color;

public class ColorPoints {
	private Color color;
	private int x, y;
	
	public ColorPoints(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	

}
