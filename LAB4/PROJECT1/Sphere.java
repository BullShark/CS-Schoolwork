/**********************************************************
 * File name:       Sphere.java                           *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class Sphere extends ThreeDShape {

   double radius;

   // -------------------------------------
   //   Constructor, creates sphere of given length
   // -------------------------------------
   public Sphere(double radius) {
      this.radius = radius;
   }

   // -------------------------------------
   //   Returns the area of the sphere
   // -------------------------------------
   public double getArea() {
      return 4 * Math.PI * Math.pow(radius, 2);
   }

   // -------------------------------------
   //   Returns the volume of the sphere
   // -------------------------------------
   public double getVolume() {
      return 4.0/3.0 * Math.PI * Math.pow(radius, 3);
   }

   // -------------------------------------
   //   Returns a string with measurements for printing measurements
   // -------------------------------------
   public String toString() {
      return ("The area of a sphere with a radius " + radius + " is " + getArea() +
      " and volume is " + getVolume() + ".");
   }
}
