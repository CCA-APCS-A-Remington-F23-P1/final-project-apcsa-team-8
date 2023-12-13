import java.awt.Graphics;
import java.awt.Color;

class Projectile extends MovingThing {
  private int speed;
  
  public Projectile(int x, int y, int width, int height, int s) {
    super(x,y,width,height);
    speed = s;
  }

  public void setSpeed(int s){
    speed=s;
  }
  public int getSpeed(){
    return speed;
  }

  public void move(String direction) {
    if(direction.equals("LEFT")) {
      super.setX(super.getX()-speed);
    }
    if(direction.equals("RIGHT")) {
      super.setX(super.getX()+speed);
    }
  }
  public void draw(Graphics window) {
    window.setColor(Color.BLUE);
    window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
  }
  
}
