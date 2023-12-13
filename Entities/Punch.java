import java.awt.Color;
import java.awt.Graphics;

public class Punch extends MovingThing {
  private int speed;
  private boolean isActive;
  private String direction;
  private int distanceTraveled;
  
  public Punch(int x, int y, int width, int height, int s) {
    super(x, y, width, height);
    speed = s;
    isActive = true;
    direction = "";
    distanceTraveled = 0;
  }
  
  public void setDirection(String d) {
    direction = d;
  }
  
  public void move() {
    if (direction.equals("LEFT")) {
      super.setX(super.getX() - speed);
    } else if (direction.equals("RIGHT")) {
      super.setX(super.getX() + speed);
    }
    distanceTraveled += speed;
    if (distanceTraveled > 100) {
      isActive = false;
    }
  }
  
  public boolean isActive() {
    return isActive;
  }
  
  public void draw(Graphics window) {
    if (isActive) {
      window.setColor(Color.RED);
      window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
  }
}
