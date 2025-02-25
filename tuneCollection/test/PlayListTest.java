
// STUDENTS TO COMPLETE ONLY PORTIONS OF THIS FILE:
// setUp, as needed; sortByTitle; and sortByTempo.
// The other methds needing tests may be skipped for this midterm.

// PROVIDE TWO ASSERTIONS PER METHOD (THREE FOR COMPARISON TESTS).

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class PlayListTest {
  private PlayList playList;

  @BeforeEach
  public void setUp() {
    playList = new PlayList();
  }

  @Test
  void addItem() {
  }

  @Test
  void getItem() {
  }

  @Test
  void remove() {
  }

  @Test
  void size() {
  }

  @Test
  public void testSortByTitle() {
    // Create test tunes
    Tune tune1 = new MockTune("Yesterday", "Beatles", "Rock", 120, "path1.mp3");
    Tune tune2 = new MockTune("Bohemian Rhapsody", "Queen", "Rock", 150, "path2.mp3");
    Tune tune3 = new MockTune("Stairway to Heaven", "Led Zeppelin", "Rock", 100, "path3.mp3");
    Tune tune4 = new MockTune("Another One Bites the Dust", "Queen", "Rock", 110, "path4.mp3");

    // Add tunes to the playlist in a not sorted order
    playList.addTune(tune1);
    playList.addTune(tune4);
    playList.addTune(tune2);
    playList.addTune(tune3);

    // Sort the playlist by title
    playList.sortByTitle();

    // Create an expected order after sorting
    Tune[] expectedOrder = {tune1, tune3, tune2, tune4}; // "Yesterday", "Stairway to Heaven", "Bohemian Rhapsody", "Another One Bites the Dust"

    // Check the order after the sort
    for (int i = 0; i < expectedOrder.length; i++) {
      assertEquals(expectedOrder[i], playList.getTune(i));
    }
  }

  @Test
  public void testSortByTempo() {
    // Create test tunes
    Tune tune1 = new MockTune("Losing My Religion", "R.E.M.", "Alternative", 100, "path5.mp3");
    Tune tune2 = new MockTune("Shake It Off", "Taylor Swift", "Pop", 120, "path6.mp3");
    Tune tune3 = new MockTune("Thunder", "Imagine Dragons", "Rock", 140, "path7.mp3");
    Tune tune4 = new MockTune("Imagine", "John Lennon", "Pop", 80, "path8.mp3");

    // Add tunes to the playlist in a random order
    playList.addTune(tune1);
    playList.addTune(tune3);
    playList.addTune(tune2);
    playList.addTune(tune4);

    // Sort the playlist by tempo
    playList.sortByTempo();

    // Create expected order after sorting
    Tune[] expectedOrder = {tune4, tune1, tune2, tune3}; // Tempo: 80, 100, 120, 140

    // Check the order after the sort
    for (int i = 0; i < expectedOrder.length; i++) {
      assertEquals(expectedOrder[i], playList.getTune(i));
    }
  }

  @Test
  void testToString() {
  }
}
