package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{
	protected Point3D _p;
	protected Vector _v;
	
	//*************************constructors*********************//
	
	
	
	/**
	 * constructor plane by a point and a vector
	 * @param color
	 * @param p
	 * @param v
	 */
	public Plane(Color color,Material material,Point3D p, Vector v) 
	{
		super(color, material);
		this._p = new Point3D(p);
		this._v = new Vector(v);
	}
	/*
	 * plane by 3 points
	 */
	public Plane(Color color,Material material,Point3D p1,Point3D p2,Point3D p3 ) 
	{
		super(color, material);
		this._p = new Point3D(p1);
		Vector temp1 = new Vector(p1,p2);
		Vector temp2= new Vector(p2,p3);
		this._v=temp1.crossProduct(temp2);
	}

	
		//*************************getters *********************//
		
	/**
	 * get P
	 * @return this._p
	 */
	public Point3D getP() 
	{
		return new Point3D(this._p);
	}
	 
	
	/**
	 * get V
	 * @return this._v
	 */
	public Vector getV() 
	{
		return new Vector(this._v);
	}


	
	
	
	//*************************administration*********************//
	
	
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() 
	{
		return "Plane [_p=(" + _p.getX()+","+_p.getY()+","+_p.getZ()+ "), _v=(" + _v.getHead().getX()+","+_v.getHead().getY()+"," + _v.getHead().getZ()+")]";
	}

	
	//*************************operations*********************//

	/**
	 * get Normal to the plain
	 */
	public Vector getNormal(Point3D sec)
	{
		return this._v;
	}
	
	public ArrayList<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();

		Vector vector = new Vector(_v);
		Point3D p = ray.get_PointOrigin();
		Point3D q = new Point3D(_p);
		vector.normalize();
		Vector dot = new Vector(q, p);
		Vector v = new Vector(ray.get_direction());
		v.normalize();
		
		double t = (-1 * vector.dotProduct(dot))/(vector.dotProduct(v));
		if(t>=0)
		{
		 v=v.scale(t);
		 p=p.addVector(v);

		 intersectionPoints.add(p);
		}

		return intersectionPoints;

		}

}
