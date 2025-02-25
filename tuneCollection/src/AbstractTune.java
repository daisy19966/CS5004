/**
 * Abstract Tune class helps implement the Tune interface
 * <p></p>
 * STUDENT TO COMPLETE -- INCLUDING JAVADOCS, STUBBED/MISSING METHODS
 * See AbstractTuneTest as well
 */
// BUG: A class can only extend one superclass. The AbstractTune class should implement the Comparable interface.
public abstract class AbstractTune implements Tune, Comparable<Tune> {
  private String title;
  private Person artist;
  private Genre genre;
  private int tempo;
  private String filePath;

  /**
   * STUDENT TO COMPLETE JAVADOCS and ARG-CHECKING of CONSTRUCTOR
   * Constructs an abstract class AbstractTune with the specified title, artist, genre, tempo, and filePath.
   *
   * @param title the title of the tune
   * @param artist the artist performing the tune
   * @param genre the genre of the tune
   * @param tempo the tempo of the tune
   * @param filePath the file path to the music file
   */
  // BUG: Missing filePath attribute in the consructor
  // BUG: Missing null checks
  public AbstractTune(String title, Person artist, Genre genre, int tempo, String filePath) {
    if (title == null || artist == null || genre == null || filePath == null || tempo <= 0) {
      throw new IllegalArgumentException("Invalid argument: none of the parameters can be null, and tempo must be positive.");
    }

      this.title = title;
      this.artist = artist;
      this.genre = genre;
      this.tempo = tempo;
      this.filePath = filePath;
  }

  /**
   * STUDENT TO COMPLETE REMAINING METHODS, except playTune, here.
   * INCLUDE ACTUAL JAVADOCS and ARG CHECKS. THIS SHOULD INCLUDE
   * equals METHOD, hashCode METHOD, and toString METHODS. See the
   * parent Interface for a full list of methods required. What
   * you see here has been partly "stubbed out" to get started.
   */

  // BUG: The get methods are not correctly implemented.
  /**
   * Gets the title of the tune
   * @return the title of the tune
   */
  public String getTitle () {
      return this.title;
    }

  /**
   * Gets the artist performing the tune.
   * @return the artist performing the tune.
   */
  @Override
  public Person getArtist() {
    return this.artist;
  }

  /**
   * Gets the genre of the tune
   * @return the genre of the tune
   */
  @Override
  public Genre getGenre() {
    return this.genre;
  }

  /**
   * Gets the tempo of the tune
   * @return the tempo of the tune
   */
  @Override
  public int getTempo() {return this.tempo;
  }

  /**
   * Gets the file path to the music file
   * @return the file path to the music file
   */
  @Override
  public String getFilePath() {
    return this.filePath;
  }


  /*
   There is one required method that is NOT to be implemented here:
   the method for playing a tune from a file. That is left to each concrete
   class that extends AbstractTune, based on the type of file that
   contains the music. See the two concrete classes for details.
  */

  /** Overriding equals for Tunes to examine all attributes */
  // BUG: The equals method should have an Object as input argument
  @Override
  public boolean equals(Object obj) {
    // Student to complete
    if (this == obj) return true;

    if (!(obj instanceof AbstractTune)) return false;

    AbstractTune other = (AbstractTune) obj;

    return this.getTitle().equals(other.getTitle()) &&
        this.getArtist().equals(other.getArtist()) &&
        this.getGenre().equals(other.getGenre()) &&
        this.getTempo() == other.getTempo() &&
        this.getFilePath().equals(other.getFilePath());
  }

  /** Overriding hashCode for Tunes to match equals */
  @Override
  public int hashCode () {
    // Student to complete
    return Objects.hash(getGenre(), getArtist(), getTitle(), getTempo(), getFilePath());
  }

  /** Overriding toString for Tunes to include all attributes */
  /**
   * Returns a summary of the tune, including title, main artist, genre, tempo and file path.
   *
   * @return a string summarizing the tune's attributes
   */
  @Override
  public String toString () {
    // Student to complete
    return " Title: " + this.getTitle() +
        " Artist: " + this.getArtist() +
        " Genre: " + this.getGenre() +
        " Tempo: " + this.getTempo() +
        " FilePath: " + this.getFilePath();
  }