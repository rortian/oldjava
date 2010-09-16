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
import java.io.IOException;
import Pets.*;
import Zoology.*;

class Cat {

   Cat(String nm, String fm) {
   name = nm;
   family = fm;
   }

   void getData() {
   System.out.println("Cat Data:");
   System.out.println("Species = "+name);
   System.out.println("Family = "+family);
   System.out.println();
   }

   private String name;
   private String family;

}

public class NamespaceDemo {

    public static void main(String args[]) {

    Pets.Bird macaw1 = new Pets.Bird("Macaw", Pets.Bird.FEMALE, 249.98);
    macaw1.getData();

    System.out.println("The macaw costs $"+macaw1.getSalesPrice()+"\n");

    Pets.Dog beagle = new Pets.Dog("Beagle", Pets.Dog.MALE, Pets.Dog.SMOOTH, 349.50);
    beagle.getData();

    Zoology.Bird macaw2 = new Zoology.Bird("Macaw", "Parrot", 2.0, 10);
    macaw2.getData();

       {
       Zoology.Bird cockatoo = new Zoology.Bird("Cockatoo", "Parrot", 0.80, 6);
       cockatoo.getData();
       Pets.Dog collie = new Pets.Dog("Collie", Pets.Dog.FEMALE, Pets.Dog.LONG_HAIR, 539.50);
       collie.getData();
       }

    Zoology.Bird hawk = new Zoology.Bird("Hawk", "Flying Predators", 5.0, 25);
    hawk.getData();

    Cat kitty = new Cat("House Cat", "Tabby");
    kitty.getData();

    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }
}
