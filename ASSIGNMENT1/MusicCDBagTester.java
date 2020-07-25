//********************************************************************
//  MusicCDBagTester.java       Authors: Chris Lemire
//
//  Reads in two files to create two bags and tests functions of ArrayBag.java
//********************************************************************
import jss2.ArrayBag;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import jss2.exceptions.*;

public class MusicCDBagTester {
  public static void main(String args[]) {

    ArrayBag<MusicCD> musicCDbag1 = new ArrayBag<MusicCD>();
    ArrayBag<MusicCD> musicCDbag2 = new ArrayBag<MusicCD>();
    ArrayBag<MusicCD> musicCDbag3;
    MusicCD cd;

    System.out.println("MusicCDBagTester.java is made by Chris Lemire to create two bags " +
    "from CD information read in from two files and test the funtionality of ArrayBag.java.\n");

    try {
      File file = new File("musicCD1.txt");
      Scanner scan = new Scanner(file);

      // adds all of the elements from the first file to bag one
      while(scan.hasNext() && scan.hasNext()) {
        cd = new MusicCD(scan.next(), scan.nextInt());
        musicCDbag1.add(cd);
      }

      file = new File("musicCD2.txt");
      scan = new Scanner(file);

      // adds all of the elements from the second file to bag two
      while(scan.hasNext() && scan.hasNext()) {
        cd = new MusicCD(scan.next(), scan.nextInt());
        musicCDbag2.add(cd);
      }

      // prints the contents of both bags
      System.out.println("Bag one contains:\n" + musicCDbag1 
      + "\nBag two contains:\n" + musicCDbag2);

      // prints differences bag one has that bag two does not have
      System.out.println("Bag one has these differences from bag two:\n" 
      + musicCDbag1.difference(musicCDbag2));

      // prints differences bag two has that bag one does not have
      System.out.println("Bag two has these differences from bag one:\n" 
      + musicCDbag2.difference(musicCDbag1));

      // prints elements contained in both bags
      System.out.println("Both bags have these intersections:\n" + musicCDbag1.intersection(musicCDbag2));

      // creates bag three so it can be a union of bag one and bag two
      musicCDbag3 = new ArrayBag<MusicCD>();

      // casting must be used because union returns a SetADT<T> object
      musicCDbag3 = (ArrayBag<MusicCD>) musicCDbag1.union(musicCDbag2);
      System.out.println("Bag three is the union of bag one and bag two:\n" + musicCDbag3);

      // removes a random element from bag three and counts how many copies of it exist in bag one and two
      cd = musicCDbag3.removeRandom();
      System.out.println("A random element removed from bag three:\n" + cd);
      System.out.println("Bag one has " + musicCDbag1.count(cd) + " copy or copies of this element.");
      System.out.println("Bag two has " + musicCDbag2.count(cd) + " copy or copies of this element.\n");

      System.out.println("Bag one's size: " + musicCDbag1.size());
      System.out.println("Bag two's size: " + musicCDbag2.size());
      // bag three's size should be the size of bag one plus bag two minus one random element that was removed
      System.out.println("Bag three's size: " + musicCDbag3.size() + "\n");

      // removes the random element from bag one
      System.out.println("The random element will try to be removed from bag one.");
      try {
        musicCDbag1.remove(cd);
        System.out.println("The element was removed. Bag one's size is now: " + musicCDbag1.size());
      }
      catch (EmptyBagException exception) {
        System.out.println("Bag one is empty. No element could be removed.");
      }
      catch (NoSuchElementException exception) {
        System.out.println("Bag one does not contain the random element. No element could be removed.");
      }

      System.out.println();

      // removes the random element from bag two
      System.out.println("The random element will try to be removed from bag two.");
      try {
        musicCDbag2.remove(cd);
        System.out.println("The element was removed. Bag two's size is now: " + musicCDbag2.size());
      }
      catch (EmptyBagException exception) {
        System.out.println("Bag two is empty. No element could be removed.");
      }
      catch (NoSuchElementException exception) {
        System.out.println("Bag two does not contain the random element. No element could be removed.");
      }

      System.out.println();

      // tries to remove every element from bag three
      System.out.println("Every element will try to be removed from bag three.");

      while(!(musicCDbag3.isEmpty())) {
        musicCDbag3.removeRandom();
      }

      // uses isEmpty to determine if bag three is empty
      if(musicCDbag3.isEmpty())
        System.out.println("Bag three is empty.");
      else
        System.out.println("Bag three is not empty.");
 
      System.out.println();  

    }
    catch (FileNotFoundException exception) {
      System.out.println("The files were not found.");
    }
    catch (Exception exception) {} // catches any other exceptions
  }
}
