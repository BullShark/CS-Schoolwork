/**********************************************************
 * File name:	PostfixEvaluator.java                   *
 *                                                        *
 * Programming Assignment 2                               *
 * Algorithm: Provides an implementation of an            *
 * infix to postfix converter for expressions.            *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Friday, March 24, 2006                           *
 **********************************************************
 */

/**
Infix to Postfix Conversion:

* Scan the input String using Scanner
* While there are more tokens
   o If the next token is of length greater than 1, it is a 
     multiple digit number and is added to the result
   o Else if the next token is 1 digit number, it is added 
     to the result
   o Else if the next token is a right parenthesis,
      * Pop elements off of the stack, adding them to the 
        result until the top element of the stack is a matching 
        left parenthesis
      * Pop the left parenthesis off of the stack
   o Else if the next token is an operator (+,-,*,/,^)
      * Then compare the token to the top of the stack to 
        determine precedence
      * While the operator on the stack has precedence
      * Pop the top element off of the stack and add it to the 
        result
      * Push the current operator on the stack
* While there are elements remaining on the stack
   o Pop the top element off of the stack and add it to the result
* The result is a postfix expression. Return the result.

*/

import jss2.*;
import java.util.Scanner;

public class InfixToPostfix 
{
  /**********************************************************
     Returns a postfix expression of this infix string
      as a list.
  **********************************************************/
  public static String convert(String infix)
  {
    String result = "";

    ArrayStack<String> pStack = new ArrayStack<String>();

    int toPush = 0, operand1 = 0, operand2 = 0;
    boolean precedence = true;
    char tempChar;
    String tempToken;
    Scanner s = new Scanner(infix);

    while(s.hasNext()) // iterate through each token in the infix expression
    {
      tempToken = s.next();
      tempToken = tempToken.toString();
  
      if(tempToken.length()>1) // a token greater than one is an operand
      {
        result = result.concat(tempToken).concat(" "); 
      }
      else if(tempToken.length() == 1) // token could be an operand or operator
      {
        tempChar = tempToken.charAt(0);
      
        if(tempChar >= '0' && tempChar <= '9') { // token is an operand

        result = result.concat(tempToken).concat(" ");
        }

        else if(tempToken.equals("(") ) // token is a left paranthesis
          pStack.push(tempToken);

        else if(tempToken.equals(")") ) // token is a right paranthesis
        {
          while(!(pStack.isEmpty()) && 
                !(pStack.peek().equals("("))  )
          {                
            result = result.concat(pStack.pop()).concat(" ");
          }
          if (!(pStack.isEmpty()))
            pStack.pop();
        }

        else if( tempToken.equals("*") || tempToken.equals("/") || // token is an operator
                   tempToken.equals("+") || tempToken.equals("-") || 
                 tempToken.equals("^") )
        {
          if(!(pStack.isEmpty()))
          {
            String top = pStack.peek()+""; 
              
            if((top.equals("+") || top.equals("-")) &&
               (tempToken.equals("*") || tempToken.equals("/") || tempToken.equals("^") ))       
              precedence = false;

              else if(tempToken.equals("^"))
                precedence = false;
              else if (top.equals("("))
                precedence = false;
              else
                precedence = true;
          }
          while( !(pStack.isEmpty()) && 
                 !(pStack.peek().equals("(")) && precedence )
          { 
            String top = pStack.peek()+""; 

            if((tempToken.equals("+") || tempToken.equals("-")) &&
               (top.equals("*") || top.equals("/") || top.equals("^") ))
              precedence = true;
              else if (top.equals("("))
                precedence = true;
              else
                precedence = false;            

            result = result.concat(pStack.pop()).concat(" ");
          }
            
          pStack.push(tempToken); // push the token onto the stack 

        }

        else   //error handling
        {
          System.out.println( tempToken + " is illegal");
          System.exit(1);
        }
      }
    } // end of first while loop
    
    while( !(pStack.isEmpty()) ) // add the remaining operators in the stack to the result
    {
      result = result.concat(pStack.pop()).concat(" ");
    }
    
    s.close();

    result = result.trim();

    return result;
  }
}
