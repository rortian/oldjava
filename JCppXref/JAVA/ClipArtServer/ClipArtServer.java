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

import java.io.*;
import java.net.*;

class ClipArtAssistant extends Thread {

    ClipArtAssistant(Socket s) {
       sock = s;
    }

    public void run() {
       try {
           DataOutputStream out = new DataOutputStream(sock.getOutputStream());
           DataInputStream  in  = new DataInputStream(sock.getInputStream());

           filename = in.readLine();
           File fobj = new File(filename);
           FileInputStream fis = null;

           int count;
           byte [] barray = new byte[8192];

           if (fobj.exists() && fobj.isFile()) {
              fis = new FileInputStream(fobj);
              while ((count = fis.read(barray)) != -1) {
                 out.write(barray, 0, count);
                 out.flush();
                 sleep(5);
                 }
              }

           in.close();
           out.close();
           sock.close();
           }
       catch(Exception err) {
           System.err.println(err.toString());
           System.exit(-1);
           }
    }

    private Socket sock;
    private String filename;
}

public class ClipArtServer {

    public static void main(String args[]) {
        Socket sock = null;
        FileInputStream fis = null;
        ClipArtAssistant ca = null;
        try {
            ServerSocket servsock = new ServerSocket(new Integer(args[0]).intValue());
            while (true) {
               sock = servsock.accept();
               ca = new ClipArtAssistant(sock);
               ca.start();
               }
             }
          catch (Exception err) {
             System.out.println(err.toString());
             System.exit(-1);
             }

    }
}
