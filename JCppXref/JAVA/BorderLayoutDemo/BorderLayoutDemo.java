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

public class BorderLayoutDemo extends Frame {

    public BorderLayoutDemo() {

        super("BorderLayoutDemo window");
        setLayout(new BorderLayout());

        resize(450, 350);
        button1=new Button("Button 1");
        add("North", button1);
        button2=new Button("Button 2");
        add("East", button2);
        button3=new Button("Button 3");
        add("South", button3);
        button4=new Button("Button 4");
        add("West", button4);
        button5=new Button("Button 5");
        add("Center", button5);

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

    public boolean action(Event event, Object arg) {
        if (event.target instanceof MenuItem) {
            String label = (String) arg;
        }
        return super.action(event, arg);
    }

    public static void main(String args[]) {
        new BorderLayoutDemo();
    }

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

}
