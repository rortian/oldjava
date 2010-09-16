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

class Pair {
public:
   Pair(int, int);
   virtual ~Pair();
   void Display() const;
protected:
   int getX() const;
   int getY() const;
   int getId() const;
private:
   static int count;
   int x;
   int y;
   int id;		// Used for identifying each unique instance of Pair
};

int Pair::count = 0;

Pair::Pair(int x_value, int y_value) : x(x_value), y(y_value), id(++count){
}

void Pair::Display() const {
cout<<"("<<getX()<<", "<<getY()<<")"<<" has id "<<getId()<<endl;
}

int Pair::getX() const {
return x;
}

int Pair::getY() const {
return y;
}

int Pair::getId() const {
return id;
}

Pair::~Pair() {
cout<<"~Pair() called for "<<"("<<getX()<<", "<<getY()<<")"<<" with id "<<getId()<<'\n';
}

class Triplet : public Pair {
public:
   Triplet(int, int, int);
   Triplet operator+(Triplet &);
   virtual ~Triplet();
   void Display() const;
private:
   int z;
};

Triplet::Triplet(int x_value, int y_value, int z_value) : Pair(x_value, y_value), z(z_value) {
if ((x_value == 0) && (y_value == 0) && (z_value == 0))  // Intentionally written to cause a throw
   throw("Cannot instantiate a Triplet with all zero components");
}

Triplet Triplet::operator+(Triplet & tr) {
return Triplet(getX()+tr.getX(), getY()+tr.getY(), z+tr.z);
}

void Triplet::Display() const {
cout<<"("<<getX()<<", "<<getY()<<", "<<z<<")"<<" has id "<<getId()<<endl;
}

Triplet::~Triplet() {
cout<<"~Triplet() called for "<<"("<<getX()<<", "<<getY()<<", "<<z<<")"<<" with id "<<getId()<<endl;
}

void main()
{
Pair * tr1 = new Triplet(-10, -90, 85);
try {
    Triplet tr2(-5, -34, 45);
	tr2.Display();

    Triplet tr3(5, 34, -45);
	tr3.Display();

    Triplet tr4 = tr2+tr3; 
	tr4.Display();			// This statement is never reached
    }
catch(char * errmsg) {
    cout<<errmsg<<endl;
	delete tr1;
	cout<<"Exiting program"<<endl;
	return;
    }
delete tr1;
}

