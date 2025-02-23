import java.util.List;

interface ICollidable {

  double getX();

  double getY();

  double getWidth();

  double getHeight();

  boolean isPaddle();

  boolean isBall();

  boolean isBrick();

  static boolean collidesWith(ICollidable entity1, ICollidable entity2) {
    return entity1.getX() < entity2.getX() + entity2.getWidth() &&
            entity1.getX() + entity1.getWidth() > entity2.getX() &&
            entity1.getY() < entity2.getY() + entity2.getHeight() &&
            entity1.getY() + entity1.getHeight() > entity2.getY();
  }

  default void handleCollision(List<GameObject> ls) {
    return;
  }
}
