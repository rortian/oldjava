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

import java.io.IOException;

class Player extends Thread {

     Player(String name, int value) {
     super(name);
     key = value;
     }

     public void run() {
     play();
     try {
         sleep(5);
         }
     catch(InterruptedException err) {
         System.out.println(err.toString());
         System.exit(-1);
         }
     }

     private synchronized void play() {

     while (((key % 20) != 0) && (pause)) {
        try {
            System.out.println(getName()+" has key = "+key);
            wait(5);
            key = (int)(100 * Math.random());
            }
        catch(InterruptedException err) {
            System.out.println(err.toString());
            System.exit(-1);
            }
        }

     System.out.println(getName()+" has finished with "+"key = "+key);
     setPause(false);
     notify();
     }

     public static void setPause(boolean value) {
     pause = value;
     }

private int key;
private static boolean pause = true;
}

public class ThreadDemo4 {

    public static void main(String args[]) {
        int num1 = (int)(100 * Math.random());
        int num2 = (int)(100 * Math.random());
        int num3 = (int)(100 * Math.random());
        int num4 = (int)(100 * Math.random());
        int num5 = (int)(100 * Math.random());

        Player p1 = new Player("p1", num1);
        Player p2 = new Player("p2", num2);
        Player p3 = new Player("p3", num3);
        Player p4 = new Player("p4", num4);
        Player p5 = new Player("p5", num5);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        while ((p1.isAlive()) || (p2.isAlive()) ||
               (p3.isAlive()) || (p4.isAlive()) ||
               (p5.isAlive()));

        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }

    }
}
