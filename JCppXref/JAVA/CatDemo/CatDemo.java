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

public class CatDemo {

    static void GetAndDisplayKeyboardInput(DataInputStream dataIn) {
    try {
        String inBuffer = null;
        while ((inBuffer = dataIn.readLine()) != null)
           System.out.println(inBuffer);
        }
    catch (IOException err) {
        System.out.println(err.toString());
        Prompt();
        System.exit(1);
        }
    }

    static void GetAndDisplayLines(String filename, DataInputStream dataIn) {
    try {
        String inBuffer = null;
        System.out.println(filename+":");
        while ((inBuffer = dataIn.readLine()) != null)
           System.out.println(inBuffer);
        System.out.println();
        }
    catch (IOException err) {
        System.out.println(err.toString());
        Prompt();
        System.exit(1);
        }
    }

    public static void main(String args[]) {

    DataInputStream dataInputStream = null;

    if (args.length == 0) {
        dataInputStream = new DataInputStream(System.in);
        GetAndDisplayKeyboardInput(dataInputStream);
        }
    else
    if (args.length > 0) {
        int index = 0;
        for (index = 0; index < args.length; index++) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(args[index]));
                GetAndDisplayLines(args[index], dataInputStream);
                try {
                    dataInputStream.close();
                    }
                catch(IOException err) {
                    System.err.println(err.toString());
                    Prompt();
                    System.exit(1);
                    }
                }
            catch(FileNotFoundException err) {
                System.out.println("File "+args[index]+" not found!");
                System.out.println();
                }
            }  // for
        }  // if (args.length > 0)

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
