package primitives;


public class Coordinate {
	protected double _coordinate;
	//**********constructors***********//
	/**
	 * defined zero=(0.0)
	 */
	public static Coordinate ZERO = new Coordinate(0.0);
	
	/**
	 * initial constructor
	 * @param _coordinate
	 */
	public Coordinate(double _coordinate) {
		this._coordinate = _coordinate;
	}
	/**
	 * default constructor
	 */
	public Coordinate() {
		this._coordinate = 0;
	}
	/**
	 * copy constructor
	 * @param myCoordinate
	 */
	public Coordinate(Coordinate myCoordinate) {
		this._coordinate = myCoordinate._coordinate;
	}
	
	//**********getters and setters**********//
	/**
	 * get coordinate
	 * @return
	 */
	public double get_coordinate() {
		return _coordinate;
	}
	/**
	 * set coordinate
	 * @param _coordinate
	 */
	public void set_coordinate(double _coordinate) {
		this._coordinate = _coordinate;
	}
	
	//************administration*****************// 
	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "Coordinate [_coordinate=" + _coordinate + "]";
	}
	/**
	 * equal
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
			return false;
		return true;
	}
	//****************operation***************//
	/**
	 * add 2 coordinates
	 * @param myCoordinate
	 * @return
	 */
	public double add(Coordinate myCoordinate) {
		return this._coordinate+myCoordinate.get_coordinate();
		
	}
	/**
	 * subtract 2 coordinates
	 * @param myCoordinate
	 * @return
	 */
	public double subtract(Coordinate myCoordinate) {
		return this._coordinate-myCoordinate.get_coordinate();
	}
	/**
	 * multiply 2 coordinates
	 * @param myCoordinate
	 * @return
	 */
	public double mul(Coordinate myCoordinate){
		return this._coordinate*myCoordinate.get_coordinate();
	}

	public Coordinate scale(double num) {
		return new Coordinate(num*this._coordinate);
	}
}
