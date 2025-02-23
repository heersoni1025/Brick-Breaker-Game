import java.awt.*;
import java.awt.geom.Rectangle2D;

 class Brick extends GameObject implements ICollidable {

   private static final int width =50;
   private static final int height =20;
  Brick(double x, double y) {
    super(x,y,50,20);
  }

  @Override
  void update() {
  }

  @Override
  void render(Graphics2D g2d) {
    g2d.setColor(Color.RED);
    // Draw the brick itself.
    Shape s = new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    g2d.fill(s);
    // Draw outline for bricks
    g2d.setColor(Color.YELLOW);
    g2d.draw(s);
  }
   @Override
   public boolean isPaddle(){
     return false;
   }
   @Override
   public boolean isBall(){
     return false;
   }
   @Override
   public boolean isBrick(){
     return true;
   }
}
