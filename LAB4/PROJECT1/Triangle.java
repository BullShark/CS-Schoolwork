/**********************************************************
 * File name:       Triangle.java                         *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class Triangle extends TwoDShape {

   double a, b, c, p, s;

   // -------------------------------------
   //   Constructor, creates triangle of given sides and adds them for the  perimeter
   // -------------------------------------
   public Triangle(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
      p = a + b + c;
      s = p/2; // for the area formula
   }

   // -------------------------------------
   //   Returns the area of the triangle
   // -------------------------------------
   public double getArea() {
      return Math.sqrt(s * (s - a) * (s - b) * (s - c));
   }

   // -------------------------------------
   //   Returns a string with measurements for printing measurements
   // -------------------------------------
   public String toString() {
      return ("The area of a triangle with a perimeter " + p + " and length of sides " +
      a + ", " + b + ", and " + c +  " is " + getArea() + ".");
   }
}