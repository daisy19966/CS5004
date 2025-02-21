import java.util.Comparator;

/**
 * Compares two shapes based on their perimeter.
 * Implements the Comparator interface for Shape objects.
 */
public class PerimeterComparator implements Comparator<Shape> {
  /**
   * Compares two shapes by their perimeter.
   *
   * @param s1 the first shape to compare
   * @param s2 the second shape to compare
   * @return a negative integer, zero, or a positive integer if the perimeter of s1
   *         is less than, equal to, or greater than the perimeter of s2
   */
  @Override
  public int compare(Shape s1, Shape s2) {
    return Double.compare(s1.perimeter(), s2.perimeter());
  }
}