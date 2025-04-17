import java.io.IOException;

public class TextView implements IView {
  private final Appendable out;

  public TextView(Appendable out) {
    this.out = out;
  }

  @Override
  public void showString(String s) throws IOException {
    out.append("String: ").append(s).append("\n");
  }

  @Override
  public void showOptions() throws IOException {
    out.append("Menu:\n");
    out.append("E: Enter a string\n");
    out.append("Q: Quit the program\n");
    out.append("Enter your choice: ");
  }

  @Override
  public void showStringEntry() throws IOException {
    out.append("\nEnter the string to be echoed: ");
  }

  @Override
  public void showOptionError() throws IOException {
    out.append("\nInvalid option.\n");
  }
}