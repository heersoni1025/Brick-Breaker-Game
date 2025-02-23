import java.awt.*;

abstract class GameObject implements ICollidable{
    private double x=0;
    private double y =0;
    private double width = 0;
    private double height = 0;



    GameObject(double x, double y, double width, double height){
    this.x = x;
    this.y=y;
    this.width = width;
    this.height = height;



    }
    abstract void update();

    abstract void render(Graphics2D g2d);

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

}
