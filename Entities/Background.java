import java.awt.Image;
import java.awt.image.BufferedImage;

public class Background{

  private final int GROUND_Y;
  private Image i;

public Background(int g, Image i){
  GROUND_Y=g;
  this.i=i;
}

  public int getGroundY(){
    return GROUND_Y;
  }

}
