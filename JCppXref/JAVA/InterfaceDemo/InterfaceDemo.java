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

interface Transportation {
    public long getDistance();
	public void travel(long dist);
	public String getName();
}

class Employee {

    Employee(String nm, long id, char sx) {
        name = new String(nm);
        ssn  = id;
        gender = sx;
    }

    public String getName() {
        return name;
    }

    private String name;
    private long ssn;
    private char gender;
}

class TravelingEmployee extends Employee implements Transportation {

    TravelingEmployee(String nm, long id, char sx, long dist) {
        super(nm, id, sx);
        distance = dist;
    }

    public long getDistance() {
        return distance;
    }

    public void travel(long dist) {
        distance += dist;
    }

    private long distance;
}


public class InterfaceDemo {

    public static void main(String args[]) {

        TravelingEmployee emp = new TravelingEmployee("Bob", 45900, 'M', 10000);
        System.out.println(emp.getName()+"'s transportation has accumulated "+emp.getDistance()+" miles.");
        emp.travel(225);
        System.out.println(emp.getName()+"'s transportation has accumulated "+emp.getDistance()+" miles.");

        System.out.println("(press Enter to exit)");
        try {
            System.in.read();
        }
        catch (IOException e) {
            return;
        }
    }
}
