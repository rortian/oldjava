#ifndef STRCLASS_HH
#define STRCLASS_HH

class  String {
public:
   String();
   String(const char *);
   String(const String&);
   ~String();
   operator const char * () const;
   String operator+(String &);
   String& operator=(String &);
   void DisplayString() const;
   const char * ReturnString() const;
   int  ReturnLength() const;
private:
   int   length;
   char  *text;
}; 

#endif