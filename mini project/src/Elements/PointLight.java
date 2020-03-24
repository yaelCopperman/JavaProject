package Elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light{
	Point3D _position;
	double _kc;
	double _kl;
	double _kq;

	//*************************constructors*********************//
			
	/**
	 * initialize constructor
	 * @param color
	 * @param _position
	 * @param _kc
	 * @param _kl
	 * @param _kq
	 */
	public PointLight(Color color, Point3D _position, double _kc, double _kl, double _kq) {
		super(color);
		this._position = new Point3D(_position);
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}
	
	/**
	 * default constructor
	 */
	public PointLight()
	{
		super();
		this._position=new Point3D();
		this._kc = 0.1;
		this._kl = 0.1;
		this._kq = 0.1;
	}
	
	//*************************getters and setters*********************//
		

	/**
	 * get the position of the light
	 * @return _position
	 */
	public Point3D get_position() {
		return new Point3D(_position);
	}

	/**
	 * set the position of the light
	 * @param _position
	 */
	public void set_position(Point3D _position) {
		this._position = new Point3D(_position);
	}

	/**
	 * get _kc
	 * @return _kc
	 */
	public double get_kc() {
		return _kc;
	}

	/**
	 * set _kc
	 * @param _kc
	 */
	public void set_kc(double _kc) {
		this._kc = _kc;
	}

	/**
	 * get _kl
	 * @return _kl
	 */
	public double get_kl() {
		return _kl;
	}

	/**
	 * set _kl
	 * @param _kl
	 */
	public void set_kl(double _kl) {
		this._kl = _kl;
	}

	/**
	 * get _kq
	 * @return _kq
	 */
	public double get_kq() {
		return _kq;
	}

	/**
	 * set _kq
	 * @param _kq
	 */
	public void set_kq(double _kq) {
		this._kq = _kq;
	}
	
	//*************************administration*********************//
		

	/**
	 * return true if 2 PointLight objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	/**
	 * return this object as a string
	 */
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}
	
	//*************************operations*********************//


	
	/**
	 * get the Intensity of the light
	 */
	public Color getIntensity(Point3D point){
		double d = _position.distance(point);
		Color I0 = this._color;
	    double mechane = _kc +(_kl*d)+(_kq*d*d);
	    double ILred = I0.getRed()/Math.max(mechane,1);
	    if(ILred>255) ILred= 255;
		if(ILred<0) ILred = 0;
	    double ILgreen = I0.getGreen()/Math.max(mechane, 1);
	    if(ILgreen>255) ILgreen= 255;
	    if(ILgreen<0) ILgreen = 0;
	    double ILblue = I0.getBlue()/Math.max(mechane, 1);
	    if(ILblue>255) ILblue= 255;
	    if(ILblue<0) ILblue = 0;
	    Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
	    return IL;

	}
	
	/**
	 * get the normalized vector from the light to point
	 */
	public Vector getL(Point3D point){
		Vector temp=new Vector(_position,point);
		temp.normalize();
		return temp;
	}
	
	
}
