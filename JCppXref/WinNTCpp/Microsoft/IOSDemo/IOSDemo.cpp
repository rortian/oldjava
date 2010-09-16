#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>

const char * filenameA [] = { 
	                        "",
	                        "OS01A.TXT", "OS02A.TXT", "OS03A.TXT", "OS04A.TXT",
                            "OS05A.TXT", "OS06A.TXT", "OS07A.TXT", "OS08A.TXT",
							"OS09A.TXT",  "OS10A.TXT"
						    };

const char * filenameB [] = { 
	                        "",
	                        "OS01B.TXT", "OS02B.TXT", "OS03B.TXT", "OS04B.TXT",
                            "OS05B.TXT", "OS06B.TXT", "OS07B.TXT", "OS08B.TXT"
						    };

// Custom manipulators for left and right justification

ostream & left(ostream & os) {
return os<<resetiosflags(ios::right)<<setiosflags(ios::left);
}

ostream & right(ostream & os) {
return os<<resetiosflags(ios::left)<<setiosflags(ios::right);
}

void Test01() {

ofstream os1A(filenameA[1], ios::out);

char * bird = "penguin";
char * fish = "rock cod";
char * tree = "maple";

os1A.fill('~');
os1A.width(12);
os1A<<bird<<endl;
os1A.width(12);
os1A<<fish<<endl;
os1A<<tree<<endl;

os1A.close();

ofstream os1B(filenameB[1], ios::out);

os1B<<setfill('~')<<setw(12)<<bird<<endl;
os1B<<setw(12)<<fish<<endl;
os1B<<tree<<endl;

os1B.close();
}

void Test02() {

ofstream os2A(filenameA[2], ios::out);

double num1 = 17.7875678;
os2A.precision(8);
os2A<<num1<<endl;

os2A.close();

ofstream os2B(filenameB[2], ios::out);

os2B<<setprecision(8)<<num1<<endl;

os2B.close();
}

void Test03() {

ofstream os3A(filenameA[3], ios::out);

int num1 = 160;

os3A<<oct<<"Octal = "<<num1<<endl;
os3A<<setiosflags(ios::showbase)<<"Octal = "<<num1<<endl;
os3A<<hex<<"Hexadecimal = "<<num1<<endl;
os3A<<setiosflags(ios::uppercase)<<"Hexadecimal = "<<num1<<endl;
os3A<<dec<<"Decimal = "<<num1<<endl;

os3A.close();
}

void Test04() {

ofstream os4A(filenameA[4], ios::out);

char * feline = "bob cat";
long   lnum   = 757905;
double dnum   = 2345070.00915756;

os4A.setf(ios::left, ios::adjustfield);
os4A.fill('#');
os4A.width(12);
os4A.precision(14);
os4A<<feline<<endl;
os4A.width(12);
os4A<<lnum<<endl;
os4A.width(12);
os4A<<dnum<<endl;

os4A.unsetf(ios::left);  // equivalent to os4A.setf(ios::right, ios::adjustfield);
os4A.fill('*');
os4A.width(12);
os4A.precision(14);
os4A<<feline<<endl;
os4A.width(12);
os4A<<lnum<<endl;
os4A.width(12);
os4A<<dnum<<endl;

os4A.close();

ofstream os4B(filenameB[4], ios::out);

os4B<<setiosflags(ios::left)<<setfill('#')<<setw(12)<<setprecision(14)<<feline<<endl;
os4B<<setw(12)<<lnum<<endl;
os4B<<setw(12)<<dnum<<endl;

os4B<<resetiosflags(ios::left)<<setfill('*')<<setw(12)<<setprecision(14)<<feline<<endl;                            
os4B<<setw(12)<<lnum<<endl;
os4B<<setw(12)<<dnum<<endl;

os4B.close();
}

void Test05() {

ofstream os5A(filenameA[5], ios::out);

char * bird = "penguin";
char * fish = "rock cod";
char * tree = "maple";

os5A.setf(ios::left, ios::adjustfield);
os5A.fill('*');
os5A.width(12);
os5A<<bird<<endl;
os5A.width(12);
os5A<<fish<<endl;
os5A.setf(ios::right, ios::adjustfield);
os5A.width(12);
os5A<<tree<<endl;

os5A.close();

ofstream os5B(filenameB[5], ios::out);

os5B<<setiosflags(ios::left)<<setfill('*')<<setw(12)<<bird<<endl;
os5B<<setw(12)<<fish<<endl;
os5B<<resetiosflags(ios::left)<<setw(12)<<tree<<endl;

os5B.close();
}

void Test06() {

ofstream os6A(filenameA[6], ios::out);

int   int1 = 34950;
int   int2 = -int1;
float flt1 = 17.5829f;
float flt2 = -flt1;

os6A.setf(ios::internal, ios::adjustfield);
os6A.fill('^');
os6A.width(16);
os6A<<int1<<endl;
os6A.width(16);
os6A<<int2<<endl;
os6A.width(16);
os6A<<flt1<<endl;
os6A.width(16);
os6A<<flt2<<endl;
os6A.unsetf(ios::internal);
os6A.width(16);
os6A<<flt2<<endl;

os6A.close();

ofstream os6B(filenameB[6], ios::out);

os6B<<setiosflags(ios::internal)<<setfill('^')<<setw(16)<<int1<<endl;
os6B<<setw(16)<<int2<<endl;
os6B<<setw(16)<<flt1<<endl;
os6B<<setw(16)<<flt2<<endl;
os6B<<resetiosflags(ios::internal)<<setw(16)<<flt2<<endl;

os6B.close();
}

