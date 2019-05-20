// Evan Ma
// 4/18/2019
// CSE142
// TA: Dylan Hayre (YES I COPY AND PASTE THIS EVERY SINGLE TIME I TURN IT IN)
// Assignment #3
//
// This program will attempt to print out MY BEAUTIFUL ARTWORK
import java.awt.*;

public class Doodle{
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(1000,1000);
      Graphics g = panel.getGraphics();
      
      Color annoying = new Color(204, 255, 0);
      
      g.setColor(annoying);
      g.fillRect(0,0,1000,1000);
      for(int i = 1; i < 20; i++){
         g.setColor(Color.red);
         g.fillRect(500+20*i, 500+20*i, 30, 50);
         g.setColor(Color.blue);
         g.fillOval(10, 20+20*i, 20, 30);
         g.setColor(Color.black);
         g.fillOval(30+40*i, 20+50*i, 40, 40);
      }  
   }
}