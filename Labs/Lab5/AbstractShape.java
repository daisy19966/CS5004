/**
 * An abstract class that implements the Shape interface and provides common functionality
 * for all shapes. This class includes a reference point and implements the distanceFromOrigin
 * and compareTo methods.
 *
 * @author Ashesh
 * @version 1.0
 * @since 1/26/2017
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  /**
   * Constructs an AbstractShape with the given reference point.
   *
   * @param reference the reference point of the shape
   */
  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  /**
   * Calculates the distance of the shape's reference point from the origin.
   *
   * @return the distance from the origin as a double
   */
  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

  /**
   * Compares this shape to another shape based on their areas.
   * Returns a negative integer, zero, or a positive integer if the area of this shape
   * is less than, equal to, or greater than the area of the other shape.
   *
   * @param s the other shape to compare to
   * @return -1 if this shape's area is less, 0 if equal, or 1 if greater
   */
  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis < areaOther) {
      return -1;
    } else if (areaOther < areaThis) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * If comparisons are to be based on perimeter, the following parts need to be modified:
   * 1. The compareTo method in the AbstractShape class should be changed to compare based on perimeter.
   * 2. If the AbstractShape class did not exist, the compareTo method would need to be implemented separately in the Rectangle, Circle, and Triangle classes.
   * Therefore, without AbstractShape, 3 files would need to be modified.
   */
}