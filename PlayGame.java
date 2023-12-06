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

class PlayGame extends Canvas impliments KeyListener, Runable{

  private Fighter fighter1;
  private Fighter fighter2;
  private ScoreBar scoreBar;
  private String startMsg;
  private String gaveOverMsg;
  private boolean[] keys;
  private BuffedImage back;
  private int frames;
  private int leftLastShot;
  private int rightLastShot;

  public PlayGame(Fighter f1, Fighter f2){
    fighter1=f1;
    fighter2=f2;
    setBackground(Color.black);
    keys = new boolean[8];
    scoreBar = new ScoreBar();
    startMsg = "Ready! Set! Go!";
    gameOverMsg = "Game Over!";
    frames=0;
    leftLastShot=Integer.MIN_VALUE;
    rightLastShot=Integer.MIN_VALUE;
    
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

    frames++;
    graphToBack.setColor(Color.WHITE);
    graphToBack.fillRect(0,0,800,600);
    fighter1.draw(graphToBack);
    fighter2.draw(graphToBack);
    scoreBar.draw(graphToBack);


    if(keys[0])
      fighter1.move("LEFT");
    if(keys[1])
      fighter1.move("RIGHT");
    if(keys[2])
      fighter1.jump();
    if(keys[3]){
      if(frames-leftLastShot>=200){
        fighter1.shoot();
        leftLastShot=frames;
      }
    }
    if(keys[4])
      fighter2.move("LEFT");
    if(keys[5])
      fighter2.move("RIGHT");
    if(keys[6])
      fighter2.jump();
    if(keys[7]){
      if(frames-rightLastShot>=200){
        fighter2.shoot();
        rightLastShot=frames;
      }
    }
  twoDGraph.drawImage(back, null, 0, 0);
}
      
public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[4] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[5] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[6] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[7] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[4] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      keys[5] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[6] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[7] = false;
    }
    repaint();
  }
public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

