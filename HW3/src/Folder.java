import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory (folder) in the file system.
 * Can contain other files or folders as children.
 */
public class Folder extends FileSys {
  private List<FileSys> children;

  /**
   * Creates a new folder with the specified name.
   * @param name The name of the folder
   */
  public Folder(String name) {
    super(name);
    this.children = new ArrayList<>();
  }

  /**
   * Adds a child node (file or folder) to this folder.
   * @param node The node to add
   */
  public void addNode(FileSys node) {
    children.add(node);
  }

  /**
   * Recursively prints the folder structure with proper indentation.
   * Folders are prefixed with "d ".
   * @param indent The current indentation level
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + "d " + name); // Directory prefix
    for (FileSys child : children) {
      child.prettyPrintName(indent + "    "); // Increase indentation
    }
  }
}