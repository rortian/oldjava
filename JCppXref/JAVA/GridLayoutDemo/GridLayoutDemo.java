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

public class GridLayoutDemo extends Frame {

    public GridLayoutDemo() {

        super("GridLayoutDemo window");
        setLayout(new GridLayout(4,3));

        resize(480,400);

        for (int index = 0; index < 12; index++) {
           button[index] = new Button("Button "+(index+1));
           add(button[index]);
           }

        show();
    }

    public synchronized void show() {
    	move(75, 75);
    	super.show();
    }

    public boolean handleEvent(Event event) {
    	if (event.id == Event.WINDOW_DESTROY) {
            hide();
            dispose();
            System.exit(0);
            return true;
    	}
    	return super.handleEvent(event);
    }

    public static void main(String args[]) {
        new GridLayoutDemo();
    }

    private Button [] button = new Button[12];

}
