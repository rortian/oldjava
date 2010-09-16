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

public class TwoDArrayDemo2 {

    public static void main(String args[]) {

        int cell[][] = { {-3, -6, -9, -12, -15},
                         {4, 12, 16, 20, 24},
                         {-5, 15, -20, 25, -30} };

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 5; column++)
                System.out.print("["+row+","+column+"] = "+cell[row][column]+"\t");
            System.out.println();
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
