/*
 * Frederick F. Chew, The Java/C++ Cross Reference Handbook (Book/CD-ROM)
 * Published By HP Press/Prentice-Hall
 * Copyright (C) 1997 Hewlett-Packard Company
 * All Rights Reserved. ISBN 0-13-848318-3
 *
 * Permission to use, copy, modify, and distribute this 
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this 
 * copyright notice appears in all copies. 
 * 
 * THE AUTHOR AND PUBLISHER MAKE NO REPRESENTATIONS OR 
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. THE AUTHOR
 * AND PUBLISHER SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED 
 * BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING 
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
 
/**
 * @version 1.00 01 May 1997
 * @author Frederick F. Chew
 */

import java.awt.Point;
import java.io.IOException;

public class ParameterPassingDemo {

     public static void swap_by_value(int x, int y) {
     int temp;
     temp = x;
     x = y;
     y = temp;
     }

     public static void exchange_coordinates_by_reference(Point pt) {
     int temp = pt.x;
     pt.x = pt.y;
     pt.y = temp;

     System.out.println("\n Inside exchange_coordinates_by_reference...");
     System.out.println("\n pt.x = " + pt.x);
     System.out.println("\n pt.y = " + pt.y);
     }

     public static void main(String argv[]) {

         int num1 = -30;
         int num2 =  45;

         System.out.println("\n Before calling swap_by_value...");
         System.out.println("\n num1 = "+num1);
         System.out.println("\n num2 = "+num2);

         swap_by_value(num1,num2);

         System.out.println("\n After calling swap_by_value...");
         System.out.println("\n num1 = "+num1);
         System.out.println("\n num2 = "+num2);

         Point aPoint = new Point(-50,300);

         System.out.println("\n Before calling exchange_coordinates_by_reference...");
         System.out.println("\n aPoint.x = " + aPoint.x);
         System.out.println("\n aPoint.y = " + aPoint.y);

         exchange_coordinates_by_reference(aPoint);

         System.out.println("\n After calling exchange_coordinates_by_reference...");
         System.out.println("\n aPoint.x = " + aPoint.x);
         System.out.println("\n aPoint.y = " + aPoint.y);

         System.out.println("\n(press Enter to exit)");
         try {
             System.in.read();
             }
         catch (IOException e) {
             return;
             }
         }
}
