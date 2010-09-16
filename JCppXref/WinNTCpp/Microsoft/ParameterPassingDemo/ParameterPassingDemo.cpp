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

class Point {
public:
	Point();
	Point(int,int);
	void setCoordinates(int,int);
	int getX() const;
	int getY() const;   
private:
	int x;
	int y;
};

Point::Point() : x(0), y(0) {
}

Point::Point(int x_value, int y_value) : x(x_value), y(y_value) {
}

void Point::setCoordinates(int x_value, int y_value) {
x = x_value;
y = y_value;
}

int Point::getX() const {
return x;
}

int Point::getY() const {
return y;
}

void swap_by_value(int x, int y) {
int temp;
temp = x;
x = y;
y = temp;
}

void swap_by_pointer(int * x, int * y) {
int temp;
temp = *x;
*x = *y;
*y = temp;
}

void swap_by_reference(int & x, int & y) {
int temp;
temp = x;
x = y;
y = temp;
}


void exchange_coordinates_by_reference(Point & pt) {
int x_val = pt.getX();
int y_val = pt.getY();
pt.setCoordinates(y_val,x_val);

cout<<"\nInside exchange_coordinates_by_reference...\n";
cout<<"pt.x = "<<pt.getX()<<endl;
cout<<"pt.y = "<<pt.getY()<<endl;
}

void main(int argc, char ** argv) 
{
int num1 = -30;
int num2 =  45;
int num3 = -15;
int num4 =  55;
int * num5;
int * num6;
int & num7 = num1;
int & num8 = num2;

cout<<"\nBefore calling swap_by_value...\n";
cout<<"num1 = "<<num1<<endl;
cout<<"num2 = "<<num2<<endl;

swap_by_value(num1,num2);

cout<<"\nAfter calling swap_by_value...\n";
cout<<"num1 = "<<num1<<endl;
cout<<"num2 = "<<num2<<endl;

num5 = &num3;
num6 = &num4;

cout<<"\nBefore calling swap_by_pointer...\n";
cout<<"*num5 = "<<*num5<<endl;
cout<<"*num6 = "<<*num6<<endl;

swap_by_pointer(num5,num6);

cout<<"\nAfter calling swap_by_pointer...\n";
cout<<"*num5 = "<<*num5<<endl;
cout<<"*num6 = "<<*num6<<endl;

cout<<"\nBefore calling swap_by_reference...\n";
cout<<"num7 = "<<num7<<endl;
cout<<"num8 = "<<num8<<endl;

swap_by_reference(num7,num8);

cout<<"\nAfter calling swap_by_reference...\n";
cout<<"num7 = "<<num7<<endl;
cout<<"num8 = "<<num8<<endl;

Point aPoint(-50,300);

cout<<"\nBefore calling exchange_coordinates_by_reference...\n";
cout<<"aPoint.x = "<<aPoint.getX()<<endl;
cout<<"aPoint.y = "<<aPoint.getY()<<endl;

exchange_coordinates_by_reference(aPoint);

cout<<"\nAfter calling exchange_coordinates_by_reference...\n";
cout<<"aPoint.x = "<<aPoint.getX()<<endl;
cout<<"aPoint.y = "<<aPoint.getY()<<endl;

}
