package primitives;


import static java.lang.StrictMath.sqrt;

public class Point2D {
	protected Coordinate x;
	protected Coordinate y;
	
	//***********getters and setters*********//
/**
 * gets x
 * @return
 */
	public Coordinate getX() {
		return x;
	}

	/**
	 * sets x
	 * @param x
	 */
	public void setX(Coordinate x) {
		this.x = x;
	}

	/**
	 * gets y
	 * @return
	 */
	public Coordinate getY() {
		return y;
	}

	/**
	 * sets y
	 * @param y
	 */
	public void setY(Coordinate y) {
		this.y = y;
	}
	
	
	//***********constructors**********//
	
	/**
	 * set point to (0.0)
	 */
	public Point2D()
	{
		setX(Coordinate.ZERO);
		setY(Coordinate.ZERO);
	}
	


	/**
	 * set point to (x.y)
	 * @param x
	 * @param y
	 */
	public Point2D(Coordinate x, Coordinate y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * copy constructor
	 * @param other
	 */
	public Point2D(Point2D other)
	{
		this.setX(other.getX());
		this.setY(other.getY());
	}
	
	//**************administration**********//
	
	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
/**
 * checks if equal
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	//*******************operations**************//
	
	/**
	 * returns the distance between 2 2D-Points
	 * @param p
	 * @return
	 */
	public double distance2D (Point2D p)
	{
		double x1= (p.getX().get_coordinate()-getX().get_coordinate())*
		(p.getX().get_coordinate()-getX().get_coordinate());
		double y1= (p.getY().get_coordinate()-getY().get_coordinate())*
				(p.getY().get_coordinate()-getY().get_coordinate());
		double resalt= sqrt(x1+y1);
		
		return resalt;
	}
	
}
