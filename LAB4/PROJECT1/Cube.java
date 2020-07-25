/**********************************************************
 * File name:       Cube.java                             *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class Cube extends ThreeDShape {

   double length;

   // -------------------------------------
   //   Constructor, creates cube of given length
   // -------------------------------------
   public Cube(double length) {
      this.length = length;
   }

   // -------------------------------------
   //   Returns the area of the cube
   // -------------------------------------
   public double getArea() {
      return 6 * Math.pow(length, 2);
   }

   // -------------------------------------
   //   Returns the volume of the cube
   // -------------------------------------
   public double getVolume() {
      return Math.pow(length, 3);
   }

   // -------------------------------------
   //   Returns a string with measurements for printing measurements
   // -------------------------------------
   public String toString() {
      return ("The area of a cube with a length " + length + " is " + getArea() +
      " and volume is " + getVolume() + ".");
   }
}