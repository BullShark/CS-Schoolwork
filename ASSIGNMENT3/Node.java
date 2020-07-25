/**********************************************************
 * File name:	Node.java                                 *
 *                                                        *
 * Programming Assignment 3                               *
 * Algorithm: Defines the nodes for BigInt                *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Wednesday, April 26, 2006                        *
 **********************************************************
 */

public class Node {
	public int digit;
	public Node next, pre;
	
	public Node(int digit) {
		this.digit = digit;
		next = null;
		pre = null;
	}
}
