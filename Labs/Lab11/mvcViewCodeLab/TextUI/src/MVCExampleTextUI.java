import java.io.InputStreamReader;

public class MVCExampleTextUI {
  public static void main(String[] args) {
    IModel model = new Model();

    // Use InputStreamReader (which implements Readable) instead of System.in directly
    Readable in = new InputStreamReader(System.in);
    Appendable out = System.out;

    IView view = new TextView(out);
    IController controller = new TextController(model, in, view);

    try {
      controller.go();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}