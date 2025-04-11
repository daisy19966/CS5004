package calculator;

import org.junit.jupiter.api.Test;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestController6 {

  @Test
  public void testAdditionSequence() throws Exception {
    String input = "+ 3 4 + 8 9 q";
    String expectedOutput = "7\n17\n";

    StringReader reader = new StringReader(input);
    StringBuilder output = new StringBuilder();  // ← 修改这里

    Controller6 controller = new Controller6(reader, output);
    controller.go(new Calculator());

    assertEquals(expectedOutput, output.toString());
  }
}