import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

final class BreakoutPanel extends JPanel {

  /**
   * We need to keep a reference to the parent swing app for sizing and
   * other bookkeeping.
   */
  private final BreakoutRunner RUNNER;

  private final List<GameObject> GAME_OBJECTS;

  BreakoutPanel(final BreakoutRunner breakoutRunner) {
    this.RUNNER = breakoutRunner;
    this.GAME_OBJECTS = new ArrayList<>();
    this.setPreferredSize(new Dimension(this.RUNNER.getWidth(), this.RUNNER.getHeight()));
    this.requestFocusInWindow(true);

    // Add paddle and ball to the game objects list.
    Paddle p = new Paddle(360, 550); // Place paddle at the bottom center of the screen.
    this.GAME_OBJECTS.add(p);
    this.GAME_OBJECTS.add(new Ball(this, 360, 360)); // Place ball at the center of the screen.

    // Add bricks in a grid
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        this.GAME_OBJECTS.add(new Brick(70 + (i * 50), 50 + (j * 20)));
      }
    }

    // Mark the paddle as the input listener.
    this.addKeyListener(p.getInput());
  }

  void update() {
    for (int i = 0; i < this.GAME_OBJECTS.size(); i++) {
      GameObject obj = this.GAME_OBJECTS.get(i);
      obj.update();
      obj.handleCollision(this.GAME_OBJECTS);
    }
  }

  @Override
  public void paintComponent(final Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    this.GAME_OBJECTS.forEach(o -> o.render(g2d));
  }
}