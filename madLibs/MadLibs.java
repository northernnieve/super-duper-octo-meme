// Evan Ma
// 5/15/2019
// CSE142
// TA: Dylan Hayre (I liek puppies)
// Assignment #6
// This program will attempt to play a game of Mad Libs

import java.applet.*;
import java.util.*;
import java.io.*;
public class MadLibs extends Applet{
   public static void main(String args[]) throws FileNotFoundException{
      
      Scanner console = new Scanner(System.in);
      
      introduction(); 
      
      createViewQuit(console);

   }
   public static void introduction(){
      //usual introduction
      System.out.println("Welcome to the game of Mad Libs");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   public static boolean createViewQuit(Scanner console) throws FileNotFoundException{
   //the main menu, what would the player like to do today?
      String choice = "";
      boolean isDone = true; //an efficient way of breaking the while loop
      while(isDone){
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         choice = console.next(); //looks for users' input
         if (!choice.equalsIgnoreCase("q")){ 
            if(choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("v")){
                  if(choice.equalsIgnoreCase("c")){
                     createStory(console); //if chosen c, start up creation of story
                  } else if (choice.equalsIgnoreCase("v")) {
                     viewStory(console);  // if chosen v, start up the view story
                  }
            }
         } else {
            isDone = false;
         }
      }
      return false;
   }
   public static void createStory(Scanner console) throws FileNotFoundException{
      //construction of the story here
      System.out.print("Input file name: ");
      File inputFileName = new File(console.next());
      
         while(!inputFileName.exists()){   
            System.out.print("File not found. Try again: ");
            inputFileName = new File(console.next());
         }
                  
      System.out.print("Output file name: ");
      String newFileName = console.next();
      console.nextLine(); 
      //TIL console.next from before doesn't read the "enter" key prompt, so this line consumes that enter prompt
      System.out.println();
      
      Scanner promptRead = new Scanner(inputFileName);
      PrintStream promptWrite = new PrintStream(new File(newFileName));    
      
      while(promptRead.hasNextLine()){
         String readLine = promptRead.nextLine();
         Scanner scanLine = new Scanner(readLine); //scans through the string readLine
            //so, TIL scanner is a static entity that only reads whatever readLine has at the time of excecution
            //it does not change when readLine changes, so to counter this, we update scanLine in the while loop
         while(scanLine.hasNext()){
            String readTokenInLine = scanLine.next();
            if(readTokenInLine.startsWith("<") && readTokenInLine.endsWith(">") && readTokenInLine.length() > 3){
               /*find an instance of a string that has brackets "<>" and has at least a few characters inside it*/
               //take that token within the line interested, take out the brackets, and spit it out as a question
               readTokenInLine = readTokenInLine.substring(1, readTokenInLine.length()-1);
               readTokenInLine = readTokenInLine.replace("-", " ");
               readTokenInLine = readTokenInLine.toLowerCase();
                  //take user's input, do fancy things like take out the - and change to a/an if noun
                  if(readTokenInLine.startsWith("a") || readTokenInLine.startsWith("e") || readTokenInLine.startsWith("i") || readTokenInLine.startsWith("o") || readTokenInLine.startsWith("u")){
                     System.out.print("Please type an " + readTokenInLine + ": ");
                  } else {
                     System.out.print("Please type a " + readTokenInLine + ": ");
                  }
                  String userInput = console.nextLine();
                  promptWrite.print(userInput.replace("-", " ") + " ");
                  
               //write that out in txt file using printStream
               
            } else {
            promptWrite.print(readTokenInLine + " ");
            //write that out in txt file using printStream
            }
         } 
         if(scanLine.hasNext() == false){
            promptWrite.println(); //go next line at certain points as indicated in txt file
         }
         
      }
      System.out.println("Your mad-lib has been created!"); 
         
   }
   public static void viewStory(Scanner console) throws FileNotFoundException{
      //print out the story here
      System.out.print("Input file name: ");
      String fileName = console.next();
      File finalStory = new File(fileName);
      
         while(!finalStory.exists()){   
            System.out.print("File not found. Try again: ");
            finalStory = new File(console.next());
         }//usual looking for existing file
         
      System.out.println();
      
      Scanner viewOnly = new Scanner(finalStory);
      String newLine = ""; //blank instance of newLine, which is going to be a placeholder
         
         while(viewOnly.hasNextLine()){
            newLine = viewOnly.nextLine();
            System.out.println(newLine);
         }//simple line to jsut print everything out
      
      System.out.println();
   }
}