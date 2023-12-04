import java.awt.Color;
import java.awt.Graphics; 

public class Block //implements Locateable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private Color color;

  public Block()
  {
    xPos = 0;
    yPos = 0;
    width = 100;
    height = 100;
    color = Color.BLACK;
  }
  public Block(int x, int y, int w, int h)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    color = Color.BLACK;
  }
  public Block(int x, int y, int w, int h, Color c)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    color = c;
  }

  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
 
  public int getY(){
    return yPos;
  }   
  public void setY(int y){
    yPos = y;
  }
  public int getX(){
    return xPos;
  }

  public void setX(int x){
    xPos = x;
  }
  
  public void setPos(int x, int y){
    xPos = x;
    yPos = y;
  }
   public Color getC(){
    return color;
  }
  public void setColor(Color col)
  {
    color = col;

  }

  public void draw(Graphics window)
  {
    //window.setColor(Color.WHITE); //was in order to delete
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());

  }


  
  public boolean equals(Block obj)
  {
    if(((xPos == obj.getX())&&(yPos == obj.getY()))&&(width == obj.getWidth())&&(height == obj.getHeight())&&(color == obj.getC())){
      return true;
    }
    return false;
  }   

  public String toString(){
    return xPos + " " + yPos + " " + width + " " + height + " " + color.toString();
  }
}
