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

class Person {

    public Person(String nm, String id, char sx, int yrs) {
    name = new String(nm);
    ssn = new String(id);
    gender = sx;
    age = yrs;
    }

    public void DisplayData() {
    System.out.print("\n\nName = "+name);
    System.out.print("\nSSN = "+ssn);
    System.out.print("\nGender = "+gender);
    System.out.print("\nAge = "+age);
    }

    private String name;
    private String ssn;
    private char gender;
    private int age;
}

class Pupil extends Person {

    public Pupil(String nm, String id, char sx, int yrs, String sc, int lv) {
    super(nm, id, sx, yrs);
    school = new String(sc);
    class_level = lv;
    }

    public void DisplayData() {
    super.DisplayData();
    System.out.print("\nSchool = "+school);
    System.out.print("\nLevel = "+class_level);
    }

    private String school;
    private int class_level;
}

public class InheritanceDemo1 {

    public static void main(String args[]) {
        Person wes = new Person("Wes", "570-45-1287", 'M', 17);
        wes.DisplayData();

        Pupil yvonne = new Pupil("Yvonne", "630-22-0980", 'F', 22,
                                 "Univ. of Washington", 3);

        yvonne.DisplayData();

        System.out.println("\n(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}