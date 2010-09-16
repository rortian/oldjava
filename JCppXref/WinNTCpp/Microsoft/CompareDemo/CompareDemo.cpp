#include <iostream.h>
#include <string.h>

class  String {
public:
   enum { FALSE, TRUE };
   String();
   String(const char *);
   String(const String&);
   ~String();
   void DisplayString() const;
   int  ReturnLength() const;
   operator const char * () const;
   String operator+(const String &);
   String& operator=(const String &);
   int operator==(const String &);
   int Equals(const String &);
private:
   int   length;
   char  *text;
}; 

String::String() : text(0), length(0) {
}

String::String(const char *str) {
text = new char[strlen(str) + 1];
strcpy(text, str);
length = strlen(str);
}

String::String(const String &str) {
text = new char[strlen(str.text) + 1];
strcpy(text, str.text);
length = strlen(str.text);
}

String::~String() {
delete [] text;
}

String::operator const char * () const {
return text;
}

void String::DisplayString() const {
cout<<"String is "<<text<<'\n';
}

int  String::ReturnLength() const {
return(length);
}

String String::operator+(const String &str) {
int lgth = this->ReturnLength() + str.ReturnLength();
char * temp_text = new char[lgth+1];
strcpy(temp_text, *this);
strcat(temp_text, *this);
String temp_str(temp_text);
return(temp_str);
}

String& String::operator=(const String &str) {
length = str.ReturnLength();
char * temp_text = new char[length+1];
strcpy(temp_text, str);
delete [] text;
text = temp_text;
return(*this);
}

int String::operator==(const String &str) {
if (this == &str)
   return String::TRUE;
else
   return String::FALSE;
}

int String::Equals(const String &str) {
if (strcmp(*this, str)==0)
   return String::TRUE;
else
   return String::FALSE;
}

void main()
{
String str1("Tequilla Sunset");
String str2("Tequilla Sunset");
String str3("Tequilla Sundown");
String & str4 = str1;

/* (1) */
if (str1 == str2)
   cout<<"Variables str1 and str2 refer to the same object\n";
else
   cout<<"Variables str1 and str2 do NOT refer to the same object\n";

if (str1.Equals(str2))
   cout<<"The objects referred to by str1 and str2 are equal in content\n\n";
else
   cout<<"The objects referred to by str1 and str2 are NOT equal in content\n\n";

/* (2) */
if (str2 == str3)
   cout<<"Variables str2 and str3 refer to the same object\n";
else
   cout<<"Variables str2 and str3 do NOT refer to the same object\n";

if (str2.Equals(str3))
   cout<<"The objects referred to by str2 and str3 are equal in content\n\n";
else
   cout<<"The objects referred to by str2 and str3 are NOT equal in content\n\n";

/* (3) */
if (str1 == str4)
   cout<<"Variables str1 and str4 refer to the same object\n";
else
   cout<<"Variables str1 and str4 do NOT refer to the same object\n";

if (str1.Equals(str4))
   cout<<"The objects referred to by str1 and str4 are equal in content\n\n";
else
   cout<<"The objects referred to by str1 and str4 are NOT equal in content\n\n";

}
