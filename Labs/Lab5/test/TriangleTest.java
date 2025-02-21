import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @Test
  void testTriangleConstructor() {
    // Test valid triangle
    assertDoesNotThrow(() -> new Triangle(3, 4, 5));

    // Test invalid triangle
    assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
  }

  @Test
  void testTriangleArea() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(6.0, triangle.area(), 0.001);

    Triangle triangle2 = new Triangle(5, 12, 13);
    assertEquals(30.0, triangle2.area(), 0.001);
  }

  @Test
  void testTrianglePerimeter() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(12.0, triangle.perimeter(), 0.001);

    Triangle triangle2 = new Triangle(5, 12, 13);
    assertEquals(30.0, triangle2.perimeter(), 0.001);
  }

  @Test
  void testTriangleToString() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals("Triangle with sides 3.0, 4.0, 5.0", triangle.toString());

    Triangle triangle2 = new Triangle(5, 12, 13);
    assertEquals("Triangle with sides 5.0, 12.0, 13.0", triangle2.toString());
  }

  @Test
  void testTriangleCompareTo() {
    Triangle triangle1 = new Triangle(3, 4, 5); // Area = 6
    Triangle triangle2 = new Triangle(5, 12, 13); // Area = 30
    Triangle triangle3 = new Triangle(6, 8, 10); // Area = 24

    // Test less than
    assertTrue(triangle1.compareTo(triangle2) < 0);

    // Test greater than
    assertTrue(triangle2.compareTo(triangle1) > 0);

    // Test equal
    Triangle triangle4 = new Triangle(3, 4, 5); // Same as triangle1
    assertEquals(0, triangle1.compareTo(triangle4));
  }
}