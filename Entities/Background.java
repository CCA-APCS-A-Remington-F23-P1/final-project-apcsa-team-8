import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.io.File;
import java.net.URL;


public class Background{

  private final int GROUND_Y;
  private Image i;

public Background(int g, String str){
  GROUND_Y=g;
  try
  {
    URL url = getClass().getResource(str);
    i = ImageIO.read(url);
    
  }
  catch(Exception e)
  {
    try{
      URL url = getClass().getResource("DefaultBackground.jpg");
      i=ImageIO.read(url);
      
    }
    catch(Exception f){
      System.out.println("Error loading images");
      
    }
    //feel free to do something here
  }
}
public Background(){
  GROUND_Y=428;
  try{
    URL url = getClass().getResource("DefaultBackground.jpg");
    i=ImageIO.read(url);
    
  }
  catch(Exception e){
    System.out.println("Error loading images");
  }
}

  public int getGroundY(){
    return GROUND_Y;
  }

  public void draw(Graphics window){
    window.drawImage(i, 0, 0, null);
  }

}
