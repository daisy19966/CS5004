public class NewShoe {

  private ShoeType type;
  private ShoeColor color;
  private ShoeBrand brand;
  private double size;

  /**
   * Constructs a Shoe object with the specified type, color, brand, and size.
   *
   * @param type  the type of the shoe (e.g., SNEAKER, DRESS, etc.)
   * @param color the color of the shoe (e.g., BLACK, RED, etc.)
   * @param brand the brand of the shoe (e.g., NIKE, ADIDAS, etc.)
   * @param size  the size of the shoe (e.g., 10.5)
   * @throws IllegalArgumentException if the brand is NIKE and the type is DRESS
   */

  public NewShoe(ShoeType type, ShoeColor color, ShoeBrand brand, double size) {
    if (brand == ShoeBrand.NIKE && type == ShoeType.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell DRESS shoes.");
    }
    this.type = type;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Gets the type of the shoe.
   *
   * @return the type of the shoe
   */
  public ShoeType getType() {
    return type;
  }

  /**
   * Gets the color of the shoe.
   *
   * @return the color of the shoe
   */
  public ShoeColor getColor() {
    return color;
  }

  /**
   * Gets the brand of the shoe.
   *
   * @return the brand of the shoe
   */
  public ShoeBrand getBrand() {
    return brand;
  }

  /**
   * Gets the size of the shoe.
   *
   * @return the size of the shoe
   */
  public double getSize() {
    return size;
  }

  /**
   * Returns a summary of the shoe, including its type, color, brand, and size.
   *
   * @return a string summarizing the shoe's attributes
   */
  public String getSummary() {
    return "Shoe [Type: " + type + ", Color: " + color + ", Brand: " + brand + ", Size: " + size + "]";
  }
}