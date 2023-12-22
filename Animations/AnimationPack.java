import java.io.File; 
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class AnimationPack{

  private ArrayList<Image> idleFrames = new ArrayList<Image>();
  private ArrayList<Image> walkFrames = new ArrayList<Image>();
  private ArrayList<Image> jumpFrames = new ArrayList<Image>();
  private ArrayList<Image> shootFrames = new ArrayList<Image>();
  private ArrayList<Image> deathFrames = new ArrayList<Image>();
  private ArrayList<Image> winFrames = new ArrayList<Image>();
  private ArrayList<Image> meleeFrames = new ArrayList<Image>();
  
  private String folder;
  private String currentFramesString = "idle";
  private ArrayList<Image> currentFrames;
  private Graphics window;
  private int frameNumber = 0;
  private Fighter fighter;
  private Image image = null;
  private boolean loop = true;
  private int i = 1;

  private boolean imgReset = false;
  private boolean animFinished = false;
  
  public AnimationPack(String folder, Graphics g, Fighter f){ // such as "Ryu"
    
    this.folder = folder;
    window = g;
    fighter = f;

    while (loop) { // idle animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/idle" + "/idle" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/idle" + "/idle" + i + ".png");
        i = 1;
        break;
      }
      idleFrames.add(image);
    }
    while (loop) { // walk animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/walk" + "/walk" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/walk" + "/walk" + i + ".png");
        i = 1;
        break;
      }
      walkFrames.add(image);
    }
    while (loop) { // jump animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/jump" + "/jump" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/jump" + "/jump" + i + ".png");
        i = 1;
        break;
      }
      jumpFrames.add(image);
    }
    while (loop) { // shoot animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/shoot" + "/shoot" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/shoot" + "/shoot" + i + ".png");
        i = 1;
        break;
      }
      shootFrames.add(image);
    }
    while (loop) { // melee animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/melee" + "/melee" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/melee" + "/melee" + i + ".png");
        i = 1;
        break;
      }
      meleeFrames.add(image);
    }
    while (loop) { // death animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/death" + "/death" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/death" + "/death" + i + ".png");
        i = 1;
        break;
      }
      deathFrames.add(image);
    }
    while (loop) { // win animpack
      try
      {
        URL url = getClass().getResource("Animations/" + folder + "/win" + "/win" + i + ".png");
        image = ImageIO.read(url);
        i++;
      }
      catch(Exception e)
      {
        System.out.println("Error: could not find image directory | Animations/" + folder + "/win" + "/win" + i + ".png");
        i = 1;
        break;
      }
      winFrames.add(image);
    }
  
    currentFrames = idleFrames;
  }
  /*
  public void flipImages(){
    flip(idleFrames);
    flip(walkFrames);
    flip(jumpFrames);
    flip(shootFrames);
    flip(deathFrames);
    flip(winFrames);
    flip(meleeFrames);
  }
//yo my fault imma fix this rq

  
  private void flip(ArrayList<Image> images){
    for (Image x : images) {
      x.rotateFlip(RotateFlipType.RotateNoneFlipX);
      x.save();
    }
  }
  */
  
  public void setCurrentAnimation(String animation){
    System.out.println("set animation to : " + animation);
    currentFramesString = animation;
    if (animation.equals("idle")){
      currentFrames = idleFrames;
      return;
    }
    if (animation.equals("walk")){
      currentFrames = walkFrames;
      return;
    }
    if (animation.equals("jump")){
      currentFrames = jumpFrames;
      return;
    }
    if (animation.equals("shoot")){
      currentFrames = shootFrames;
      return;
    }
    if (animation.equals("melee")){
      currentFrames = meleeFrames;
      return;
    }
    if (animation.equals("death")){
      currentFrames = deathFrames;
      return;
    }
    if (animation.equals("win")){
      currentFrames = winFrames;
      return;
    }
    //System.out.println("Error: could not find animation type: " +animation);
  }
 
  public Image runAnimation(int frames){
   
  
    if (frames%10==0 && currentFrames.size()>frameNumber){

      
      if (frameNumber == currentFrames.size()-1){
        frameNumber = -1; 
        if (currentFramesString.equals("shoot")){
          setCurrentAnimation("idle");
        }
        if (currentFramesString.equals("melee")){
          setCurrentAnimation("idle");
        }
        if (currentFramesString.equals("jump")){
          setCurrentAnimation("idle");
        }
        if (currentFramesString.equals("win")){
          frameNumber=currentFrames.size()-2;
        }
        if (currentFramesString.equals("win")){
          frameNumber=currentFrames.size()-2;
        }
      }

      
      frameNumber++;
    }
    if(frameNumber<currentFrames.size())
      return currentFrames.get(frameNumber);
    return currentFrames.get(0);
  }
}
