import java.util.*;
import java.io.*;
public class MadLibsTest{
   public static void main(String args[]) throws FileNotFoundException{
      int i =0;
      String name = "";
      while(i<5){ 
          Scanner scanner = new Scanner(System.in);
          System.out.print("Please enter your full name: ");
          name = scanner.nextLine();
          System.out.println(name);
          i++;
      }
   }
}