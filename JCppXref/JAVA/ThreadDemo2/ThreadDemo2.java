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
import RunnableSort.QSort;

public class ThreadDemo2 {

    public static void main(String args[]) {
    QSort qs1 = new QSort("TERMS1.TXT", "TERMS2.TXT");
    QSort qs2 = new QSort("TERMS3.TXT", "TERMS4.TXT");
    QSort qs3 = new QSort("TERMS5.TXT", "TERMS6.TXT");

    Thread td1 = new Thread(qs1, "td1");
    Thread td2 = new Thread(qs2, "td2");
    Thread td3 = new Thread(qs3, "td3");

    td1.setPriority(Thread.NORM_PRIORITY);
    td2.setPriority(Thread.NORM_PRIORITY+1);
    td3.setPriority(Thread.NORM_PRIORITY+2);

    td1.start();
    td2.start();
    td3.start();

    while ((td1.isAlive()) || (td2.isAlive()) || (td3.isAlive()));

    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }

}
