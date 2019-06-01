// Evan Ma
// 5/15/2019
// CSE142
// TA: Dylan Hayre (I liek puppies)
// Assignment #7
// This program will attempt to build a personality test from a set
// of given data

import java.applet.*;
import java.util.*;
import java.io.*;
public class Personality{
public static final int DIMENSIONS = 4; //class constant for the code
public static void main(String args[]) throws FileNotFoundException{
   
   //in theory, this is what's happeing on console
   System.out.println("This program processes a file of answers to the");
   System.out.println("Keirsey Temperament Sorter.  It converts the");
   System.out.println("various A and B answers for each person into");
   System.out.println("a sequence of B-percentages and then into a");
   System.out.println("four-letter personality type.");
   
   readWrite(); //input file name and output file name happen here
   
   

}
public static void readWrite() throws FileNotFoundException{
   //the method that does all the writing and reading from txt file to another
   
   Scanner console = new Scanner(System.in);
   System.out.print("input file name? ");
   File inputFile = new File(console.nextLine());
   Scanner inputRead = new Scanner(inputFile);
   System.out.print("output file name? ");
   PrintStream outputWrite = new PrintStream(new File(console.nextLine()));
   // creates a reader for input file, and a pen for output file to write
   
   while(inputRead.hasNextLine()){
      String writeToken = inputRead.nextLine();
      outputWrite.print(writeToken + ": "); //write out name
      
      writeToken = inputRead.nextLine();
      int[] calculateTotalCounts = calculateTotalCounts(writeToken.toUpperCase());
      int[] calculatePercentage = calculatePercentage(calculateTotalCounts);
      outputWrite.print(Arrays.toString(calculatePercentage)); //write out percentage
      
      String personalityOutput = assignLetterAndOutput(calculatePercentage);
      outputWrite.print(" = " + personalityOutput);
      outputWrite.println(); //write out personality trait
   }
   
   
   
   
}

public static int[] calculateTotalCounts(String listOfInput){
   //calculates the total counts in each dimension, place them into a 8x1 array called countsTotal and spit that out
   // countsTotal->> instance 0-3: the amount of B answers for each dimension, respectively
   //                instance 4-7: the amount of blank answers for each dimension, respectively
   
   //the sectionNumber-for loop and charNumber-for loop is similar
   //to how we read matrices in math: sectionNumber divides out the group questions from the big string
   //                                 tokenCount writes out the answers in each group into a new string 
   
   int[] countsTotal = new int[2*DIMENSIONS];
   for(int sectionNumber = 0; sectionNumber < 10; sectionNumber++){
      String extractedInputs = ""; 
      for(int charNumber = 0; charNumber < 7; charNumber++){      
         extractedInputs += listOfInput.charAt((sectionNumber) * 7 + charNumber);   
      }   
      //scans through and search for "B" answers. if there exists one, increase 
      //countsTotal[i] by 1 
      for(int tokenCount = 0; tokenCount < 7; tokenCount++){
         for(int j = -1; j < 3; j++){
            if (extractedInputs.charAt(tokenCount) == "B".charAt(0) && 2*j < tokenCount && tokenCount < 2*j+3){
                countsTotal[j+1]++;  //count of questions in each section answered
            } 
            if (extractedInputs.charAt(tokenCount) == "-".charAt(0) && 2*j < tokenCount && tokenCount < 2*j+3){
               countsTotal[j+5]++; //how many question in each section not answered
               j = 3; //exit out the for loop if there is a "-"
            }
         }                      
      }
   } 
   return countsTotal;
}

public static int[] calculatePercentage(int[] countsTotal){
   //takes the set of numbers from extractListOfStringInputs() and calculate the percentages
   int[] percentageTotal = new int[DIMENSIONS];
   
   int questionTotal = 10;
   for(int i = 0; i < DIMENSIONS; i++){
      if( i != 0){
         questionTotal = 20;
      }
      percentageTotal[i] = (int) Math.round((100 * (countsTotal[i]*1.0 / (questionTotal - countsTotal[i+DIMENSIONS]))));
      //that math expression is digusting to look at
   }  
   return percentageTotal;
   
}

public static String assignLetterAndOutput(int[] percentageTotal){
   //assigns the letters based on the given array from calculatePercentage()
   //which is dependent on %B answers from calculateTotalCounts()
   String personalityResult = "";
   
   String[] ifSmallerThan50 = {"E", "S", "T", "J"};
   String[] ifBiggerThan50 = {"I", "N", "F", "P"};
   
   for(int count = 0; count < DIMENSIONS; count++){
      if(percentageTotal[count] < 50){
         personalityResult += ifSmallerThan50[count];
      } else if (percentageTotal[count] > 50){
         personalityResult += ifBiggerThan50[count];
      } else {
         personalityResult += "X";
      }
   }
   return personalityResult;
   
}


}



