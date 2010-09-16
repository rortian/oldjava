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

#include <X11/StringDefs.h>
#include <X11/Intrinsic.h>
#include <Xm/Xm.h>
#include <Xm/RowColumn.h>
#include <Xm/PushB.h>

static char * btns[] = { 
		       "btn1", "btn2", "btn3",
		       "btn4", "btn5", "btn6",
		       "btn7", "btn8", "btn9",
		       "btn10", "btn11", "btn12"
		       };
void main(argc,  argv)
int argc;
char * argv[];
{
Widget mainLevel, rowcolWidget, buttonWidget[XtNumber(btns)];
int index;

mainLevel = XtInitialize(argv[0], "Flow", NULL, 0, &argc, argv);

rowcolWidget = XtCreateManagedWidget("rowcol", xmRowColumnWidgetClass, mainLevel, NULL, 0); 

for (index=0; index<XtNumber(btns); index++)
   buttonWidget[index] = XtCreateWidget(btns[index], xmPushButtonWidgetClass, rowcolWidget, NULL, 0);

XtManageChildren(buttonWidget, XtNumber(btns));

XtRealizeWidget(mainLevel);
XtMainLoop();
}

