package model;

/**
 * The TTTModel interface defines the necessary methods to represent and maintain
 * the Tic Tac Toe game state.
 */
public interface TTTModel {

  /**
   * Places a mark (X or O) on the board at the specified row and column.
   *
   * @param player The player making the move (X or O).
   * @param row The row index (0-based).
   * @param col The column index (0-based).
   * @throws IllegalArgumentException If the position is out of bounds or already occupied.
   */
  void placeMark(Player player, int row, int col);

  /**
   * Gets the mark at the specified position.
   *
   * @param row The row index (0-based).
   * @param col The column index (0-based).
   * @return The player (X, O) occupying the position, or null if empty.
   * @throws IllegalArgumentException If the position is out of bounds.
   */
  Player getCell(int row, int col);

  /**
   * Checks if the game is over (either a win or a full board without a winner).
   *
   * @return True if the game is over, false otherwise.
   */
  boolean isGameOver();

  /**
   * Gets the winner of the game, if any.
   *
   * @return The winning player (X or O), or null if there is no winner.
   */
  Player getWinner();

  /**
   * Resets the board to an empty state.
   */
  void resetGame();
}