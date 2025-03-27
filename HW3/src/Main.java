/**
 * Demonstrates the file system hierarchy structure and pretty-printing.
 */
public class Main {
  public static void main(String[] args) {
    // Build the folder structure
    Folder root = new Folder("root");
    Folder home = new Folder("home");
    Folder mlmiller = new Folder("mlmiller");

    File fileA = new File("markFileA.txt");
    File fileB = new File("markFileB.txt");

    // Assemble the hierarchy
    root.addNode(home);
    home.addNode(mlmiller);
    mlmiller.addNode(fileA);
    mlmiller.addNode(fileB);

    // Print the entire structure
    root.prettyPrintName("");
  }
}