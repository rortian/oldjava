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

public class RegistrationApplicationDemo extends Frame {

    private Menu fileMenu;
    private Menu editMenu;
    private Menu helpMenu;

    private Label registrationTitle;
    private Label firstName;
    private Label lastName;
    private Label email;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField edit1;
    private Label environment;
    private Checkbox win95;
    private Checkbox winnt;
    private Checkbox solaris;
    private Checkbox hpux;
    private Button OKButton;
    private Button cancelButton;
    private Checkbox macOS7;

    public RegistrationApplicationDemo() {

        super("Registration Window");

        MenuBar mb = new MenuBar();
        fileMenu = new Menu("&File");
        fileMenu.add(new MenuItem("&New"));
        fileMenu.add(new MenuItem("&Open..."));
        fileMenu.add(new MenuItem("&Save"));
        fileMenu.add(new MenuItem("Save &As..."));
        fileMenu.addSeparator();
        fileMenu.add(new MenuItem("E&xit"));
        mb.add(fileMenu);
        editMenu = new Menu("&Edit");
        editMenu.add(new MenuItem("&Undo"));
        editMenu.addSeparator();
        editMenu.add(new MenuItem("Cu&t"));
        editMenu.add(new MenuItem("&Copy"));
        editMenu.add(new MenuItem("&Paste"));
        mb.add(editMenu);
        helpMenu = new Menu("&Help");
        helpMenu.add(new MenuItem("&About..."));
        mb.add(helpMenu);
        setMenuBar(mb);

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 717, insets().top + insets().bottom + 395);
        registrationTitle=new Label("Beta Tester Registration Form");
        registrationTitle.setFont(new Font("Dialog",Font.PLAIN,24));
        add(registrationTitle);
        registrationTitle.reshape(insets().left + 186,insets().top + 46,342,32);
        firstName=new Label("First Name");
        firstName.setFont(new Font("Dialog",Font.PLAIN,18));
        add(firstName);
        firstName.reshape(insets().left + 42,insets().top + 111,102,26);
        lastName=new Label("Last Name");
        lastName.setFont(new Font("Dialog",Font.PLAIN,18));
        add(lastName);
        lastName.reshape(insets().left + 360,insets().top + 111,102,26);
        email=new Label("E-Mail Address");
        email.setFont(new Font("Dialog",Font.PLAIN,18));
        add(email);
        email.reshape(insets().left + 42,insets().top + 163,144,26);
        firstNameField=new TextField(21);
        firstNameField.setFont(new Font("Dialog",Font.PLAIN,18));
        add(firstNameField);
        firstNameField.reshape(insets().left + 156,insets().top + 111,180,32);
        lastNameField=new TextField(24);
        lastNameField.setFont(new Font("Dialog",Font.PLAIN,18));
        add(lastNameField);
        lastNameField.reshape(insets().left + 468,insets().top + 111,198,32);
        edit1=new TextField(38);
        edit1.setFont(new Font("Dialog",Font.PLAIN,18));
        add(edit1);
        edit1.reshape(insets().left + 192,insets().top + 163,318,32);
        environment=new Label("Environment");
        environment.setFont(new Font("Dialog",Font.PLAIN,18));
        add(environment);
        environment.reshape(insets().left + 42,insets().top + 215,132,26);
        win95=new Checkbox("Windows 95");
        win95.setFont(new Font("Dialog",Font.BOLD,16));
        add(win95);
        win95.reshape(insets().left + 54,insets().top + 254,126,26);
        winnt=new Checkbox("Windows NT");
        winnt.setFont(new Font("Dialog",Font.BOLD,16));
        add(winnt);
        winnt.reshape(insets().left + 192,insets().top + 254,126,26);
        solaris=new Checkbox("Sun Solaris");
        solaris.setFont(new Font("Dialog",Font.BOLD,16));
        add(solaris);
        solaris.reshape(insets().left + 324,insets().top + 254,126,26);
        hpux=new Checkbox("HP-UX");
        hpux.setFont(new Font("Dialog",Font.BOLD,16));
        add(hpux);
        hpux.reshape(insets().left + 456,insets().top + 254,90,26);
        OKButton=new Button("OK");
        OKButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(OKButton);
        OKButton.reshape(insets().left + 234,insets().top + 306,90,26);
        cancelButton=new Button("Cancel");
        cancelButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(cancelButton);
        cancelButton.reshape(insets().left + 372,insets().top + 306,90,26);
        macOS7=new Checkbox("Mac OS 7.5");
        macOS7.setFont(new Font("Dialog",Font.BOLD,16));
        add(macOS7);
        macOS7.reshape(insets().left + 558,insets().top + 254,126,26);
        setBackground(Color.lightGray);
        show();
    }

    public synchronized void show() {
    	move(50, 50);
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
            if (label.equalsIgnoreCase("&About...")) {
                selectedAbout();
                return true;
            } else if (label.equalsIgnoreCase("E&xit")) {
                selectedExit();
                return true;
            } else if (label.equalsIgnoreCase("&Open...")) {
                selectedOpen();
                return true;
            }
        }
        return super.action(event, arg);
    }

    public static void main(String args[]) {
        new RegistrationApplicationDemo();
    }

    public void selectedOpen() {
        (new FileDialog(this, "Open...")).show();
    }
    public void selectedExit() {
        QuitBox theQuitBox;
        theQuitBox = new QuitBox(this);
        theQuitBox.show();
    }
    public void selectedAbout() {
        AboutBox theAboutBox;
        theAboutBox = new AboutBox(this);
        theAboutBox.show();
    }
}

