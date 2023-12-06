import java.awt.Graphics;
import java.awt.Color;

class Fighter extends MovingThing {
  private int speed;
  private int health = 100; 
  
  private final int groundY = 300;
  private float yVelocity = 0;
  private boolean isOnGround = true;
  private float gravity = 0.5f;
  
  public Fighter(int x, int y, int width, int height, int s) {
    super(x,y,width,height);
    speed = s;
  }

  public void move(String direction) {
    if(direction.equals("LEFT")) 
      super.setX(super.getX()-speed);
    
    else if(direction.equals("RIGHT")) 
      super.setX(super.getX()+speed);
    
    else if( direction.equals("UP") && isOnGround ) {
      yVelocity = 2.0f;
      isOnGround = false;
    }
      
  }
  public void moveAndDraw(Graphics window) {
    window.setColor(Color.GREEN);
    window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());

    if(!isOnGround) {
      yVelocity-=gravity;
      super.setX( super.getX() + yVelocity );
      if(super.getY() >= groundY()) {
        isOnGround = true;
        super.setY(groundY());
        yVelocity = 0;
      }
    }
  }
  
}
