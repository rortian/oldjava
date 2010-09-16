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

/**
 *
 * Program:  CommandLineDemo
 *
 * Author:  Frederick F. Chew
 *
 * Description:  This program is for displaying the arguments entered
 * on the command line.  In addition, the total number of arguments is
 * also displayed.
 *
 */

import java.io.IOException;

public class CommandLineDemo {

     /**
      *
      * main:  The entry point for a standalone Java program.
      *
      */

     public static void main(String argv[]) {

     if (argv.length > 0)  {
        for (int index = 0; index < argv.length; index++)
           System.out.println("\nArgument #"+index+" is "+argv[index]);
        System.out.println("\nTotal number of arguments: "+argv.length);
        }
     else
        System.out.println("\nNo arguments were entered!");

     System.out.println("\n(press Enter to exit)");
     try {
         System.in.read();
         }
     catch (IOException e) {
         return;
         }
     }
}
