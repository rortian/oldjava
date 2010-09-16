#ifndef PETS_BIRD_HH
#define PETS_BIRD_HH

namespace Pets {

class Bird {
public:
   enum { FEMALE, MALE };
   Bird(String, int, double);
   void getData();
   double  getSalesPrice();
private:
   String name;
   int    gender;
   int    coat;
   double sales_price;
};

} // Namespace Pets

#endif
