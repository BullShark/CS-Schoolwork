/**********************************************************
 * File name:       Square.java                           *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class Square extends TwoDShape {

   double side;

   // -------------------------------------
   //   Constructor, creates square of given side
   // -------------------------------------
   public Square(double side) {
      this.side = side;
   }

   // -------------------------------------
   //   Returns the area of the square
   // -------------------------------------
   public double getArea() {
      return Math.pow(side, 2);
   }

   // -------------------------------------
   //   Returns a string with measurements for printing measurements
   // -------------------------------------
   public String toString() {
      return ("The area of a square with a side " + side + " is " + getArea() + ".");
   }
}