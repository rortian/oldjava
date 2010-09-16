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
#include <Xm/Form.h>
#include <Xm/PushB.h>

static char * btns[] = {
                       "btn1", "btn2", "btn3", "btn4", "btn5" 
		       };

void main(argc,  argv)
int argc;
char * argv[];
{
Widget mainLevel, formWidget, buttonWidget[XtNumber(btns)];
int index, n;
Arg wargs[10];

mainLevel = XtInitialize(argv[0], "Border", NULL, 0, &argc, argv);

formWidget = XtCreateManagedWidget("form", xmFormWidgetClass, mainLevel, NULL, 0); 

for (index=0; index<XtNumber(btns); index++)
   buttonWidget[index] = XtCreateWidget(btns[index], xmPushButtonWidgetClass, formWidget, NULL, 0);

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetValues(buttonWidget[0], wargs, n);

n = 0;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, buttonWidget[0]); n++;
XtSetArg(wargs[n], XmNbottomAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNbottomWidget, buttonWidget[2]); n++;
XtSetValues(buttonWidget[1], wargs, n);

n = 0;
XtSetArg(wargs[n], XmNbottomAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetValues(buttonWidget[2], wargs, n);

n = 0;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, buttonWidget[0]); n++;
XtSetArg(wargs[n], XmNbottomAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNbottomWidget, buttonWidget[2]); n++;
XtSetValues(buttonWidget[3], wargs, n);

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, buttonWidget[0]); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNrightWidget, buttonWidget[1]); n++;
XtSetArg(wargs[n], XmNbottomAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNbottomWidget, buttonWidget[2]); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNleftWidget, buttonWidget[3]); n++;
XtSetValues(buttonWidget[4], wargs, n);

XtManageChildren(buttonWidget, XtNumber(btns));

XtRealizeWidget(mainLevel);
XtMainLoop();
}
