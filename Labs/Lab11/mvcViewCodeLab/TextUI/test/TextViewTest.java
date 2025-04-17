import org.junit.jupiter.api.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TextViewTest {

  @Test
  public void testShowString() throws IOException {
    StringWriter output = new StringWriter();
    IView view = new TextView(output);

    // Call the method that shows the string
    view.showString("hello");

    // Assert 1: Check that the output contains "String: hello"
    String result = output.toString();
    assertTrue(result.contains("String: hello"));

    // Assert 2: Ensure the output ends with a newline after the string
    assertTrue(result.endsWith("\n"));
  }

  @Test
  public void testShowOptions() throws IOException {
    StringWriter output = new StringWriter();
    IView view = new TextView(output);

    // Call the method that shows the options
    view.showOptions();

    // Assert 1: Check that the menu text is included
    String result = output.toString();
    assertTrue(result.contains("Menu:\n"));
    assertTrue(result.contains("E: Enter a string\n"));
    assertTrue(result.contains("Q: Quit the program\n"));

    // Assert 2: Check the prompt at the end
    assertTrue(result.contains("Enter your choice: "));
  }

  @Test
  public void testShowStringEntry() throws IOException {
    StringWriter output = new StringWriter();
    IView view = new TextView(output);

    // Call the method that shows the string entry prompt
    view.showStringEntry();

    // Assert 1: Check that the prompt contains "Enter the string to be echoed"
    String result = output.toString();
    assertTrue(result.contains("Enter the string to be echoed: "));

    // Assert 2: Ensure there's a newline after the prompt
    assertTrue(result.endsWith(": \n"));
  }

  @Test
  public void testShowOptionError() throws IOException {
    StringWriter output = new StringWriter();
    IView view = new TextView(output);

    // Call the method that shows the error message
    view.showOptionError();

    // Assert 1: Check that the error message is included
    String result = output.toString();
    assertTrue(result.contains("Invalid option.\n"));

    // Assert 2: Ensure the error ends with a newline
    assertTrue(result.endsWith("\n"));
  }
}