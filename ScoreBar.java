import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
import java.util.Random;

public class ScoreBar {
  private int player1Score;
  private int player2Score;
  private int player1Health;
  private int player2Health;



public ScoreBar(){
  player1Score = 0;
  player2Score = 0;
  player1Health = 100;
  player2Health = 100;
}


  public void setP1Score(int s)
  {
       player1Score = s;
  }

  public void setP2Score(int s)
  {
    player2Score = s;
  }

  public int getP1Score(){
    return player1Score;
  }
  public int getP2Score(){
    return player2Score;
  }
   
  
  
  
  public void draw(Graphics window)
   {
     window.setColor(Color.WHITE);
     window.setFont(new Font("TAHOMA",Font.BOLD,18));
     window.drawString("Player 1 Score: " + player1Score, 50, 50);
     window.drawString("Player 2 Score: " + player2Score, 50, 80);
     window.drawString("Player 1 Health: " + player1Health, 50, 110);
     window.drawString("Player 2 Health: " + player2Health, 50, 140);
   }


     
/*public ScoreBar(int h1, int h2){
  player1Score = 0;
  player2Score = 0;
  player1Health = h1;
  player2Health = h2;
}
  */

public int p1Score(PlayGame pg){
if(player1Health <= 0){
player2Score++;
  player1Health = 100;
  pg.resetStuff(1);
}
  else{
    return player2Score;
  }
  return player2Score;
}

  public int p2Score(PlayGame pg){
if(player2Health <= 0){
player1Score++;
  player2Health = 100;
  pg.resetStuff(2);
}
  else{
    return player1Score;
  }
  return player1Score;
}

public void p1Hurt(int n){
  player1Health-=n;
}
public void p2Hurt(int n){
  player2Health-=n;
}
  
}


