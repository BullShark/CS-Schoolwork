//  Person.java by Chris Lemire

//  Lab 3 assignment due October 11, 2005

//  Instructor Yu Pa-Ng

public class Person {

   private int count, age;
   private String first, last;

   // ***********************************
   //  Constructor initializes person
   // ***********************************
   public Person(String first, String last, int age) {
      this.first = first;
      this.last = last;
      this.age = age;
   }

   // ***********************************
   //  Accessor method to return first name
   // ***********************************
   public String getFirst() {
      return first;
   }

   // ***********************************
   //  Accessor method to return last name
   // ***********************************
   public String getLast() {
      return last;
   }

   // ***********************************
   //  Accessor method to return age
   // ***********************************
   public int getAge() {
      return age;
   }

   // ***********************************
   //  Returns a string representation of Person
   // ***********************************
   public String toString() {
      return last + ", " + first + "\t\t" + age;
   }
}
