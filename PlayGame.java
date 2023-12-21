import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Image;
import javax.imageio.ImageIO;

public class PlayGame extends Canvas implements KeyListener, Runnable{

  private Fighter fighter1;
  private Fighter fighter2;
  private ScoreBar scoreBar;
  private String startMsg;
  private String gameOverMsg;
  private boolean[] keys;
  private BufferedImage back;
  private int frames;
  private int leftLastShot;
  private int rightLastShot;
  private Background background;
  private AnimationPack fighter1anim;
  private AnimationPack fighter2anim;
  private boolean init = false;
  
  public PlayGame(Fighter f1, Fighter f2, String b){
    fighter1=f1;
    fighter2=f2;
    
    
    
    setBackground(Color.black);
    keys = new boolean[10];
    scoreBar = new ScoreBar();
    startMsg = "Ready! Set! Go!";
    gameOverMsg = "Game Over!";
    frames=0;
    leftLastShot=Integer.MIN_VALUE;
    rightLastShot=Integer.MIN_VALUE;
    if(b.toUpperCase().equals("CARGO")){
      background = new Background(519, "CargoBackground.jpg");
      fighter1.setGround(519);
      fighter2.setGround(519);
    fighter1.setY(399);
    fighter2.setY(399);}
    else if(b.toUpperCase().equals("WATER")){
      background = new Background(312, "WaterBackground.jpg");
      fighter1.setGround(312);
      fighter2.setGround(312);
    fighter1.setY(192);
    fighter2.setY(192);}
    else if(b.toUpperCase().equals("FIELD")){
      background = new Background(434, "FieldBackground.jpg");
      fighter1.setGround(434);
      fighter2.setGround(434);
    fighter1.setY(314);
    fighter2.setY(314);}
    else{
      background = new Background(423, "TableBackground.jpg");
      fighter1.setGround(423);
      fighter2.setGround(423);
    fighter1.setY(303);
    fighter2.setY(303);}
    
    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window){
    Graphics2D twoDGraph = (Graphics2D)window;
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));
    Graphics graphToBack = back.createGraphics();

  //initialize animations
    if (init==false){
      fighter1anim = new AnimationPack("Ryu", graphToBack, fighter1);
      fighter2anim = new AnimationPack("Ken", graphToBack, fighter2);
      init = true;
    }
    
  // 

    
    //frames++;
    //graphToBack.setColor(Color.WHITE);
    //graphToBack.fillRect(0,0,800,600);
    background.draw(graphToBack);
    fighter1.setImage(fighter1anim.runAnimation(frames));
    fighter2.setImage(fighter2anim.runAnimation(frames));
    fighter1.draw(graphToBack);
    fighter2.draw(graphToBack);

    if(((fighter1.didCollide(fighter1.getPunch()))&&(fighter1.getAttacking()))||((fighter1.didCollide(fighter2.getPunch()))&&(fighter2.getAttacking()))){
      scoreBar.p1Hurt(1);
      scoreBar.p1Score(this);
    }
    if((fighter1.didCollide(fighter1.getProjectile()))&&(fighter1.getProjectile().isActive())){
      scoreBar.p1Hurt(30);
      scoreBar.p1Score(this);
      fighter1.getProjectile().setActive(false);
    }
    if((fighter1.didCollide(fighter2.getProjectile()))&&(fighter2.getProjectile().isActive())){
      scoreBar.p1Hurt(30);
      scoreBar.p1Score(this);
      fighter2.getProjectile().setActive(false);
    }

    if(((fighter2.didCollide(fighter1.getPunch()))&&(fighter1.getAttacking()))||((fighter2.didCollide(fighter2.getPunch()))&&(fighter2.getAttacking()))){
      scoreBar.p2Hurt(1);
      scoreBar.p2Score(this);
    }
    if((fighter2.didCollide(fighter1.getProjectile()))&&(fighter1.getProjectile().isActive())){
      scoreBar.p2Hurt(30);
      scoreBar.p2Score(this);
      fighter1.getProjectile().setActive(false);
    }
    if((fighter2.didCollide(fighter2.getProjectile()))&&(fighter2.getProjectile().isActive())){
      scoreBar.p2Hurt(30);
      scoreBar.p2Score(this);
      fighter2.getProjectile().setActive(false);
    }

    

  
    scoreBar.draw(graphToBack);


    //Animations

    


    
    if(keys[0]){
      fighter1.move("LEFT");
      fighter1anim.setCurrentAnimation("walk");
    }
    if(keys[1]){
      fighter1.move("RIGHT");
      fighter1anim.setCurrentAnimation("walk");
    }
    if(keys[2]){
      fighter1.move("UP");
      fighter1anim.setCurrentAnimation("jump");
    }
    
    if(keys[3]){
      if(true){
        fighter1.shoot();
        leftLastShot=frames;
        fighter1anim.setCurrentAnimation("shoot");
      }
    }
    if(keys[4]){
      if(true){
        fighter1.setAttacking(true);
        leftLastShot=frames;
        fighter1anim.setCurrentAnimation("melee");
      }
    }
    if(keys[5]){
      fighter2.move("LEFT");
      fighter2anim.setCurrentAnimation("walk");
    }
    if(keys[6]){
      fighter2.move("RIGHT");
      fighter2anim.setCurrentAnimation("walk");
    }
      
    if(keys[7]){
      fighter2.move("UP");
      fighter2anim.setCurrentAnimation("jump");
    }
      
    if(keys[8]){
      if(true){
        fighter2.shoot();
        rightLastShot=frames;
        fighter2anim.setCurrentAnimation("shoot");
      }
    }
    if(keys[9]){
      if(true){
        fighter2.setAttacking(true);
        rightLastShot=frames;
        fighter2anim.setCurrentAnimation("melee");
      }
    }
    
  twoDGraph.drawImage(back, null, 0, 0);
}
      
