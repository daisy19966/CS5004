import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A generic queue implementation using ArrayList.
 * @param <T> the type of elements in this queue
 */
public class MyQueue<T> {
  private ArrayList<T> queue;

  /**
   * Constructs an empty queue.
   */
  public MyQueue() {
    this.queue = new ArrayList<>();
  }

  /**
   * Adds an element to the tail of the queue.
   * @param e the element to add
   */
  public void enqueue(T e) {
    queue.add(e);
  }

  /**
   * Removes and returns the head element of the queue.
   * @return the head element of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  // Question A: Frequent dequeue() operations can lead to performance degradation because in an
  // ArrayList, removing elements from the front requires shifting all subsequent elements to the left.
  // This results in a time complexity of O(n) for each dequeue() operation, which can become inefficient when the queue grows large.

  // Question B: A possible solution is to use a circular queue or a linked list-based queue implementation
  // to avoid the need to shift elements when dequeue, thereby improving performance.
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return queue.remove(0);
  }

  /**
   * Returns the head element of the queue without removing it.
   * @return the head element of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return queue.get(0);
  }

  /**
   * Returns true if the queue is empty.
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   * Returns a string representation of the queue.
   * @return a string representation of the queue
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Queue: ");
    for (T item : queue) {
      sb.append(item.toString()).append(" ");
    }
    return sb.toString().trim();
  }

  /**
   * Checks if two queues are equal.
   * @param obj the object to compare with
   * @return true if the queues are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MyQueue<?> myQueue = (MyQueue<?>) obj;
    return queue.equals(myQueue.queue);
  }

  /**
   * Returns the hash code of the queue.
   * @return the hash code of the queue
   */
  @Override
  public int hashCode() {
    return Objects.hash(queue);
  }
}