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
      System.out.println(first + last + age);
      
      }
      while (!first.equals("-1"));

      System.out.println("Average age: " + l.getAverage());
/*      
      System.out.println("\n*** Original List ***");
      System.out.println(PersonList);

      l.bubbleSort();
      
      System.out.println();

      System.out.println("\n*** Sorted List ***");
      System.out.println(PersonList);
*/
   }
}
