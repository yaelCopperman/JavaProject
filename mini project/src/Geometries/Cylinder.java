package Geometries;
import java.awt.Color;
import java.util.List;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends RadialGeometry {
	protected Point3D _axisPoint;
	protected Vector _axisDirection;
	
	// ***************** Constructors ********************** //
	/**
	 * default constructor
	 */
	public Cylinder() 
	{
		super();
		this._axisPoint = new Point3D();
		this._axisDirection = new Vector();
	}
	
	/**
	 * constructor
	 * @param color
	 * @param radius
	 * @param axisPoint
	 * @param axisDirection
	 */
	public Cylinder(Color color,Material material,double radius,Point3D axisPoint, Vector axisDirection) 
	{
		super(color,material,radius);
		this._axisPoint = new Point3D(axisPoint);
		this._axisDirection = new Vector(axisDirection);
	}
	
	/**
	 * copy constructor
	 * @param sec
	 */
	public Cylinder(Cylinder sec) 
	{
		super(sec.getColor(),sec.getMaterial(), sec.getRadius());
		this._axisPoint = new Point3D(sec.getAxisPoint());
		this._axisDirection = new Vector(sec.getAxisDirection());
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * get AxisPoint
	 * @return _axisPoint
	 */
	public Point3D getAxisPoint() 
	{
		return new Point3D(_axisPoint);
	}
	
	/**
	 * set AxisPoint
	 * @param axisPoint
	 */
	public void setAxisPoint(Point3D axisPoint) 
	{
		this._axisPoint = new Point3D(axisPoint);
	}
	
	/**
	 * get AxisDirection
	 * @return _axisDirection
	 */
	public Vector getAxisDirection() 
	{
		return new Vector(_axisDirection);
	}
	
	/**
	 * set AxisDirection
	 * @param axisDirection
	 */
	public void setAxisDirection(Vector axisDirection) 
	{
		this._axisDirection = new Vector(axisDirection);
	}
	
	// ***************** administration ******************** //
	/**
	 * @return true if the @param obj equals to this.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() 
	{
		return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
	}
	
	/**
	 * get Normal-calculates the normal of vector
	 * @param sec
	 */
	public Vector getNormal(Point3D sec)
	{
		return this._axisDirection;
	}
	
	/**
	 * find the Intersection points between an object and ray
	 * here the function do nothing and exist because the is an abstract function in Geometry
	 * @param myRay
	 * @return null
	 */
	public List<Point3D> findIntersections (Ray myRay)
	{
		return null; 
	}

}
