import java.awt.Graphics;
import java.awt.Color;

class Fighter extends MovingThing {
  private int speed;
  private int health = 100;  
  
  public Fighter(int x, int y, int width, int height, int s) {
    super(x,y,width,height);
    speed = s;
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
    window.setColor(Color.GREEN);
  }
  
}
