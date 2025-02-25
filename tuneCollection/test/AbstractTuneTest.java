import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// STUDENT TO TEST ALL METHODS IN AbstractTune
// TWO ASSERTIONS PER METHOD, THREE FOR COMPARISONS

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTuneTest {

  private AbstractTune tune1;
  private AbstractTune tune2;
  private AbstractTune tune3;

  @BeforeEach
  void setUp() {
    // Initialize test data
    tune1 = new MockTune("Yesterday", "The Beatles", "Pop", 120, "yesterday.mp3");
    tune2 = new MockTune("Bohemian Rhapsody", "Queen", "Rock", 150, "bohemian.mp3");
    tune3 = new MockTune("Yesterday", "The Beatles", "Pop", 120, "yesterday.mp3"); // Same as tune1
  }

  @Test
  void testToString() {
    // Test that the toString method works correctly
    assertEquals("Title: Yesterday, Artist: The Beatles, Genre: Pop, Tempo: 120, FilePath: yesterday.mp3", tune1.toString());
    assertNotEquals(tune1.toString(), tune2.toString()); // Ensure different tunes don't return the same string
  }

  @Test
  void getTitle() {
    // Assert that getTitle returns the correct title
    assertEquals("Yesterday", tune1.getTitle());
    assertNotEquals("Bohemian Rhapsody", tune1.getTitle()); // Different check
  }

  @Test
  void compareTo() {
    // Assert that compareTo compares titles correctly
    assertTrue(tune1.compareTo(tune2) < 0); // "Yesterday" < "Bohemian Rhapsody"
    assertTrue(tune2.compareTo(tune1) > 0); // "Bohemian Rhapsody" > "Yesterday"
    assertEquals(0, tune1.compareTo(tune3)); // Same tunes should return 0
  }

  @Test
  void testEquals() {
    // Test for equality based on content
    assertEquals(tune1, tune3); // tune1 and tune3 should be equal
    assertNotEquals(tune1, tune2); // tune1 and tune2 should not be equal
  }

  @Test
  void testHashCode() {
    // Test that equal objects have the same hash code
    assertEquals(tune1.hashCode(), tune3.hashCode()); // Same content
    assertNotEquals(tune1.hashCode(), tune2.hashCode()); // Different contents
  }

  // MockTune class as a simple implementation of AbstractTune
  private static class MockTune extends AbstractTune {
    // Constructor
    public MockTune(String title, String artist, String genre, int tempo, String filePath) {
      super(title, artist, genre, tempo, filePath);
    }

    @Override
    public String getArtist() {
      return super.getArtist();
    }

    @Override
    public String getGenre() {
      return super.getGenre();
    }

    @Override
    public int getTempo() {
      return super.getTempo();
    }

    @Override
    public String getFilePath() {
      return super.getFilePath();
    }
  }
}
