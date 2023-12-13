import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

class Fighter extends MovingThing {
  private int speed;
  private int health = 100; 
  private Projectile p;
  private String direction;
  private boolean isAttacking = false;
  
  private final int groundY = 300;
  private float yVelocity = 0;
  private boolean isOnGround = true;
  private float gravity = 0.5f;
  private String name;
  
  public Fighter(int x, int y, int width, int height, int s, String n) {
    super(x,y,width,height);
    speed = s;
    name=n;
    p = new Project(x,y,30,30,1);
  }

  public int getHealth() {
    return health;
  }
  public void setHealth(int h) {
    health = h;
  }

  public boolean getAttacking() {
    return isAttacking;
  }
  public void setAttacking(boolean a) {
    isAttacking = a;
  }
  public String getName(){
    return name;
  }

  public void setName(String n){
    name=n;
  }
  @Override
  public void draw(Graphics window) {
    window.setColor(Color.GREEN);
    window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    p.draw(window);

    if(!isOnGround) {
      yVelocity-=gravity;
      super.setX( super.getX() + yVelocity );
      if(super.getY() >= groundY()) {
        isOnGround = true;
        super.setY(groundY());
        yVelocity = 0;
      }
    }

    if(p.isActive())
      p.move(direction);
  }

  public void move(String direction) {
    if(!isAttacking) {
      if(direction.equals("LEFT")) {
        super.setX(super.getX()-speed);
        this.direction = "LEFT";
      }
      else if(direction.equals("RIGHT")) {
        super.setX(super.getX()+speed);
        this.direction = "RIGHT";
      }
      else if( direction.equals("UP") && isOnGround ) {
        yVelocity = 2.0f;
        isOnGround = false;
      }
    }
  }

  public void shoot() {
    if(!isAttacking) {
      p.setActive(true);
      p.setDirection(direction);
    }
  }
}
