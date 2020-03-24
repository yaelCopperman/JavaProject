package Elements;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light{
	Vector _direction;

	

	//*************************constructors*********************//
		
	/**
	 * initialize constructor
	 * @param _direction
	 */
	public DirectionalLight(Vector _direction) {
		super();
		this._direction = new Vector(_direction);
	}
	
	/**
	 * default constructor
	 */
	public DirectionalLight() {
		super();
		this._direction =  new Vector(0,0,1);
	}
	
	/**
	 * copy constructor
	 * @param directional_light
	 */
	public DirectionalLight(DirectionalLight directional_light) {
		super();
		this._direction = new Vector(directional_light._direction);
	}
	
	//*************************getters and setters*********************//
			
	/**
	 * get the direction of the light
	 * @return _direction
	 */
	public Vector get_direction() {
		return new Vector(_direction);
	}
	
	/**
	 * set the direction of the light
	 * @param _direction
	 */
	public void set_direction(Vector _direction) {
		this._direction =new Vector(_direction);
	}
	
	//*************************administration*********************//
	
	/**
	 * return true if 2 DirectionalLight objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	/**
	 * return this object as a string
	 */
	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
	}
	
	//*************************operations*********************//
	
	
	/**
	 * get the light Intensity
	 */
	public Color getIntensity(Point3D point){
		Color temp=new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
		return temp;
	}
	
	/**
	 * get the normalized vector of light direction
	 */
	public Vector getL(Point3D point){
		Vector v=new Vector(_direction);
		v.normalize();
		return v;
	}
}
