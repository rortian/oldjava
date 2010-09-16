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

import java.awt.*;
import java.io.IOException;

public class CompareDemo {

    public static void main(String args[]) {
        String str1 = new String("Tequilla Sunset");
        String str2 = new String("Tequilla Sunset");
        String str3 = new String("Tequilla Sundown");
        String str4 = str1;
        /* (1) */
        if (str1 == str2)
           System.out.print("Variables str1 and str2 refer to the same object\n");
        else
           System.out.print("Variables str1 and str2 do NOT refer to the same object\n");

        if (str1.equals(str2))
            System.out.println("The objects referred to by str1 and str2 are equal in content\n");
        else
            System.out.println("The objects referred to by str1 and str2 are NOT equal in content\n");
        /* (2) */
        if (str2 == str3)
           System.out.print("Variables str2 and str3 refer to the same object\n");
        else
           System.out.print("Variables str2 and str3 do NOT refer to the same object\n");

        if (str2.equals(str3))
           System.out.println("The objects referred to by str2 and str3 are equal in content\n");
        else
           System.out.println("The objects referred to by str2 and str3 are NOT equal in content\n");
        /* (3) */
        if (str1 == str4)
           System.out.print("Variables str1 and str4 refer to the same object\n");
        else
           System.out.print("Variables str1 and str4 do NOT refer to the same object\n");

        if (str1.equals(str4))
           System.out.println("The objects referred to by str1 and str4 are equal in content\n");
        else
          System.out.println("The objects referred to by str1 and str4 are NOT equal in content\n");

		System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}
