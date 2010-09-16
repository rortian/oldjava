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

public class OrderPair {

    public OrderPair(int x_value, int y_value) {
        setX(x_value);
        setY(y_value);
        }
    public int getX() {
        return x;
        }
    public int getY() {
        return y;
        }
    public void setX(int x_value) {
        x = x_value;
        }
    public void setY(int y_value) {
        y = y_value;
        }
    public void printXY() {
        System.out.print("("+getX()+","+getY()+")\n");
        }

    private int x;
    private int y;

    public static void main(String args[]) {
       OrderPair pair[] = { new OrderPair(-4,4), new OrderPair(7,17),
                            new OrderPair(19,25), new OrderPair(-9,21),
                            new OrderPair(37, -93), new OrderPair(-15, 72)};
       for (int index = 0; index < pair.length; index++)
          pair[index].printXY();

       System.out.println("(press Enter to exit)");
       try {
           System.in.read();
           }
       catch (IOException e) {
           return;
           }

       }
}

