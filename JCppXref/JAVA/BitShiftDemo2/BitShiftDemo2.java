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

public class BitShiftDemo2 {

     public static void main(String argv[]) {

     int anInt = -1;
     System.out.println("anInt = "+anInt);
     anInt >>>= 1;
     System.out.println("anInt = "+anInt);

     byte aByte = (byte)-1;
     System.out.println("aByte = "+aByte);
     aByte = (byte)((aByte & 0xFF)>>1);
     // aByte >>>= 1;
     System.out.println("aByte = "+aByte);
     aByte = (byte)((aByte & 0xFF)>>1);
     System.out.println("aByte = "+aByte);

     short aShort = -1;
     System.out.println("aShort = "+aShort);
     aShort = (short)((aShort & 0xFFFF)>>1);
     // aShort >>>= 1;
     System.out.println("aShort = "+aShort);
     aShort = (short)((aShort & 0xFFFF)>>1);
     System.out.println("aShort = "+aShort);

     System.out.println("\n(press Enter to exit)");
     try {
         System.in.read();
         }
     catch (IOException e) {
         return;
         }
     }
}

