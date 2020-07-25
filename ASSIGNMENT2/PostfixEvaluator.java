/**********************************************************
 * File name:	PostfixEvaluator.java                   *
 *                                                        *
 * Programming Assignment 2                               *
 * Algorithm: Evaluates postfix expressions using         *
 * stack. Assumes the operands are constants.             *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Friday, March 24, 2006                           *
 **********************************************************
 */

import jss2.LinkedStack;
import java.util.StringTokenizer;

public class PostfixEvaluator
{
  private final char ADD = '+', SUBTRACT = '-';
  private final char MULTIPLY = '*', DIVIDE = '/', POWER = '^';

  private LinkedStack<Integer> stack;

  /*******************************************************************
    Sets up this evalutor by creating a new stack.
  *******************************************************************/
  public PostfixEvaluator()
  {
    stack = new LinkedStack<Integer>();
  }

  /*******************************************************************
    Evaluates the specified postfix expression. If an operand is
    encountered, it is pushed onto the stack. If an operator is
    encountered, two operands are popped, the operation is
    evaluated, and the result is pushed onto the stack.
  *******************************************************************/
  public String evaluate (String expr)
  {
    int op1, op2, result = 0;
    String token;
    StringTokenizer tokenizer = new StringTokenizer (expr);

    while (tokenizer.hasMoreTokens())
    {
      token = tokenizer.nextToken();

      if (isOperator(token))
      {
        op2 = (stack.pop()).intValue();
        op1 = (stack.pop()).intValue();
        result = evalSingleOp (token.charAt(0), op1, op2);
        stack.push (new Integer(result));
      }
      else
        stack.push (new Integer(Integer.parseInt(token)));
    }

    return String.valueOf(result);
  }

  /*******************************************************************
    Determines if the specified token is an operator.
  *******************************************************************/
  private boolean isOperator (String token)
  {
    return ( token.equals("+") || token.equals("-") ||
             token.equals("*") || token.equals("/") || token.equals("^"));
  }

  /*******************************************************************
    Peforms integer evaluation on a single expression consisting of 
    the specified operator and operands.
  *******************************************************************/
  private int evalSingleOp (char operation, int op1, int op2)
  {
    int result = 0;

    switch (operation)
    {
      case ADD:
        result = op1 + op2;
        break;
      case SUBTRACT:
        result = op1 - op2;
        break;
      case MULTIPLY:
        result = op1 * op2;
        break;
      case DIVIDE:
        result = op1 / op2;
        break;
      case POWER:
        result = (int) Math.pow(op1, op2);
    }

    return result;
  }
}
