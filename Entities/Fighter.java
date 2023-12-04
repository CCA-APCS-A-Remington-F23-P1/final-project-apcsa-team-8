
class Fighter extends MovingThing {
  private int speed;
  private int health = 100;  
  
  public Fighter(int x, int y, int width, int height, int s) {
    super(x,y,width,height);
    speed = s;
  }
}
