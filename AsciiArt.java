// Evan Ma
// 4/12/2019
// CSE142
// TA: Dylan Hayre
// Assignment #2
//
// This program will attempt to print out some cool 
// ASCII images that I'm legally required to construct

public class AsciiArt{
   public static void main(String[] args){
         
      drawCustom();
   
   }
   public static void drawCustom(){//draws out my cool awesome art
      //I strive in replicating minimalism.
      //I dub this "The Everlasting Sight of Grass". It deplicts the sight of grass 
      //over a plain. It captures the uniformity of grass from afar, and reinforces
      //nature's continuity and consistency, just like this for loop.
      int size = 33;
      for(int i = 0; i < size; i++){
         for(int j = 0; j < size; j++){
            System.out.print("\\");
         }
         System.out.println();
      }      
  }
}