/**********************************************************
 * File name:       CopyFile.java                         *
 *                                                        *
 * Lab 5 Programming Project 1                            *
 * Purpose: Demonstrates exception handling               *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 22, 2005                                    *
 **********************************************************
 */

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class CopyFile {
   public static void main(String[] args) {

      Scanner scan;
      boolean once = true;
      String s = "";
      System.out.println("This program was written by Chris Lemire.");


      if(args.length != 2) // two arguments must be gave
         System.out.println("Usage: java CopyFile source_file destination_file.");

      else {			
         File a = new File(args[0]);

         do {
            if(once) { // do the try block in this if block only the first time through the loop
               try {

                  scan = new Scanner(a);

                  while (scan.hasNext())
                     s += scan.nextLine() + "\n";

                  FileWriter f = new FileWriter(args[1]);
                  BufferedWriter b = new BufferedWriter(f);
                  PrintWriter p = new PrintWriter(b);

                  p.print(s);
                  p.close();
                  System.out.println(args[1] + " has been copied to " + args[1] + " successfully.");

               }
               catch(FileNotFoundException e) {
                  System.out.println("File " + args[0] + " does not exist, please try again.");
               }
               catch(ArrayIndexOutOfBoundsException e) {
                  System.out.println("File " + args[0] + " does not exist, please try again.");
               }
               catch(Exception e) { // this one catches all exceptions
                  System.out.println("File " + args[0] + " does not exist, please try again.");
               }
               finally {
               }
            }
				
            if(!a.exists()) {
               System.out.println("Enter the file name you want to copy:");
				
            try {
               Scanner scanFile = new Scanner(System.in);
               args[0] = scanFile.next();
               a = new File(args[0]);
               scan = new Scanner(a);
			
               while (scan.hasNext())
                  s += scan.nextLine() + "\n";

               FileWriter f = new FileWriter(args[1]);
               BufferedWriter b = new BufferedWriter(f);
               PrintWriter p = new PrintWriter(b);

               p.print(s);
               p.close();
               System.out.println(args[0] + " has been copied to " + args[1] + " successfully.");

            } // end of try
            catch(FileNotFoundException e) {
               System.out.println("File " + args[0] + " does not exist, please try again.");
            }
            catch(ArrayIndexOutOfBoundsException e) {
               System.out.println("File " + args[0] + " does not exist, please try again.");
            }
            catch(Exception e) {
            System.out.println("File " + args[0] + " does not exist, please try again.");
            }
            finally {
            }
         }
         once = false; // sets once to false after the first iteration of the loop                       

         } while(!a.exists());
      }
   }
}
