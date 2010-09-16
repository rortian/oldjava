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
   Point(int x_value = 0, int y_value = 0);
   int getX();
   int getY();
   void setX(int x_value);
   void setY(int y_value);
private:
   int x;
   int y;
};

Point::Point(int x_value, int y_value) : x(x_value), y(y_value) {
}

int Point::getX() {
return x;
}

int Point::getY() {
return y;
}

void Point::setX(int x_value) {
x = x_value;
}

void Point::setY(int y_value) {
y = y_value;
}
        
class Circle {
public:
   Circle(Point & middle, double rad);
   static int Total_Circles();
private:
   static int count;
   Point center;
   double radius;
};

int Circle::count = 0;

Circle::Circle(Point & middle, double rad) {
center.setX(middle.getX());
center.setY(middle.getY());
radius = rad;
count++;
}

int Circle::Total_Circles() {
return count;
}

void main()
{
Circle circle1(Point(300,400),10);
Circle circle2(Point(400,450),20);
Circle circle3(Point(500,300),25);
Circle circle4(Point(75,-30),30);

cout<<"Total number of circles created: "<<Circle::Total_Circles()<<endl;
}