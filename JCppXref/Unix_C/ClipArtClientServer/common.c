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

u_long inet_addr();

int notify_exit(msg, va_alist)
char * msg;
va_dcl
{
va_list parms;
va_start(parms);
_doprnt(msg, parms, stderr);
va_end(parms);
exit(1);
}

int createTCPSocket(host, port, backlog)
char * host;
int    port;
int    backlog;
{
struct hostent  *  pHostEnt;
struct protoent *  pProtoEnt;
struct sockaddr_in sin;
int    sock;

bzero((char*)&sin, sizeof(sin));
sin.sin_family = AF_INET;
sin.sin_port = htons((u_short)port);

if (host == NULL)
   sin.sin_addr.s_addr = INADDR_ANY;
else {
   if (pHostEnt = gethostbyname(host))
      bcopy(pHostEnt->h_addr, (char*)&sin.sin_addr, pHostEnt->h_length);
   else
   if ((sin.sin_addr.s_addr = inet_addr(host)) == INADDR_NONE)
      notify_exit("Cannott get \"%s\" protocol entry\n", host);
   }

if ((pProtoEnt = getprotobyname("tcp")) == 0)
   notify_exit("Cannot get \"tcp\" protocol entry\n");

sock = socket(PF_INET, SOCK_STREAM, pProtoEnt->p_proto);
if (sock < 0)
   notify_exit("Cannot create socket:  %s\n", sys_errlist[errno]);

if (host == NULL) {
   if (bind(sock, (struct sockaddr *)&sin, sizeof(sin)) < 0)
      notify_exit("Cannot bind to port %d: %s\n", port, sys_errlist[errno]);
   
   printf("Successful bind to port %d\n", port);
   
   if (listen(sock, backlog) < 0)
      notify_exit("Cannot listen on port %d: %s\n", port, sys_errlist[errno]);
   }
else {
   if (connect(sock, (struct sockaddr *)&sin, sizeof(sin)) < 0)
      notify_exit("Cannot connect to host %s on port %d: %s\n", host, port, sys_errlist[errno]);
   }

return sock;
}
