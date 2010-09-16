#include <iostream.h>
#include <string.h>
#include "String.hh"

class Person {
public:
	Person(const char *, long);
	void DisplayName() const;
	long GetSSN() const;
private:
	String name;
	long   ssn;
};

Person::Person(const char * nm, long num) : name(nm), ssn(num) {
}

void Person::DisplayName() const {
name.DisplayString();
}

long Person::GetSSN() const {
return ssn;
}

class Employee : virtual public Person {
public:
	Employee(const char *, long, const char *, long);
private:
	String company;
	long   id;
};

Employee::Employee(const char * nm, long ssnum, const char * comp, long idnum) :
   Person(nm, ssnum), company(comp), id(idnum) {
}

class Driver : virtual public Person {
public:
	Driver(const char *, long, const char *, long);
private:
	String vehicle;
	long   license;
};

Driver::Driver(const char * nm, long ssnum, const char * veh, long lic):
   Person(nm, ssnum), vehicle(veh), license(lic) {
};

class EmployedDriver : public Employee, public Driver {
public:
	EmployedDriver(const char *, long, const char *, long, const char *, long, double);
private:
	double salary;
};

EmployedDriver::EmployedDriver(const char * nm, long ssnum, const char *  comp, 
							   long idnum, const char * veh, long lic, double wages)
							   : Person(nm, ssnum), Employee(nm, ssnum, comp, idnum), Driver(nm, ssnum, veh, lic),
							     salary(wages) {
}

int main()
{
EmployedDriver peter("Peter", 420055, "Fast Truckers, Inc.", 2000, "Road King", 9080, 25.70);

cout<<"Default ssn is "<<peter.GetSSN()<<endl;
cout<<"Employee::ssn is "<<peter.Employee::GetSSN()<<endl;
cout<<"Driver::ssn is "<<peter.Driver::GetSSN()<<endl;

return 0;
}
