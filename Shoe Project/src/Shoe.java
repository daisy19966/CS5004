public class Shoe {

  private String type;
  private String color;
  private String brand;
  private double size;

  /**
   * Constructs a Shoe object with the specified type, color, brand, and size.
   *
   * @param type  the type of the shoe (e.g., "Sneaker")
   * @param color the color of the shoe (e.g., "Red")
   * @param brand the brand of the shoe (e.g., "Nike")
   * @param size  the size of the shoe (e.g., 10.5)
   */
  public Shoe(String type, String color, String brand, double size) {
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
  public String getType() {
    return type;
  }

  /**
   * Gets the color of the shoe.
   *
   * @return the color of the shoe
   */
  public String getColor() {
    return color;
  }

  /**
   * Gets the brand of the shoe.
   *
   * @return the brand of the shoe
   */
  public String getBrand() {
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