package Geometries;

import java.util.ArrayList;
import java.util.List;
import primitives.*;

/**
 * Polygon class represents two-dimensional polygon in 3D Cartesian coordinate
 * system
 * 
 * @author Dan
 */
public class Polygon //extends Geometry//implements IGeometry
{
    /**
     * List of polygon's vertices
     */
    protected List<Point3D> _vertices;
    /**
     * Associated plane in which the polygon lays
     */
    
    
    protected Plane _plane;

	/*List<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();

		Vector vector = new Vector(_v);
		Point3D p = ray.get_PointOrigin();
		Point3D q = new Point3D(_p);
		vector.normalize();
		Vector dot = new Vector(q, p);
		Vector v = new Vector(ray.get_direction());
		v.normalize();
		
		double t = (-1 * vector.dotProduct(dot))/(vector.dotProduct(v));
		if(t>=0)
		{
		 v=v.scale(t);
		 p=p.addVector(v);

		 intersectionPoints.add(p);
		}

		return intersectionPoints;

		}
	}/*
	

	
    /**
     * Polygon constructor based on vertices list. The list must be ordered by edge
     * path. The polygon must be convex.
     * 
     * @param vertices list of vertices according to their order by edge path
     * @throws IllegalArgumentException in any case of illegal combination of vertices:
     *                                  <ul>
     *                                  <li>Less than 3 vertices</li>
     *                                  <li>Consequent vertices are in the same point
     *                                  <li>The vertices are not in the same plane</li>
     *                                  <li>The order of vertices is not according to edge path</li>
     *                                  <li>Three consequent vertices lay in the same line (180&#176; angle between two
     *                                  consequent edges)
     *                                  <li>The polygon is concave (not convex></li>
     *                                  </ul>
     */
   /* public Polygon(Point3D... vertices) {
        if (vertices.length < 3)
            throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
        _vertices = List.of(vertices);
        // Generate the plane according to the first three vertices and associate the
        // polygon with this plane.
        // The plane holds the invariant normal (orthogonal unit) vector to the polygon
        _plane = new Plane(_color,_material,vertices[0], vertices[1], vertices[2]);
        if (vertices.length == 3) return; // no need for more tests for a Triangle

        Vector n = _plane.getNormal(vertices[0]);

        // Subtracting any subsequent points will throw an IllegalArgumentException
        // because of Zero Vector if they are in the same point
        Vector edge1 = vertices[0].subtractFromPoint(vertices[vertices.length - 1]);
        Vector edge2 = vertices[1].subtractFromPoint(vertices[0]);

        // Cross Product of any subsequent edges will throw an IllegalArgumentException
        // because of Zero Vector if they connect three vertices that lay in the same
        // line.
        // Generate the direction of the polygon according to the angle between last and
        // first edge being less than 180 deg. It is hold by the sign of its dot product
        // with
        // the normal. If all the rest consequent edges will generate the same sign -
        // the
        // polygon is convex ("kamur" in Hebrew).
        boolean positive = edge1.crossProduct(edge2).dotProduct(n) > 0;
        for (int i = 2; i < vertices.length; ++i) {
            // Test that the point is in the same plane as calculated originally
            if ((vertices[i].subtractFromPoint(vertices[0]).dotProduct(n))!=0)
                throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
            // Test the consequent edges have
            edge1 = edge2;
            edge2 = vertices[i].subtractFromPoint(vertices[i - 1]);
            if (positive != (edge1.crossProduct(edge2).dotProduct(n) > 0))
                throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
        }
    }

    @Override
    public Vector getNormal(Point3D point) {
        return _plane.getNormal(point);
    }*/
}
