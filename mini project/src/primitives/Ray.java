package primitives;


public class Ray {
	protected Point3D _PointOrigin;
	protected Vector _direction;
	
//**********************constructors****************//
	
	/**
	 * sets ray by point and vector
	 * @param _PointOrigin
	 * @param _direction
	 */
	public Ray(Point3D _PointOrigin, Vector _direction) {
	super();
	this._PointOrigin =new Point3D( _PointOrigin);
	this._direction =new Vector ( _direction);
	this._direction.normalize();
}

	/**
	 * default constructor
	 */
	public Ray ()
	{
		_PointOrigin=new Point3D();
		_direction=new Vector();
	}

/**
 	* copy constructor	
 * @param ray
 */
	public Ray(Ray ray)
	{
		this._direction=ray._direction;
		this._PointOrigin=ray._PointOrigin;
	}
	
	
	
//***********************getters and setters***********//
	
	
	/**
	 * gets point
	 * @return
	 */
	public Point3D get_PointOrigin() {
		return new Point3D(_PointOrigin);
	}

	/**
	 * sets point
	 * @param _PointOrigin
	 */
	public void set_PointOrigin(Point3D _PointOrigin) {
		this._PointOrigin = new Point3D(_PointOrigin);
	}

	/**
	 * gets direction vector
	 * @return
	 */
	public Vector get_direction() {
		return new Vector( _direction);
	}

	/**
	 * sets direction vector
	 * @param _direction
	 */
	public void set_direction(Vector _direction) {
		this._direction =new Vector( _direction);
	}




	
	
//***************************administration*************//
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Ray {_PointOrigin=" + _PointOrigin + ", _direction=" + _direction + "}";
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
		Ray other = (Ray) obj;
		if (_PointOrigin == null) {
			if (other._PointOrigin != null)
				return false;
		} else if (!_PointOrigin.equals(other._PointOrigin))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	
	
//******************************Operations****************//

	
	
	
	
	
	
}
