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

#ifndef OrderPair__hh
#define OrderPair__hh

class OrderPair {
public:
	OrderPair();
    OrderPair(int x_value, int y_value);
    int getX() const;
    int getY() const;
    void setX(int x_value);
    void setY(int y_value);
    void printXY() const;
private:
    int x;
    int y;
};

#endif

OrderPair::OrderPair() { // Learning by negative example...
this(0,0);			     // This will not compile!!!  Illegal in C++!
}


OrderPair::OrderPair(int x_value, int y_value) : x(x_value), y(y_value) {
}

inline int OrderPair::getX() const {
return x;
}

inline int OrderPair::getY() const {
return y;
}

inline void OrderPair::setX(int x_value) {
x = x_value;
}

inline void OrderPair::setY(int y_value) {
y = y_value;
}

inline void OrderPair::printXY() const{
cout<<"("<<getX()<<","<<getY()<<")"<<endl;
}

void main(int argc, char ** argv) {

OrderPair pair[] = { 
				   OrderPair(-4,4), OrderPair(7,17),
                   OrderPair(19,25), OrderPair(-9,21),
                   OrderPair(37, -93), OrderPair(-15, 72)
				   };

for (int index = 0; index < sizeof(pair)/sizeof(OrderPair); index++)
   pair[index].printXY();

}

