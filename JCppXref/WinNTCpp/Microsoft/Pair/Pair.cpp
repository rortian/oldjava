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
   Pair();
   Pair(int, int, char *);
   Pair(const Pair &);
   Pair & operator=(const Pair &);
   ~Pair();
   void Display();
private:
   static int count;
   int  * ref_count_ptr;
   char * label;
   int x;
   int y;
   int id;		// Used for identifying each unique instance of Pair
};

int Pair::count = 0;

Pair::Pair() : x(0), y(0), id(++count) {
label = new char[strlen("Unknown")+1];
strcpy(label, "Unknown");
ref_count_ptr = new int;
*ref_count_ptr = 1;
}

Pair::Pair(int x_value, int y_value = 0, char * str = "\0") : x(x_value), y(y_value), id(++count){
label = new char[strlen(str)+1];
strcpy(label, str);
ref_count_ptr = new int;
*ref_count_ptr = 1;
}

Pair::Pair(const Pair & pr) {
x = pr.x;
y = pr.y;
id = ++count;
label = pr.label;
ref_count_ptr = pr.ref_count_ptr;
++*ref_count_ptr;
}

Pair & Pair::operator=(const Pair & pr) {
if (label != pr.label) {
   --*ref_count_ptr;
   if (*ref_count_ptr <= 0) {
       delete [] label;
       delete ref_count_ptr;
       }
   label = pr.label;
   ref_count_ptr = pr.ref_count_ptr;
   ++*ref_count_ptr;
   x = pr.x;
   y = pr.y;
   }
return (*this);
}

Pair::~Pair() {
--*ref_count_ptr;
if (*ref_count_ptr <= 0) {
   delete [] label;
   delete ref_count_ptr;
   }
}

void Pair::Display() {
cout<<"("<<x<<", "<<y<<")"<<" is named "<<label<<" with id "<<id<<'\n';
}

void main()
{	// outer block

	{	// middle block
	Pair pr1(-50, 450, "Mars");
	pr1.Display();

		{	// inner block
		Pair pr2;
		pr2 = pr1;	           // assignment operation performed here
		pr2.Display();

		// pr2 goes out of scope
		}

	// pr1 goes out of scope
	}

}
