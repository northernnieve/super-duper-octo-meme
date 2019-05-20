// Evan Ma
// 5/4/2019
// CSE142
// TA: Dylan Hayre (I liek puppies)
// Assignment #4
//
// This program will attempt to play a guessing game with good old jigsaw:
// YOU WANNA PLAY A GAME??

import java.util.*;


public class GuessingGame{
   public static final int MAXIMUM = 5;
   public static void main(String args[]){
   
      Scanner console = new Scanner(System.in);
   
      haikuMsg();  
         
      int bestGame = guesses(console); //first game being played here, and the total guess here is technically "best guess"
      int totalGuessCount = bestGame;  //totalGuessCount keeps track of total guesses made, which after the first game is equal to bestGame

      System.out.print("Do you want to play again? ");
      String userResponse = console.next();     
      System.out.println(); //prompt for play again. If we do, hop into while loop to play as much as we want. If not we jump to gameStatistics
          
      int currentGuessCount = 0; //keeps track of the amount of guesses in each game, used to calculate best game.
      int totalGameCount = 1; //total game played   
      while(userResponse.startsWith("y") || userResponse.startsWith("Y")){   
         totalGuessCount = totalGuessCount + guesses(console);
            if (currentGuessCount < bestGame){
               currentGuessCount = bestGame; //max loop incorporated into the game
               //if I can use arrays, then I would put this into another method, then spit out 
               //bestGame and totalGameCount into a single gameStatistics[]                              
            }
         System.out.print("Do you want to play again? "); //repeat from 24-26
         userResponse = console.next();
         totalGameCount++; //keeps track total games played, i.e. how many times user said "yes" 
      }
      
      gameStatistics(totalGuessCount, totalGameCount, bestGame); //print out statistics
   
   }
   
   public static void haikuMsg(){
      System.out.println("CS is not fun.\nYou wanna play a game mate.\nYOUR SOUL SHALL SUFFER.\n");
   }
   
   public static int guesses(Scanner console){
      Random random = new Random();
      int randomChoice = random.nextInt(MAXIMUM)+1; //Random random generates number between [0,MAXIMUM-1], the +1 offset that   
      
          
      System.out.println("I'm thinking of a number between 1 and "+ MAXIMUM +"...");
      System.out.print("Your guess? ");
      int userGuess = console.nextInt(); 
      int guessCount = 1; //keeps track of guess count here, since we already got a guess in line 56, guessCount = 1
      
      while(randomChoice != userGuess){ //cross check with our randomized number as long as user input is not equal to chosen number
         if(randomChoice > userGuess) {
            System.out.println("It's higher.");
            System.out.print("Your guess? ");
            userGuess = console.nextInt();
            guessCount++;
         } else { //give hints as to whether our number is higher or lower
            System.out.println("It's lower.");
            System.out.print("Your guess? ");
            userGuess = console.nextInt();
            guessCount++; //with each successive guess, guess Counter increases by 1
         }
      }
      System.out.println("You got it right in " + guessCount + " guesses!");
      return guessCount; //spits out the amount of times we guessed
   }
   
      
   public static void gameStatistics(int totalGuessCount, int totalGameCount, int bestGame){
      double totalGuessCountDouble = totalGuessCount; //printing out the total statistics after user indicate they dont wanna play no more
      System.out.printf("Overall results: \nTotal games   = "+ totalGameCount +
         "\nTotal guesses = "+totalGuessCount+ 
         "\nGuesses/game  = %.1f\nBest game     = "+bestGame, totalGuessCountDouble/totalGameCount);
      
   }
  
}