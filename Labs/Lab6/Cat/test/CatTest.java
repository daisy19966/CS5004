import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatTest {

  @Test
  void testSetAge() {
    Cat cat = new Cat("Whiskers", 3, Color.GRAY, new Person("Alice", "Jones", 1986));
    cat.setAge(5);
    assertEquals(5, cat.getAge());
  }

  @Test
  void testSetOwner() {
    Cat cat = new Cat("Whiskers", 3, Color.GRAY, new Person("Alice", "Jones", 1986));
    Person newOwner = new Person("Bob", "Smith", 1990);
    cat.setOwner(newOwner);
    assertEquals(newOwner, cat.getOwner());
  }

  @Test
  void testEquals() {
    Person owner = new Person("Alice", "Jones", 1986);
    Cat cat1 = new Cat("Whiskers", 3, Color.GRAY, owner);
    Cat cat2 = new Cat("Whiskers", 3, Color.GRAY, owner);
    Cat cat3 = new Cat("Shadow", 3, Color.GRAY, owner);

    assertEquals(cat1, cat2);
    assertNotEquals(cat1, cat3);
  }

  @Test
  void testHashCode() {
    Person owner = new Person("Alice", "Jones", 1986);
    Cat cat1 = new Cat("Whiskers", 3, Color.GRAY, owner);
    Cat cat2 = new Cat("Whiskers", 3, Color.GRAY, owner);
    Cat cat3 = new Cat("Shadow", 3, Color.GRAY, owner);

    assertEquals(cat1.hashCode(), cat2.hashCode());
    assertNotEquals(cat1.hashCode(), cat3.hashCode());
  }
}