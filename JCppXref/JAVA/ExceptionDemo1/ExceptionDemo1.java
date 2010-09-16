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

class Glossary {
    Glossary(String name) throws FileNotFoundException, IOException {
        FileInputStream inStream = new FileInputStream(name);
        filename = new String(name);
        inStream.close();
        }
    void Display() throws FileNotFoundException, IOException {
        String line = null;
        FileInputStream inStream = new FileInputStream(filename);
        DataInputStream inDataStream = new DataInputStream(inStream);
        while ((line = inDataStream.readLine()) != null)
           System.out.println(line);
        inDataStream.close();
        inStream.close();
        }
    private String filename;
    final int MAX_WORD_LENGTH = 161;
}

public class ExceptionDemo1 {

    public static void main(String args[]) {
        try {
            Glossary gloss = new Glossary("TERMS.TXT");
	        gloss.Display();
            }
        catch (FileNotFoundException err) {
	        System.out.println(err.toString());
            }
        catch (IOException err) {
	        System.out.println(err.toString());
            }
        catch (Exception err) {
            System.out.println(err.toString());
            }
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}
