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
import java.io.*;

public class EventDemo extends Frame {

    public EventDemo() {

        super("EventDemo window");
        try {
            ps = new PrintStream(new FileOutputStream("MESSAGES.TXT"));
            }
        catch(IOException err) {
            System.out.println(err.toString());
            System.exit(-1);
            }

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 279, insets().top + insets().bottom + 530);
        choice1= new Choice();
        choice1= new Choice();
        choice1.addItem("Chocolate");
        choice1.addItem("Peach");
        choice1.addItem("Pumpkin");
        choice1.addItem("Vanilla");
        choice1.addItem("Spumoni");
        choice1.addItem("Rocky Road");
        choice1.addItem("Strawberry");
        choice1.addItem("French Vanilla");
        choice1.addItem("Dutch Apple");
        choice1.addItem("Mocha");
        choice1.addItem("Cookies 'n Cream");
        choice1.addItem("Mandarin Orange");
        add(choice1);
        choice1.reshape(insets().left + 30,insets().top + 156,222,150);
        group1= new CheckboxGroup();
        OKButton=new Button("OK");
        OKButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(OKButton);
        OKButton.reshape(insets().left + 30,insets().top + 462,90,32);
        cancelButton=new Button("Cancel");
        cancelButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(cancelButton);
        cancelButton.reshape(insets().left + 156,insets().top + 462,90,32);
        typeLabel=new Label("Type");
        typeLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(typeLabel);
        typeLabel.reshape(insets().left + 12,insets().top + 65,102,13);
        flavorLabel=new Label("Flavors");
        flavorLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(flavorLabel);
        flavorLabel.reshape(insets().left + 12,insets().top + 130,102,13);
        dessertLabel=new Label("Frozen Desserts");
        dessertLabel.setFont(new Font("Dialog",Font.BOLD,16));
        add(dessertLabel);
        dessertLabel.reshape(insets().left + 66,insets().top + 20,156,19);
        iceCreamButton=new Checkbox("Ice Cream",group1, true);
        iceCreamButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(iceCreamButton);
        iceCreamButton.reshape(insets().left + 30,insets().top + 91,120,26);
        frozenYogartButton=new Checkbox("Frozen Yogurt",group1, false);
        frozenYogartButton.setFont(new Font("Dialog",Font.BOLD,12));
        add(frozenYogartButton);
        frozenYogartButton.reshape(insets().left + 162,insets().top + 91,120,26);
        caramelToppingCheckBox=new Checkbox("Caramel Topping");
        caramelToppingCheckBox.setFont(new Font("Dialog",Font.BOLD,12));
        add(caramelToppingCheckBox);
        caramelToppingCheckBox.reshape(insets().left + 30,insets().top + 325,126,20);
        cherriesCheckBox=new Checkbox("Cherries");
        cherriesCheckBox.setFont(new Font("Dialog",Font.BOLD,12));
        add(cherriesCheckBox);
        cherriesCheckBox.reshape(insets().left + 30,insets().top + 351,120,20);
        nutsCheckBox=new Checkbox("Nuts");
        nutsCheckBox.setFont(new Font("Dialog",Font.BOLD,12));
        add(nutsCheckBox);
        nutsCheckBox.reshape(insets().left + 30,insets().top + 377,120,20);
        additionalTextField=new TextField(26);
        additionalTextField.setFont(new Font("Dialog",Font.BOLD,12));
        add(additionalTextField);
        additionalTextField.reshape(insets().left + 30,insets().top + 429,216,26);
        additionalLabel=new Label("Additional Topping:");
        additionalLabel.setFont(new Font("Dialog",Font.BOLD,12));
        add(additionalLabel);
        additionalLabel.reshape(insets().left + 12,insets().top + 409,144,13);

        show();
    }

    public synchronized void show() {
    	move(50, 50);
    	super.show();
    }

    public boolean handleEvent(Event event) {
        if (event.id == Event.MOUSE_MOVE)
           return super.handleEvent(event);
        else
    	if (event.id == Event.WINDOW_DESTROY) {
    	   ps.println(event.toString());
    	   ps.close();
           hide();
           dispose();
           System.exit(0);
           return true;
    	}
    	else
    	   ps.println(event.toString());

    	return super.handleEvent(event);
    }

    public boolean action(Event event, Object arg) {
        return super.action(event, arg);
    }

    public static void main(String args[]) {
        new EventDemo();
    }

    private CheckboxGroup group1;
    private Choice choice1;
    private Button OKButton;
    private Button cancelButton;
    private Label typeLabel;
    private Label flavorLabel;
    private Label dessertLabel;
    private Checkbox iceCreamButton;
    private Checkbox frozenYogartButton;
    private Checkbox caramelToppingCheckBox;
    private Checkbox cherriesCheckBox;
    private Checkbox nutsCheckBox;
    private TextField additionalTextField;
    private Label additionalLabel;
    private PrintStream ps;

}
