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
#include <typeinfo.h>
#include "String.hh"

class Publication {
public:
	Publication(String, String, String);
	String getTitle();
	String getSubject();
	String getPublisher();
	void Display();	
	~Publication();
private:
	String title;
	String subject;
	String publisher;
};

Publication::Publication(String tit, String sub, String pub) : title(tit), subject(sub), publisher(pub) {
}

Publication::~Publication() {
}

String Publication::getTitle() {
return title;
}

String Publication::getSubject() {
return subject;
}

String Publication::getPublisher() {
return publisher;
}

void Publication::Display() {
cout<<"Title:  "<<getTitle()<<", Subject:  "<<getSubject()<<", Publisher:  "
				<<getPublisher()<<endl;
}

class Book : public Publication {
public:
	Book(String, String, String, String);
	String getAuthor();
	void Display();
private:
	String author;
};

Book::Book(String tit, String sub, String pub, String aut) :
									Publication(tit, sub, pub), author(aut) {
}

String Book::getAuthor() {
return author;
}

void Book::Display() {
cout<<"Title:  "<<getTitle()<<", Subject:  "<<getSubject()<<", Publisher:  "
				<<getPublisher()<<", Author:  "<<getAuthor()<<endl;
}

class Manual : public Book {
public:
	Manual(String, String, String, String, String);
	String getProduct();
	void Display();
private:
	String product;
};

Manual::Manual(String tit, String sub, String pub, String aut, String prod) : 
									Book(tit, sub, pub, aut), product(prod) {
}

String Manual::getProduct() {
return product;
}

void Manual::Display() {
cout<<"Title:  "<<getTitle()<<", Subject:  "<<getSubject()<<", Publisher:  "
	<<getPublisher()<<", Author:  "<<getAuthor()<<", Product:  "<<getProduct()<<endl;
}

void main()
{
Book book1("Sunrise over Saratoga", "Fiction", "Story Tellers, Ltd.", "Vern Goodman");

if (typeid(book1) == typeid(Publication))
   cout<<"book1 is of type Publication"<<endl;
else
   cout<<"book1 is NOT of type Publication"<<endl;

if (typeid(book1) == typeid(Book)) {
   cout<<"book1 is of type Book"<<endl;
   cout<<"book1 is authored by "<<book1.getAuthor()<<endl;
   }
else
   cout<<"book1 is NOT of type Book"<<endl;

if (typeid(book1) == typeid(Manual))
   cout<<"book1 is of type Manual"<<endl;
else
   cout<<"book1 is NOT of type Manual"<<endl;

cout<<"Variable book1 represents an instance of "<<typeid(book1).name()<<endl;
}