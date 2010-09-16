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
import java.applet.Applet;

public class LogonAppletDemo extends Applet {

    public void init() {

        super.init();
        name = "";
        password = "";

        setLayout(null);     // changed from the version 1.02 program
        addNotify();
        resize(insets().left + insets().right + 333, insets().top + insets().bottom + 222);
        nameField=new TextField(20);
        add(nameField);
        nameField.reshape(insets().left + 117,insets().top + 68,167,25);
        nameField.requestFocus();
        logonLabel=new Label("Identification and Logon");
        logonLabel.setFont(new Font("Helvetica",Font.BOLD,14));
        add(logonLabel);
        logonLabel.reshape(insets().left + 72,insets().top + 23,186,18);
        nameLabel=new Label("Name:");
        nameLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(nameLabel);
        nameLabel.reshape(insets().left + 39,insets().top + 73,47,18);
        passwordField=new TextField(20);
        add(passwordField);
        passwordField.reshape(insets().left + 117,insets().top + 107,168,25);
        OKButton=new Button("OK");
        OKButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(OKButton);
        OKButton.reshape(insets().left + 72,insets().top + 158,75,27);
        passwordLabel=new Label("Password:");
        passwordLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(passwordLabel);
        passwordLabel.reshape(insets().left + 39,insets().top + 112,69,16);
        cancelButton=new Button("Cancel");
        cancelButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(cancelButton);
        cancelButton.reshape(insets().left + 186,insets().top + 156,75,29);

        // show();

    }  // LogonAppDemo

    public boolean handleEvent(Event event) {
    	if (event.id == Event.KEY_PRESS && event.target == OKButton) {
    	    enterOKButton(event);
    	    return true;
    	    }
    	else
    	if (event.id == Event.KEY_PRESS && event.target == cancelButton) {
    	    enterCancelButton(event);
    	    return true;
    	    }
    	else
    	if (event.id == Event.KEY_PRESS && event.target == nameField) {
    	    keyPressNameField(event);
    	    return true;
    	    }
    	else
    	if (event.id == Event.KEY_PRESS && event.target == passwordField) {
    	    keyPressPasswordField(event);
    	    return true;
    	    }
    	else
    	if (event.id == Event.WINDOW_DESTROY) {
            hide();
            // dispose();
            // System.exit(0);
            return true;
    	    }

    	return super.handleEvent(event);

    }  // handleEvent

    public boolean action(Event event, Object arg) {
        if (event.target instanceof Button) {
           String caption = (String)arg;
           if (caption.equals("OK")) {
              handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
              }
           if (caption.equals("Cancel"))
              handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
           }

        return super.action(event, arg);

    }  // action


    public void keyPressNameField(Event ev) {

    String tmp = "";
    char ch = (char)ev.key;
    if ((SPACE <= ev.key) && (ev.key <= TILDE)) {
       name += ch;
       nameField.setText(name);
       }
    if (ev.key == BACKSPACE) {
       if (name.length() > 0)  {
          tmp += name.substring(0, name.length()-1);
          name = tmp;
          nameField.setText(name);
          tmp = "";
          }
       }
    if ((ev.key == TAB) || (ev.key == NEWLINE)) {
        if (ev.shiftDown())
           cancelButton.requestFocus();
        else
           passwordField.requestFocus();
        }

    }  // keyPressNameField

    public void keyPressPasswordField(Event ev) {

    String tmp = "";
    char ch = (char)ev.key;
    if ((EXCLAMATION <= ev.key) && (ev.key <= TILDE)) {
       password += ch;
       passwordField.setText(passwordField.getText()+"*");
       }
    if (ev.key == BACKSPACE) {
       if (password.length() > 0)  {
          tmp += password.substring(0, password.length()-1);
          password = tmp;
          tmp = "";
          for (int index = 0; index < password.length(); index++)
             tmp += "*";
          passwordField.setText(tmp);
          tmp = "";
          }
       }
    if ((ev.key == TAB) || (ev.key == NEWLINE)) {
        if (ev.shiftDown())
           nameField.requestFocus();
        else
           OKButton.requestFocus();
        }

    }  // keyPressPasswordField

    public void enterOKButton(Event ev) {
    if (ev.key == TAB) {
        if (ev.shiftDown())
           passwordField.requestFocus();
        else
           cancelButton.requestFocus();
        }
    if (ev.key == NEWLINE) {
       handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
       }
    }  // enterOKButton

    public void enterCancelButton(Event ev) {
    if (ev.key == TAB) {
        if (ev.shiftDown())
           OKButton.requestFocus();
        else
           nameField.requestFocus();
        }
    if (ev.key == NEWLINE) {
       handleEvent(new Event(this, Event.WINDOW_DESTROY, null));
       }
    }  // enterCancelButton

    private final int BACKSPACE   =   8;
    private final int TAB         =   9;
    private final int NEWLINE     =  10;
    private final int SPACE       =  32;
    private final int EXCLAMATION =  33;
    private final int TILDE       = 126;

    private Label logonLabel;
    private Label nameLabel;
    private Label passwordLabel;
    private TextField nameField;
    private TextField passwordField;
    private Button OKButton;
    private Button cancelButton;

    private String name;
    private String password;

}
