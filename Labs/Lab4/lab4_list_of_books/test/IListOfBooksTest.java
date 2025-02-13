import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for IListOfBooks implementations.
 */
public class IListOfBooksTest {
  private IListOfBooks empty;
  private IListOfBooks bookList;
  private Book book1, book2, book3;

  @BeforeEach
  public void setUp() {
    empty = new EmptyNode();
    book1 = new Book("Book A", "Author A", 1990, 10.0f);
    book2 = new Book("Book B", "Author B", 2005, 20.0f);
    book3 = new Book("Book C", "Author C", 1985, 15.0f);
    bookList = new ElementNode(book1, new ElementNode(book2, new ElementNode(book3, empty)));
  }

  // Tests for count()
  @Test
  public void testEmptyNodeCount() {
    assertEquals(0, empty.count());
  }

  @Test
  public void testElementNodeCount() {
    assertEquals(3, bookList.count());
  }

  // Tests for totalPrice()
  @Test
  public void testEmptyNodeTotalPrice() {
    assertEquals(0.0f, empty.totalPrice());
  }

  @Test
  public void testElementNodeTotalPrice() {
    assertEquals(45.0f, bookList.totalPrice()); // 10 + 20 + 15
  }

  // Tests for allBefore()
  @Test
  public void testAllBeforeOnEmptyNode() {
    assertEquals(0, empty.allBefore(2000).count());
  }

  @Test
  public void testAllBeforeOnElementNode() {
    IListOfBooks filteredList = bookList.allBefore(2000);
    assertEquals(2, filteredList.count()); // Books A (1990) and C (1985) remain
  }

  // Tests for addAtEnd()
  @Test
  public void testAddAtEndOnEmptyNode() {
    Book newBook = new Book("Book D", "Author D", 2010, 25.0f);
    IListOfBooks newList = empty.addAtEnd(newBook);
    assertEquals(1, newList.count());
    assertTrue(newList.toString().contains("Book D"));
  }

  @Test
  public void testAddAtEndOnElementNode() {
    Book book4 = new Book("Book D", "Author D", 2015, 25.0f);
    IListOfBooks newList = bookList.addAtEnd(book4);
    assertEquals(4, newList.count());
    assertTrue(newList.toString().contains("Book D"));
  }

  // Tests for toString()
  @Test
  public void testToStringOnEmptyNode() {
    assertEquals("", empty.toString());
  }

  @Test
  public void testToStringOnElementNode() {
    String expected = "Title: Book A Author: Author A Year: 1990 Price: 10.00\n" +
        "Title: Book B Author: Author B Year: 2005 Price: 20.00\n" +
        "Title: Book C Author: Author C Year: 1985 Price: 15.00\n";
    assertEquals(expected, bookList.toString());
  }
}