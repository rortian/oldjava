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
import Publications.*;

public class RuntimeTypeInfoDemo {

    public static void main(String args[]) {
    Book book1 = new Book("Sunrise over Saratoga", "Fiction", "Story Tellers, Ltd.", "Vern Goodman");

    if (book1.getClass().getName().equals("Publications.Publication"))
       System.out.println("book1 is of type Publication");
    else
       System.out.println("book1 is NOT of type Publication");

    if (book1.getClass().getName().equals("Publications.Book")) {
       System.out.println("book1 is of type Book");
       System.out.println("book1 is authored by "+book1.getAuthor());
       }
    else
       System.out.println("book1 is NOT of type Book");

    if (book1.getClass().getName().equals("Publications.Manual"))
       System.out.println("book1 is of type Manual");
    else
       System.out.println("book1 is NOT of type Manual");

    System.out.println("Variable book1 represents an instance of "+book1.getClass().getName());

    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }

}
