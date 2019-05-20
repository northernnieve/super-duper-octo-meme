// Evan Ma
// 4/4/2019
// CSE142
// TA: Dylan Hayre (i forgot his name tbh sorry mate, it's section AC)
// Assignment #2
//
// This program will attempt to print out that rocket thing

public class DrawRocket{
   static int size = 3;
   public static void main(String[] args){
      drawRocketShip();
      
      // in this instance, int size is used as the constant size
      
   }  
   
   public static void drawRocketShip(){
   // drawRocketShip is the union of all the other
   // methods I've used i.e. the table of content
   // for how this rocket is printed out on console 
      printTop();
      printTransition();
      
      printDiamondTop();
      printDiamondBottom();
      
      printTransition();
      
      printDiamondBottom();
      printDiamondTop();
      
      printTransition();
      
      printTop();
   }
   public static void printTop(){
      //printTop is literally a method used to print the 
      //head of the rocket, and the flames of the rocket
      //I realized that the head is the exact same as the flame 
      //once I finished writing it.
      
      //this comment is left as a reminder that printTop
      //is used to create the flames at the end as well.      
      for(int slashCount = 1; slashCount < 2*size; slashCount++){
         //slashCount counts the amount of slashes in a single line
         int spaceCount = 2*size - slashCount;
         //spaceCount counts the amount of space in a given line
         for(int j = 0; j < spaceCount; j++){
            System.out.print(" ");
         }  
         for(int k = 0; k < slashCount; k++){
            System.out.print("/");
         }
         System.out.print("**");
         for(int m = 0; m < slashCount; m++){
            System.out.print("\\");
         }  
         //last three for-loop prints out the corrosponding slashes/spaces
         //given by slashCount and spaceCount
         System.out.println();
      }
   }
   public static void printDiamondTop(){
   //this is the upper triange part of the diamond on the rocket
   //separated out by dots.
   
      for(int lineCount = 1; lineCount <= size; lineCount++){ 
      //line count, start from 1 (the first line with the first triangle)
      //up to (int size)th line (in our case, 3rd line)  
         System.out.print("|");
         for(int j = 0; j < 2; j++){ 
         //simply mirrors the construction
         //the next three for-loops grants us the left triangle. 
         //Using for-loop j, we get the triangle on the right 
                   
            for(int dotLeft = size - lineCount; dotLeft > 0; dotLeft--){
               System.out.print(".");
               //for loop here prints out (size-lineCount) amount of dots
               //decreases the amount of dots printed as lineCount++
            }
            
            for(int carrotMid = 1; carrotMid-1 < lineCount; carrotMid++){
               System.out.print("/\\"); 
               //carrotMid is a counter for amount of carrots in a line
               //increases as lineCount++ increases
               //A question you might as is "can I simplify this code by equating carrotMid with lineCount?"
               //The answer is "no". Since carrotMid-for loop is happening, lineCount is
               //not changing. Therefore we end up with an infinite loop.    
            }
            
            for(int dotRight = size - lineCount; dotRight > 0; dotRight--){
               System.out.print(".");
               //right dots, same with left dots
            }
         }  
         System.out.print("|");
         System.out.println();
      }  
   }
   public static void printDiamondBottom(){
      for(int lineCount = 0; lineCount < size; lineCount++){ 
      // not gonna lie, this is literally a stright up copy and paste from 
      // printDiamondTop, except I swapped the initial conditions between
      // dotLeft and carrotMid
      // see printDiamondTop for notes
         System.out.print("|");
         for(int j = 0; j < 2; j++){ 
                         
            for(int dotLeft = 1; dotLeft < lineCount+1; dotLeft++){
               System.out.print(".");//left dots
            }
            
            for(int carrotMid = size - lineCount; carrotMid > 0; carrotMid--){
               System.out.print("\\/"); //carrot in the middle
            }
            
            for(int dotRight = 1; dotRight < lineCount+1; dotRight++){
               System.out.print(".");//right dots
            }
         }  
         System.out.print("|");
         System.out.println();
      }  
   }
 
   public static void printTransition(){
      //prints that line between every parts
      //do I even have to explain this bit?
      //this is the easiest part of the code to read 
      //ok fine ill explain it
      
      System.out.print("+"); //prints "+" in the beginning
      for(int i = 0; i < size; i++){
         System.out.print("=*=*"); //prints out "=*=*" (int size)th times
      }
      System.out.print("+"); //ending with "+"
      System.out.println(); //next line
      
      //there, are you happy now, does this satisify you 
   }

}