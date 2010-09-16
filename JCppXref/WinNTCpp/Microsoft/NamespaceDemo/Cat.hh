#ifndef CAT_HH
#define CAT_HH	

namespace {

class Cat {
public:
   Cat(String, String);
   void getData();
private:
   String name;
   String family;
};

}  // Anonymous Namespace

#endif