package primitives;

public class Point3D extends Point2D
{
	protected Coordinate z;
//**********************constructors**************//
	
	/**
	 * sets Point by coordinates values given(x,y,z)
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinate x,Coordinate y,Coordinate z) 
	{
		super(x,y);
		this.setZ(z);
	}
	/**
	 * sets point by double values given
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x,double y, double z) 
	{
		setX(new Coordinate(x));
		setY(new Coordinate(y));
		setZ(new Coordinate(z));

	}
/**
 	* constructor
 * @param z
 */
	public Point3D(Coordinate z) 
	{
		this.z = new Coordinate(z);
	}
	/**
	 * copy constructor
	 * @param p
	 */
	public Point3D(Point3D p)
	{
		this.setX(p.getX());
		this.setY(p.getY());
		this.setZ(p.getZ());
	}
	/**
	 * default constructor 
	 */
	public Point3D()
	{
		this.setX(new Coordinate(Coordinate.ZERO));
		this.setY(new Coordinate(Coordinate.ZERO));
		this.setZ(new Coordinate(Coordinate.ZERO));
	}

	//******************getters and setters*******************//
	
	/**
	 * gets z
	 * @return
	 */
	public Coordinate getZ() {
		return z;
	}
/**
 	* sets z
 * @param z
 */
	public void setZ(Coordinate z) {
		this.z = z;
	}


//********************administration***************//

/**
 	* toString
 */
	@Override
	public String toString()
{
	return "Point3D {"
			+ "x=" + super.getX() +
			", y=" +super.getY() + 
			", z=" + getZ() + "}";
}
/**
 	* equals
 */
@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Point3D other = (Point3D) obj;
	if (z == null) {
		if (other.z != null)
			return false;
	} else if (!z.equals(other.z))
		return false;
	return true;
}

	
//*********************operations******************//

	/**
 * adds vector's-head-point to point
 * @param vector
 */
	public Point3D addVector(Vector vector) 
{
	Point3D temp= vector.getHead();
	Point3D result=new Point3D(
			this.getX().add(temp.getX()),
			this.getY().add(temp.getY()),
			this.getZ().add(temp.getZ()));
	return result;
}

	/**
	 * adds point to point
	 * @param temp
	 * @return result point
	 */

	public Point3D add(Point3D temp)
	  {
	    Point3D help= new Point3D();
	    help.setX(new Coordinate(x.get_coordinate()+temp.getX().get_coordinate()));
	    help.setY(new Coordinate(y.get_coordinate()+temp.getY().get_coordinate()));
	    help.setZ(new Coordinate(z.get_coordinate()+temp.getZ().get_coordinate()));
	    return help;
	    
	  }
	
	/**
	 * adds vector to vector
	 * @param sec
	 */
	public Vector add(Vector sec) 
	{
		double x = this.x.add(sec.getHead().getX());
		double y = this.y.add(sec.getHead().getY());
		double z = this.z.add(sec.getHead().getZ());
		return new Vector(x,y,z);

	}
	
	
	/**
	 * Subtracts vector from this
	 * @param sec
	 */
	public Vector subtract(Vector sec) 
	{
		double x = this.x.subtract(sec.getHead().getX());
		double y = this.y.subtract(sec.getHead().getY());
		double z = this.z.subtract(sec.getHead().getZ());
		return new Vector(x,y,z);
	}
	
	/**
	 * subtract point point from this point
	 * @param temp
	 * @return
	 */
	public Point3D subtract(Point3D temp)
	  {
	    Point3D help= new Point3D();
	    help.setX(new Coordinate(x.get_coordinate()-temp.getX().get_coordinate()));
	    help.setY(new Coordinate(y.get_coordinate()-temp.getY().get_coordinate()));
	    help.setZ(new Coordinate(z.get_coordinate()-temp.getZ().get_coordinate()));
	    return help;
	    
	  }

	public Vector subtractFromPoint(Point3D sec)
	  {
		double x1 = this.x.get_coordinate()-sec.x.get_coordinate();
		double y1 = this.y.get_coordinate()-sec.y.get_coordinate();
		double z1 = this.z.get_coordinate()-sec.z.get_coordinate();
		return new Vector(x1,y1,z1);
	    
	  }

	

	/**
	 * returns the distance between 2 3D-points
	 * @param p
	 * @return
	 */
	public double distance(Point3D p)
	{
		Vector v= new Vector(this,p);
		return v.length();
	}
	
	

}



