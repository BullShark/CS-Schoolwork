/**********************************************************
 * File name:	ArrayStack.java                         *
 *                                                        *
 * Programming Assignment 2                               *
 * Algorithm: Represents an array                         *
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

public class ArrayStack<T> implements StackADT<T>
{
  private final int DEFAULT_CAPACITY = 100;
  private int top;  // indicates the next open slot
  private T[] stack;
  
  /*******************************************************************
    Creates an empty stack using the default capacity.
  *******************************************************************/
  public ArrayStack()
  {
    top = 0;
    stack = (T[])(new Object[DEFAULT_CAPACITY]);
  }

  /*******************************************************************
    Creates an empty stack using the specified capacity.
  *******************************************************************/
  public ArrayStack (int initialCapacity)
  {
    top = 0;
    stack = (T[]) (new Object[initialCapacity]);
  }

  /*******************************************************************
    Adds the specified element to the top of this stack, expanding
    the capacity of the stack array if necessary.
  *******************************************************************/
  public void push (T element)
  {
    if (size() == stack.length) 
      expandCapacity();

    stack[top] = element;
    top++;
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

    top--;
    T result = stack[top];
    stack[top] = null; 

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

    return stack[top-1];
  }

  /*******************************************************************
    Returns true if this stack is empty and false otherwise. 
  *******************************************************************/
  public boolean isEmpty()
  {
    return (size() == 0);
  }
 
  /*******************************************************************
    Returns the number of elements in this stack.
  *******************************************************************/
  public int size()
  {
    return top;
  }

  /*******************************************************************
    Returns a string representation of this stack. 
  *******************************************************************/
  public String toString()
  {
    String result = "";
    
    for (int index=0; index < top; index++) 
      result = result + stack[index].toString() + "\n";
    
    return result;
  }

  /*******************************************************************
    Creates a new array to store the contents of this stack with
    twice the capacity of the old one.
  *******************************************************************/
  private void expandCapacity()
  {
    T[] larger = (T[])(new Object[stack.length*2]);
    
    for (int index=0; index < stack.length; index++)
      larger[index] = stack[index];
    
    stack = larger;
  }
}
