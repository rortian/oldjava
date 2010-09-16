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

public class StandalonePair {

    public StandalonePair(int x_value, int y_value, String name) {
        setX(x_value);
        setY(y_value);
        setLabel(name);
        setId();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getLabel() {
        return label;
    }
    public void setX(int x_value) {
        x = x_value;
    }
    public void setY(int y_value) {
        y = y_value;
    }
    public void setLabel(String name) {
    label = name;
    }
    public void setId() {
    id = ++count;
    }
    public void Display() {
    System.out.println("("+getX()+", "+getY()+")"+" is named "+
                        getLabel()+" with id "+id+"\n");
    }

    private int x;
    private int y;
    private String label;
    private int id;
    private static int count = 0;

    public static void main(String args[]) {
       StandalonePair pr1 = new StandalonePair(-50, 450, "Mars");
       pr1.Display();
          {
          StandalonePair pr2 = pr1;
          pr2.Display();
          }
       System.out.println("(press Enter to exit)");
       try {
           System.in.read();
           }
       catch (IOException e) {
           return;
           }
    }
}
