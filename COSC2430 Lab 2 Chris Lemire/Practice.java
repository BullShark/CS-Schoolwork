/* Practice.java by Christopher Lemire */

import java.util.Scanner;

public class Practice {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      System.out.print("This program was written by Chris Lemire.\n" +
                       "Practice array takes a users number to create\n" +
                       "an array and labels the largest and smallest.\n" +
                       "Enter in the numbers of elements for an array: ");
      int user = scan.nextInt();

      int[] numbers = new int[user];

      int largest = -214483647; // Makes sure that the smallest and largest are found
      int smallest = 214483647;

      // --------------------------------------------------
      // Stores all the values in the array
      // --------------------------------------------------
      System.out.println("Enter in the number(s) in the array.");

      for(int index = 0; index < numbers.length; index++) {
         System.out.print("Enter value " + (index + 1) + ": ");
         numbers[index] = scan.nextInt();
      }

      // --------------------------------------------------
      //  Finds the smallest and largest
      // --------------------------------------------------
      for(int index = 0; index < numbers.length; index++) {
         if(numbers[index] > largest)
            largest = numbers[index];

         if(numbers[index] < smallest)
            smallest = numbers[index];
      }

      // --------------------------------------------------
      //  Prints the values with the smallest and largest labled
      // --------------------------------------------------
      for(int index = 0; index < numbers.length; index++) {

         System.out.print("Value " + (index + 1) + ": ");

         if(numbers[index] == largest)
            System.out.println(numbers[index] + " LARGEST");
            
         else if(numbers[index] == smallest)
            System.out.println(numbers[index] + " SMALLEST");
            
         else
            System.out.println(numbers[index]);
      }
   }
}
