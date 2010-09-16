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

public class GridBagLayoutDemo extends Frame {

    public GridBagLayoutDemo() {

        super("GridBagLayoutDemo window");

        GridBagLayout gbl = new GridBagLayout();			/* (1) */
        setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();

        int weightX = 10;
        int weightY = 10;

        resize(350,330);
        nutritionGroup = new CheckboxGroup();
        Panel nutritionPanel = new Panel();

        // Row 0   (gridy == 0)

        saladLabel=new Label("Salad");
        saladLabel.setFont(new Font("Dialog",Font.BOLD,14));
        saladLabel.setBackground(Color.lightGray);
        add(saladLabel, gbl, gbc, 					        /* (2) */
               GridBagConstraints.NONE, GridBagConstraints.SOUTHWEST,
                weightX, weightY, 0, 0, 1, 1);

        dressingLabel=new Label("Dressing");
        dressingLabel.setFont(new Font("Dialog",Font.BOLD,14));
        dressingLabel.setBackground(Color.lightGray);
        add(dressingLabel, gbl, gbc, 					    /* (2) */
               GridBagConstraints.NONE, GridBagConstraints.SOUTHWEST,
                weightX, weightY, 1, 0, 1, 1);

        // Row 1   (gridy == 1)

        saladChoice= new Choice();
        saladChoice.setFont(new Font("Dialog",Font.BOLD,12));
        add(saladChoice,gbl, gbc,					        /* (2) */
               GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                weightX, weightY, 0, 1, 1, 2);
        saladChoice.addItem("Chinese Chicken");
        saladChoice.addItem("Little Caesar");
        saladChoice.addItem("Smoked Turkey");
        saladChoice.addItem("Tossed Green");
        saladChoice.addItem("Tuna 'N Shrimp");

        dressingChoice= new Choice();
        dressingChoice.setFont(new Font("Dialog",Font.BOLD,12));
        add(dressingChoice, gbl, gbc, 				        /* (2) */
               GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                weightX, weightY, 1, 1, 1, 2);
        dressingChoice.addItem("French");
        dressingChoice.addItem("Italian");
        dressingChoice.addItem("Oil 'N Vinegar");
        dressingChoice.addItem("Ranch");
        dressingChoice.addItem("Russian");
        dressingChoice.addItem("Thousand Island");

        // Row 2  (gridy == 2)  is empty

        // Row 3  (gridy == 3)

        nutritionLabel=new Label("Nutrition");
        nutritionLabel.setFont(new Font("Dialog",Font.BOLD,14));
        nutritionLabel.setBackground(Color.lightGray);
        add(nutritionLabel, gbl, gbc, 					     /* (2) */
              GridBagConstraints.NONE, GridBagConstraints.SOUTHWEST,
               weightX, weightY, 1, 3, 1, 1);

        // Row 4   (gridy == 4)

        regularButton=new Checkbox("Regular",nutritionGroup, true);
        regularButton.setFont(new Font("Dialog",Font.BOLD,12));

        lowcalButton=new Checkbox("Low Calorie",nutritionGroup, false);
        lowcalButton.setFont(new Font("Dialog",Font.BOLD,12));

        nutritionPanel.add(regularButton);
        nutritionPanel.add(lowcalButton);
        nutritionPanel.setBackground(Color.lightGray);

        add(nutritionPanel, gbl, gbc, 					     /* (2) */
               GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                weightX, weightY, 1, 4, 1, 1);
        setBackground(new Color(150, 150, 150));

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

    private void add(Component comp, GridBagLayout gridBagLayout,      /* (3) */
                               GridBagConstraints gridBagParms,
                               int fl, int an,
                               int wx, int wy,
                               int gx, int gy,
                               int gw, int gh)  {
     gridBagParms.fill           = fl;
     gridBagParms.anchor         = an;
     gridBagParms.weightx        = wx;
     gridBagParms.weighty        = wy;
     gridBagParms.gridx          = gx;
     gridBagParms.gridy          = gy;
     gridBagParms.gridwidth      = gw;
     gridBagParms.gridheight     = gh;
     gridBagLayout.setConstraints(comp, gridBagParms);
     add(comp);
     }

    public static void main(String args[]) {
        new GridBagLayoutDemo();
    }

    private CheckboxGroup  nutritionGroup;
    private Choice                 saladChoice;
    private Label                   saladLabel;
    private Label                   dressingLabel;
    private Choice                 dressingChoice;
    private Checkbox             regularButton;
    private Checkbox            lowcalButton;
    private Label                   nutritionLabel;

}
