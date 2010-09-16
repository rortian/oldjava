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

import java.util.*;
import java.io.IOException;

public class Student {

    private String name;
    private int    ssn;
    private String birthdate;
    private char   sex;

    public Student() {
        this(new String("Nameless"),0,new String("01/01/1970"), 'U');
        /*
        name = new String("Nameless");
        ssn  = 0;
        birthdate = new String("01/01/1970");
        sex = 'U';
        */
        }

    public Student(String nm, int id, String bd, char sx) {
        name = nm;
        ssn  = id;
        birthdate = bd;
        sex = sx;
        }

    public void Display() {
        System.out.println("Student: "+name);
        System.out.println("Social Security Number: "+ssn);
        System.out.println("Birthdate: "+birthdate);
        if (sex == 'M')
           System.out.println("Sex: Male\n");
        else
        if (sex == 'F')
           System.out.println("Sex: Female\n");
        else
           System.out.println("Sex: Unknown\n");
        }

    public static void main(String args[]) {
        Student someone = new Student();
        someone.Display();
        Student fred = new Student(new String("Fred"), 4570, new String("03/15/1985"), 'M');
        fred.Display();
        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
            }
        catch (IOException e) {
            return;
            }
    }
}  // Student

