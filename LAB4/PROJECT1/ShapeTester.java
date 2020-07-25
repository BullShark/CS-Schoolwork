/**********************************************************
 * File name:       ShapeTester.java                      *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

public class ShapeTester {
   public static void main(String[] args) {

      // -------------------------------------
      //   Prints who it was written by prints and what it does
      // -------------------------------------
      System.out.println("This program was written by Chris Lemire.\nIt demonstrates polymorphism and inheritance.\n");

      // -------------------------------------
      //   Makes an array with 5 shape elements then cast them to a specific shape and instantiate
      // -------------------------------------
      Shape[] S = new Shape[5];
      S[0] = new Circle(6);
      S[1] = new Square(7);
      S[2] = new Triangle(3, 4, 5);
      S[3] = new Sphere(8);
      S[4] = new Cube(8);

      // -------------------------------------
      //   Prints each shape and tells whether the shape is 2 deminionsional or 3 deminsional
      // -------------------------------------
      for(int i=0;i<S.length;i++) {
         System.out.println(S[i]);
         if (S[i] instanceof TwoDShape)
            System.out.println("The shape is a two dimensional object.\n");
         if (S[i] instanceof ThreeDShape)
            System.out.println("The shape is a three dimensional object.\n");

      }
   }
}
