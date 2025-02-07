import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionImplTest {

  private Fraction fraction1;
  private Fraction fraction2;
  private Fraction fraction3;

  @BeforeEach
  public void setUp() {
    // Initialize some fractions for testing
    fraction1 = new FractionImpl(3, 4);
    fraction2 = new FractionImpl(1, 2);
    fraction3 = new FractionImpl(5, 6);
  }

  // Test the constructor with valid values
  @Test
  public void testConstructorValid() {
    Fraction fraction = new FractionImpl(5, 7);
    assertEquals(5, fraction.getNumerator());
    assertEquals(7, fraction.getDenominator());
  }

  // Test the constructor with a non-positive denominator (should throw exception)
  @Test
  public void testConstructorInvalidDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(3, 0));
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(3, -4));
  }

  // Test the constructor where both numerator and denominator are negative
  @Test
  public void testConstructorBothNegative() {
    Fraction fraction = new FractionImpl(-3, -4);
    assertEquals(3, fraction.getNumerator());
    assertEquals(4, fraction.getDenominator());
  }

  // Test the toDouble method
  @Test
  public void testToDouble() {
    assertEquals(0.75, fraction1.toDouble());
    assertEquals(0.5, fraction2.toDouble());
  }

  // Test toString method, ensuring it shows the fraction in reduced form
  @Test
  public void testToString() {
    assertEquals("3 / 4", fraction1.toString());
    assertEquals("1 / 2", fraction2.toString());
    assertEquals("5 / 6", fraction3.toString());
  }

  // Test reciprocal method
  @Test
  public void testReciprocal() {
    Fraction reciprocalFraction1 = fraction1.reciprocal();
    assertEquals(4, reciprocalFraction1.getNumerator());
    assertEquals(3, reciprocalFraction1.getDenominator());

    // Reciprocal of zero should throw an exception
    Fraction fractionZero = new FractionImpl(0, 1);
    assertThrows(IllegalArgumentException.class, () -> fractionZero.reciprocal());
  }

  // Test add method
  @Test
  public void testAdd() {
    Fraction result = fraction1.add(fraction2);
    assertEquals(10, result.getNumerator());
    assertEquals(8, result.getDenominator());
  }

  // Test compareTo method (fraction1 should be greater than fraction2)
  @Test
  public void testCompareTo() {
    assertTrue(fraction1.compareTo(fraction2) > 0);
    assertTrue(fraction2.compareTo(fraction1) < 0);
    assertEquals(0, fraction1.compareTo(fraction1));  // Should be equal
  }

  // Test setting the numerator
  @Test
  public void testSetNumerator() {
    fraction1.setNumerator(6);
    assertEquals(6, fraction1.getNumerator());
  }

  // Test setting the denominator with a valid value
  @Test
  public void testSetDenominator() {
    fraction1.setDenominator(6);
    assertEquals(6, fraction1.getDenominator());
  }

  // Test setting the denominator with an invalid value (should throw exception)
  @Test
  public void testSetDenominatorInvalid() {
    assertThrows(IllegalArgumentException.class, () -> fraction1.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> fraction1.setDenominator(-1));
  }

  // Test the GCD function
  @Test
  public void testGcd() {
    // Testing gcd helper method directly can be done through toString method
    assertEquals("3 / 4", fraction1.toString());  // Should be reduced using GCD
    assertEquals("1 / 2", fraction2.toString());  // Should be reduced using GCD
  }

  // Test adding fractions with the same denominator
  @Test
  public void testAddSameDenominator() {
    Fraction fraction4 = new FractionImpl(1, 4);
    Fraction fraction5 = new FractionImpl(2, 4);
    Fraction result = fraction4.add(fraction5);
    assertEquals(3, result.getNumerator());
    assertEquals(4, result.getDenominator());
  }

  // Test adding fractions with different denominators
  @Test
  public void testAddDifferentDenominators() {
    Fraction fraction6 = new FractionImpl(2, 3);
    Fraction result = fraction1.add(fraction6);
    assertEquals(17, result.getNumerator());
    assertEquals(12, result.getDenominator());
  }

  // Test comparison with fractions that are equal
  @Test
  public void testCompareToEqual() {
    Fraction fraction7 = new FractionImpl(2, 4);  // Equivalent to 1/2
    assertEquals(0, fraction2.compareTo(fraction7));  // Should be equal
  }
}