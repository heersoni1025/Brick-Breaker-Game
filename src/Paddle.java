import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

  class Paddle extends GameObject implements ICollidable{

  private final KeyAdapter input = new PaddleKeyAdapter(this);
  private static final int width =100;
  private static final int height =20;
  private double velX;
  private double velY;


   Paddle(double x, double y ) {

     super(x,y,width,height);
   }

  @Override
  void update() {
    this.setX(this.getX() + this.getVelX());
    this.setY(this.getY() + this.getVelY());
  }

  @Override
  void render(Graphics2D g2d) {
    g2d.setColor(Color.YELLOW);
    Shape p = new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    g2d.fill(p);
  }

  KeyAdapter getInput() {
    return this.input;
  }


  // ========================= DO NOT MODIFY THE CODE BELOW ========================= //
  private static class PaddleKeyAdapter extends KeyAdapter {

    private Paddle p;

    PaddleKeyAdapter(Paddle p) {
      this.p = p;
    }

    @Override
    public void keyPressed(KeyEvent e) {
      super.keyPressed(e);
      switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          this.p.setVelX(-5);
          break;
        case KeyEvent.VK_RIGHT:
          this.p.setVelX(+5);
          break;
      }
    }

    public void keyReleased(KeyEvent e) {
      super.keyPressed(e);
      switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_RIGHT:
          this.p.setVelX(0);
      }
    }
  }
  @Override
   public boolean isPaddle(){
     return true;
  }
  @Override
  public boolean isBall(){
     return false;
  }
  @Override
  public boolean isBrick(){
     return false;
  }
  public void setVelX(int x){
     this.velX = x;
  }
   public void setVelY(int y){
     this.velY = y;
   }
   public double getVelX(){
     return velX;
   }
   public double getVelY(){
     return velY;
   }
}