void Test07() {

ofstream os7A(filenameA[7], ios::out);

long   lng1 = 875090406;
double dbl1 = 395.0;
double dbl2 = 7693.8356;
double dbl3 = 3409.958;

os7A<<dbl1<<endl;
os7A.setf(ios::showpos | ios::showpoint);
os7A<<dbl1<<endl;
os7A.setf(ios::scientific, ios::floatfield);
os7A<<lng1<<endl;
os7A<<dbl2<<endl;
os7A<<dbl3<<endl;
os7A.unsetf(ios::showpos | ios::showpoint | ios::scientific);
os7A<<lng1<<endl;
os7A<<dbl1<<endl;
os7A<<dbl2<<endl;
os7A<<dbl3<<endl;

os7A.close();

ofstream os7B(filenameB[7], ios::out);

os7B<<dbl1<<endl;
os7B<<setiosflags(ios::showpos | ios::showpoint)<<dbl1<<endl;
os7B<<setiosflags(ios::scientific)<<lng1<<endl;
os7B<<dbl2<<endl;
os7B<<dbl3<<endl;
os7B<<resetiosflags(ios::showpos | ios::showpoint | ios::scientific)<<lng1<<endl;
os7B<<dbl1<<endl<<dbl2<<endl<<dbl3<<endl;

os7B.close();
}

void Test08() {

ofstream os8A(filenameA[8], ios::out);

int num1 = 160;

os8A.setf(ios::oct, ios::basefield);
os8A<<"Octal = "<<num1<<endl;
os8A.setf(ios::showbase);
os8A<<"Octal = "<<num1<<endl;
os8A.setf(ios::hex, ios::basefield);
os8A<<"Hexadecimal = "<<num1<<endl;
os8A.setf(ios::uppercase);
os8A<<"Hexadecimal = "<<num1<<endl;
os8A.setf(ios::dec, ios::basefield);
os8A<<"Decimal = "<<num1<<endl;

os8A.close();

ofstream os8B(filenameB[8], ios::out);

os8B<<setiosflags(ios::oct)<<"Octal = "<<num1<<endl;
os8B<<setiosflags(ios::showbase)<<"Octal = "<<num1<<endl;
os8B<<resetiosflags(ios::oct)<<setiosflags(ios::hex)<<"Hexadecimal = "<<num1<<endl;
os8B<<setiosflags(ios::uppercase)<<"Hexadecimal = "<<num1<<endl;
os8B<<resetiosflags(ios::hex)<<setiosflags(ios::dec)<<"Decimal = "<<num1<<endl;

os8B.close();
}

void Test09() {  // This test uses the custom-designed manipulators:  left and right

char * feline = "bob cat";
long   lnum   = 757905;
double dnum   = 2345070.00915756;

ofstream os9A(filenameA[9], ios::out);

os9A<<left<<setfill('#')<<setw(12)<<setprecision(14)<<feline<<endl;
os9A<<setw(12)<<lnum<<endl;
os9A<<setw(12)<<dnum<<endl;

os9A<<right<<setfill('*')<<setw(12)<<setprecision(14)<<feline<<endl;                            
os9A<<setw(12)<<lnum<<endl;
os9A<<setw(12)<<dnum<<endl;

os9A.close();
}

void Test10() {

double dbl3[]  = {
                 0.123456, 1.123456, 12.123456, 123.123456, 1234.123456, 12345.123456, 123456.123456,
                 12345.6123456, 1234.56123456, 123.456123456, 12.3456123456, 1.23456123456,
                 1234561.23456, 12345612.3456, 123456123.456, 1234561234.56, 12345612345.6, 1234567.123456,
                 12345678.123456, 123456789.123456, 1234567891.123456, 12345678912.123456, 123456789123.123456,
                 1234567891234.123456
                 };

ofstream os10A(filenameA[10], ios::out);

os10A.precision(20);
os10A.width(30);
os10A.setf(ios::right, ios::adjustfield);

os10A<<"Fixed Format - Positive"<<endl;
os10A.width(30);
for(int index = 0; index < 24; index++) {
   os10A<<dbl3[index]<<endl;
   os10A.width(30);
   }

os10A.width(30);

os10A<<"Fixed Format - Negative"<<endl;
os10A.width(30);
for(index = 0; index < 24; index++) {
   os10A<<-dbl3[index]<<endl;
   os10A.width(30);
   }

os10A.setf(ios::scientific, ios::floatfield);
os10A.width(30);

os10A<<"Scientific Format - Positive"<<endl;
os10A.width(30);
for(index = 0; index < 24; index++) {
   os10A<<dbl3[index]<<endl;
   os10A.width(30);
   }

os10A.width(30);

os10A<<"Scientific Format - Negative"<<endl;
os10A.width(30);
for(index = 0; index < 24; index++) {
   os10A<<-dbl3[index]<<endl;
   os10A.width(30);
   }

os10A.close();
}

void main() 
{

Test01();
Test02();
Test03();
Test04();
Test05();
Test06();
Test07();
Test08();
Test09();
Test10();

}
