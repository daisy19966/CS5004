/**
 * Abstract base class representing a node in the file system hierarchy.
 * Can be extended by both folders (directories) and files.
 */
public abstract class FileSys {
  protected String name;

  /**
   * Constructs a file system node with a given name.
   * @param name The name of the node (file or folder)
   */
  public FileSys(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the node.
   * @return The name of the node
   */
  public String getName() {
    return name;
  }

  /**
   * Prints the node's name with appropriate formatting and indentation.
   * @param indent The current indentation string (e.g., "    ")
   */
  public abstract void prettyPrintName(String indent);
}