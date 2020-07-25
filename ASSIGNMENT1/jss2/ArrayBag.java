//********************************************************************
//  ArrayBag.java       Authors: Chris Lemire
//
//  Represents an array implementation of a bag.
//********************************************************************
package jss2;
import jss2.exceptions.*;
import java.util.*;

public class ArrayBag<T> implements BagADT<T>, Iterable<T>
{
  private static Random rand = new Random();
  private final int DEFAULT_CAPACITY = 100;
  private final int NOT_FOUND = -1;
  private int count;  // the current number of elements in the bag
  private T[] contents; 
  
  /******************************************************************
    Creates an empty bag using the default capacity.
  ******************************************************************/
  public ArrayBag()
  {
    count = 0;
    contents = (T[])(new Object[DEFAULT_CAPACITY]);
  }
  
  /******************************************************************
    Creates an empty bag using the specified capacity.
  ******************************************************************/
  public ArrayBag (int initialCapacity)
  {
    count = 0;
    contents = (T[])(new Object[initialCapacity]);
  }
  
  /******************************************************************
    Adds the specified element to the bag if it is not already
    present. Expands the capacity of the bag array if necessary.
  ******************************************************************/
  public void add (T element)
  {
    if (size() == contents.length)
      expandCapacity();
    
    contents[count] = element;
    count++;
  }
  
  /******************************************************************
    Adds the contents of the parameter to this bag.
  ******************************************************************/
  public void addAll (SetADT<T> bag)
  {
    Iterator<T> scan = bag.iterator();
    
    while (scan.hasNext())
      add (scan.next());
  }
  
  /******************************************************************
    Removes a random element from the bag and returns it. Throws
    an EmptyBagException if the bag is empty.
  ******************************************************************/
  public T removeRandom() throws EmptyBagException
  {
    if (isEmpty())
      throw new EmptyBagException();
    
    int choice = rand.nextInt(count);
    
    T result = contents[choice];
    
    contents[choice] = contents[count-1];  // fill the gap
    contents[count-1] = null;
    count--;
    
    return result;
  }
  
  /******************************************************************
    Removes the specified element from the bag and returns it.
    Throws an EmptyBagException if the bag is empty and a
    NoSuchElementException if the target is not in the bag.
  ******************************************************************/
  public T remove (T target) throws EmptyBagException,
                                      NoSuchElementException
  {
    int search = NOT_FOUND;
    
    if (isEmpty())
      throw new EmptyBagException();
    
    for (int index=0; index < count && search == NOT_FOUND; index++)
      if (contents[index].equals(target))
        search = index;
    
    if (search == NOT_FOUND)
      throw new NoSuchElementException();
    
    T result = contents[search];
    
    contents[search] = contents[count-1];
    contents[count-1] = null;
    count--;
    
    return result;
  }
  
  /******************************************************************
    Returns a new bag that is the union of this bag and the
    parameter.
  ******************************************************************/
  public BagADT<T> union (SetADT<T> bag)
  {
    ArrayBag<T> both = new ArrayBag<T>();
    
    for (int index = 0; index < count; index++)
      both.add (contents[index]);
    
    Iterator<T> scan = bag.iterator();
    while (scan.hasNext())
      both.add (scan.next());
    
    return both;
  }
  
  /******************************************************************
    Returns true if this bag contains the specified target
    element.
  ******************************************************************/
  public boolean contains (T target)
  {
    int search = NOT_FOUND;
    
    for (int index=0; index < count && search == NOT_FOUND; index++)
      if (contents[index].equals(target))
        search = index;
    
    return (search != NOT_FOUND);
  }
  
  /******************************************************************
    Returns true if this bag contains exactly the same elements
    as the parameter.
  ******************************************************************/
  public boolean equals (SetADT<T> bag)
  {
    boolean result = false;
    ArrayBag<T> temp1 = new ArrayBag<T>();
    ArrayBag<T> temp2 = new ArrayBag<T>();
    T obj;
    
    if (size() == bag.size())
    {
      temp1.addAll(this);
      temp2.addAll(bag);
      
      Iterator<T> scan = bag.iterator();
      
      while (scan.hasNext())
      {
        obj = scan.next();   
        if (temp1.contains(obj))
        {
          temp1.remove(obj);
          temp2.remove(obj);
        }
      }
      
      result = (temp1.isEmpty() && temp2.isEmpty());
    }
    
    return result;
  }
  
  /******************************************************************
    Returns true if this bag is empty and false otherwise.
  ******************************************************************/
  public boolean isEmpty()
  {
    return (count == 0);
  }
  
  /******************************************************************
    Returns the number of elements currently in this bag.
  ******************************************************************/
  public int size()
  {
    return count;
  }
  
  /******************************************************************
    Returns an iterator for the elements currently in this bag.
  ******************************************************************/
  public Iterator<T> iterator()
  {
    return new ArrayIterator<T> (contents, count);
  }
  
  /******************************************************************
    Returns a string representation of this bag.
  ******************************************************************/
  public String toString()
  {
    String result = "";
    
    for (int index=0; index < count; index++) 
      result = result + contents[index].toString() + "\n";
    
    return result;
  }
  
  /******************************************************************
    Creates a new array to store the elements of the bag with
    twice the capacity of the old one.
  ******************************************************************/
  private void expandCapacity()
  {
    T[] larger = (T[])(new Object[contents.length*2]);
    
    for (int index=0; index < contents.length; index++)
      larger[index] = contents[index];
    
    contents = larger;
  }

  // Below here are the three methods from the BagADT<T> interface. 

  /******************************************************************
    Returns a new bag with contents in this bag that are not
    in the bag that is being passed in.
  ******************************************************************/
  public BagADT<T> difference (BagADT<T> bag)
  {
    ArrayBag<T> diff = new ArrayBag<T>();
    T obj;

    diff.addAll(this);
    
    Iterator<T> scan = bag.iterator();
    
    while (scan.hasNext())
    {
      obj = scan.next();   
      if (diff.contains(obj))
      {
        diff.remove(obj);
      }
    }
    
    return diff;
  }

  /******************************************************************
    Returns a new bag with elements that are both contained in
    this bag and the bag being passed in.
  ******************************************************************/
  public BagADT<T> intersection (BagADT<T> bag)
  {
    // a new bag to contain elements that are in both bags
    ArrayBag<T> same = new ArrayBag<T>();
    T obj;

    // a copy of this set is made so changes can be
    // made to it without affecting the original
    ArrayBag<T> copy = new ArrayBag<T>();
    copy.addAll(this);
    Iterator<T> scan = bag.iterator();
    
    while (scan.hasNext())
    {
      obj = scan.next();   
      if (copy.contains(obj))
      {
        // removing obj from copy prevents duplicates in the bag
        // being passed in to be added to same more than these
        // elements exists in this bag
        copy.remove(obj);
        same.add(obj);
      }
    }
    
    return same;
  }

  /******************************************************************
    Returns the number of copies in the bag of the target element
    being passed in.
  ******************************************************************/
  public int count (T target)
  {
    int copies = 0;
    
    for (int index=0; index < count; index++)
      if (contents[index].equals(target))
        copies++;
    
    return copies;
  }
}
