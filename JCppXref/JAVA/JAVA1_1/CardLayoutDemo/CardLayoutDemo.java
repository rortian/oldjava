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

/**
 * Note:  This program was built from the JDK version 1.1
 *
 */

import java.awt.*;

public class CardLayoutDemo extends Frame {

    public CardLayoutDemo() {

        super("CardLayoutDemo window");

        setLayout(new BorderLayout());

        cardPanel = new Panel();
        cardPanel.setLayout(layout = new CardLayout());

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(1,4));
        button1=new Button("Button 1");
        p1.add(button1);
        button2=new Button("Button 2");
        p1.add(button2);
        button3=new Button("Button 3");
        p1.add(button3);
        button4=new Button("Button 4");
        p1.add(button4);
        cardPanel.add("",p1);			// add(Component) does not seem to work in version 1.1

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1,4));
        button5=new Button("Button 5");
        p2.add(button5);
        button6=new Button("Button 6");
        p2.add(button6);
        button7=new Button("Button 7");
        p2.add(button7);
        button8=new Button("Button 8");
        p2.add(button8);
        cardPanel.add("",p2);			// add(Component) does not seem to work in version 1.1

        Panel p3 = new Panel();
        p3.setLayout(new GridLayout(1,4));
        button9=new Button("Button 9");
        p3.add(button9);
        button10=new Button("Button 10");
        p3.add(button10);
        button11=new Button("Button 11");
        p3.add(button11);
        button12=new Button("Button 12");
        p3.add(button12);
        cardPanel.add("",p3);			// add(Component) does not seem to work in version 1.1

        add("North",cardPanel);

        forwardButton=new Button("Forward");
        forwardButton.setFont(new Font("Dialog",Font.BOLD,12));
        add("South", forwardButton);

        resize(450, 350);
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
        if (event.target instanceof Button) {
            String label = (String) arg;
            if (label.equals("Forward")) {
               layout.next(cardPanel);
               }
        }
        return super.action(event, arg);
    }

    public static void main(String args[]) {
        new CardLayoutDemo();
    }

    private CardLayout layout;
    private Panel      cardPanel;
    private Button     forwardButton;
    private Button     button1;
    private Button     button2;
    private Button     button3;
    private Button     button4;
    private Button     button5;
    private Button     button6;
    private Button     button7;
    private Button     button8;
    private Button     button9;
    private Button     button10;
    private Button     button11;
    private Button     button12;

}
