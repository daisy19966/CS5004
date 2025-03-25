import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

public class MyQueueTest {

  @Test
  public void testEnqueueAndDequeue() {
    MyQueue<Object> queue = new MyQueue<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    assertEquals("A", queue.dequeue()); // Enable the first the element is deleted
    assertEquals("B", queue.dequeue());
    assertEquals("C", queue.dequeue());
  }

  @Test
  public void testPeek() {
    MyQueue<String> queue = new MyQueue<>();
    queue.enqueue("A");
    queue.enqueue("B");

    assertEquals("A", queue.peek());
    queue.dequeue();
    assertEquals("B", queue.peek());
  }

  @Test
  public void testIsEmpty() {
    MyQueue<String> queue = new MyQueue<>();
    assertTrue(queue.isEmpty());
    queue.enqueue("A");
    assertFalse(queue.isEmpty());
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testDequeueException() {
    MyQueue<String> queue = new MyQueue<>();
    assertThrows(NoSuchElementException.class, queue::dequeue);
  }

  @Test
  public void testPeekException() {
    MyQueue<String> queue = new MyQueue<>();
    assertThrows(NoSuchElementException.class, queue::peek);
  }

  @Test
  public void testToString() {
    MyQueue<String> queue = new MyQueue<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    assertEquals("Queue: A B C", queue.toString()); 
  }
}