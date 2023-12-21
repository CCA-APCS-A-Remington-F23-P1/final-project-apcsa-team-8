import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;


public class Fighter extends MovingThing {
  private int speed;
  private int health = 100; 
  private Projectile p;
  private Punch punch;
  private String direction;
  private boolean isAttacking = false;

  private int groundY = 400;
  private float yVelocity = 0;
  private boolean isOnGround = true;
  private float gravity = 0.5f;
  private String name;

  private Image image;
  
  public Fighter(int x, int y, int width, int height, int s, String n) {
    super(x,y,width,height);
    speed = s;
    name=n;
    p = new Projectile(x,y,30,30,10);
    punch = new Punch(x+width,y,30,height,s);
    direction = "RIGHT";
  }

  public int getHealth() {
    return health;
  }
  public void setHealth(int h) {
    health = h;
  }
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int s) {
    speed = s;
  }
  public void setGround(int g){
    groundY=g;
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

  public Punch getPunch() {
    return punch;
  }

  public Projectile getProjectile(){
    return p;
  }


  public void setImage(Image s){
    this.image = s;
  }
  public Image getImage(){
    return image;
  }
  public void setDirection(String d){
    direction = d;
  }
  
  @Override
  public void draw(Graphics window) {


    window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    //window.setColor(Color.GREEN);
    //window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());

    if(!isOnGround) {
      yVelocity-=gravity;
      super.setY((int) (super.getY() - yVelocity ));
      if(super.getY()+super.getHeight() >= groundY) {
        isOnGround = true;
        super.setY(groundY-super.getHeight());
        yVelocity = 0;
      }
      p.draw(window);
    }
    if(isAttacking){
      if(this.direction.equals("RIGHT"))
        punch.setX(super.getX()+super.getWidth());
      else if(this.direction.equals("LEFT"))
        punch.setX(super.getX()+80-super.getWidth());
      punch.draw(window);
    }
    if(p.isActive()) {
     
      p.move(direction);
      p.draw(window);
    }
  }

  public void move(String direction) {
    if(!isAttacking) {
      if(direction.equals("LEFT")) {
        super.setX(super.getX()-speed);
        this.direction = "LEFT";
        punch.move("LEFT");
      }
      else if(direction.equals("RIGHT")) {
        super.setX(super.getX()+speed);
        this.direction = "RIGHT";
        punch.move("RIGHT");
      }
      else if( direction.equals("UP") && isOnGround ) {
        yVelocity = 10.0f;
        isOnGround = false;
      }
    }
    
  }

  

  public void shoot() {
    
    if(!isAttacking) {
      p.setActive(true);
      p.setDirection(direction);
      if(direction.equals("RIGHT"))
      p.setPos(super.getX()+super.getWidth(), super.getY()+super.getHeight()/2);
      else if(direction.equals("LEFT"))
        p.setPos(super.getX()-super.getWidth()+80, super.getY()+super.getHeight()/2);
    }
  }
}
d setAttacking(boolean a) {
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
      super.setX((int)( super.getX() + yVelocity ));
      if(super.getY() >= groundY) {
        isOnGround = true;
        super.setY(groundY);
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
