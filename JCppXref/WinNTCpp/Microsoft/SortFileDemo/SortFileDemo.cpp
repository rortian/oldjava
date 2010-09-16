#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
#include <stdlib.h>
#include <string.h>
#include <io.h>
#include <fcntl.h>

typedef char * char_ptr;

const int MAX_SIZE = 256;

void Partition(char ** str, int left, int right) {
int index1;
int index2;
char * curr_str = 0;
char * temp_str = 0;

index1 = left;
index2 = right;

curr_str = str[(left+right)/2];

do {
	while ( (strcmp(str[index1], curr_str)<0) && (index1 < right) ) index1++;
	while ( (strcmp(curr_str, str[index2])<0) && (index2 > left)  ) index2--;

    if (index1 < index2) {
		temp_str    = str[index1];
		str[index1] = str[index2];
		str[index2] = temp_str;
		index1++;
		index2--;
	    }
    else	
    if (index1 == index2) {
		index1++;
		index2--;
	    }

    } while (index1 <= index2);

if (left < index2)  Partition(str, left, index2);
if (index1 < right) Partition(str, index1, right);
}

void Quicksort(char ** str, int num_recs) {
Partition(str, 0, num_recs-1);
}

void ReadAndSortFile(const char * source_file, const char * target_file) {
char buffer[MAX_SIZE];
char ** record = 0;
int count = 0;
int input_status = 1;
int index;

ifstream infile(source_file, ios::in | ios::nocreate);
if (!infile) {
	cout<<"File "<<source_file<<" not found!"<<endl;
	cout<<endl;
	return;
    }

ofstream outfile(target_file, ios::out);
if (!outfile) {
	cout<<"File "<<target_file<<" not found!"<<endl;
	cout<<endl;
	return;
    }

while (input_status) {
   infile.getline(buffer, MAX_SIZE);
   if (infile.eof())
      break;
   count++;
   }

record = new char_ptr[count];

infile.clear();	  // Reset the ios::eofbit
infile.seekg(0);  // Put the file pointer to the beg of file

index = 0;

while (input_status) {
   infile.getline(buffer, MAX_SIZE);
   if (infile.eof())
      break;
   record[index] = new char[strlen(buffer)+1];
   strcpy(record[index++], buffer);
   }

Quicksort(record, count);

for (index = 0; index < count; index++)
   outfile<<record[index]<<endl;

delete [] record;

infile.close();
outfile.close();
}

void main(int argc, char ** argv)
{

if (argc != 3) {
   cout<<"Usage:  SortFileDemo <source file> <target file>"<<endl;
   return;
   }

ReadAndSortFile(argv[1], argv[2]);

}