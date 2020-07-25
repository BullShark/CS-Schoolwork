//********************************************************************
//  EmptyBagException.java     Authors: Chris Lemire
//
//  Represents the situation in which a bag is empty.
//********************************************************************
package jss2.exceptions;

public class EmptyBagException extends RuntimeException
{
  /******************************************************************
    Creates the exception.
  *******************************************************************/
  public EmptyBagException()
  {
    super ("The bag is empty.");
  }
  
  /******************************************************************
    Creates the exception with the specified message.
  *******************************************************************/
  public EmptyBagException (String message)
  {
    super (message);
  }
}