class AboutBox extends Dialog {

    Label label1;
    Button OKButton;

    public AboutBox(Frame parent) {

	    super(parent, "About", true);
    	setResizable(false);

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 333, insets().top + insets().bottom + 114);
        label1=new Label("Standalone Java Application");
        label1.setFont(new Font("Dialog",Font.BOLD,14));
        add(label1);
        label1.reshape(insets().left + 12,insets().top + 33,210,19);
        OKButton=new Button("OK");
        OKButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(OKButton);
        OKButton.reshape(insets().left + 234,insets().top + 26,78,33);
    }

    public synchronized void show() {
    	Rectangle bounds = getParent().bounds();
    	Rectangle abounds = bounds();

    	move(bounds.x + (bounds.width - abounds.width)/ 2,
    	     bounds.y + (bounds.height - abounds.height)/2);

    	super.show();
    }

    public synchronized void wakeUp() {
    	notify();
    }

    public boolean handleEvent(Event event) {
    	if (event.id == Event.ACTION_EVENT && event.target == OKButton) {
    	    	clickedOKButton();
    	    	return true;
    	}
    	else

    	if (event.id == Event.WINDOW_DESTROY) {
    	    hide();
    	    return true;
    	}
    	return super.handleEvent(event);
    }


    public void clickedOKButton() {
        handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
    }
}

class QuitBox extends Dialog {

    Button yesButton;
    Button noButton;

    public QuitBox(Frame parent) {

	    super(parent, "Quit Application?", true);
    	setResizable(false);

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 261, insets().top + insets().bottom + 96);
        yesButton=new Button("Yes");
        yesButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(yesButton);
        yesButton.reshape(insets().left + 48,insets().top + 20,48,26);
        noButton=new Button("No");
        noButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(noButton);
        noButton.reshape(insets().left + 150,insets().top + 20,42,26);
    }

    public synchronized void show() {
    	Rectangle bounds = getParent().bounds();
    	Rectangle abounds = bounds();

    	move(bounds.x + (bounds.width - abounds.width)/ 2,
    	     bounds.y + (bounds.height - abounds.height)/2);

    	super.show();
    }

    public synchronized void wakeUp() {
    	notify();
    }

    public boolean handleEvent(Event event) {
    	if (event.id == Event.ACTION_EVENT && event.target == noButton) {
    	    	clickedNoButton();
    	    	return true;
    	}
    	else
    	if (event.id == Event.ACTION_EVENT && event.target == yesButton) {
    	    clickedYesButton();
    	    return true;
    	}
    	else

    	if (event.id == Event.WINDOW_DESTROY) {
    	    hide();
    	    return true;
    	}
    	return super.handleEvent(event);
    }


    public void clickedYesButton() {
        System.exit(0);
    }
    public void clickedNoButton() {
        handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
    }
}
