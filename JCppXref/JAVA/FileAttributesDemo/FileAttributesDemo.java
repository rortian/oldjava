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

public class FileAttributesDemo {

    static void DisplayFileAttributes(File fobj) {

    System.out.println();
    System.out.println("Attributes of File: "+fobj.getName());
    System.out.println("Absolute path: "+fobj.getAbsolutePath());
    System.out.println("Readable: "+ (fobj.canRead()?"Yes":"No"));
    System.out.println("Writeable: "+ (fobj.canWrite()?"Yes":"No"));
    if (fobj.isFile())
       System.out.println("Length of file: "+fobj.length());
    if (fobj.isDirectory()) {
       System.out.println();
       System.out.println(fobj.getName()+" contains:");
       String [] element = fobj.list();
       for (int index=0; index<element.length; index++)
          System.out.println(element[index]);
       }
    }

    static void EditFileName(String filename) {

    try {
        File file_obj = new File(filename);
        if (file_obj.exists())
           DisplayFileAttributes(file_obj);
        else
           System.out.println(file_obj.getName()+" does not exist!");
        }
    catch (NullPointerException err) {
        System.err.println(err.toString());
        Prompt();
        }
    }

    public static void main(String args[]) {

    try {
        String line = null;

        DataInputStream ins = new DataInputStream(System.in);

        do {
           System.out.print("\nEnter the name of a file or directory or press EOF to exit: ");
           System.out.flush();

           if ((line = ins.readLine()) != null)
              if (line.length() != 0)
                 EditFileName(line);

           } while (line != null);

        }
    catch (IOException err) {
        System.err.println(err.toString());
        }

    Prompt();
    }

    static void Prompt() {
    System.out.println("(press Enter to exit)");
     try {
         System.in.read();
         }
     catch (IOException e) {
         return;
         }
    }
}
