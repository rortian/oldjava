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
#include <string.h>
#include "String.hh"

class Transportation {
public:
	Transportation(long);
	long getDistance();
	void travel(long);
private:
	String name;
	long distance;
};

Transportation::Transportation(long dist) : distance(dist) {                
}

long Transportation::getDistance() {
return distance;
}

void Transportation::travel(long dist) {
distance += dist;
}

class Employee {
public:
   Employee(String, long, char);
   String getName();
private:
   String name;
   long ssn;
   char gender;
};

Employee::Employee(String nm, long id, char sx) :
   name(nm), ssn(id), gender(sx) {
}

String Employee::getName() {
return name;
}

class TravelingEmployee : public Employee, public Transportation {
public:
	TravelingEmployee(String, long, char, long);
};

TravelingEmployee::TravelingEmployee(String nm, long id, char sx, long dist) :				 
   Employee(nm, id, sx), Transportation(dist) {
   }

void main() 
{
TravelingEmployee emp("Bob", 45900, 'M', 10000);
cout<<emp.getName()<<"'s transportation has accumulated "<<emp.getDistance()<<" miles."<<endl;
emp.travel(225);
cout<<emp.getName()<<"'s transportation has accumulated "<<emp.getDistance()<<" miles."<<endl;
}
