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
import Humans.*;

public class Tutor extends Pupil {

    public Tutor(String nm, String id, char sx, int yrs, String sc, int lv, String sj, String prof) {
    super(nm, id, sx, yrs, sc, lv);
    subject = new String(sj);
    professor = new String(prof);
    }

    public void DisplayData() {
    super.DisplayData();
    System.out.print("\nSubject = "+subject);
    System.out.print("\nProfessor = "+professor);
    }

    public void decrementAge() {
    int curr_age = getAge();
    setAge(--curr_age);
    }

    private String subject;
    private String professor;

    public static void main(String args[]) {

    Tutor veronica = new Tutor("Veronica", "630-22-0980", 'F', 27,
                               "Monroe Community College", 4, "Mathematics", "Dr. R. Thompson");
    veronica.DisplayData();

    veronica.setAge(23);
    veronica.DisplayData();

    veronica.decrementAge();
    veronica.DisplayData();

    System.out.println("\n(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }
}

