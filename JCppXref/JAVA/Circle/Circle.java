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

public class Circle {

    public Circle(Point middle, double rad) {
        center = new Point(middle.x, middle.y);
        radius = rad;
        count++;
        }

    public static int Total_Circles() {
        return count;
        }

    private static int count = 0;
    private Point center;
    private double radius;

    public static void main(String args[]) {
        Circle circle1 = new Circle(new Point(300,400),10);
        Circle circle2 = new Circle(new Point(400,450),20);
        Circle circle3 = new Circle(new Point(500,300),25);
        Circle circle4 = new Circle(new Point(75,-30),30);

        System.out.println("Total number of circles created: "+
                           Circle.Total_Circles()+"\n");

        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}
