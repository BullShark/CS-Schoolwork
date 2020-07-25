/**********************************************************
 * File name:	MyTest.java                               *
 *                                                        *
 * Programming Assignment 3                               *
 * Algorithm: Used to test and debug BigInt               *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Wednesday, April 26, 2006                        *
 **********************************************************
 */

public class MyTest
{
	public static void main(String [] args)
	{
		System.out.println("This program was written by Chris Lemire to test and debug BigInt.");
		
		int a1[] = {9,7,8,3,2,4,8,3,8,8,2,3,7,3,9,9,4,5,2,7,5,3,1,1,2,5,7,8,9,8,2,4};
		int a2[] = {4,6,8,0,7,5,3,2,1,5,8,4,2,6,7,8,9,5,3,1,7,3,6};
		
		BigInt B1, B2, B3, B4, B5;
		B1 = new BigInt(a1);
		B2 = new BigInt(a2);
		
		System.out.println("B1 = " + B1);
		System.out.println("B2 = " + B2);
		System.out.println("B1 has " + B1.numDigits() + " digits.");
		System.out.println("B2 has " + B2.numDigits() + " digits.");
		
		System.out.print(B1 + " * " + "4 = ");
		B1 = B1.scale(4);
		System.out.println(B1);
		
		System.out.print(B1 + " + " + B2 + " = "); 
		B3 = B1.add(B2);
		System.out.println(B3);
		
		System.out.print(B1 + " * " + B2 + " = "); 
		B4 = B1.multiply(B2);
		System.out.println(B4);
		
		B5 = B4.scale(0);
		System.out.println(B5);
	}
}