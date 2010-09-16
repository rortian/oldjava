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

/**
 * Note:  This program requires a compiler like Borland C++ 5.0
 *        or higher (i.e., a compiler that supports the terminate()
 *        and set_terminate() features.
 */

#include <stdio.h>
#include <iostream.h>
#include <string.h>
#include <fcntl.h>
#include <io.h>
#include <except.h>

// Beginning of exception class framework

class Xception {
public:
	Xception(long);
	virtual void Display() const;
protected:
   long getValue() const;
private:
	long actual_value;
};

Xception::Xception(long some_value) : actual_value(some_value) {
}

long Xception::getValue() const {
return actual_value;
}

void Xception::Display() const {
cout<<"Xception:  "<<"illegal value = "<<getValue()<<endl;
}

class Out_of_Memory : public Xception {
public:
	Out_of_Memory(long);
	virtual void Display() const;
};

Out_of_Memory::Out_of_Memory(long some_value) : Xception(some_value) {
}

void Out_of_Memory::Display() const {
cout<<"Out_of_Memory:  "<<"heap exhausted during attempt to allocate "<<getValue()<<" elements"<<endl;
}

class Illegal_Size : public Xception {
public:
	Illegal_Size(long);
	virtual void Display() const;
};

Illegal_Size::Illegal_Size(long some_value) : Xception(some_value) {
}

void Illegal_Size::Display() const {
cout<<"Illegal_Size:  "<<"requested array size of "<<getValue()<<" is illegal"<<endl;
}

class Out_of_Bounds : public Xception {
public:
	Out_of_Bounds(long, long, long);
	virtual void Display() const;
private:
	long lower_bounds;
	long upper_bounds;
};

Out_of_Bounds::Out_of_Bounds(long some_value, long lbounds, long ubounds):
	Xception(some_value), lower_bounds(lbounds), upper_bounds(ubounds) {
}

void Out_of_Bounds::Display() const {
cout<<"Out_of_Bounds:  "<<"attempt to index element at "<<getValue()<<" is illegal"<<endl;
}

// End of the exception class framework

class Vector {
public:
	Vector(int) throw(Out_of_Memory, Illegal_Size);
	int & operator[](int) const throw(Out_of_Bounds);
	void Traverse() const;
	~Vector();
private:
	Vector(const Vector &);
	void operator=(const Vector &);
	enum { MAXSIZE = 100 };
	static int count;     // Used only for identifying the instance
	int id;               // Used only for identifying the instance
	int * vector_ptr;
	int   size;
};

int Vector::count = 0;

Vector::Vector(int init_size) throw(Out_of_Memory, Illegal_Size) {
id = ++count;
if (!((0 < init_size) && (init_size <= MAXSIZE))) {
	throw Illegal_Size(init_size);
	}
size = init_size;
vector_ptr = new int[init_size];
if (!vector_ptr) {
	throw Out_of_Memory(init_size);
	}
}

int & Vector::operator[](int index) const throw(Out_of_Bounds) {
if ( (0 <= index) && (index < size) )
	return(vector_ptr[index]);
else {
   throw Out_of_Bounds(index, 0, size - 1);
	}
}
  
void Vector::Traverse() const {
for (int i = 0; i < size; i++)
	cout<<vector_ptr[i]<<endl;
}

Vector::Vector(const Vector &) { }

void Vector::operator=(const Vector &) { }

Vector::~Vector() {
delete [] vector_ptr;
}

void Create_New_Vector() {

try {
    Vector vec2(-6);            // An exception is thrown here

    for (int index = 0; index < 6; index++) vec2[index] = 6.0 * index;
    cout<<"Elements of vec2: "<<endl;
    vec2.Traverse();
    }

catch(char * err) {
cout<<"Inside catch(char *) of Create_New_Vector..."<<endl;
cout<<err<<endl;
}

catch(Out_of_Bounds & err) {
cout<<"Inside catch(Out_of_Bounds &) of Create_New_Vector..."<<endl;
err.Display();
}
/*
catch(Xception & err) {
cout<<"Inside catch(Xception &) of main..."<<endl;
err.Display();
}
*/
cout<<"First line after the catch handlers of Create_New_Vector"<<endl;
}

int fd;

void terminate_routine() {
cout<<"terminate_routine called..."<<endl;
cout<<"An exception object of unknown type was not caught..."<<endl;
cout<<"Closing file descriptor..."<<endl;
close(fd);
exit(-1);
}

void main()
{

set_terminate(terminate_routine);

if ((fd = open("TERMS1.TXT", O_RDONLY | O_CREAT)) == -1 )  {
   cout<<"Unable to open file TERMS1.TXT"<<endl;
   return;
   }

try {
	 Vector vec1(4);

	 for (int index = 0; index < 4; index++) vec1[index] = 4.0 * index;
	 cout<<"Elements of vec1: "<<endl;
	 vec1.Traverse();

    Create_New_Vector();
	 }

catch(char * err) {
cout<<"Inside catch(char *) of main..."<<endl;
cout<<err<<endl;
}

catch(Out_of_Bounds & err) {
cout<<"Inside catch(Out_of_Bounds &) of main..."<<endl;
err.Display();
}

cout<<"Closing file descriptor..."<<endl;

close(fd);

cout<<"Exiting main - program completed..."<<'\n';
}

