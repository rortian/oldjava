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

package Pets;
import java.awt.*;
import java.io.IOException;

public class Dog {

public Dog(String nm, int sx, int fur, double cost) {
name = nm;
gender = sx;
coat = fur;
sales_price = cost;
}

public void getData() {
System.out.println("Pet Data:");
System.out.println("Species = "+name);
System.out.println("Gender = "+((gender==FEMALE)?"Female":"Male"));
System.out.print("Coat = ");
switch (coat) {
   case SMOOTH:
      System.out.println("Smooth");
	  break;
   case SHAGGY:
	  System.out.println("Shaggy");
	  break;
   case SHORT_HAIR:
	  System.out.println("Short hair");
	  break;
   case LONG_HAIR:
	  System.out.println("Long hair");
	  break;
   }
System.out.println("Price = "+sales_price);
System.out.println();
}

public int getCoat() {
return coat;
}

private String name;
private int    gender;
private int    coat;
private double sales_price;

public static final int FEMALE = 0;
public static final int MALE   = 1;

public static final int SMOOTH     = 0;
public static final int SHORT_HAIR = 1;
public static final int LONG_HAIR  = 2;
public static final int SHAGGY     = 3;

public static void main(String args[]) {

   Dog beagle = new Dog("Beagle", MALE, SMOOTH, 349.50);
   beagle.getData();

   System.out.println("(press Enter to exit)");
   try {
       System.in.read();
       }
   catch (IOException e) {
       return;
       }
   }
}
