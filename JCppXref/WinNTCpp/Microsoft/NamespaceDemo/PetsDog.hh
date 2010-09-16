#ifndef PETS_DOG_HH
#define PETS_DOG_HH

namespace Pets {

class Dog {
public:
   enum { FEMALE, MALE };
   enum { SMOOTH, SHORT_HAIR, LONG_HAIR, SHAGGY };
   Dog(String, int, int, double);
   void getData();
   int  getCoat();
private:
   String name;
   int    gender;
   int    coat;
   double sales_price;
};

} // Namespace Pets

#endif
