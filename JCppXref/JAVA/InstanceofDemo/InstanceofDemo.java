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
import Publications.*;
import java.io.IOException;

public class InstanceofDemo {

    public static void main(String args[]) {
    Publication pub1 = new Publication("The Handyman Journal", "Home Repairs", "Easy Publications");
    Book book1 = new Book("Sunrise over Saratoga", "Fiction", "Story Tellers, Ltd.", "Vern Goodman");
    Manual manual1 = new Manual("Steller C++ User's Guide", "Programming Languages", "Star Publishers", "Roberta Soo", "Steller C++");

    if (pub1 instanceof Book)
       System.out.println("pub1 is a Book with author "+((Book)pub1).getAuthor());
    else
       System.out.println("pub1 is NOT a Book");

    if (book1 instanceof Book)
       System.out.println("book1 is a Book with author "+((Book)book1).getAuthor());
    else
       System.out.println("book1 is NOT a Book");

    if (manual1 instanceof Book)
       System.out.println("manual1 is a Book with author "+((Book)manual1).getAuthor());
    else
       System.out.println("manual1 is NOT a Book");

    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }
}
