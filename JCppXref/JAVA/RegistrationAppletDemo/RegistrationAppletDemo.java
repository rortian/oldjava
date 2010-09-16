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

/*
    This class is a basic extension of the Applet class.  It would generally be
    used as the main class with a Java browser or the AppletViewer.  But an instance
    can be added to a subclass of Container.  To use this applet with a browser or
    the AppletViewer, create an html file with the following code:

    <HTML>
    <HEAD>
    <TITLE> A simple program </TITLE>
    </HEAD>
    <BODY>

    <APPLET CODE="RegistrationAppletDemo.class" WIDTH=660 HEIGHT=400></APPLET>

    </BODY>

    </HTML>

 */

import java.awt.*;
import java.applet.*;

public class RegistrationAppletDemo extends Applet {

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
    private Button okButton;
    private Button cancelButton;
    private Checkbox macOS7;
    final String TITLE = new String("Beta Tester Registration Form");

    public void init() {

        super.init();

        setLayout(null);
        resize(704,382);
        registrationTitle=new Label(TITLE);
        registrationTitle.setFont(new Font("Dialog",Font.PLAIN,24));
        add(registrationTitle);
        registrationTitle.reshape(182,37,343,30);
        firstName=new Label("First Name");
        firstName.setFont(new Font("Dialog",Font.PLAIN,18));
        add(firstName);
        firstName.reshape(20,105,110,30);
        lastName=new Label("Last Name");
        lastName.setFont(new Font("Dialog",Font.PLAIN,18));
        add(lastName);
        lastName.reshape(360,105,104,30);
        email=new Label("E-Mail Address");
        email.setFont(new Font("Dialog",Font.PLAIN,18));
        add(email);
        email.reshape(35,165,147,30);
        firstNameField=new TextField(25);
        firstNameField.setFont(new Font("Dialog",Font.PLAIN,18));
        add(firstNameField);
        firstNameField.reshape(140,105,210,30);
        lastNameField=new TextField(21);
        lastNameField.setFont(new Font("Dialog",Font.PLAIN,18));
        add(lastNameField);
        lastNameField.reshape(476,105,175,30);
        edit1=new TextField(44);
        edit1.setFont(new Font("Dialog",Font.PLAIN,18));
        add(edit1);
        edit1.reshape(182,165,371,30);
        environment=new Label("Environment");
        environment.setFont(new Font("Dialog",Font.PLAIN,18));
        add(environment);
        environment.reshape(35,232,119,30);
        win95=new Checkbox("Windows 95");
        win95.setFont(new Font("Dialog",Font.BOLD,16));
        add(win95);
        win95.reshape(49,270,126,30);
        winnt=new Checkbox("Windows NT");
        winnt.setFont(new Font("Dialog",Font.BOLD,16));
        add(winnt);
        winnt.reshape(182,270,126,30);
        solaris=new Checkbox("Sun Solaris");
        solaris.setFont(new Font("Dialog",Font.BOLD,16));
        add(solaris);
        solaris.reshape(322,270,119,30);
        hpux=new Checkbox("HP-UX");
        hpux.setFont(new Font("Dialog",Font.BOLD,16));
        add(hpux);
        hpux.reshape(455,270,91,30);
        okButton=new Button("OK");
        okButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(okButton);
        okButton.reshape(189,322,105,30);
        cancelButton=new Button("Cancel");
        cancelButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(cancelButton);
        cancelButton.reshape(350,322,105,30);
        macOS7=new Checkbox("Mac OS 7.5");
        macOS7.setFont(new Font("Dialog",Font.BOLD,16));
        add(macOS7);
        macOS7.reshape(553,270,126,30);

    }


    public boolean handleEvent(Event event) {
        return super.handleEvent(event);
    }


}
