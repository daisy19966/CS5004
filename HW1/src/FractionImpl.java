public class FractionImpl implements Fraction {
  private int numerator;
  private int denominator;

  // Constructor
  public FractionImpl(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    if (this.numerator < 0 && this.denominator < 0) {
      this.numerator = -this.numerator;
      this.denominator = -this.denominator;
    }
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.denominator = denominator;
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  @Override
  public String toString() {
    int gcdValue = gcd(Math.abs(numerator), denominator);
    return (numerator / gcdValue) + " / " + (denominator / gcdValue);
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new IllegalArgumentException("Cannot compute reciprocal of zero.");
    }
    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    int newNumerator = this.numerator * other.getDenominator() + this.denominator * other.getNumerator();
    int newDenominator = this.denominator * other.getDenominator();
    return new FractionImpl(newNumerator, newDenominator);
  }

  @Override
  public int compareTo(Fraction other) {
    int crossMultiplyLeft = this.numerator * other.getDenominator();
    int crossMultiplyRight = this.denominator * other.getNumerator();
    return Integer.compare(crossMultiplyLeft, crossMultiplyRight);
  }

  // Helper method for GCD
  private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
}