import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

  public MyPanel() {
    this.setFocusable(true);
    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }

    rnd = new Random();
    apple_loc = new Coordinate(200, 200);
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(50, 50));
    snake_loc.add(new Coordinate(60, 50));
    snake_loc.add(new Coordinate(70, 50));

    direction = Direction.UP;

    new Timer(200, this).start();
    this.addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Coordinate old_tail = snake_loc.remove(snake_loc.size() - 1);
    int old_head_x = snake_loc.get(0).x;
    int old_head_y = snake_loc.get(0).y;

    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (direction == Direction.UP) {
      new_head_y -= dot_size;
    } else if (direction == Direction.DOWN) {
      new_head_y += dot_size;
    } else if (direction == Direction.LEFT) {
      new_head_x -= dot_size;
    } else if (direction == Direction.RIGHT) {
      new_head_x += dot_size;
    }

    // Implement wrap-around behavior
    if (new_head_x < 0) new_head_x = board_width - dot_size;
    else if (new_head_x >= board_width) new_head_x = 0;
    if (new_head_y < 0) new_head_y = board_height - dot_size;
    else if (new_head_y >= board_height) new_head_y = 0;

    snake_loc.add(0, new Coordinate(new_head_x, new_head_y));

    if (snake_loc.get(0).equals(apple_loc)) {
      snake_loc.add(old_tail);
      regenApple();
    }

    repaint();
  }

  private void regenApple() {
    int new_x = rnd.nextInt(board_width / dot_size) * dot_size;
    int new_y = rnd.nextInt(board_height / dot_size) * dot_size;
    apple_loc = new Coordinate(new_x, new_y);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP && direction != Direction.DOWN) direction = Direction.UP;
    else if (keyCode == KeyEvent.VK_DOWN && direction != Direction.UP) direction = Direction.DOWN;
    else if (keyCode == KeyEvent.VK_LEFT && direction != Direction.RIGHT) direction = Direction.LEFT;
    else if (keyCode == KeyEvent.VK_RIGHT && direction != Direction.LEFT) direction = Direction.RIGHT;
  }

  @Override public void keyTyped(KeyEvent e) {}
  @Override public void keyReleased(KeyEvent e) {}

  private Coordinate apple_loc;
  private Image apple_image;
  private Image snake_head_image;
  private Image snake_body_image;
  private final int dot_size = 10;
  private Direction direction;
  private final Random rnd;
  List<Coordinate> snake_loc;
  private final int board_width = 400;
  private final int board_height = 400;
}