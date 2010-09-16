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
#include "ZoologyBird.hh"

using namespace Zoology;

Bird::Bird(String nm, String fm, double sn, long sp) :
      name(nm), family(fm), wing_span(sn), speed(sp) {
}

void Bird::getData() {
cout<<"Animal Data:"<<endl;
cout<<"Species = "<<name<<endl;
cout<<"Family = "<<family<<endl;
cout<<"Wing span = "<<wing_span<<" feet"<<endl;
cout<<"Speed in flight = "<<speed<<" miles per hour"<<endl;
cout<<endl;
}

long Bird::getSpeed() {
return speed;
}
