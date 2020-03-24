package Geometries;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;
import primitives.Material;

public abstract class RadialGeometry extends Geometry {
	protected double _radius;

	// ***************** Constructors ********************** //
	/**
	 * default constructor 
	 */
	public RadialGeometry() 
	{
		super();
		this._radius = 0;
	}
	
	/**
	 * Initialize constructor
	 * @param color
	 * @param radius
	 */
	public RadialGeometry(Color color,Material material,double radius) 
	{
		super(color,material);
		this._radius = radius;
	}

	/**
	 * copy constructor
	 * @param radius
	 */
	public RadialGeometry(RadialGeometry radius) 
	{
		super(radius.getColor(),radius.getMaterial());
		this._radius = radius._radius;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * get Radius
	 * @return _radius
	 */
	public double getRadius() 
	{
		return _radius;
	}
	
	/**
	 * set Radius
	 * @param radius
	 */
	public void setRadius(double radius) 
	{
		this._radius = radius;
	}
	
	// ***************** Operations ******************** //
	/**
	 * define abstract function that all the classes should implement
	 */
	public abstract Vector getNormal(Point3D sec);
	
	
}
