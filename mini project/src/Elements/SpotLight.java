package Elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;
public class SpotLight extends PointLight{
	Vector _direction;
    
	

	//*************************constructors*********************//
			/**
     * initialize constructor
     * @param color
     * @param _position
     * @param _kc
     * @param _kl
     * @param _kq
     * @param _direction
     */
	public SpotLight(Color color, Point3D _position, double _kc, double _kl, double _kq,Vector _direction) {
		super(color,_position,_kc,_kl,_kq);
		this._direction = new Vector(_direction);
	}
	
	/**
	 * default constructor
	 */
	public SpotLight() {
		super();
		this._direction = new Vector(0,0,1);
	}
	
	/**
	 * copy constructor
	 * @param spot_light
	 */
	public SpotLight(SpotLight spot_light) {
		super(spot_light.get_color(),spot_light.get_position(),spot_light.get_kc(),spot_light.get_kl(),spot_light.get_kq());
		this._direction = new Vector(spot_light._direction);
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
		this._direction = new Vector(_direction);
	}
	
	//*************************administration*********************//


	
	/**
	 * return true if 2 SpotLight objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
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
		return "SpotLight [_direction=" + _direction + "]";
	}
	
	//*************************operations*********************//

	/**
	 * return the intensity of the light
	 */
	public Color getIntensity(Point3D point){
		Vector L= new Vector(get_position(),point);
		  L.normalize();//L
		  Vector D = new Vector(_direction);
		  D.normalize();
		  double DL= D.dotProduct(L);
		  double d = _position.distance(point);//d
		  double mechane = _kc +(_kl*d)+(_kq*d*d);
		  Color I0 = this._color;
		  double ILred = Math.abs(I0.getRed()*DL/(Math.max(mechane, 1)));
		  if(ILred>255) ILred= 255;
		  if(ILred<0) ILred = 0;
		  double ILgreen = Math.abs(I0.getGreen()*DL/Math.max(mechane, 1));
		  if(ILgreen>255) ILgreen= 255;
		  if(ILgreen<0) ILgreen = 0;
		  double ILblue = Math.abs(I0.getBlue()*DL/Math.max(mechane, 1));
		  if(ILblue>255) ILblue= 255;
		  if(ILblue<0) ILblue = 0;  
		  Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
		  return IL;

	}
	
	/**
	 * get the normalize vector from the light to point
	 */
	public Vector getL(Point3D point){
		return super.getL(point);
	}
	
}
