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
import Sort.QSort;

public class ThreadDemo1 {

    public static void main(String args[]) {
    QSort qs1 = new QSort("TERMS1.TXT", "TERMS2.TXT", "qs1");
    QSort qs2 = new QSort("TERMS3.TXT", "TERMS4.TXT", "qs2");
    QSort qs3 = new QSort("TERMS5.TXT", "TERMS6.TXT", "qs3");

    qs1.start();
    qs2.start();
    qs3.start();

    while ((qs1.isAlive()) || (qs2.isAlive()) || (qs3.isAlive()));

    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }

}
