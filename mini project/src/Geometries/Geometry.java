package Geometries;
import java.awt.Color;
import java.util.List;
import primitives.*;

public abstract class Geometry implements IGeometry{
	
	protected double _nShininess =1;
	protected Color _color;
	protected Material _material;
	
	// ***************** Constructors ********************** //
	/**
	 * default constructor 
	 */
	public Geometry() 
	{
		this._color = new Color(0);
		this._material=new Material();
	}
	
	/**
	 * Initialize constructor
	 * @param color
	 * @param material
	 */
	public Geometry(Color color,Material material) 
	{
		this._color = color;
		this._material = material;
	}
	
	
	// ***************** Getters/Setters ********************** // 
	/**
	 * get Emission
	 * @return _color
	 */
	public Color getEmission() 
	{
		return _color;
	}
	
	/**
	 * get Color
	 * @return _color
	 */
	public Color getColor() {
		return _color;
	}
	
	/**
	 * set Color
	 * @param _color
	 */
	public void setColor(Color _color) {
		this._color = _color;
	}
	
	/**
	 * get Material
	 * @return _material
	 */
	public Material getMaterial() {
		return new Material(_material);
	}
	
	/**
	 * set Material
	 * @param _material
	 */
	public void setMaterial(Material _material) {
		this._material = new Material(_material);
	}
	
	// ***************** Operations ******************** //
	
	
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() {
		return "Geometry [_color=" + _color + ", _material=" + _material + "]";
	}

	
	
	/**
	 * @param sec: the point to calculate the vector on
	 * @return the normal of the geometry in the point sec
	 */
	public abstract Vector getNormal(Point3D sec);
	
	/**
	 * @param myRay
	 * @return the intersections between the geometry and the given Ray
	 * this is the abstract function
	 */
	public abstract List<Point3D> findIntersections (Ray myRay); 

}
