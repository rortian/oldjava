#include <iostream.h>

void main() {

int num[10];

for (int index = 0; index < 10; index++) { 
   num[index] = 3 * index;
   }
for (index = 0; index < 10; index++) {
	cout<<"Element #"<<index<<" = "<<num[index]<<endl;
    }

cout<<"Number of elements of array = "<<sizeof(num)/sizeof(int)<<endl;

}