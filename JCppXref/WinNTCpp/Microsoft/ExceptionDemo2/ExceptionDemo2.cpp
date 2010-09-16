#include <stdio.h>
#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
#include <string.h>
#include <fcntl.h>
#include <io.h>
#include <sys/types.h>
#include <sys/stat.h>

// Xception class hierarchy

class Xception {
public:
	Xception(char *);
	virtual void Display() const;
protected:
	const char * getMessage() const;
private:
    char message[80];
};

Xception::Xception(char * msg) {
strcpy(message, msg);
}

const char * Xception::getMessage() const {
return message;
}

void Xception::Display() const {
cout<<"Xception:  "<<getMessage()<<endl;
}

class IOException : public Xception {
public:
	IOException(char *);
	virtual void Display() const;
};

IOException::IOException(char * msg) : Xception(msg) {
}

void IOException::Display() const {
cout<<"IOException:  "<<getMessage()<<endl;
}

class FileNotFoundException : public IOException {
public:
	FileNotFoundException(char *);
	virtual void Display() const;
};

FileNotFoundException::FileNotFoundException(char * msg) : IOException(msg) {
}

void FileNotFoundException::Display() const {
cout<<"FileNotFoundException:  "<<getMessage()<<endl;
}

// FileInputStream and FileOutputStream classes

class FileInputStream {
public:
	FileInputStream(char *);
	~FileInputStream();
	int read(char *, int);
	int getDescriptor();
private:
	int    descriptor;
	char * filename;
	FileInputStream(const FileInputStream &);
    FileInputStream & operator=(const FileInputStream &);
};

FileInputStream::FileInputStream(char * name) {
descriptor = _open(name, _O_RDONLY);
if (descriptor == -1) {
   char errmsg[80];
   sprintf(errmsg, "Unable to open file %s", name);
   throw FileNotFoundException(name);
   }
else {
   filename = new char[strlen(name)+1];
   strcpy(filename, name);
   }
}

FileInputStream::~FileInputStream() {
close(descriptor);
delete [] filename;
}

int FileInputStream::read(char * buffer, int num_of_chars) {
int bytes_read;
if ( (bytes_read = _read(descriptor, buffer, num_of_chars)) <= 0 )
   return -1;
else
   return  bytes_read;
}

int FileInputStream::getDescriptor() {
return descriptor;
}

class FileOutputStream {
public:
	FileOutputStream(char *);
	~FileOutputStream();
	int write(char *, int);
private:
	int    descriptor;
	char * filename;
	FileOutputStream(const FileOutputStream &);
    FileOutputStream & operator=(const FileOutputStream &);
};

FileOutputStream::FileOutputStream(char * name) {
descriptor = _open(name, _O_WRONLY, _S_IREAD | _S_IWRITE);  // Exception if file does not exist
if (descriptor == -1) {
   char errmsg[80];
   sprintf(errmsg, "Unable to open file %s", name);
   throw IOException(name);
   }
else {
   filename = new char[strlen(name)+1];
   strcpy(filename, name);
   }
}

FileOutputStream::~FileOutputStream() {
close(descriptor);
delete [] filename;
}

int FileOutputStream::write(char * buffer, int num_bytes) {
if ( _write(descriptor, buffer, num_bytes) != num_bytes )
   return -1;
else
   return  0;
}

// Start of main example in C++

void MergeStreams(FileInputStream * in1, FileInputStream * in2, char * outfile) {
FileOutputStream * outStream = NULL;
try {
	int nbytes;
	char buffer[1];
    outStream = new FileOutputStream(outfile);
    
	while ((nbytes = (in1->read(buffer, 1)) != -1)) {
		outStream->write(buffer, nbytes);
	    }

	while ((nbytes = (in2->read(buffer, 1)) != -1)) {
		outStream->write(buffer, nbytes);
	    }

	delete outStream;
    }
catch (IOException & err) {
	err.Display();
	cout<<"Deleting dynamic outStream object"<<endl;
	delete outStream;
    throw FileNotFoundException(outfile);
    }
catch (Xception & err) {
	err.Display();
	cout<<"Deleting dynamic FileOutputStream object"<<endl;
	delete outStream;
    throw FileNotFoundException(outfile);
    }
}

void OpenSecondInputStream(FileInputStream * input1, char * infile2) {
FileInputStream * inStream2 = NULL;
try {
	inStream2 = new FileInputStream(infile2);
	MergeStreams(input1, inStream2, "TERMS3.TXT");
	delete inStream2;
    }
catch (FileNotFoundException & err) {
	err.Display();
	cout<<"Deleting second dynamic FileInputStream object"<<endl;
	delete inStream2;
    throw err;
    }
catch (IOException & err) {
	err.Display();
	cout<<"Deleting second dynamic FileInputStream object"<<endl;
	delete inStream2;
    throw err;
    }
}

void main()
{
FileInputStream * inStream1 = NULL;
try {
	inStream1 = new FileInputStream("TERMS1.TXT");
	OpenSecondInputStream(inStream1, "TERMS2.TXT");
	delete inStream1;
    }
catch (Xception & err) {
	err.Display();
	cout<<"Deleting first dynamic FileInputStream object"<<endl;
	delete inStream1;
	cout<<"At least one input or output stream failed to open..."<<endl;
	cout<<"Exiting program..."<<endl;
    }
}