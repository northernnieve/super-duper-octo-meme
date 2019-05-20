// Evan Ma
// 4/4/2019
// CSE142
// TA: Dylan Hayre (i forgot his name tbh sorry mate, it's section AC)
// Assignment #1
//
// This program will attempt to print out the 
// song “There Was an Old Woman Who Swallowed a Fly.”

public class Song{//summary of song described in main
   public static void main(String[] args){
      phraseFly();
      stanza0();
      
      phraseSpider();
      stanza1();
      
      phraseBird();
      stanza2();w
            
      phraseCat();
      stanza3();
            
      phraseDog();
      stanza4();
            
      phraseCustom();
      stanza5();
            
      phraseHorse();
      
   }
   
// phrases used in the first line of each stanza starts here. total of 7, counting horse
// if faced with same hw again, compress method into phraseAnimal(string Animal, string Rhyme)
   public static void phraseFly(){//see refrainFly() for notes
      System.out.println("There was an old woman who swallowed a fly.");
   }
   public static void phraseSpider(){
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
   }
   public static void phraseBird(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
   }
   public static void phraseCat(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
   }
   public static void phraseDog(){
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
   }
   public static void phraseCustom(){
      System.out.println("There was an old woman who swallowed a hive,");
      System.out.println("How is she alive to swallow a hive");
   }
   public static void phraseHorse(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }

// collapsing each refrain in here, stanza_i represents the (i+1)-th stanza
// yeah i can see why we need for-loops now
   public static void stanza0(){
      refrainFly();
   }
   public static void stanza1(){
      refrainSpider();
      refrainFly();
   }
   public static void stanza2(){
      refrainBird();
      refrainSpider();
      refrainFly();
   }
   public static void stanza3(){
      refrainCat();
      refrainBird();
      refrainSpider();
      refrainFly();
   }
   public static void stanza4(){
      refrainDog();
      refrainCat();
      refrainBird();
      refrainSpider();
      refrainFly();
   }
    public static void stanza5(){
      refrainCustom();
      refrainDog();
      refrainCat();
      refrainBird();
      refrainSpider();
      refrainFly();
   }
   
   
// refrain construction using println
// all this ctrl-c/ctrl-v could've went away if I 
// could declare a refrain(string "predator", string "prey") method 
// but nope, suffering ensures
   public static void refrainCustom(){  
      System.out.println("She swallowed the hive to catch the dog,");
   }
   public static void refrainDog(){  
      System.out.println("She swallowed the dog to catch the cat,");
   }
   public static void refrainCat(){  
      System.out.println("She swallowed the cat to catch the bird,");
   }  
   public static void refrainBird(){  
      System.out.println("She swallowed the bird to catch the spider,");
   }
   public static void refrainSpider(){  
      System.out.println("She swallowed the spider to catch the fly,");
   }
   public static void refrainFly(){ //refrainFly repeats after every stanza, gets special treatment
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println(); // added to reduce "redundancy", since each stanza ends on 
                            // "perhaps she'll die" anyways
   }
}