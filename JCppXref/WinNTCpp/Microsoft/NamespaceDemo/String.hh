#ifndef STRCLASS_HH
#define STRCLASS_HH

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
   int   * ref_count;
   int     length;
   char  * text;
};

#endif