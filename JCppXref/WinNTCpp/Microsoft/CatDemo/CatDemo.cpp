#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
#include <io.h>
#include <fcntl.h>

const int MAX_SIZE = 256;

void GetAndDisplayKeyboardInput () {
char buffer[MAX_SIZE];
int input_status = 1;

while (input_status) {
   cin.getline(buffer, MAX_SIZE);
   if (cin.eof())
	   break;
   cout<<buffer<<endl;             					
   }
}

void GetAndDisplayLines(const char * filename) {
char buffer[MAX_SIZE];
int input_status = 1;

ifstream infile(filename, ios::in | ios::nocreate);
if (!infile) {
	cout<<"File "<<filename<<" not found!"<<endl;
	cout<<endl;
	return;
    }

cout<<filename<<":"<<endl;
while (input_status) {
   infile.getline(buffer, MAX_SIZE);
   if (infile.eof())
	   break;
   cout<<buffer<<endl;             					
   }  
cout<<endl;
infile.close();
}

void main(int argc, char ** argv)
{

if (argc == 1)
   GetAndDisplayKeyboardInput();
else
if (argc > 1)
   for (int index = 1; index < argc; index++)
	   GetAndDisplayLines(argv[index]);

}