public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = true;
      fighter1anim.setCurrentAnimation("walk");
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = true;
      fighter1anim.setCurrentAnimation("walk");
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = true;
      fighter1anim.setCurrentAnimation("jump");
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = true;
      fighter1anim.setCurrentAnimation("shoot");
    }
    if (e.getKeyCode() == KeyEvent.VK_X)
    {
      keys[4] = true;
      fighter1.setAttacking(true);
      fighter1anim.setCurrentAnimation("melee");
    }



    if (e.getKeyCode() == KeyEvent.VK_J)
    {
      keys[5] = true;
      fighter2anim.setCurrentAnimation("walk");
    }
    if (e.getKeyCode() == KeyEvent.VK_L)
    {
      keys[6] = true;
      fighter2anim.setCurrentAnimation("walk");
    }
    if (e.getKeyCode() == KeyEvent.VK_I)
    {
      keys[7] = true;
      fighter2anim.setCurrentAnimation("jump");
    }
    if (e.getKeyCode() == KeyEvent.VK_K)
    {
      keys[8] = true;
      fighter2anim.setCurrentAnimation("shoot");
    }
    if (e.getKeyCode() == KeyEvent.VK_M)
    {
      keys[9] = true;
      fighter2.setAttacking(true);
      fighter2anim.setCurrentAnimation("melee");
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = false;
      fighter1anim.setCurrentAnimation("idle");
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = false;
      fighter1anim.setCurrentAnimation("idle");
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = false;
    
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = false;
    
    }
    if (e.getKeyCode() == KeyEvent.VK_X)
    {
      keys[4] = false;
      fighter1.setAttacking(false);
    }
    if(e.getKeyCode() == KeyEvent.VK_J){
      keys[5] = false;
      fighter2anim.setCurrentAnimation("idle");
    }
    if (e.getKeyCode() == KeyEvent.VK_L)
    {
      keys[6] = false;
      fighter2anim.setCurrentAnimation("idle");
    }
    if (e.getKeyCode() == KeyEvent.VK_I)
    {
      keys[7] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_K)
    {
      keys[8] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_M)
    {
      keys[9] = false;
      fighter2.setAttacking(false);
    }
    repaint();
  }
public void keyTyped(KeyEvent e)
  {
    //ignore
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        frames++;
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
    public void resetStuff(int i){
      fighter1.setX(50);
      fighter2.setX(600);
      if (i==1){
        fighter1anim.setCurrentAnimation("death");
        fighter2anim.setCurrentAnimation("win");
      }
      if (i==2){
        fighter2anim.setCurrentAnimation("death");
        fighter1anim.setCurrentAnimation("win");
      }
      fighter1.setAttacking(false);
      fighter2.setAttacking(false);
      fighter1.getProjectile().setActive(false);
      fighter2.getProjectile().setActive(false);
    }
  
  
  
}



