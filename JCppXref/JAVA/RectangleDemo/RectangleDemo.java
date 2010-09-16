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

public class RectangleDemo {

    public RectangleDemo(Point pt1, Point pt2) {
    int ul_x;
    int ul_y;
    int lr_x;
    int lr_y;

    if (pt1.x < pt2.x) {
       ul_x = pt1.x;
       lr_x = pt2.x;
       }
    else {
       ul_x = pt2.x;
       lr_x = pt1.x;
       }

    if (pt1.y < pt2.y) {
       ul_y = pt1.y;
       lr_y = pt2.y;
       }
    else {
       ul_y = pt2.y;
       lr_y = pt1.y;
       }

    upperLeft  = new Point(ul_x, ul_y);
    lowerRight = new Point(lr_x, lr_y);
    }

    public boolean onInterior(Point pt) {
    if (((upperLeft.x <= pt.x) && (pt.x <= lowerRight.x))  &&
        ((upperLeft.y <= pt.y) && (pt.y <= lowerRight.y)))
       return true;
    return false;
    }

    private Point upperLeft;
    private Point lowerRight;

    public static void main(String args[]) {
        Point pt1 = new Point(20,25);
        Point pt2 = new Point(55,85);
        Point pt3 = new Point(40,60);
        Point pt4 = new Point(56,77);

        RectangleDemo rect = new RectangleDemo(pt1, pt2);

        if (rect.onInterior(pt3))
           System.out.println(pt3.toString()+
                              " is within the rectangle\n");
        else
           System.out.println(pt3.toString()+
                              " is outside the rectangle\n");
        if (rect.onInterior(pt4))
           System.out.println(pt4.toString()+
                              " is within the rectangle\n");
        else
           System.out.println(pt4.toString()+
                              " is outside the rectangle\n");

        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
        } catch (IOException e) {
            return;
        }
    }
}
