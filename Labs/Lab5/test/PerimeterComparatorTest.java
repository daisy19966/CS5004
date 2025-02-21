import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerimeterComparatorTest {
  @Test
  void testCompare() {
    Shape circle = new Circle(5);
    Shape rectangle = new Rectangle(4, 6);
    PerimeterComparator comparator = new PerimeterComparator();

    // Test circle perimeter < rectangle perimeter
    assertTrue(comparator.compare(circle, rectangle) < 0);

    // Test circle perimeter > rectangle perimeter
    assertTrue(comparator.compare(rectangle, circle) > 0);

    // Test equal perimeters
    Shape circle2 = new Circle(5);
    assertEquals(0, comparator.compare(circle, circle2));
  }
}