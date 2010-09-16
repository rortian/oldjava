#include <stdio.h>
#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
#include <string.h>
#include <fcntl.h>
#include <io.h>

class Glossary {			// Exception specifications are not supported in
public:						// Microsoft Visual C++ 4.0
   Glossary(char *);		// Glossary(char *) throw(char *);
   ~Glossary();
   void Display();
   enum { MAX_WORD_LENGTH = 161 };
private:
   char * filename;
   Glossary(const Glossary &);
   Glossary & operator=(const Glossary &);
};

Glossary::Glossary(char * name) {
int descriptor = _open(name, _O_RDONLY);
if (descriptor == -1) {
   char errmsg[80];
   sprintf(errmsg, "Unable to open file %s", name);
   throw(errmsg);
   }
else {
   filename = new char[strlen(name)+1];
   strcpy(filename, name);
   _close(descriptor);
   }
}

Glossary::~Glossary() {
delete [] filename;
}

void Glossary::Display() {
fstream filestream(filename, ios::in);
char word[MAX_WORD_LENGTH];
while (!filestream.eof()) {
	filestream>>setw(MAX_WORD_LENGTH)>>word;
	cout<<word<<endl;
    }
filestream.close();
}

void main()
{
try {
    Glossary gloss("TERMS.TXT");
	gloss.Display();
    }
catch (char * msg) {
	cout<<msg<<endl;
    }
}