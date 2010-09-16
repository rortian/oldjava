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
#include "PetsBird.hh"
#include "PetsDog.hh"

namespace {  // Anonymous Namespace

class Cat {
public:
   Cat(String, String);
   void getData();
private:
   String name;
   String family;
};

Cat::Cat(String nm, String fm) : name(nm), family(fm) {
}

void Cat::getData() {
cout<<"Cat Data:"<<endl;
cout<<"Species = "<<name<<endl;
cout<<"Family = "<<family<<endl;
cout<<endl;
}

}  // Anonymous Namespace

namespace Zoo = Zoology;

void CreateDog() {
Pets::Dog dalmatian("Dalmatian", Pets::Dog::MALE, Pets::Dog::SMOOTH, 700.50);
dalmatian.getData();
}

void CreatePet() {
using namespace Pets;
Bird parakeet("Parakeet", Bird::MALE, 39.95);
parakeet.getData();
CreateDog();
}

void CreateHawk() {
using namespace Zoology;
// using namespace Pets;
Bird hawk("Hawk", "Flying Predators", 5.0, 25);
hawk.getData();
cout<<"The hawk flies at "<<hawk.getSpeed()<<" miles per hour.\n"<<endl;
}

void CreateAnimals() {
using namespace Zoology;
using Pets::Dog;
Bird cockatoo("Cockatoo", "Parrot", 0.80, 6);
cockatoo.getData();
Dog collie("Collie", Dog::FEMALE, Dog::LONG_HAIR, 539.50);
collie.getData();
}

void main() {

/*
Pets::Bird macaw1("Macaw", Pets::Bird::FEMALE, 249.98);
macaw1.getData();
*/

// The above can be replaced by the following:
using namespace Pets;

Bird macaw1("Macaw", Bird::FEMALE, 249.98);
macaw1.getData();

cout<<"The macaw costs $"<<macaw1.getSalesPrice()<<"\n"<<endl;

Dog beagle("Beagle", Dog::MALE, Dog::SMOOTH, 349.50);
beagle.getData();

Zoo::Bird macaw2("Macaw", "Parrot", 2.0, 10);
macaw2.getData();

CreateAnimals();
CreatePet();
CreateHawk();

Cat kitty("House Cat", "Tabby");	// Cat is unique to this translation unit
kitty.getData();
}