package primitives;

public class Material {
	private double _kd;
	private double _ks;
	private double _kr;
	private double _kt;

	private double _nShininess;
	/**
	 * Initialize constructor
	 * @param _kd
	 * @param _ks
	 * @param _kr
	 * @param _kt
	 * @param _nShininess
	 */
	public Material(double _kd, double _ks, double _kr, double _kt, double _nShininess) {
		super();
		if(_kd<0) this._kd = 0;
		else if(_kd>1) this._kd = 1;
		else     this._kd = _kd;

		if(_ks<0) this._ks = 0;
		else if(_ks>1) this._ks = 1;
		else     this._ks = _ks;

		if(_kr<0) this._kr = 0;
		else if(_kr>1) this._kr = 1;
		else     this._kr = _kr;

		if(_kt<0) this._kt = 0;
		else if(_kt>1) this._kt = 1;
		else     this._kt = _kt;
		this._nShininess = _nShininess;
	}
	
	/**
	 * default constructor
	 */
	public Material() {
		super();
		this._kd = 1;
		this._ks = 1;
		this._kr = 0;
		this._kt = 0;
		this._nShininess = 19;
	}
	
	/**
	 * copy constructor
	 * @param material
	 */
	public Material(Material material) {
		super();
		this._kd = material._kd;
		this._ks = material._ks;
		this._kr = material._kr;
		this._kt = material._kt;
		this._nShininess = material._nShininess;
	}
	
	/**
	 * get kd
	 * @return_kd
	 */
	public double get_kd() {
		return _kd;
	}
	
	/**
	 * set kd
	 * @param _kd
	 */
	public void set_kd(double _kd) {
		this._kd = _kd;
	}
	
	/**
	 * get ks
	 * @return _ks
	 */
	public double get_ks() {
		return _ks;
	}
	
	/**
	 * set ks
	 * @param _ks
	 */
	public void set_ks(double _ks) {
		this._ks = _ks;
	}
	
	/**
	 * get kr
	 * @return _kr
	 */
	public double get_kr() {
		return _kr;
	}
	
	/**
	 * set_kr
	 * @param _kr
	 */
	public void set_kr(double _kr) {
		this._kr = _kr;
	}
	
	/**
	 * get kt
	 * @return _kt
	 */
	public double get_kt() {
		return _kt;
	}
	
	/**
	 * set kt
	 * @param _kt
	 */
	public void set_kt(double _kt) {
		this._kt = _kt;
	}
	
	/**
	 * get nShininess
	 * @return _nShininess
	 */
	public double get_nShininess() {
		return _nShininess;
	}
	
	/**
	 * set nShininess
	 * @param _nShininess
	 */
	public void set_nShininess(double _nShininess) {
		this._nShininess = _nShininess;
	}
	
	/**
	 * @return true if the @param obj equals to this.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
			return false;
		if (Double.doubleToLongBits(_nShininess) != Double.doubleToLongBits(other._nShininess))
			return false;
		return true;
	}
	
	/**
	 * Print the details of the object
	 */
	@Override
	public String toString() {
		return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _kr=" + _kr + ", _kt=" + _kt + ", _nShininess="
				+ _nShininess + "]";
	}

}
