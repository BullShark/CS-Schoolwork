/**********************************************************
 * File name:       TwoDShape.java                        *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrate Polymorphism and Inheritance      *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

// -------------------------------------
//   Makes classes extending this one define methods to return area of their shapes
// -------------------------------------
abstract public class TwoDShape extends Shape {
   abstract public double getArea();
}