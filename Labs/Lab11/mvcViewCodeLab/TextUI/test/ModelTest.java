import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

  @Test
  public void testSetAndGetString_basicUsage() {
    IModel model = new Model();
    model.setString("hello");

    // Assert 1: getString should return the string set earlier
    assertEquals("hello", model.getString());

    // Assert 2: update with a new string and check again
    model.setString("world");
    assertEquals("world", model.getString());
  }

  @Test
  public void testSetAndGetString_emptyStringAndDefault() {
    IModel model = new Model();

    // Assert 1: the default string should be an empty string
    assertEquals("", model.getString());

    // Assert 2: setting an empty string should be stored correctly
    model.setString("");
    assertEquals("", model.getString());
  }

  @Test
  public void testSetNull() {
    IModel model = new Model();

    // Assert 1: set string to null and check that it's stored
    model.setString(null);
    assertNull(model.getString());

    // Assert 2: set string again to a non-null value after null
    model.setString("not null anymore");
    assertEquals("not null anymore", model.getString());
  }
}