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

/**
 * Note:  This program was built from the JDK version 1.1
 *
 */

import java.awt.*;
import java.io.*;

class FullPipe {

   FullPipe() {
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

   synchronized void updateSendCount(long value) {
   send_count += value;
   }

   long getRecvCount () {
   return recv_count;
   }

   synchronized void updateRecvCount(long value) {
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


class Transmitter extends Thread {

   Transmitter(ThreadGroup group, String name, int times, FullPipe fp) {
   super(group, name);
   fullPipe = fp;
   iterations = times;
   }

   public void run() {
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

class Receiver extends Thread {

   Receiver(ThreadGroup group, String name, int count, FullPipe fp) {
   super(group, name);
   fullPipe = fp;
   no_of_senders = count;
   }

   public void run() {
   int  ivalue;
   int count = 0;
   byte [] buffer = new byte[1];
   PipedInputStream dis = fullPipe.getInPipe();
   try {
       while ((ivalue = dis.read(buffer, 0, 1)) != -1) {
          if (buffer[0] == -1) {
             count++;
             if (count==no_of_senders)
                break;
             }
          else {
             fullPipe.updateRecvCount(1);
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

class Monitor extends Thread {
   Monitor(ThreadGroup group, String name, FullPipe fp,
           TextField send, TextField receive, TextField status,
           Thread recvThread, Button beginButton, Button endButton,
           Button continueButton, Button pauseButton) {
   super(group, name);
   fullPipe      = fp;
   sendField     = send;
   recvField     = receive;
   statusField   = status;
   receiveThread = recvThread;
   startButton   = beginButton;
   stopButton    = endButton;
   resumeButton  = continueButton;
   suspendButton = pauseButton;
   }

   public void run() {
   while (true) {
      if (fullPipe.getRecvCount() % 20 == 0) {
         sendField.setText(new Long(fullPipe.getSendCount()).toString());
         recvField.setText(new Long(fullPipe.getRecvCount()).toString());
         statusField.setText("Transmitting ...");
         }
      if (!receiveThread.isAlive()) {
         statusField.setText("Transfer Completed");
         startButton.enable();
         stopButton.disable();
         resumeButton.disable();
         suspendButton.disable();
         break;
         }
      try {
          sleep(10);
          }
      catch (InterruptedException err) {
          }
      }
   }

   private FullPipe  fullPipe;
   private TextField sendField;
   private TextField recvField;
   private TextField statusField;
   private Thread    receiveThread;
   private Button    startButton;
   private Button    stopButton;
   private Button    resumeButton;
   private Button    suspendButton;

}

public class ThreadDemo5 extends Frame {

    public ThreadDemo5() {

        super("ThreadDemo5 window");
        threadGroup = null;

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 396, insets().top + insets().bottom + 227);
        sendField=new TextField(15);
        sendField.setFont(new Font("Dialog",Font.BOLD,12));
        sendField.disable();
        add(sendField);
        sendField.reshape(insets().left + 59,insets().top + 42,126,26);
        recvField=new TextField(15);
        recvField.setFont(new Font("Dialog",Font.BOLD,12));
        recvField.disable();
        add(recvField);
        recvField.reshape(insets().left + 221,insets().top + 42,126,26);
        startButton=new Button("Start");
        startButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(startButton);
        startButton.reshape(insets().left + 42,insets().top + 151,66,33);
        suspendButton=new Button("Suspend");
        suspendButton.setFont(new Font("Dialog",Font.BOLD,12));
        suspendButton.disable();
        add(suspendButton);
        suspendButton.reshape(insets().left + 123,insets().top + 151,66,33);
        resumeButton=new Button("Resume");
        resumeButton.setFont(new Font("Dialog",Font.BOLD,12));
        resumeButton.disable();
        add(resumeButton);
        resumeButton.reshape(insets().left + 201,insets().top + 151,66,33);
        stopButton=new Button("Stop");
        stopButton.setFont(new Font("Dialog",Font.BOLD,12));
        stopButton.disable();
        add(stopButton);
        stopButton.reshape(insets().left + 282,insets().top + 151,66,33);
        statusField=new TextField(18);
        statusField.setFont(new Font("Dialog",Font.BOLD,12));
        statusField.disable();
        add(statusField);
        statusField.reshape(insets().left + 131,insets().top + 99,151,26);
        statusLabel=new Label("Status:");
        statusLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(statusLabel);
        statusLabel.reshape(insets().left + 65,insets().top + 101,55,18);
        sendLabel=new Label("Bytes Sent");
        sendLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(sendLabel);
        sendLabel.reshape(insets().left + 51,insets().top + 21,95,16);
        recvLabel=new Label("Bytes Received");
        recvLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(recvLabel);
        recvLabel.reshape(insets().left + 215,insets().top + 21,108,20);
        setBackground(Color.lightGray);

        show();
    }

    public synchronized void show() {
    	move(50, 50);
    	super.show();
    }

    public boolean handleEvent(Event event) {

    	if (event.id == Event.WINDOW_DESTROY) {
    	    if (threadGroup != null) {
    	       threadGroup.stop();
    	       threadGroup.destroy();
    	       }
            hide();
            dispose();
            System.exit(0);
            return true;
    	}
    	return super.handleEvent(event);
    }

    public boolean action(Event event, Object arg) {
        if (event.target instanceof Button) {
            String label = (String) arg;
            if (label.equalsIgnoreCase("Start")) {
                startThreads();
                startButton.disable();
                stopButton.enable();
                suspendButton.enable();
                resumeButton.disable();
                return true;
                }
            else
            if (label.equalsIgnoreCase("Suspend")) {
                suspendThreads();
                suspendButton.disable();
                resumeButton.enable();
                return true;
                }
            else
            if (label.equalsIgnoreCase("Resume")) {
               resumeThreads();
               resumeButton.disable();
               suspendButton.enable();
               return true;
               }
            else
            if (label.equalsIgnoreCase("Stop")) {
                stopThreads();
                stopButton.disable();
                startButton.enable();
                suspendButton.disable();
                resumeButton.disable();
                return true;
                }
        }
        return super.action(event, arg);
    }

    public void startThreads() {

    FullPipe pipe = new FullPipe();

    threadGroup = new ThreadGroup("ThreadDemo5");

    Transmitter tran1  = new Transmitter(threadGroup, "tran1", 200, pipe);
    Transmitter tran2  = new Transmitter(threadGroup, "tran2", 200, pipe);
    Transmitter tran3  = new Transmitter(threadGroup, "tran3", 200, pipe);
    Transmitter tran4  = new Transmitter(threadGroup, "tran4", 200, pipe);
    Transmitter tran5  = new Transmitter(threadGroup, "tran5", 200, pipe);
    Transmitter tran6  = new Transmitter(threadGroup, "tran6", 200, pipe);
    Transmitter tran7  = new Transmitter(threadGroup, "tran7", 200, pipe);
    Transmitter tran8  = new Transmitter(threadGroup, "tran8", 200, pipe);
    Transmitter tran9  = new Transmitter(threadGroup, "tran9", 200, pipe);
    Transmitter tran10 = new Transmitter(threadGroup, "tran10", 200, pipe);
    Receiver    recv   = new Receiver(threadGroup, "recv", 10, pipe);
    Monitor     watch  = new Monitor(threadGroup, "watch", pipe,
                                     sendField, recvField, statusField,
                                     recv, startButton, stopButton,
                                     resumeButton, suspendButton);

    threadGroup.setMaxPriority(Thread.NORM_PRIORITY-1);

    // The following statements under version 1.1 seem to prevent the
    // Receiver from getting the data

    // recv.setPriority(Thread.NORM_PRIORITY+2);
    // watch.setPriority(Thread.NORM_PRIORITY+2);

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
    watch.start();

    sendField.setText("0");
    recvField.setText("0");
    statusField.setText("Started...");

    }

    public void suspendThreads() {
    threadGroup.suspend();
    statusField.setText("Suspended...");
    }

    public void resumeThreads() {
    threadGroup.resume();
    statusField.setText("Resumed...");
    }

    public void stopThreads() {
    threadGroup.stop();
    statusField.setText("Stopped...");
    }

    public static void main(String args[]) {
       new ThreadDemo5();
    }

    private ThreadGroup threadGroup;
    private TextField sendField;
    private TextField recvField;
    private Button startButton;
    private Button suspendButton;
    private Button resumeButton;
    private Button stopButton;
    private TextField statusField;
    private Label statusLabel;
    private Label sendLabel;
    private Label recvLabel;
}
