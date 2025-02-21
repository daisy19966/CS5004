import java.awt.Point;

public class Triangle implements Shape {
  private final Point p1;
  private final Point p2;
  private final Point p3;

  // Constructor
  public Triangle(Point p1, Point p2, Point p3) {
    // A Triangle with two (or three) identical points cannot be constructed
    if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
      throw new IllegalArgumentException("Two or more points are identical. Cannot form a valid triangle.");
    }

    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  // Method to calculate the distance between two points
  private double getDistance(Point a, Point b) {
    return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
  }

  // Method to calculate the perimeter of the triangle
  public double perimeter() {
    double side1 = getDistance(p1, p2);
    double side2 = getDistance(p2, p3);
    double side3 = getDistance(p3, p1);
    return side1 + side2 + side3;
  }

  // Method to calculate the area of the triangle using Heron's formula
  public double area() {
    double side1 = getDistance(p1, p2);
    double side2 = getDistance(p2, p3);
    double side3 = getDistance(p3, p1);

    // Calculate the semi-perimeter
    double s = (side1 + side2 + side3) / 2;

    // Calculate the area using Heron's formula
    double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

    // If the points are collinear, the area will be 0
    return area;
  }

  // Method to calculate the distance from the origin (using the reference point p1)
  public double distanceFromOrigin() {
    return Math.sqrt(Math.pow(p1.getX(), 2) + Math.pow(p1.getY(), 2));
  }

  // Method to resize the triangle by a given factor
  public Shape resize(double factor) {
    // Calculate the new area
    double newArea = area() * factor;

    // Calculate the scaling factor for the sides
    double scale = Math.sqrt(newArea / area());

    // Scale the points relative to the centroid of the triangle
    double centroidX = (p1.getX() + p2.getX() + p3.getX()) / 3.0;
    double centroidY = (p1.getY() + p2.getY() + p3.getY()) / 3.0;

    Point newP1 = new Point(
        (int) (centroidX + (p1.getX() - centroidX) * scale),
        (int) (centroidY + (p1.getY() - centroidY) * scale)
    );
    Point newP2 = new Point(
        (int) (centroidX + (p2.getX() - centroidX) * scale),
        (int) (centroidY + (p2.getY() - centroidY) * scale)
    );
    Point newP3 = new Point(
        (int) (centroidX + (p3.getX() - centroidX) * scale),
        (int) (centroidY + (p3.getY() - centroidY) * scale)
    );

    return new Triangle(newP1, newP2, newP3);
  }

  // Override toString method to display the triangle's points
  public String toString() {
    return "Triangle with points: " + p1 + ", " + p2 + ", " + p3;
  }

  // Implement Comparable interface to compare shapes by area
  public int compareTo(Shape other) {
    return Double.compare(this.area(), other.area());
  }
}