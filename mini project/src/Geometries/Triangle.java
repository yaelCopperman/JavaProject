package Geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.Material;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Triangle extends Geometry implements FlatGeometry{
	protected Point3D _p1;
	protected Point3D _p2;
	protected Point3D _p3;


	//*************************constructors*********************//
	/**
	 * sets triangle by 3 points and color 
	 * @param color
	 * @param point1
	 * @param point2
	 * @param point3
	 */
	public Triangle(Color color, Point3D p1, Point3D p2, Point3D p3)
	 {
		super(color,new Material());
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	 }
	 
	/**
	 * sets the triangle by 3 points 
	 * @param point1
	 * @param point2
	 * @param point3
	 */
	public Triangle (Point3D point1, Point3D point2, Point3D point3)
	 {
		 this.setP1(point1);
		 this.setP2(point2);
		 this.setP3(point3);
	 }
	
	public Triangle(Color color,Material material, Point3D p1, Point3D p2, Point3D p3) 
	{
		super(color,material);
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}
	
	//*************************getters and setters*********************//
	
	/**
	 * get p1
	 * @return
	 */
	public Point3D getP1() {
		return _p1;
	}
	/**
	 * set p1
	 * @param p1
	 */
	public void setP1(Point3D p1) {
		this._p1 = p1;
	}
	
	/**
	 * get p2
	 * @return
	 */
	public Point3D getP2() {
		return _p2;
	}
	
	/**
	 * set p2
	 * @param p2
	 */
	public void setP2(Point3D p2) {
		this._p2 = p2;
	}
	
	/**
	 * get p3
	 * @return
	 */
	public Point3D getP3() {
		return _p3;
	}
	
	/**
	 * set p3
	 * @param p3
	 */
	public void setP3(Point3D p3) {
		this._p3 = p3;
	}

	
	
	
	//*************************administration*********************//
	
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Triangle [p1=" + _p1 + ", p2=" + _p2 + ", p3=" + _p3 + "]";
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
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	
	
	//*************************operations*********************//

	/**
	 * gets the normal of the triangle
	 */
	public Vector getNormal(Point3D p)
	{
		Vector v1=new Vector(_p1,_p2);
		Vector v2= new Vector(_p1,_p3);
		Vector n= v1.crossProduct(v2);
		n.normalize();
		n.scale(-1);
		return n;
	}
	
	
	/**
	 * find Intersections
	 */
	@Override
	public List<Point3D> findIntersections (Ray ray)
	{
		Vector v = this.getNormal(new Point3D());
		List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        Plane p = new Plane(this.getColor(),this.getMaterial(),this._p1,v);
        
        intersectionPoints = p.findIntersections(ray);
        
        if (intersectionPoints.isEmpty())
        {
        	return intersectionPoints; 
        }
        
        Triangle tr1 = new Triangle(this.getColor(),this.getMaterial(), ray.get_PointOrigin(), _p1, _p2);
        Vector N1 = new Vector(tr1.getNormal(new Point3D()));
        Triangle tr2 = new Triangle(this.getColor(),this.getMaterial(), ray.get_PointOrigin(), _p2, _p3);
        Vector N2 = new Vector(tr2.getNormal(new Point3D()));
        Triangle tr3 = new Triangle(this.getColor(),this.getMaterial(), ray.get_PointOrigin(), _p3, _p1);
        Vector N3 = new Vector(tr3.getNormal(new Point3D()));
        
        Vector v1 = new Vector(intersectionPoints.get(0));
        Vector v2=new Vector(ray.get_PointOrigin());
        Vector sign=new Vector(v1.subtract(v2)); 
        if (((sign.dotProduct(N1) >= 0) && (sign.dotProduct(N2) >= 0) 
	               && (sign.dotProduct(N3) >= 0)) || ((sign.dotProduct(N1) < 0) && 
	                  (sign.dotProduct(N2) < 0) && (sign.dotProduct(N3) < 0))) 
        {
    	//	System.out.println("triangle intersect (condition works)="+intersectionPoints);
        	return intersectionPoints;
        }
        intersectionPoints.clear();
		//System.out.println("triangle intersect (condition doesn't works)="+intersectionPoints);

	    return intersectionPoints;    
	 }
	
	
}
