import java.awt.Graphics;
import java.awt.Color;

public class Projectile extends MovingThing {
  private int speed;
  private boolean isActive;
  private String direction;
  
  public Projectile(int x, int y, int width, int height, int s) {
    super(x,y,width,height);
    speed = s;
    isActive = false;
  }
  @Override
  public void move(String direction) {
    if(direction.equals("LEFT")) {
      super.setX(super.getX()-speed);
    }
    if(direction.equals("RIGHT")) {
      super.setX(super.getX()+speed);
    }
  }
  @Override
  public int getSpeed(){
    return speed;
  }
  @Override
  public void setSpeed(int s){
    speed=s;
  }

  public void setActive(boolean b) {
    isActive = b;
  }

  public boolean isActive() {
    return isActive;
  }
  
  public void setDirection(String d) {
    direction = d;
  }
  
  public void draw(Graphics window) {
    if(isActive) {
      window.setColor(Color.BLUE);
      window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
  }
  
}
