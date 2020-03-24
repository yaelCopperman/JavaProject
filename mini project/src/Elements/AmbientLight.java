package Elements;

import java.awt.Color;

public class AmbientLight {
	
	protected Color _color;
	protected double _ka;
	

	//*************************constructors*********************//
		
	/**
	 * default constructor
	 */
	public AmbientLight()
	{
		this._color=new Color(255,255,255);
		this._ka=0.1;
	}
	
	/**
	 * initialize constructor
	 * @param color
	 * @param ka
	 */
	public AmbientLight(Color color,double ka)
	{
		this._color=new Color(color.getRed(),color.getGreen(),color.getBlue());
		if (ka<=1.0 && ka>=0)
			this._ka=ka;
		else
			this._ka=1.0;
			
	}
	/**
	 * constructor initialize color
	 * @param a
	 * @param b
	 * @param c
	 */
	public AmbientLight(int a,int b,int c)
	{
		this._color=new Color(a,b,c);
		this._ka=0;
	}
	
	/**
	 * copy constructor
	 * @param a
	 */
	public AmbientLight(AmbientLight a)
	{
		this._color=a.getColor();
		this._ka=a.getKa();
	}
	/**
	 * get Color
	 * @return temp
	 */
	
	//*************************getters and setters*********************//
			
	public Color getColor() 
	{  
		Color temp=new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
		return temp;
	}
     /**
      * set Color
      * @param color
      */
	public void setColor(Color color) 
	{
		this._color = color;
	}
	/**
	 * get Ka
	 * @return temp
	 */
	public double getKa() 
	{
		double temp=this._ka;
		return temp;
	}
	/**
	 * set Ka
	 * @param ka
	 */
	public void setKa(double ka) 
	{
		if (ka<1.0 && ka>0)
			this._ka = ka;
	}
	
	//*************************administration*********************//
	
	/**
	 * return "this" object as a string
	 */
	@Override
	public String toString() {
		return "AmbientLight [_color=" + _color + ", _ka=" + _ka + "]";
	}
	/**
	 * return 1 if 2 ambiantLight are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}
	
	//*************************operations*********************//

	/**
	 * return the color of the light intensity 
	 * @return
	 */
	public Color getIntensity()
	{
		return new Color((int)(_color.getRed()*_ka),(int)(_color.getGreen()*_ka),(int)(_color.getBlue()*_ka));
	}

}
