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

package Humans;
import java.awt.*;
import java.io.IOException;

public class Person {

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
    System.out.flush();
    }

    protected int getAge() {  // private protected for InheritanceDemo2
    return age;
    }

    protected void setAge(int yrs) {  // private protected for InheritanceDemo2
    age = yrs;
    }

    private String name;
    private String ssn;
    private char gender;
    private int age;

}
