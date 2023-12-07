import java.awt.Image;
import java.awt.image.BufferedImage;

public class Background{

  private final int GROUND_Y;
  private image i;

public Background(int g, image i){
  GROUND_Y=g;
  this.i=i;
}

  public int getGroundY(){
    return GROUND_Y;
  }

}
