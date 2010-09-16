#include <iostream.h>
#include <string.h>
#include "String.hh"

class Person {
public:
    Person(String, String, char, int);
    void DisplayData();
private:
	String name;
    String ssn;
    char gender;
    int age;
};

Person::Person(String nm, String id, char sx, int yrs) :
		name(nm), ssn(id), gender(sx), age(yrs) {
}

void Person::DisplayData() {
cout<<endl;
cout<<"Name = "<<name<<endl;
cout<<"SSN = "<<ssn<<endl;
cout<<"Gender = "<<gender<<endl;
cout<<"Age = "<<age<<endl;
}

class Pupil : public Person {
public:
   Pupil(String nm, String id, char sx, int yrs, String sc, int lv);
   void DisplayData();
private:
   String school;
   int class_level;
};

Pupil::Pupil(String nm, String id, char sx, int yrs, String sc, int lv) :
			Person(nm, id, sx, yrs), school(sc), class_level(lv) {
}

void Pupil::DisplayData() {
Person::DisplayData();
cout<<"School = "<<school<<endl;
cout<<"Level = "<<class_level<<endl;
}

void main() {
Person wes("Wes", "570-45-1287", 'M', 17);
wes.DisplayData();

Pupil yvonne("Yvonne", "630-22-0980", 'F', 22, "Univ. of Washington", 3);

yvonne.Person::DisplayData();

yvonne.DisplayData();
}
