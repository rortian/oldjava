#ifndef STRCLASS_CPP
#define STRCLASS_CPP
#include <iostream.h>
#include <string.h>
#include "String.hh"

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

#endif
