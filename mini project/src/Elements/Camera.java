package Elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera 
{
	protected Point3D _po;
	protected Vector _vUp;
	protected Vector _vRight;
	protected Vector _vToward;
	
	// ***************** Constructors ********************** // 
	/**
	 * default constructor
	 */
	public Camera() 
	{
		this._po = new Point3D();
		this._vUp = new Vector(0,1,0);
		this._vToward = new Vector(0,0,-1);
		this._vRight = new Vector(_vToward.crossProduct(_vUp));
	}
	
	/**
	 * initialize constructor
	 * @param po
	 * @param vUp
	 * @param vToward
	 * computes vRight by cross product of vUp and vTo
	 */
	public Camera(Point3D po, Vector vUp, Vector vToward) 
	{
		this._po = new Point3D(po);
		this._vUp = new Vector(vUp);
		this._vToward = new Vector(vToward);
		this._vRight = new Vector(_vToward.crossProduct(_vUp));
		
	}
	
	/**
	 * copy constructor
	 * @param sec | the camera to copy
	 */
	public Camera(Camera sec) 
	{
		this._po = new Point3D(sec.getPo());
		this._vUp = new Vector(sec.getVUp());
		this._vRight = new Vector(sec.getVRight());
		this._vToward = new Vector(sec.getVToward());
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * get Po
	 * @return _po
	 */
	public Point3D getPo() 
	{
		return new Point3D(_po);
	}
	/**
	 * set Po
	 * @param po
	 */
	public void setPo(Point3D po) 
	{
		this._po = new Point3D(po);
	}
	/**
	 * getV Up
	 * @return _vUp
	 */
	public Vector getVUp() 
	{
		return new Vector(_vUp);
	}
	/**
	 * setV Up
	 * @param vUp
	 */
	public void setVUp(Vector vUp) 
	{
		this._vUp = new Vector(vUp);
	}
	/**
	 * getV Right
	 * @return _vRight
	 */
	public Vector getVRight() 
	{
		return new Vector(_vRight);
	}
	/**
	 * set vector VRight
	 * @param vRight
	 */
	public void setVRight(Vector vRight) 
	{
		this._vRight = new Vector(vRight);
	}
	/**
	 * get vector VToward
	 */
	public Vector getVToward() 
	{
		return new Vector(_vToward);
	}
	/**
	 * set vector VToward
	 * @param vToward
	 */
	public void setVToward(Vector vToward) 
	{
		this._vToward = new Vector(vToward);
	}

	// ***************** Administration ******************** // 
	/**
	 * return true if 2 Camera objects are equal
	 */
	@Override
	/**
	 * @return true if the @param obj equals to this.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (_po == null) {
			if (other._po != null)
				return false;
		} else if (!_po.equals(other._po))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vToward == null) {
			if (other._vToward != null)
				return false;
		} else if (!_vToward.equals(other._vToward))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}

	
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() 
	{
		return "Camera: po=" + _po + ", _vUp=" + _vUp + ", _vRight=" + _vRight + ", _vToward=" + _vToward + "";
	}
	
	// ***************** Operations ******************** // 

	/**
	 * Construct a ray through a pixel.
	 * @param Nx: number of pixels x
	 * @param Ny: number of pixels y
	 * @param x: to construct a ray through this pixel 
	 * @param y
	 * @param screenDist: 
	 * @param screenWidth
	 * @param screenHeight
	 * @return ray
	 */
	public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, 
		      double screenDist, double screenWidth,double screenHeight,String location)
	{
		double rx=screenWidth/Nx;
	    double ry=screenHeight/Ny;
	    double tempX=1;
	    double tempY=1;
		if(location=="center")
		{
			tempX=(x-(Nx/2.0))*rx+(rx/2.0);
		    tempY=(y-(Ny/2.0))*ry+(ry/2.0);
		}
		if(location=="upLeft")
		{
			tempX=(x-(Nx/2.0))*rx;
		    tempY=(y-(Ny/2.0))*ry;
		}
		if(location=="upRight")
		{
			tempX=(x-(Nx/2.0))*rx+rx;
		    tempY=(y-(Ny/2.0))*ry;
		}
		if(location=="downLeft")
		{
			tempX=(x-(Nx/2.0))*rx;
		    tempY=(y-(Ny/2.0))*ry+ry;
		}
		if(location=="downRight")
		{
			tempX=(x-(Nx/2.0))*rx+rx;
		    tempY=(y-(Ny/2.0))*ry+ry;
		}
	    Vector vec = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(tempX).subtract(_vUp.scale(tempY))));
	    Point3D tempPoint = new Point3D(vec.getHead());
	    return new Ray(tempPoint, vec);
	}
	
	

}
