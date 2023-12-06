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
}

public ScoreBar(int h1, int h2){
  player1Score = 0;
  player2Score = 0;
  player1Health = h1;
  player2Health = h2;
}

public int Score(){
if(player1Health <= 0){
player2Score++;
}
  if(player2Health <= 0){
player1Score++;
  }
}








}

 







    

