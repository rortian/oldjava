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

#include <stdio.h>
#include <varargs.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <fcntl.h>
#include "common.h"

extern int errno;
extern char * sys_errlist[];

void get_file(host, port)
char * host;
int    port;
{
char buff[LINELGTH+1];
char filename[LINELGTH+1];
int  sock, count, fdes;

do {
   bzero(filename, sizeof(filename));
   sock = createTCPSocket(host, port, 0);
   printf("Enter the name of a file and press <return> (Type a single <return> to exit): ");

   fgets(buff, sizeof(buff), stdin);
   buff[LINELGTH] = '\0';
   if (buff[0]=='\n')
      return;
   write(sock, buff, strlen(buff));
   if (buff[strlen(buff)-1] == '\n')
      buff[strlen(buff)-1] = '\0';
   strcat(filename, buff);

   fdes = open(filename, O_WRONLY | O_CREAT, S_IRUSR | S_IWUSR);

   if (fdes < 0)
      notify_exit("Unable to get file descriptor for file %s\n", filename);

   while  (count = read(sock, buff, sizeof(buff))) {
      if (count < 0)
         notify_exit("Socket read failed: %s\n", sys_errlist[errno]);
      if (write(fdes, buff, count)<0)
         notify_exit("Write failed on file %s", filename);
      }
   close(fdes);
   } while (TRUE);
}

int main(argc, argv)
int  argc;
char *argv[];
{
char * host = "localhost";
int    port_no = PORT;

switch (argc) {
   case 1:  host = "localhost";
            break;
   case 3:  port_no = atoi(argv[2]);

   case 2:  host = argv[1];
            break;
   default: fprintf(stderr, "Usage: FileGet [host [port]]\n");
            exit(1);
   }

get_file(host, port_no);
exit(0);
}
