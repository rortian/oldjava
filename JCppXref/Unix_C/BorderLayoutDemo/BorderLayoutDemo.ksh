#! /bin/ksh

cc -o BorderLayoutDemo BorderLayoutDemo.c \
   -I /usr/include/Motif1.2/ -I /usr/include/X11R5/ \
   -L /usr/lib/Motif1.2/ -lXm \
   -L /usr/lib/X11R5/ -lXt -lX11
