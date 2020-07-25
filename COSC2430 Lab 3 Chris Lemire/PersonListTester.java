//  PersonListTester.java by Chris Lemire

//  Lab 3 assignment due October 11, 2005

//  Instructor Yu Pa-Ng

import java.util.Scanner;
public class PersonListTester {
   public static void main(String[] args) {

      String first, last;
      int quit, age;
      Scanner scan = new Scanner(System.in);
      PersonList l = new PersonList();
      Person p;

      System.out.println("\nThis program was written by Chris Lemire.");

      // ***********************************
      //  Takes person information from the user
      //  and puts it in the array of Person
      // ***********************************
      do {
      System.out.println("Enter a person information (or -1 to quit) *******");
      System.out.print("  --Enter First Name: ");
      first = scan.next();

      if(first.equals("-1"))
         break;

      System.out.print("  --Enter Last Name: ");
      last = scan.next();

      System.out.print("  --Enter Age: ");
      age = scan.nextInt();

      p = new Person(first, last, age);
      l.addPerson(p);      
      }
      while (!first.equals("-1")); // adds Person objects to the array untill user pushes -1 to quit
      
      System.out.println("\n*** Original List ***");
      System.out.println(l);

      l.bubbleSort(); // sorts the elements in the array using bubble sort then prints them out again
      
      System.out.println();

      System.out.println("\n*** Sorted List ***");
      System.out.println(l);

      System.out.println("Total " + l.getCount() + " people, Average age " + l.getAverage());
   }
}
