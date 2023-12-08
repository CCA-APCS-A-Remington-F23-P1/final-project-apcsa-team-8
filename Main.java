import java.util.Scanner;
import java.io.File;
public class Main{
  
    public static void main(String[] args){
      File file = new File("data.txt");
      Scanner s1 = new Scanner(file);

      PlayGame p1 = new PlayGame(new Fighter(50,500,50,100,3,s1.nextLine()),new Fighter(700,500,50,100,3,s1.nextLine()));
    }
  
}
