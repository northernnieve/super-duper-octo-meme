// Evan Ma
// 4/18/2019
// CSE142
// TA: Dylan Hayre (YES I COPY AND PASTE THIS EVERY SINGLE TIME I TURN IT IN)
// Assignment #3
//
// This program will attempt to print out that THING WITH THE 
// WEIRD SQUARES AND GRID THING THAT MESSES WITH MY MIND

import java.awt.*;

public class CafeWall{
   public static final int MORTAR = 2;
   public static void main(String[] args){
      //seriously, class constants? it's more fun with userInput
   
      //calling classes and variables to make this homework remotely possible
      DrawingPanel background = new DrawingPanel(650,400);
      Graphics g = background.getGraphics();
      
            
      //creates background
      createBackground(g, Color.GRAY);
      //this man doesnt even read my comments anyways
      //why am i wasting my time writing them anyways
      
      //illusionRow printing out the rows the assignment demands
      illusionRow(g, 0, 0, 4, 20);
      illusionRow(g, 50, 70, 5, 30); 
      
      //createGrid prints out the remaining four grid things
      createGrid(g, 10, 150, 4, 25, 0);
      createGrid(g, 250, 200, 3, 25, 10);
      createGrid(g, 425, 180, 5, 20, 10);
      createGrid(g, 400, 20, 2, 35, 35);

   }
   public static void illusionRow(Graphics g, int x, int y, int boxCount, int size){
      //illusion Row prints out rows of squares as necessary:
      //size: length of each square, they should be equal in theory
      //boxCount: how many box sets we want to draw out today
      //    ninja edit: when boxCount = 1, we draw ONE BLACK AND ONE WHITE
      //int x and y: the (x,y) coordinate of the upper left point of the row
      
      for(int i = 0; i < boxCount; i++){
         g.setColor(Color.BLACK); //THERES THE BLACK BOX
         g.fillRect(x + 2*i*size, y, size, size);
         //the 2*i*size helps print out 1st, 3rd, 5th, etc., box.
         
         
         g.setColor(Color.BLUE); //THE CROSS
         //y always stays constant, from y to y+size
         //x changes, from x+size*k to x+size*(k+2)
         int x_1 = x + size*2*(i);
         int x_2 = x + size*(2*i+1);
         g.drawLine(x_1, y, x_2, y + size);
         //y stays the same, however, the roles of x "swaps" to create
         //backslashing lines
         g.drawLine(x_2, y, x_1 , y + size);
         //the size*(2*i+1) helps print out the 0th, 2nd, etc., box
         
         
         g.setColor(Color.WHITE); //THE WHITE BOX
         g.fillRect(x + (2*i+1)*size, y , size, size); 
         //it's 11pm and i want to go to bed now please
      }
      
   }
   public static void createBackground(Graphics g, Color color){
      //literally draws a background for us
      g.setColor(color);
      g.fillRect(0,0,650,400);
   }
   public static void createGrid(Graphics g, int x, int y, int rowCount, int size, int offSet){
      //int x, y is used as coordinate of the upper left point of the grid
      //int rowCount is the amount of rows we want, and since our grid is a 
      //    box, the amount of boxes is equal to 2 * amount of rows.
      //    Recall that boxCount counts the amount of white black box sets
      //int size is the width of each box
      //int offSet determines the 2nd row offset effect we would like
      
      for(int i = 0; i < 2*rowCount; i++){
         
         illusionRow(g, x + (offSet *(i%2)), (y + MORTAR * i) + size*i, rowCount, size);

      }      
      
   }
      // According to the checker, there was 533/260000 pixels that differ
      // from the actual picture, aka 0.205% of my picture
      // if i get marked off because of this I am going to be so mad. 
      
      // I SPENT AN HOUR AND A HALF TRYING TO GET THE DIFFERENCE TO ZERO, 
      // ONLY TO REALIZE THAT I DIDN'T HAVE TO DO THAT
      
      // to be fair i did spent 30 minutes complaining about this, 
}