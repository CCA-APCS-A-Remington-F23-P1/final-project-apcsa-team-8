import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
public class ProgressBar extends Block{

  private Block maxHealth;
  private Block currentHealth;
  private int max;
  private int current;

  public ProgressBar(int x, int y, int w, int h, Color c, int max){ //boolean b){
    // if (!b){ // false if progress goes down left => right
    // maxHealth = new Block(x,y,w,h,c);
    // currentHealth = maxHealth;
    // }
 //   if (b){ // true if progress goes down right => left
    maxHealth = new Block(x,y,w,h,c);
    currentHealth = maxHealth;
  //  }
    this.max = max;
    
  }

  public int getCurrent(){
    return current;
  }
  public void setCurrent(int s){
    current = s;
    currentHealth.setWidth((int)(maxHealth.getWidth()*(current/max)));
  }
  public int getMax(){
    return max;
  }
  public void setMax(int s){
    max = s;
  }

  public void update(Graphics window){
    maxHealth.draw(window);
    currentHealth.draw(window);
  }
}
