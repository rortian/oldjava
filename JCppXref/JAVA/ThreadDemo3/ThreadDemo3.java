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

class FullPipe {

   FullPipe() {                                 /* (1) */
   try {
       inPipe  = new PipedInputStream();
       outPipe = new PipedOutputStream(inPipe);
       send_count = 0;
       recv_count = 0;
       }
   catch(IOException err) {
       System.out.println(err.toString());
       System.exit(-1);
       }
   }

   PipedOutputStream getOutPipe() {
   return outPipe;
   }

   PipedInputStream getInPipe() {
   return inPipe;
   }

   long getSendCount () {
   return send_count;
   }

   void updateSendCount(long value) {
   send_count += value;
   }

   long getRecvCount () {
   return recv_count;
   }

   void updateRecvCount(long value) {
   recv_count += value;
   }

   public void close() {
   try {
       inPipe.close();
       outPipe.close();
       }
   catch(IOException err) {
       }
   }

   private PipedOutputStream outPipe;
   private PipedInputStream  inPipe;
   private long              recv_count;
   private long              send_count;
}


class Transmitter extends Thread {                     /* (2) */

   Transmitter(int times, FullPipe fp) {
   fullPipe = fp;
   iterations = times;
   }

   public void run() {                                 /* (3) */
   int ivalue;
   byte buffer = 0;
   try {
       for (int index = 0; index < iterations; index++) {
          buffer = (byte)(100 * Math.random());
          fullPipe.getOutPipe().write(buffer);
          fullPipe.updateSendCount(1);
          try {
              sleep(1);
              }
          catch(InterruptedException err) {
              System.out.println(err.toString());
              System.exit(-1);
              }
          }
       buffer = (byte) -1;
       fullPipe.getOutPipe().write(buffer);
       }
   catch(IOException err) {
      System.out.println(err.toString());
      System.exit(-1);
      }
   }

   private FullPipe        fullPipe;
   private int             iterations;
}

class Receiver extends Thread {                         /* (4) */

   Receiver(int count, FullPipe fp) {
   fullPipe = fp;
   no_of_senders = count;
   }

   public void run() {                                  /* (5) */
   int  ivalue;
   int count = 0;
   byte [] buffer = new byte[1];
   PipedInputStream dis = fullPipe.getInPipe();
   try {
       while ((ivalue = dis.read(buffer, 0, 1)) != -1){
          if (buffer[0] == -1) {
             count++;
             if (count==no_of_senders)
                break;
             }
          else {
             fullPipe.updateRecvCount(1);
             if (fullPipe.getRecvCount() % 500 == 0)
                System.out.println("Send count = "+fullPipe.getSendCount()+", receive count = "+fullPipe.getRecvCount());
             }
          try {
              sleep(1);
              }
          catch(InterruptedException err) {
              System.out.println(err.toString());
              System.exit(-1);
              }
          }  // while
       }
   catch(IOException err) {
      System.out.println(err.toString());
      System.exit(-1);
      }
   }

   private int       no_of_senders;
   private FullPipe  fullPipe;
}

public class ThreadDemo3 {                                  /* (6) */

   public static void main(String args[]) {
   FullPipe pipe = new FullPipe();
   Transmitter tran1  = new Transmitter(3000, pipe);
   Transmitter tran2  = new Transmitter(3000, pipe);
   Transmitter tran3  = new Transmitter(3000, pipe);
   Transmitter tran4  = new Transmitter(3000, pipe);
   Transmitter tran5  = new Transmitter(3000, pipe);
   Transmitter tran6  = new Transmitter(3000, pipe);
   Transmitter tran7  = new Transmitter(3000, pipe);
   Transmitter tran8  = new Transmitter(3000, pipe);
   Transmitter tran9  = new Transmitter(3000, pipe);
   Transmitter tran10 = new Transmitter(3000, pipe);

   Receiver    recv   = new Receiver(10, pipe);

   tran1.setPriority(Thread.NORM_PRIORITY + 1);
   tran2.setPriority(Thread.NORM_PRIORITY + 1);
   tran3.setPriority(Thread.NORM_PRIORITY + 1);
   tran4.setPriority(Thread.NORM_PRIORITY + 1);
   tran5.setPriority(Thread.NORM_PRIORITY + 1);
   tran6.setPriority(Thread.NORM_PRIORITY + 1);
   tran7.setPriority(Thread.NORM_PRIORITY + 1);
   tran8.setPriority(Thread.NORM_PRIORITY + 1);
   tran9.setPriority(Thread.NORM_PRIORITY + 1);
   tran10.setPriority(Thread.NORM_PRIORITY + 1);
   recv.setPriority(Thread.NORM_PRIORITY + 3);

   tran1.start();
   tran2.start();
   tran3.start();
   tran4.start();
   tran5.start();
   tran6.start();
   tran7.start();
   tran8.start();
   tran9.start();
   tran10.start();
   recv.start();

   while ((tran1.isAlive()) || (tran2.isAlive()) || (tran3.isAlive()) ||
          (tran4.isAlive()) || (tran5.isAlive()) || (tran6.isAlive()) ||
          (tran7.isAlive()) || (tran8.isAlive()) || (tran9.isAlive()) ||
          (tran10.isAlive()) || (recv.isAlive()));

   System.out.println("Total number of bytes sent = " + pipe.getSendCount());
   System.out.println("Total number of bytes received = " + pipe.getRecvCount());

   pipe.close();

   System.out.println("(press Enter to exit)");
   try {
       System.in.read();
       }
   catch (IOException e) {
       return;
       }
   }

}
