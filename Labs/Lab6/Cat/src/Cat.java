import java.util.Objects;

/**
 * Represents a cat with a name, age, color, and owner.
 */
public class Cat {
  private String name;
  private int age;
  private Color color;
  private Person owner;

  /**
   * Constructs a Cat object with given attributes.
   * @param name The name of the cat
   * @param age The age of the cat
   * @param color The color of the cat
   * @param owner The owner of the cat
   */
  public Cat(String name, int age, Color color, Person owner) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.owner = owner;
  }

  /** Gets the cat's name. */
  public String getName() {
    return this.name;
  }

  /** Gets the cat's age. */
  public int getAge() {
    return this.age;
  }

  /** Sets the cat's age. */
  public void setAge(int age) {
    this.age = age;
  }

  /** Gets the cat's color. */
  public Color getColor() {
    return this.color;
  }

  /** Gets the cat's owner. */
  public Person getOwner() {
    return this.owner;
  }

  /** Sets the cat's owner. */
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  /**
   * Returns a string representation of the Cat.
   * @return a formatted string of the cat's attributes
   */
  @Override
  public String toString() {
    return "Cat{name='" + this.name + "', age=" + this.age + ", color=" + this.color + ", owner=" + this.owner + "}";
  }

  /**
   * Checks if two Cat objects are equal.
   * @param o The object to compare with
   * @return true if the objects are equal, otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cat cat = (Cat) o;
    return age == cat.age && name.equals(cat.name) && this.color == cat.color && Objects.equals(owner, cat.owner);
  }

  /**
   * Computes the hash code for a Cat object.
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, color, owner);
  }
}