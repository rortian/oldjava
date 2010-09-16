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
cout<<"("<<getX()<<", "<<getY()<<")"<<" has id "<<getId()<<'\n';
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
   Triplet();
   Triplet(int, int, int);
   Triplet operator+(Triplet &);
   virtual ~Triplet();
   void Display() const;
private:
   static int trigger;
   int z;
};

int Triplet::trigger = 0;

Triplet::Triplet() : Pair(0,0), z(0) {
if (++trigger == 7)
   throw("Cannot instantiate a seventh Triplet object!");
}

Triplet::Triplet(int x_value, int y_value, int z_value) : Pair(x_value, y_value), z(z_value) {
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
try {
    Triplet tr[9];
    }
catch(char * errmsg) {
    cout<<errmsg<<endl;
    }

}
