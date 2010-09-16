#ifndef ZOOLOGY_BIRD_HH
#define ZOOLOGY_BIRD_HH	

namespace Zoology {

class Bird {
public:
   Bird(String, String, double, long);
   void getData();
   long getSpeed();
private:
   String name;
   String family;
   double wing_span;
   long   speed;
};

}  // Namespace Zoology

#endif