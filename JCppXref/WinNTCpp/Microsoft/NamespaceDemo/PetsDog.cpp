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
#include <string.h>
#include "String.hh"
#include "PetsDog.hh"

using namespace Pets;

Dog::Dog(String nm, int sx, int fur, double cost) :
name(nm), gender(sx), coat(fur), sales_price(cost) {
}
   
void Dog::getData() {
cout<<"Pet Data:"<<endl;
cout<<"Species = "<<name<<endl;
cout<<"Gender = "<<((gender==FEMALE)?"Female":"Male")<<endl;
cout<<"Coat = ";
switch (coat) {
   case SMOOTH:
      cout<<"Smooth"<<endl;
	  break;
   case SHAGGY:
	  cout<<"Shaggy"<<endl;
	  break;
   case SHORT_HAIR:
	  cout<<"Short hair"<<endl;
	  break;
   case LONG_HAIR:
	  cout<<"Long hair"<<endl;
	  break;
   }
cout<<"Price = "<<sales_price<<endl;
cout<<endl;
}

int Dog::getCoat() {
return coat;
}
