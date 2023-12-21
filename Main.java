import java.util.Scanner;
import java.io.File;
public class Main{

    public static void main(String[] args){
      File file = new File("data.txt");
      try {
        Scanner s1 = new Scanner(file);
        Fighter ff1=new Fighter(50,300,120,120,3,s1.nextLine());
        Fighter ff2 = new Fighter(600,300,120,120,3,s1.nextLine());
        String ss=s1.next();

        Initializer i1 = new Initializer(
                ff1,ff2,ss);
      }
      catch(Exception e){
        System.out.println(e);
      }
    
    }

}
