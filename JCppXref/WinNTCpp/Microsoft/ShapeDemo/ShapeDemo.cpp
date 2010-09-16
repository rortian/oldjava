#include <iostream.h>
#include <stdlib.h>
#include <math.h>
#include "Point.hh"

class Shape {
public:
   Shape();
   int getId();
   virtual double getArea() = 0;
private:
   static int count;
   int id;
};

int Shape::count = 0;

Shape::Shape() : id(++count) {
}

int Shape::getId() {
return id;
}

class Circle : public Shape {
public:
   Circle(int, int, int);
   virtual double getArea();
private:
   int radius;
   Point center;
};

Circle::Circle(int x, int y, int rad) :
		center(Point(x,y)), radius(rad) {
}

double Circle::getArea() {
return 4 * atan(1.0) * radius * radius;   // pi == 4 * atan(1.0)
}

class Rectangle : public Shape {
public:
   Rectangle(int, int, int, int);
   virtual double getArea();
private:
   Point upperLeft;
   Point lowerRight;
};

Rectangle::Rectangle(int ul_x, int ul_y, int lr_x, int lr_y) :
   upperLeft(Point(ul_x, ul_y)), lowerRight(Point(lr_x, lr_y)) {
}


double Rectangle::getArea() {
double result = abs(upperLeft.getX() - lowerRight.getX()) *
                abs(upperLeft.getY() - lowerRight.getY());
return result;
}


void main() {
Circle cir1(7, 9, 15);
cout<<"cir1 has id = "<<cir1.getId()<<", area = "<<cir1.getArea()<<endl;

Rectangle rect1(-50,70,150,180);
cout<<"rect1 has id = "<<rect1.getId()<<", area = "<<rect1.getArea()<<endl;

Shape * shape1 = &cir1;
cout<<"shape1 has id = "<<shape1->getId()<<", area = "<<shape1->getArea()<<endl;

shape1 = &rect1;
cout<<"shape1 has id = "<<shape1->getId()<<", area = "<<shape1->getArea()<<endl;
}
