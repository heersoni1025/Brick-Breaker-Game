import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

class Ball extends GameObject {

  private static final int DEFAULT_RADIUS = 10;

  private static final int DEFAULT_SPEED = 10;

  private double velX;
  private double velY;

  private double speed;

  private BreakoutPanel panel;

  Ball(BreakoutPanel panel, double x, double y) {
    super(x, y, DEFAULT_RADIUS, DEFAULT_RADIUS);
    this.speed = DEFAULT_SPEED;
    this.panel = panel;
    this.velX = (Math.random() * 9) -4;
    this.velY =(Math.random() * 9)-4; // TODO change velY to be random double between -4 and 4.
  }

  @Override
  void update() {
    // If the ball goes off the horizontal sides of the screen, reverse the x velocity.
    if (this.getX() < 0 || this.getX() + this.getWidth() > this.panel.getWidth()) {
      this.setVelX(-this.getVelX());
    }
    // If the ball goes off the vertical sides of the screen, reverse the y velocity.
    else if (this.getY() < 0 || this.getY() + this.getHeight() > this.panel.getHeight()) {
      this.setVelY(-this.getVelY());
    }
    // Update the ball's position.
    this.setX(this.getX() + this.velX);
    this.setY(this.getY() + this.velY);
  }

  @Override
  void render(Graphics2D g2d) {
    g2d.setColor(Color.ORANGE);
    Shape s = new Ellipse2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    g2d.fill(s);
  }

  @Override
  public void handleCollision(List<GameObject> ls) {
    for (int i = 0; i < ls.size(); i++) {
      GameObject obj = ls.get(i);
      // If the ball collides with the paddle, bounce off the paddle.
      if (obj.isPaddle()) {
        Paddle p = (Paddle) obj;
        if (ICollidable.collidesWith(this, p)) {
          double rel = (p.getX() + (p.getWidth() / 2)) - (this.getX() + (10.f));
          double norm = rel / (p.getWidth() / 2);
          double bounce = norm * (5 * Math.PI / 12);
          this.setVelX(this.getSpeed() * -Math.sin(bounce));
          this.setVelY(-this.getSpeed() * Math.cos(bounce));
        }
      }
      // If the ball collides with a brick, remove the brick and bounce the ball.
      else if (obj.isBrick()) {
        Brick b = (Brick) obj;
        if (ICollidable.collidesWith(this, b)) {
          ls.remove(b);
          this.setVelY(-this.getVelY());
          i--;
        }
      }
    }
  }

  public double getVelX() {
    return velX;
  }

  public double getVelY() {
    return velY;
  }

  public void setVelX(double velX) {
    this.velX = velX;
  }

  public void setVelY(double velY) {
    this.velY = velY;
  }

  public double getSpeed() {
    return this.speed;
  }

  @Override
  public boolean isPaddle() {
    return false;
  }

  @Override
  public boolean isBall() {
    return true;
  }

  @Override
  public boolean isBrick() {
    return false;
  }
}
