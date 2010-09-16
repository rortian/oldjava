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

#include <sys/types.h>
#include <sys/param.h>
#include <sys/socket.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <sys/errno.h>
#include <sys/signal.h>
#include <sys/wait.h>
#include <netinet/in.h>
#include <netdb.h>
#include <varargs.h>
#include <string.h>
#include <stdio.h>
#include <fcntl.h>
#include "common.h"

int errno;
char * sys_errlist[];

void reaper(int status)
{
while (wait3(&status, WNOHANG, 0) >= 0);
}

int transfer(fd)
int fd;
{
char filename[BUFFSIZE];
char buffer[BUFFSIZE];
int  lgth;
int  filedes;
int  count;

bzero(filename, sizeof(filename));
bzero(buffer, sizeof(buffer));

while (lgth = read(fd, buffer, sizeof(buffer))) {
   if (lgth < 0)
      notify_exit("Transfer read: %s\n", sys_errlist[errno]);
   if (buffer[lgth-1]=='\n') {
      buffer[lgth-1]='\0';
      strcat(filename, buffer);
      break;
      }
   else
      strcat(filename, buffer);   
   }

if (strlen(buffer)==0)
   return(0);

filedes = open(filename, O_RDONLY);

if (filedes < 0)
   notify_exit("Unable to get file descriptor for file %s\n", filename);

bzero(buffer, sizeof(buffer));

while (count = read(filedes, buffer, sizeof(buffer))) {
   if (count == -1)
      notify_exit("Read failed on file %s", filename);
   if (write(fd, buffer, count)<0)
      notify_exit("Write failed on file %s", filename);
   }

close(filedes);

printf("Done transferring file %s\n", filename);

return(0);
}

int main(argc, argv)
int argc;
char *argv[];
{
struct sockaddr_in fsin;
int                alen;
int                msock;
int                ssock;
int                port_no = PORT;

switch(argc) {
   case 1:
      break;
   case 2:
      port_no = (u_short) atoi(argv[1]);
      break;
   default:
      notify_exit("Usage: FileServer [portbase]\n");
   }

msock = createTCPSocket(NULL, port_no, QLEN);

(void) signal(SIGCHLD, reaper);

while(1) {
   alen = sizeof(fsin);
   ssock = accept(msock, (struct sockaddr *)&fsin, &alen);
   if (ssock < 0) {
      if (errno == EINTR) continue;
      notify_exit("accept:  %s\n", sys_errlist[errno]);
      }
   switch (fork()) {
      case 0:   /* child */
         (void) close(msock);
         exit(transfer(ssock));
      default:
         (void) close(ssock);
         break;
      case -1:
         notify_exit("fork:  %s\n", sys_errlist[errno]);
      } /* switch */
   }
}
