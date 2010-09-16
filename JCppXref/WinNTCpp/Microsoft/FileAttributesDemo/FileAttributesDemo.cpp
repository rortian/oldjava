/*
 * Frederick F. Chew, The Java/C++ Cross Reference Handbook (Book/CD-ROM)
 * Published By HP Press/Prentice-Hall
 * Copyright (C) 1997 Hewlett-Packard Company
 * All Rights Reserved. ISBN 0-13-848318-3
 *
 * Permission to use, copy, modify, and distribute this 
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this 
 * copyright notice appears in all copies. 
 * 
 * THE AUTHOR AND PUBLISHER MAKE NO REPRESENTATIONS OR 
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. THE AUTHOR
 * AND PUBLISHER SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED 
 * BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING 
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
 
/**
 * @version 1.00 01 May 1997
 * @author Frederick F. Chew
 */

#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
#include <io.h>
#include <fcntl.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <direct.h>

const int MAX_SIZE = 256;

enum FTYPE { FILE_TYPE, DIR_TYPE };

void DisplayFileAttributes(const char * filename, int fd, enum FTYPE ftype) {

int not_readable  = _access(filename, 4);
int not_writeable = _access(filename, 2);

char fpath[_MAX_PATH];
if( _fullpath( fpath, filename, _MAX_PATH ) == NULL ) {
   cerr<<"Absolute path cannot be found for file "<<filename<<endl;
   return;
   }

// Display all of the information collected

cout<<endl;
if (ftype == FILE_TYPE)
   cout<<"Attributes of File: "<<filename<<endl;
if (ftype == DIR_TYPE)
   cout<<"Attributes of Directory: "<<filename<<endl;

cout<<"Absolute path: "<<fpath<<endl;
cout<<"Readable: "<<(!not_readable?"Yes":"No")<<endl;
cout<<"Writeable: "<<(!not_writeable?"Yes":"No")<<endl;

if (ftype == FILE_TYPE) {
   struct _stat sbuffer;
   int ret_val = _fstat(fd, &sbuffer);
   if (ret_val) {
      cerr<<"Invalid file descriptor"<<endl;
      return;
      }
   cout<<"Length of file: "<<sbuffer.st_size<<endl;
   }
if (ftype == DIR_TYPE) {
   char * cmd = new char[strlen("dir /b ")+strlen(filename)+1];
   strcpy(cmd, "dir /b ");
   strcat(cmd, filename);
   cout<<endl;
   cout<<filename<<" contains:"<<endl;
   system(cmd);
   delete [] cmd;
   }
}

void EditFileName(const char * filename) {
int fd;
char curr_dir[_MAX_PATH];

// Get the current working directory
if( _getcwd(curr_dir, _MAX_PATH ) == NULL ) {
   cout<<"Unable to get current directory"<<endl;
   return;
   }

if ((fd = _open(filename, _O_RDONLY)) != -1)
   DisplayFileAttributes(filename, fd, FILE_TYPE);
else
if (!_chdir(filename)) {  // If filename is a directory, this operation should work
   _chdir(curr_dir);      // Change the current directory back to the original
   DisplayFileAttributes(filename, fd, DIR_TYPE);
   }
else {
   cerr<<"File "<<filename<<" does not exist!"<<endl;
   return;
   }

}

void main(int argc, char ** argv)
{
char line[MAX_SIZE];
int done = 0;

do {
   cout<<"\nEnter the name of a file or directory or press EOF to exit: "<<flush;

   if (!cin.eof()) {
      cin.getline(line, MAX_SIZE);
	  if (strlen(line) != 0)
	     EditFileName(line);
	  }

   } while(!cin.eof());
}