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

public class ExceptionDemo3 {

  static void MergeStreams(FileInputStream in1, FileInputStream in2, String outfile)
                          throws IOException, FileNotFoundException {
        FileOutputStream outStream = null;
        try {
            byte [] buffer = new byte[1];
            outStream = new FileOutputStream(outfile);

            // The following code will do an intentional throw when
            // uncommented and compiled

            if (outStream != null)
               throw new IOException(outfile);

            // The following statements of this try block
            // are ignored if an exception is thrown from
            // the previous statement

            while ((in1.read(buffer) != -1))
               outStream.write(buffer);

            while ((in2.read(buffer) != -1))
               outStream.write(buffer);

            outStream.close();
            }
        catch (IOException err) {
	        System.out.println(err.toString());
	        System.out.println("Closing the output stream...\n");
	        if (outStream != null)
	           outStream.close();
	        throw new FileNotFoundException(outfile);
            }
        catch (Exception err) {
	        System.out.println(err.toString());
	        System.out.println("Closing the output stream...\n");
	        if (outStream != null)
	           outStream.close();
	        throw new FileNotFoundException(outfile);
            }
        }

    static void OpenSecondInputStream(FileInputStream input1, String infile2)
                                      throws IOException, FileNotFoundException {
        FileInputStream inStream2 = null;
        try {
            inStream2 = new FileInputStream("TERMS2.TXT");
            MergeStreams(input1, inStream2, "TERMS3.TXT");
            inStream2.close();
            }
        catch (FileNotFoundException err) {
            System.out.println(err.toString());
            System.out.println("Closing second input stream...\n");
            if (inStream2 != null)
               inStream2.close();
            throw err;
            }
        catch (IOException err) {
            System.out.println(err.toString());
            System.out.println("Closing second input stream...\n");
            if (inStream2 != null)
               inStream2.close();
            throw err;
            }
        }

    public static void main(String args[]) {
        FileInputStream inStream1 = null;
        try {
            inStream1 = new FileInputStream("TERMS1.TXT");
            OpenSecondInputStream(inStream1, "TERMS2.TXT");
	        inStream1.close();
            }
        catch (Exception err) {
            err.printStackTrace();
            System.out.println("Closing first input stream...\n");
            if (inStream1 != null)
               try {
                   inStream1.close();
                   }
               catch (IOException e) {
                   System.out.println(e.toString());
                   }
	        System.out.println("At least one input or output stream failed to open...");
	        System.out.println("Exiting program...");
	        ExitPrompt();
            }
        }

 static void ExitPrompt() {
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
        }
}
