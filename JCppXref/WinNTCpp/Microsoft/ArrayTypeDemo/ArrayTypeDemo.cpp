#include <iostream.h>
#include <stdio.h>
#include <stdlib.h>

const int ROW_SIZE = 3;
const int COL_SIZE = 5;

typedef int * IntPtr;

void create2DArray(int ** grid, int row_size, int col_size) {

for (int row = 0; row < row_size; row++) {
   for (int column = 0; column < col_size; column++)
      grid[row][column] = column + row;
      }
}

void main() {

int ** cell;

cell = new IntPtr[ROW_SIZE];

for(int index = 0; index < ROW_SIZE; index++)
   cell[index] = new int[COL_SIZE];

create2DArray(cell, ROW_SIZE, COL_SIZE);

for (int row = 0; row < ROW_SIZE; row++) {
   for (int column = 0; column < COL_SIZE; column++)
      cout<<"["<<row<<","<<column<<"]="<<cell[row][column]<<"\t";
   cout<<endl;
   }

delete [] cell;

}

