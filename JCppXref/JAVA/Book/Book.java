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

package Publications;
import java.awt.*;
import java.io.IOException;

    public class Book extends Publication {
    private String author;

    public Book() {
    this("some title", "some subject", "some publisher", "some author");
    }

    public Book(String tit, String sub, String pub, String aut) {
    super(tit, sub, pub);
    author = new String(aut);
    }

    public String getAuthor() {
    return author;
    }

    public void Display() {
    System.out.println("Title:  "+getTitle()+", Subject:  "+getSubject()+", Publisher:  "+getPublisher()+", Author:  "+getAuthor());
    }

    public static void main(String args[]) {;
        Book book1 = new Book("Sunrise over Saratoga", "Fiction", "Story Tellers, Ltd.", "Vern Goodman");
        book1.Display();
        System.out.println("(press Enter to exit Book)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }

}
