//********************************************************************
//  BagADT.java       Authors:  Chris Lemire
//
//  Defines the interface to a bag collection.
//********************************************************************
package jss2;
import java.util.Iterator;

public interface BagADT<T> extends SetADT<T>
{
  /** Returns a new bag with differences this bag has that the bag being passed in does not have. */
  public BagADT<T> difference (BagADT<T> bag);

  /** Returns elements both bags have in a new bag. */
  public BagADT<T> intersection (BagADT<T> bag);

  /** Returns the number of copies in this bag of the target element. */
  public int count (T element);
}
