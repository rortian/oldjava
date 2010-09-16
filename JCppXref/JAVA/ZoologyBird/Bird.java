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

package Zoology;
import java.awt.*;
import java.io.IOException;

public class Bird {

public Bird(String nm, String fm, double sn, long sp) {
name      = nm;
family    = fm;
wing_span = sn;
speed     = sp;
}

public void getData() {
System.out.println("Animal Data:");
System.out.println("Species = "+name);
System.out.println("Family = "+family);
System.out.println("Wing span = "+wing_span+" feet");
System.out.println("Speed in flight = "+speed+" miles per hour");
System.out.println();
}

public long getSpeed() {
return speed;
}

private String name;
private String family;
private double wing_span;
private long   speed;

public static void main(String args[]) {

   Bird hawk = new Bird("Hawk", "Flying Predators", 5.0, 25);
   hawk.getData();
   System.out.println("(press Enter to exit)");
   try {
       System.in.read();
       }
   catch (IOException e) {
       return;
       }
   }
}
