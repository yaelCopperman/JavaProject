package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	protected Point3D _center;

	// ***************** Constructors ********************** //
	/**
	 * default constructor
	 */
	public Sphere() 
	{
		super();
		this._center = new Point3D();
	}
	
	/**
	 * constructor
	 * @param color
	 * @param radius
	 * @param center
	 */
	public Sphere(Color color ,Material material,double radius,Point3D center) 
	{
		super(color,material,radius);
		this._center = new Point3D(center);
	}
	
	/**
	 * copy constructor
	 * @param sec
	 */
	public Sphere(Sphere sec) 
	{
		super(sec.getColor(),sec.getMaterial(),sec.getRadius());
		this._center = new Point3D(sec.getCenter());
	}
	
	/**
	 * constructor without material
	 * @param color
	 * @param radius
	 * @param cente
	 */
	public Sphere(Color color,double radius,Point3D center)
	{
		super(color,new Material(),radius);
		this._center = new Point3D(center);
	}
	
	// ***************** Getters/Setters ********************** //
	/**
	 * get Center
	 * @return _center
	 */
	public Point3D getCenter() 
	{
		return new Point3D(_center);
	}
	
	/**
	 * set Center
	 * @param center
	 */
	public void setCenter(Point3D center) 
	{
		this._center = new Point3D(center);
	}

	
	// ***************** Operations ******************** //
	
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
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() 
	{
		return "Sphere [_center=" + _center + "]";
	}

	/**
	 *  get Normal-calculates the normal of vector
	 *  @return vector
	 */
	public Vector getNormal(Point3D p) 
	{
		Vector vector = new Vector(_center,p);
		vector.normalize();
		return vector;
	}
	
	/**
	 * find the Intersection points between an object and ray
	 * @param myRay
	 * @return List<Point3D> mylist
	 */
	public List<Point3D> findIntersections (Ray myRay)
	{
		//System.out.println("enter find Sphere\n");
		List<Point3D> mylist = new ArrayList<Point3D>();
		Point3D p = null, p1 = null, p2 = null;
		Point3D temp=_center.subtract(myRay.get_PointOrigin());
		Vector L = new Vector(temp);
		double tm = L.dotProduct(myRay.get_direction());
		double d=Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2));
		
	//	System.out.println("d="+d+", radius="+_radius);
		
		if (d > this._radius)
			return mylist; 
		else
			if(d == this._radius)
			{
				 p = new Point3D(myRay.get_PointOrigin().add(myRay.get_direction().scale(tm).getHead()));
				 mylist.add(p);
			}
			else 
			{
			     double th = Math.sqrt(this._radius * this._radius - d*d);
			     double t1 = tm - th, t2 = tm + th;
			     if (t1 > 0)
			     {
			    	 p1 = new Point3D(myRay.get_PointOrigin().add(myRay.get_direction().scale(t1).getHead()));
					 mylist.add(p1);
			     }
			     if (t2 > 0)
			     {
			    	 p2 = new Point3D(myRay.get_PointOrigin().add(myRay.get_direction().scale(t2).getHead()));
			    	 mylist.add(p2);		 
			     }
			}
		//System.out.println("Sphere intersect=");
		//System.out.println(mylist);
	     return mylist;
	}

}
