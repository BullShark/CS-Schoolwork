/**********************************************************
 * File name:	TestBigInt.java                           *
 *                                                        *
 * Programming Assignment 3                               *
 * Algorithm: Test the BigInt class                       *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Wednesday, April 26, 2006                        *
 **********************************************************
 */

public class TestBigInt
{
	public static void main(String [] args)
	{

		System.out.println("This program was written by Chris Lemire to test and debug BigInt.");

		int a1[] = {1,2,3};
		int a2[] = {4,6,8,0,7};

//		int a1[] = {8,3,0,4,1};
//		int a2[] = {9,8,7};
		
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