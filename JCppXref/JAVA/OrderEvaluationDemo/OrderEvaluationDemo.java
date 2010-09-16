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

import java.io.IOException;

public class OrderEvaluationDemo {

   static int add_and_increment(int val1, int val2) {
   return (val1 + val2 + 1);
   }

   public static void main(String argv[]) {
   int x = 5;
   int y;
   int m = 10;
   int n;

   System.out.println("At start, x = "+x);
   y = x + x++;
   System.out.println("At end, x = "+x+", y = "+y+"\n");

   System.out.println("At start, m = "+m);
   n = add_and_increment(m, m++);
   System.out.println("At end, m = "+m+", n = "+n+"\n");


   System.out.println("\n(press Enter to exit)");
   try {
       System.in.read();
       }
   catch (IOException e) {
       return;
       }
   }
}
