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
import java.net.*;
import java.io.*;

class FileRequest {

    FileRequest(String hostname, int port, String fn) {
        try {
            sock = new Socket(hostname, port);
            filename = fn;
            }
        catch(Exception err) {
            System.err.println(err.toString());
            System.exit(-1);
            }
    }

    void retrieve() {

        DataInputStream dis = null;
        PrintStream out = null;
        File fobj = null;
        FileOutputStream fos = null;
        byte bdata;

        try {
            dis = new DataInputStream(sock.getInputStream());
            out = new PrintStream(sock.getOutputStream());

            fobj = new File(filename);
            fos = new FileOutputStream(fobj);

            out.println(filename);
            out.flush();

            int count;
            byte [] barray = new byte[8192];

            while ((count = dis.read(barray)) != -1) {
                fos.write(barray, 0, count);
                fos.flush();
                }

            fos.close();
            dis.close();
            out.close();
            sock.close();
            }
        catch (Exception err) {
            System.out.println(err.toString());
            System.exit(-1);
            }

    }

    private Socket sock;
    private String filename;
}

public class ClipArtSelector extends Frame {

    public ClipArtSelector() {

        super("ClipArtSelector window");
        setBackground(Color.lightGray);

        setLayout(null);
        addNotify();
        resize(insets().left + insets().right + 435, insets().top + insets().bottom + 410);
        mainLabel=new Label("Clip Art Selection and Retrieval");
        mainLabel.setFont(new Font("Dialog",Font.BOLD,16));
        add(mainLabel);
        mainLabel.reshape(insets().left + 78,insets().top + 26,270,26);
        clipartChoice= new Choice();
        clipartChoice.setFont(new Font("Dialog",Font.BOLD,12));
        add(clipartChoice);
        clipartChoice.reshape(insets().left + 90,insets().top + 78,240,176);
        okButton=new Button("Ok");
        okButton.setFont(new Font("Dialog",Font.BOLD,14));
        add(okButton);
        okButton.reshape(insets().left + 162,insets().top + 280,96,32);
        statusField=new TextField(30);
        statusField.setFont(new Font("Dialog",Font.PLAIN,10));
        statusField.disable();
        add(statusField);
        statusField.reshape(insets().left + 6,insets().top + 371,252,19);

        FileInputStream fis = null;
        DataInputStream dis = null;
        String filename = null;

        try {
            fis = new FileInputStream("images.txt");
            dis = new DataInputStream(fis);

            while ((filename = dis.readLine()) != null)
               clipartChoice.addItem(filename);
            }

        catch(Exception err) {
            System.err.println(err.toString());
            System.exit(-1);
            }

        show();
    }

    public synchronized void show() {
    	move(50, 50);
    	super.show();
    }

    public boolean handleEvent(Event event) {
        if (event.id == Event.ACTION_EVENT && event.target == okButton) {
            clickedOkButton();
            return true;
        }
        else
    	if (event.id == Event.WINDOW_DESTROY) {
            hide();
            dispose();
            System.exit(0);
            return true;
    	}
    	return super.handleEvent(event);
    }

    public void clickedOkButton() {
        String selectedFile = clipartChoice.getSelectedItem();
        fileRequest = new FileRequest("micron1", 5000, selectedFile);
        statusField.setText("");
        fileRequest.retrieve();
        statusField.setText("File transfer for "+selectedFile+" done");
    }


    public static void main(String args[]) {
        new ClipArtSelector();
    }

    private Label mainLabel;
    private Choice clipartChoice;
    private Button okButton;
    private TextField statusField;
    private FileRequest fileRequest;
}

