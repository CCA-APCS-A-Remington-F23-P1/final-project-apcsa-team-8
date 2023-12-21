import javax.swing.JFrame;
import java.awt.Component;

public class Initializer extends JFrame{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public Initializer(Fighter f1, Fighter f2, String b)
  {
    super("Initializer");
    setSize(WIDTH,HEIGHT);

    PlayGame theGame = new PlayGame(f1,f2,b);
    ((Component)theGame).setFocusable(true);

    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
