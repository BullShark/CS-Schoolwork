/**********************************************************
 * File name:	BigInt.java                               *
 *                                                        *
 * Programming Assignment 3                               *
 * Algorithm: An integer type that holds                  * 
 * an arbitrary number of digits                          *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Wednesday, April 26, 2006                        *
 **********************************************************
 */

public class BigInt {
	private Node first, last; // nodes to contain the first and last digit
	private int count; // keeps count of the digits
	
	
	// used only by this class for operations that need to create a new BigInt and return it
	private BigInt() {
		count = 0;
		first = null;
		last = null;
	}
	
	// creates a BigInt from an array
	public BigInt(int [] arr) {
			for(int j = arr.length-1; j >= 0 ; j--) {
				addDigitFirst(arr[j]);
			}
	}
	
	// adds this BigInt to another one and returns the result in a new BigInt
	public BigInt add(BigInt B) {
		BigInt C = new BigInt();
		
		Node current1 = last;
		Node current2 = B.last;
		
		while(numDigits() < B.numDigits()) { // both BigInts should have the same number of digits
			addDigitFirst(0);
		}
			
		while(numDigits() > B.numDigits()) {
			B.addDigitFirst(0);
		}
		
		int n1, n2 = 0;
		String str;
		
		// convert the numbers bigger than one digit to a
		// string then convert the string into two int digits
		while(current1 != null && current2 != null)
		{
			str = Integer.toString(current1.digit + current2.digit + n2);
			
			if(str.length() > 1) {
				n1 = Integer.parseInt(str.charAt(1) + "");
				n2 = Integer.parseInt(str.charAt(0) + "");
			}
			else {
				n1 = (current1.digit + current2.digit + n2);
				n2 = 0;
			}
			
			C.addDigitFirst(n1);
			
			n1 = 0;
			
			current1 = current1.pre;
			current2 = current2.pre;
			
			// add n2 if both BigInts have been traversed
			// and there is still a digit to be added
			if(current1 == null && current2 == null && n2 != 0) 
				C.addDigitFirst(n2);
		}
		
		removeTrailingZeros(); // remove extra zeros from both BigInts
		B.removeTrailingZeros();
		
		return C;
	}
	
	// removes zeros from the left side if there are any
	private void removeTrailingZeros() {
		Node temp;

		while(first.digit == 0 && numDigits() > 1)
		{
			temp = first.next;
			temp.pre = null;
			first = temp;	
			count--;
		}
	}
	
	// multiplies this BigInt by one digit only and return the result in a new BigInt
	public BigInt scale(int s) {
		BigInt C = new BigInt();

		if(s == 0) {
			C.addDigitFirst(s);
			return C;
		}

		Node current = last; // use current for traversing the BigInt
		
		int n1, n2 = 0;
		String str;
		
		while(current != null)
		{
			str = Integer.toString(((s * current.digit) + n2));
			
			if(str.length() > 1) {
				n1 = Integer.parseInt(str.charAt(1) + "");
				n2 = Integer.parseInt(str.charAt(0) + "");
			}
			else {
				n1 = (s * current.digit + n2);
				n2 = 0;
			}
			
			C.addDigitFirst(n1);
			
			n1 = 0;
			
			current = current.pre;

			if(current == null && n2 != 0)
				C.addDigitFirst(n2);
		}
		return C;
	}
	
	// multiplies this BigInt by another BigInt and return the result in a new BigInt
	public BigInt multiply(BigInt B) {
		BigInt C = new BigInt();
		C.addDigitFirst(0);

		Node current = B.last;
		BigInt temp;

		String str;
		
		for(int j=0; current != null; j++)
		{
			temp = scale(current.digit);

			current = current.pre; // traverse through the BigInt

			for(int i = 0; i < j; i++) {	// add zeros to the right side

				temp.addDigitLast(0);
			}
			C = temp.add(C); // add temp to the result
		}
		
		return C; // return the result
	}
	
	// returns the number of digits in this BigInt
	public int numDigits() {
		return count;
	}
	
	// prints this BigInt from left to right
	public String toString() {
		Node current = last;
		String result = "";
		
		while(current != null) {
			result = Integer.toString(current.digit) + result;
			current = current.pre;
		}
		
		return result;
	}

	// adds a new node with a digit to the front of this BigInt
	public void addDigitFirst(int digit) {
		if(numDigits() == 0) {
			first = last = new Node(digit);
		}
		else {	
			Node temp = first;
			first = new Node(digit);
			first.next = temp;
			temp.pre = first;
		}
		count++;
	}
	
	// adds a new node with a digit to the rear of this BigInt
	public void addDigitLast(int digit) {
		if(numDigits() == 0) {
			first = last = new Node(digit);
		}
		else {
			Node temp = last;
			last = new Node(digit);
			temp.next = last;
			last.pre = temp;
		}
		count++;
	}
}
