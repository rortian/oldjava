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

public class FinallyDemo {

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

            }
        catch (IOException err) {
            System.out.println("In catch(IOException) block of MergeStreams");
	        System.out.println(err.toString());
	        // throw new FileNotFoundException(outfile);
            }
        catch (Exception err) {
            System.out.println("In catch(Exception) block of MergeStreams");
	        System.out.println(err.toString());
	        // throw new FileNotFoundException(outfile);
            }
        finally {
            System.out.println("In finally block of MergeStreams");
            System.out.println("Closing the output stream...");
          	if (outStream != null)
	           outStream.close();
	        }
	    // Executable statements after the try-catch-finally blocks
	    System.out.println("First statement after finally block of MergeStreams");
        }

    static void OpenSecondInputStream(FileInputStream input1, String infile2)
                                      throws IOException, FileNotFoundException {
        FileInputStream inStream2 = null;
        try {
            inStream2 = new FileInputStream("TERMS2.TXT");
            MergeStreams(input1, inStream2, "TERMS3.TXT");
            }
        catch (FileNotFoundException err) {
            System.out.println("In catch(FileNotFoundException) block of OpenSecondInputStream");
            System.out.println(err.toString());
            // throw err;
            }
        catch (IOException err) {
            System.out.println("In catch(IOException) block of OpenSecondInputStream");
            System.out.println(err.toString());
            // throw err;
            }
        finally {
            System.out.println("In finally block of OpenSecondInputStream");
            System.out.println("Closing the second input stream...");
          	if (inStream2 != null)
	           inStream2.close();
	        }
	    // Executable statements after the try-catch-finally blocks
	    System.out.println("First statement after finally block of OpenSecondInputStream");
        }

    public static void main(String args[]) {
        FileInputStream inStream1 = null;
        try {
            inStream1 = new FileInputStream("TERMS1.TXT");
            OpenSecondInputStream(inStream1, "TERMS2.TXT");
            }
        catch (Exception err) {
            System.out.println("In catch(Exception) block of main");
            System.out.println(err.toString());
            }
        finally {
            System.out.println("In finally block of main");
            System.out.println("Closing the first input stream...");
            try {
          	    if (inStream1 != null)
	               inStream1.close();
	            }
	        catch (IOException e) {
	            System.out.println(e.toString());
	            }
	        System.out.println("Leaving finally block of main");
	        }
	    // The flow of control proceeds to the following statements
	    System.out.println("First and last statement after finally block of main");
        ExitPrompt();
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
