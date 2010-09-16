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

public class BitShiftDemo1 {

     public static void main(String argv[]) {
     int num1 = 16;
     System.out.println("num1 = "+num1);
     num1 = num1>>2;
     System.out.println("num1 = "+num1);

     int num2 = 3;
     System.out.println("num2 = "+num2);
     num2 = num2<<2;
     System.out.println("num2 = "+num2);

     int num3 = -16;
     System.out.println("num3 = "+num3);
     num3 = num3>>2;
     System.out.println("num3 = "+num3);

     int num4 = -3;
     System.out.println("num4 = "+num4);
     num4 = num4>>2;
     System.out.println("num4 = "+num4);

     int num5 = 0x40000000;   // 1073741824 in decimal
     System.out.println("num5 = "+num5);
     num5 = num5<<1;
     System.out.println("num5 = "+num5);

     int num6 = 0xFFFFFFFF;   // Two's complement: -1
     System.out.println("num6 = "+num6);
     num6 = num6>>>1;
     System.out.println("num6 = "+num6);

     System.out.println("\n(press Enter to exit)");
     try {
         System.in.read();
         }
     catch (IOException e) {
         return;
         }
     }
}

