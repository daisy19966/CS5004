import org.junit.jupiter.api.Test;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TextControllerTest {

  @Test
  public void testGo_withValidInput() throws IOException {
    StringReader input = new StringReader("E\nhello world\nQ\n");
    StringWriter output = new StringWriter();
    IModel model = new Model();  // Assuming Model is implemented as shown before
    IView view = new TextView(output);  // TextView writes to StringWriter
    IController controller = new TextController(model, input, view);

    // Run the controller's go method
    controller.go();

    // Assert 1: Check if the model's string was set and echoed correctly
    String result = output.toString();
    assertTrue(result.contains("String: hello world"));

    // Assert 2: Ensure the output ends with a valid prompt or ending
    assertTrue(result.endsWith("Enter your choice: "));
  }

  @Test
  public void testGo_withInvalidOption() throws IOException {
    StringReader input = new StringReader("X\nQ\n");  // X is invalid
    StringWriter output = new StringWriter();
    IModel model = new Model();
    IView view = new TextView(output);
    IController controller = new TextController(model, input, view);

    controller.go();

    // Assert 1: Ensure the error message for invalid option is shown
    String result = output.toString();
    assertTrue(result.contains("Invalid option.\n"));

    // Assert 2: Ensure that after invalid input, the program continues and eventually quits
    assertTrue(result.endsWith("Enter your choice: "));
  }

  @Test
  public void testGo_withEmptyString() throws IOException {
    StringReader input = new StringReader("E\n\nQ\n");  // Empty string input
    StringWriter output = new StringWriter();
    IModel model = new Model();
    IView view = new TextView(output);
    IController controller = new TextController(model, input, view);

    controller.go();

    // Assert 1: Ensure the model stores the empty string and echoes it
    String result = output.toString();
    assertTrue(result.contains("String: "));

    // Assert 2: Check that the program terminates correctly after valid input and quit command
    assertTrue(result.endsWith("Enter your choice: "));
  }
}