#ifndef POINT_CPP
#define POINT_CPP
#include <iostream.h>
#include "Point.hh"

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

#endif
