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
import java.applet.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class URLDemo extends Applet {

        void URLListSelected(Event event) {
            AppletContext context = getAppletContext();
            String URLName = null;
            URL selectedURL = null;
            try {
                URLName = "http://"+URLList.getSelectedItem().trim();
                selectedURLField.setText(URLName);
                selectedURL = new URL(URLName);
                context.showDocument(selectedURL);
                }
            catch(MalformedURLException err) {
                showStatus("Error: "+err);
                }
        }

        public void init() {
                super.init();
                setLayout(null);
                addNotify();
                resize(738,309);
                setBackground(new Color(12632256));
                URLList = new java.awt.List(0,false);
                add(URLList);
                URLList.reshape(30,120,360,170);
                URLList.setFont(new Font("Dialog", Font.BOLD, 14));
                URLList.setBackground(new Color(16777215));
                selectedURLField = new java.awt.TextField();
                selectedURLField.reshape(30,66,360,30);
                selectedURLField.setFont(new Font("Dialog", Font.BOLD, 14));
                selectedURLField.setBackground(new Color(16777215));
                selectedURLField.setEditable(false);
                add(selectedURLField);
                selectedURLLabel = new java.awt.Label("Select a URL");
                selectedURLLabel.reshape(24,24,120,31);
                selectedURLLabel.setFont(new Font("Dialog", Font.BOLD, 14));
                add(selectedURLLabel);

                nativeURL = getDocumentBase();

                DataInputStream dis = null;
                String item = null;
                URL url = null;
                try {
                    url = new URL(nativeURL, "URLData.txt");
                    dis = new DataInputStream(url.openStream());
                    while ((item = dis.readLine()) != null)
                       URLList.addItem(item);
                    picture = getImage(nativeURL, "tropical.gif");
                    }
                catch(IOException err) {
                    showStatus("Error: "+err);
                    }
        }

        public boolean handleEvent(Event event) {
                if (event.target == URLList && event.id == Event.LIST_SELECT) {
                   URLListSelected(event);
                   return true;
                }
                return super.handleEvent(event);
        }

        public void paint(Graphics graph) {
            Rectangle rect = selectedURLField.bounds();
            graph.drawImage(picture, rect.x+rect.width+20, rect.y , this);
        }

        private  Image        picture;
        private  URL          nativeURL;
        private  List         URLList;
        private  TextField    selectedURLField;
        private  Label        selectedURLLabel;

}
