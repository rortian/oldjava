#ifndef POINT_HH
#define POINT_HH

class Point {
public:
   Point(int, int);
   int getX();
   int getY();
   void setX(int);
   void setY(int);
private:
   int x;
   int y;
};

#endif