package SimpleUnitTests;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	public void testGet() 
	{
	Coordinate c=new Coordinate(3);
	Coordinate d=new Coordinate(5);
	assertEquals(3,c.get_coordinate(),0.0);
	assertEquals(5,d.get_coordinate(),0.0);
	}
	@Test
	public void testSet() 
	{
	Coordinate c=new Coordinate();
	Coordinate d=new Coordinate();
	c.set_coordinate(3);
	d.set_coordinate(5);
    assertEquals(3,c.get_coordinate(),0.0);
	assertEquals(5,d.get_coordinate(),0.0);
	}
	
	@Test
	public void testEquals() 
	{
		Coordinate c=new Coordinate(3);
		Coordinate d=new Coordinate(3);
        assertTrue( c.equals(d));
	}

	@Test
	public void testAdd() 
	{
		Coordinate coor=new Coordinate(3);
		Coordinate coor2=new Coordinate(2);
		double check=coor.add(coor2);
		assertEquals(5,check,0.0);
	}
	
	@Test
	public void testSubstract() 
	{
		Coordinate coor=new Coordinate(3);
		Coordinate coor2=new Coordinate(2);
		double check=coor.subtract(coor2);
		assertEquals(1,check,0.0);
	}

}
