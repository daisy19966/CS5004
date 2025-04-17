import java.io.IOException;
import java.util.Scanner;

public class TextController implements IController {
  private final Scanner in;
  private final IView view;
  private final IModel model;

  /** Use Readable instead of InputStream to allow flexible testing */
  public TextController(IModel model, Readable in, IView view) {
    this.model = model;
    this.view = view;
    this.in = new Scanner(in);
  }

  public void go() throws IOException {
    boolean quit = false;

    while (!quit) {
      view.showString(model.getString());
      view.showOptions();

      if (!in.hasNext()) {
        break;
      }

      String option = in.next();
      switch (option) {
        case "E":
          view.showStringEntry();
          in.nextLine(); // consume newline
          String input = in.nextLine();
          model.setString(input);
          break;
        case "Q":
          quit = true;
          break;
        default:
          view.showOptionError();
      }
    }
  }
}