/**
 * Represents a file in the file system (leaf node).
 * Cannot contain other nodes.
 */
public class File extends FileSys {
  /**
   * Creates a new file with the specified name.
   * @param name The name of the file
   */
  public File(String name) {
    super(name);
  }

  /**
   * Prints the file name with indentation.
   * @param indent The current indentation string
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + name); // No prefix for files
  }
}