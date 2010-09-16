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

import java.awt.Point;
import java.io.IOException;

abstract class Shape {
   public Shape() {
   id = ++count;
   }

   public int getId() {
   return id;
   }

   public abstract double getArea();

   private static int count = 0;
   private int id;
}

class Circle extends Shape {

   public Circle(int x, int y, int rad) {
   center =  new Point(x, y);
   radius = rad;
   }

   public double getArea() {
   return 4 * Math.atan(1.0) * radius * radius;     // pi == 4 * atan(1.0)
   }

   private int radius;
   private Point center;
}

class Rectangle extends Shape {

   public Rectangle(int ul_x, int ul_y, int lr_x, int lr_y) {
   upperLeft  = new Point(ul_x, ul_y);
   lowerRight = new Point(lr_x, lr_y);
   }

   public double getArea() {
   double result = Math.abs(upperLeft.x - lowerRight.x) *
                   Math.abs(upperLeft.y - lowerRight.y);
   return result;
   }

   private Point upperLeft;
   private Point lowerRight;
}

public class ShapeDemo {

    public static void main(String args[]) {
        Circle cir1 = new Circle(7, 9, 15);
        System.out.println("cir1 has id = "+cir1.getId()+", area = "+cir1.getArea());

        Rectangle rect1 = new Rectangle(-50,70,150,180);
        System.out.println("rect1 has id = "+rect1.getId()+", area = "+rect1.getArea());

        Shape shape1 = cir1;
        System.out.println("shape1 has id = "+shape1.getId()+", area = "+shape1.getArea());

        shape1 = rect1;
        System.out.println("shape1 has id = "+shape1.getId()+", area = "+shape1.getArea());

        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}