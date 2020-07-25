//  PersonList.java by Chris Lemire

//  Lab 3 assignment due October 11, 2005

//  Instructor Yu Pa-Ng

public class PersonList {

   private Person[] personArray;  // An array of Person objects
   private int count;                    // The number of Person objects stored in
   private float sum;                             // array.

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

   // ***********************************
   //  Sorts objects in personArray[] using bubbleSort
   // ***********************************
   public void bubbleSort() {
      Person temp;
         for (int pass = 1; pass < count; pass++)
            for (int i = 0; i < count -1; i++)
               if (personArray[i].compareTo(personArray[i + 1]) < 0) {
                  temp = personArray[i];
                  personArray[i] = personArray[i + 1];
                  personArray[i + 1] = temp;
               }
   }

   // ***********************************
   //  Returns the average age of each person
   // ***********************************
   public float getAverage() {
      float c = count;
      float average = sum/c;
      return average;
   }

   // ***********************************
   //  Returns the total number of people
   // ***********************************
   public int getCount() {
      return count;
   }

   // ***********************************
   //  Returns a string representation of PersonList
   // ***********************************
   public String toString() {
      String s = "";
      for(int i = 0; i < count; i++)
         s += personArray[i] + "\n";
      return s;
   }
}
