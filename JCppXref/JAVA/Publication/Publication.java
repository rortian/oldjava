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

public class Publication {
    private String title;
    private String subject;
    private String publisher;

    public Publication(String tit, String sub, String pub) {
    title = new String(tit);
    subject = new String(sub);
    publisher = new String(pub);
    }

    public String getTitle() {
    return title;
    }

    public String getSubject() {
    return subject;
    }

    public String getPublisher() {
    return publisher;
    }

    public void Display() {
    System.out.println("Title:  "+getTitle()+", Subject:  "+getSubject()+", Publisher:  "+getPublisher());
    }

    public static void main(String args[]) {
    Publication pub1 = new Publication("The Handyman Journal", "Home Repairs", "Easy Publications");
    pub1.Display();
    System.out.println("(press Enter to exit Publication)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }

}
