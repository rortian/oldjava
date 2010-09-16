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
import java.io.*;
import java.util.*;
import Publications.*;
import java.io.IOException;

public class NewInstanceDemo1 {

    public static void main(String args[]) {
    Publication book1 = new Book("Sunrise over Saratoga", "Fiction", "Story Tellers, Ltd.", "Vern Goodman");
    Object obj1;
    try {
        obj1 = book1.getClass().newInstance();

        if (obj1.getClass().getName().equals("Publications.Book")) {
           System.out.println("obj1 is of type Book");
           System.out.println("obj1 is authored by "+((Book)obj1).getAuthor());
           }
        else
           System.out.println("obj1 is NOT of type Book");

        System.out.println("Variable obj1 represents an instance of "+obj1.getClass().getName());
        }
     catch (InstantiationException error) {
        System.out.println("Instantiation Exception!");
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException io_error) {
            System.exit(1);
            }
        System.exit(1);
        }
     catch (IllegalAccessException error) {
        System.out.println("Illegal Access Exception!");
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException io_error) {
            System.exit(1);
            }
        System.exit(1);
        }
     catch (NoSuchMethodError error) {
        System.out.println("No Such Method Error!");
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException io_error) {
            System.exit(1);
            }
        System.exit(1);
        }
     catch (Exception error) {
        System.out.println("General Exception!");
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException io_error) {
            System.exit(1);
            }
        System.exit(1);
        }
    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException io_error) {
        return;
        }
    }

}

