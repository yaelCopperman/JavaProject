package Elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;


public abstract class Light {	
	protected Color _color;

	// ***************** Constructors ********************** //

	/**
	 * initialize constructor 
	 * @param color
	 */
	public Light(Color color) {
		super();
		this._color = new Color(color.getRed(),color.getGreen(),color.getBlue());
	}
	
	/**
	 * default constructor
	 */
	public Light(){
		this._color=new Color(0,0,0);
	}

	/////abstract functions/////
	/**
	 * get the light Intensity
	 * @param point
	 * @return
	 */
	abstract public Color getIntensity(Point3D point);
	
	/**
	 * get the normalize vector of light direction
	 * @param point
	 * @return
	 */
	abstract public Vector getL(Point3D point);
	
	/**
	 * get the color of the light
	 * @return
	 */
	
	// ***************** Getters/Setters ********************** //

	public Color get_color() {
		return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
	}
	
	/**
	 * set the color of the light
	 * @param _color
	 */
	public void set_color(Color _color) {
		this._color = new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
	}
	// ***************** administration ******************** //
	
	/**
	 * return true if 2 Light Objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
	
	/**
	 * return this object as a string
	 */
	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	
	
}
