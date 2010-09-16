#include <iostream.h>
#include <string.h>
#include <iomanip.h>
#include "String.hh"

class Food {
public:
    Food(String, double, double);
	String getName();
    virtual double calculatePayment();
private:
	String name;
    double unit_cost;
	double percent_profit;
};

Food::Food(String nm, double cost, double gain) :
      name(nm), unit_cost(cost), percent_profit(gain) {
}

String Food::getName() {
return name;
}

double Food::calculatePayment() {
return unit_cost + unit_cost * percent_profit;
}

class Candy : public Food {
public:
    Candy(String, double, double, double);
    virtual double calculatePayment();
protected:
	double getLocalTax();
private:
	double local_tax;
};

Candy::Candy(String nm, double cost, double gain, double ltax) :
       Food(nm, cost, gain), local_tax(ltax) {
}

double Candy::getLocalTax() {
return local_tax;
}

double Candy::calculatePayment() {
double sales_price = Food::calculatePayment();
return sales_price + sales_price * local_tax;
}

class ForeignCandy : public Candy {
public:
    ForeignCandy(String, double, double, double, double);
    virtual double calculatePayment();
private:
	double import_tax;
};

ForeignCandy::ForeignCandy(String nm, double cost, double gain,
						   double ltax, double itax) :						   
              Candy(nm, cost, gain, ltax), import_tax(itax) {
}

double ForeignCandy::calculatePayment() {
double sales_price = Food::calculatePayment();
return sales_price + sales_price * getLocalTax() + sales_price * import_tax;                  
}

void main() {
ForeignCandy biscotti("Mocha au Lait", 3.00, 0.25, 0.10, 0.05);
cout<<biscotti.getName()<<" will cost the consumer $"
    <<biscotti.calculatePayment()<<endl;
Food & edible = biscotti;
cout<<edible.getName()<<" will cost the consumer $"
    <<edible.calculatePayment()<<endl;
}
