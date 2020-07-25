//  PersonList.java by Chris Lemire

//  Lab 3 assignment due October 11, 2005

//  Instructor Yu Pa-Ng

public class PersonList {

   private Person[] personArray;  // An array of Person objects
   private int count;                    // The number of Person objects stored in
                                                  // array.
   private float sum;

   // ***********************************
   //  Constructor sets initial values
   // ***********************************
   public PersonList() {
   personArray = new Person[10];
   count = 0;
   }

   // ***********************************
   //  Add a new person to array
   // ***********************************
   public void addPerson(Person p) {
      personArray[count] = p;
      sum += p.getAge();
      count++;
   }
/*
   // ***********************************
   //  Sorts objects in personArray[] using BubbleSort
   // ***********************************
   public void bubbleSort (int[] a) {
      personArray = a;
      int temp;
         for (int pass = 1; pass < personArray.length; pass++)
            for (int I = 0; I < personArray.length -1; i++)
               if (personArray[i] > personArray[i + 1]) {
                  temp = personArray[i];
                  personArray[i] = personArray[i + 1];
                  personArray[I + 1] = temp;
               }
   }
*/
   // ***********************************
   //  Returns the average age of each person
   // ***********************************
   public float getAverage() {
      float c = count;
      float average = sum/c;
      return average;
   }
/*
   // ***********************************
   //  Returns a string representation of PersonList
   // ***********************************
   public String toString() {
   }*/
}
