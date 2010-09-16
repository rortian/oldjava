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

#include <iostream.h>
#include "String.hh"

class Student {
public:
	Student();
	Student(String, int, String, char);
	void Display();
private:
	void setStudent(String &, int, String &, char);
	String name;
	int    ssn;
	String  birthdate;
	char   sex;
};

Student::Student() {
setStudent(String("Nameless"), 0, String("01/01/1970"), 'U');
}

Student::Student(String nm, int id, String bd, char sx) {
setStudent(nm, id, bd, sx);
}

void Student::setStudent(String & nm, int id, String & bd, char sx) {
name = nm;
ssn  = id;
birthdate = bd;
sex  = sx;
}

void Student::Display() {
cout<<"Student: "<<name<<endl;
cout<<"Social Security Number: "<<ssn<<endl;
cout<<"Birthdate: "<<birthdate<<endl;
if (sex == 'M')
   cout<<"Sex: Male"<<endl;
else
if (sex == 'F')
   cout<<"Sex: Female"<<endl;
else
   cout<<"Sex: Unknown"<<endl;
cout<<endl;
}

void main(String args[]) {
Student someone;
someone.Display();
Student fred(String("Fred"), 4570, String("03/15/1985"), 'M');
fred.Display();
}

