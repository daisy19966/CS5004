public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of the fraction.
   * @return the numerator
   */
  int getNumerator();

  /**
   * Sets the numerator of the fraction.
   * @param numerator the numerator to set
   */
  void setNumerator(int numerator);

  /**
   * Returns the denominator of the fraction.
   * @return the denominator
   */
  int getDenominator();

  /**
   * Sets the denominator of the fraction. The denominator must be positive.
   * @param denominator the denominator to set
   */
  void setDenominator(int denominator);

  /**
   * Returns the decimal value of the fraction.
   * @return the decimal value
   */
  double toDouble();

  /**
   * Returns the fraction in its simplest form as a string.
   * @return the simplified fraction as a string
   */
  String toString();

  /**
   * Returns the reciprocal of the fraction.
   * @return the reciprocal fraction
   */
  Fraction reciprocal();

  /**
   * Adds another fraction to this fraction and returns the result.
   * @param other the fraction to add
   * @return the result of addition
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction with another fraction.
   * @param other the fraction to compare with
   * @return a negative integer if this < other, positive integer if this > other, 0 if equal
   */
  int compareTo(Fraction other);
}