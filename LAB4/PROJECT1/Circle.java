/**********************************************************
 * File name:       Circle.java                           *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class Circle extends TwoDShape {

   double radius;

   // -------------------------------------
   //   Constructor, creates circle of given radius
   // -------------------------------------
   public Circle(double radius) {
      this.radius = radius;
   }

   // -------------------------------------
   //   Returns the area of the circle
   // -------------------------------------
   public double getArea() {
      return Math.PI * Math.pow(radius, 2);
   }

   // -------------------------------------
   //   Returns a string with measurements for printing measurements
   // -------------------------------------
   public String toString() {
      return ("The area of a circle with a radius " + radius + " is " + getArea() + ".");
   }
}
