/**
 * Represents a non-empty list of books, storing a book and a reference to the rest of the list.
 */
public class ElementNode implements IListOfBooks {
  private Book book;
  private IListOfBooks rest;

  /**
   * Constructs an ElementNode with a book and the remaining list.
   *
   * @param book the book stored in this node
   * @param rest the rest of the book list
   */
  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public float totalPrice() {
    return book.getPrice() + rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (book.before(year)) { // Use Book's `before` method
      return new ElementNode(book, rest.allBefore(year));
    }
    return rest.allBefore(year);
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.book, rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    return book.toString() + "\n" + rest.toString();
  }
}