package primitives;

public class Color {
	private java.awt.Color color;
	int r, g, b;
	/**
	 * constructor
	 * @param color of java.awt.Color
	 */
	public Color(java.awt.Color color) {
		super();
		setColor(color);
	}
	/**
	 * Initialize constructor
	 * @param r red
	 * @param g green
	 * @param b blue
	 */
	public Color(int r, int g, int b) {
		super();
		setR(r);
		setG(g);
		setB(b);
		this.color = new java.awt.Color(this.r,this.g,this.b);
	}

	/**
	 * get red
	 * @return the red color
	 */
	public int getR() {
		return r;
	}

	/**
	 * set red
	 * @param r 
	 */
	public void setR(int r) {
		this.r = Math.max(0,Math.min(255, r));
	}

	/**
	 * get the green color
	 * @return the green
	 */
	public int getG() {
		return g;
	}
	/**
	 * set green
	 * @param g the green
	 */
	public void setG(int g) {
		this.g = Math.max(0,Math.min(255, g));
	}

	/**
	 * get blue
	 * @return the blue color
	 */
	public int getB() {
		return b;
	}

	/**
	 * set blue
	 * @param b the blue
	 */
	public void setB(int b) {
		this.b = Math.max(0,Math.min(255, b));
	}

	/**
	 * 
	 * @param color of java.awt.Color
	 */
	public void setColor(java.awt.Color color) {
		this.color = color;
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
	}
 
	/**
	 * 
	 * @return the color
	 */
	public java.awt.Color getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param colors colors to add
	 * @return the color we get after adding the colors
	 */
	public Color add(Color...colors) {
		int blue = color.getBlue();
		int red = color.getRed();
		int green = color.getGreen();
		for (Color c : colors){
			blue += c.getB();
			red += c.getR();
			green += c.getG();
		}
		return new Color(red, green, blue);
	}
	
	/**
	 * 
	 * @param n the multiplier
	 * @return the result
	 */
	public Color scale(double n) {
		return new Color((int)Math.round(n*r), (int)Math.round(n*g), (int)Math.round(n*b));
	}
	
	/**
	 * 
	 * @param n the reducer
	 * @return the result
	 */
	public Color reduce(double n) {
		return new Color((int)(r-n), (int)(g-n), (int)(b-n));
	}
}


