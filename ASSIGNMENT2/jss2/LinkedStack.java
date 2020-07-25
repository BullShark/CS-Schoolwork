/**********************************************************
 * File name:	LinkedStack.java                        *
 *                                                        *
 * Programming Assignment 2                               *
 * Algorithm: Represents a linked                         *
 * implementation of a stack.                             *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Friday, March 24, 2006                           *
 **********************************************************
 */

package jss2;
import jss2.exceptions.*;
import java.util.Iterator;

public class LinkedStack<T> implements StackADT<T>
{
  private int count;  // indicates the next open slot
  private LinearNode<T> top; 

  /*******************************************************************
    Creates an empty stack.
  *******************************************************************/
  public LinkedStack()
  {
    count = 0;
    top = null;
  }

  /*******************************************************************
    Adds the specified element to the top of this stack.
  *******************************************************************/
  public void push (T element)
  {
    LinearNode<T> temp = new LinearNode<T> (element);

    temp.setNext(top);
    top = temp;
    count++;
  }

  /*******************************************************************
    Removes the element at the top of this stack and returns a
    reference to it. Throws an EmptyStackException if the stack
    is empty.
  *******************************************************************/
  public T pop() throws EmptyStackException
  {
    if (isEmpty())
      throw new EmptyStackException();

    T result = top.getElement();
    top = top.getNext();
    count--;
 
    return result;
  }
   
  /*******************************************************************
    Returns a reference to the element at the top of this stack.
    The element is not removed from the stack.  Throws an
    EmptyStackException if the stack is empty.  
  *******************************************************************/
  public T peek() throws EmptyStackException
  {
    if(isEmpty())
      throw new EmptyStackException();

    return top.getElement();
  }

  /*******************************************************************
    Returns true if this stack is empty and false otherwise. 
  *******************************************************************/
  public boolean isEmpty()
  {
    return (count == 0);
  }
 
  /*******************************************************************
    Returns the number of elements in the stack.
  *******************************************************************/
  public int size()
  {
    return count;
  }

  /*******************************************************************
    Returns a string representation of this stack. 
  *******************************************************************/
  public String toString()
  {
    String result = "";
    LinearNode<T> current = top;

    while(current != null) {
      result += current.getElement().toString() + "\n";
      current = current.getNext();
    }
    return result;
  }
}
