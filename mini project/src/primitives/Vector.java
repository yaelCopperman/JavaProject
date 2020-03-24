

package primitives;
import static java.lang.StrictMath.sqrt;


public class Vector {
	protected Point3D head;
	
	//**********************constructors****************//
	
	
/**
 * default constructor
 */
	public Vector()
	{
		head= new Point3D();
	}
	
	/**
	 * sets vector's-head by double values
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector( double x, double y, double z)
	{
		if (x==0&&y==0&&z==0)
			throw new IllegalArgumentException("vector (0,0,0");
		head= new Point3D(x,y,z);
	}

	/**
	 * copy constructor
	 * @param v
	 */
	public Vector(Vector v)
	{
		Vector temp=new Vector(v.head.x.get_coordinate(),v.head.y.get_coordinate(),v.head.z.get_coordinate());
		head=v.head;
	}

	/**
	 * builds a vector by 2 3D-points
	 * @param a
	 * @param b
	 */
	public Vector(Point3D a, Point3D b)
	{
		setHead(new Point3D (b.getX().subtract(a.getX()),b.getY().subtract(a.getY()),b.getZ().subtract(a.getZ())));
	}

	/**
	 * sets the vector's head
	 * @param head
	 */
	public Vector(Point3D head)
	{
		if(head.x.get_coordinate()==0&&head.y.get_coordinate()==0&&head.z.get_coordinate()==0)
			throw new IllegalArgumentException("vector (0,0,0");

		this.head = head;
	}
	
	
	
	//***********************getters and setters***********//
	
	
	/**
	 * 	gets head
	 * @return
	 */
	public Point3D getHead() {
		return head;
	}
	
	/**
	 * sets head
	 * @param head
	 */
	public void setHead(Point3D head) {
		this.head = head;
	}

	
		
		
	//***************************administration*************//
	
	
	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "Vector [head=" + head.toString() + "]";
	}
	
/**
 	* equals
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
		
		
		
	//******************************Operations****************//

	/**
	 * returns the result of adding 2 vectors
	 * @param v
	 * @return
	 */
	public Vector add(Vector v)
	{
		return new Vector(head.x.add(v.head.x),head.y.add(v.head.y),head.z.add(v.head.z));
	}
	
	/**
	 * returns the result of this-v
	 * @param v
	 * @return
	 */
	public Vector subtract(Vector v)
	{
		return new Vector(head.x.subtract(v.head.x),head.y.subtract(v.head.y),head.z.subtract(v.head.z));
	}
	
	/**
	 * returns result of v.u
	 * @param v
	 * @return
	 */
	public double dotProduct(Vector v)
	{
		return this.getHead().getX().get_coordinate()*v.getHead().getX().get_coordinate()+
				this.getHead().getY().get_coordinate()*v.getHead().getY().get_coordinate()+
				this.getHead().getZ().get_coordinate()*v.getHead().getZ().get_coordinate();
	}

	/**
	 * returns vector result of cross product
	 * @param v
	 * @return
	 */
	public Vector crossProduct(Vector v)
	{
		double x1=this.head.x.get_coordinate();
		double y1=this.head.y.get_coordinate();
		double z1=this.head.z.get_coordinate();
		double x2=v.head.x.get_coordinate();
		double y2=v.head.y.get_coordinate();
		double z2=v.head.z.get_coordinate();
	return new Vector((y1*z2-z1*y2),(z1*x2-x1*z2),(x1*y2-y1*x2));
	}
	
	/**
	 * returns the vector multiplied by the number given
	 * @param num
	 * @return
	 */
	public Vector scale(double num)
	{
		this.head.setX(head.getX().scale(num));
		this.head.setY(head.getY().scale(num));
		this.head.setZ(head.getZ().scale(num));

		return this;
	}
	
	/**
	 * returns the length of the vector
	 * @param v
	 * @return
	 */
	public double length()
	{
		double result=sqrt((head.getX().get_coordinate())*(head.getX().get_coordinate())
				+(head.getY().get_coordinate())*(head.getY().get_coordinate())
				+(head.getZ().get_coordinate())*(head.getZ().get_coordinate()));
		
		return result;
	}
	/*
	 * length*length
	 */
	public double lengthSquared()
	{
		return this.length()*this.length();
	}
	/**
	 * sets the head to (1,1,1)
	 */
	public Vector normalize ()
	{
		if (this.length()==0)
		{
			throw new IllegalArgumentException ("length = 0 -- cannot normalize");
		}
		double length=this.length();
		this.setHead(new Point3D(this.head.getX()._coordinate/length,this.head.getY()._coordinate/length,this.head.getZ()._coordinate/length) );
		return this;
	
	}

	public Vector normalized ()
	{
		Vector temp=new Vector(this);
		return temp.normalize();
	}
}
