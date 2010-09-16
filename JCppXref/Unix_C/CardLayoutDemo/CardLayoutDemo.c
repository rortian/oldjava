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
#include <Xm/RowColumn.h>
#include <Xm/PushB.h>

static char * btns[] = { 
		       "btn1", "btn2", "btn3",
		       "btn4", "btn5", "btn6",
		       "btn7", "btn8", "btn9",
		       "btn10", "btn11", "btn12"
		       };

void nextPanel(widget, rowcolWidget, callback)
Widget widget;
WidgetList rowcolWidget;
XmAnyCallbackStruct * callback;
{
int n;
Arg wargs[10];
static int curr_widget = 0;
XtUnmanageChild(rowcolWidget[curr_widget]);
curr_widget++;
curr_widget %= 3;

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNtopWidget, rowcolWidget[curr_widget]); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetValues(rowcolWidget[curr_widget], wargs, n);
XtManageChild(rowcolWidget[curr_widget]);

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, rowcolWidget[curr_widget]); n++;
XtSetValues(rowcolWidget[3], wargs, n);
}

void main(argc, argv)
int    argc;
char * argv;
{
Widget     mainLevel, mainFormWidget;
Widget     forwardButtonWidget, buttonWidget[XtNumber(btns)];
WidgetList rowcolWidget[4];
int index, n;
Arg wargs[10];

mainLevel = XtInitialize(argv[0], "Card", NULL, 0, &argc, argv);

mainFormWidget = XtCreateManagedWidget("mainform", xmFormWidgetClass, mainLevel, NULL, 0); 

rowcolWidget[0]  = XtCreateWidget("rowcol1", xmRowColumnWidgetClass, mainFormWidget, NULL, 0); 
rowcolWidget[1]  = XtCreateWidget("rowcol2", xmRowColumnWidgetClass, mainFormWidget, NULL, 0); 
rowcolWidget[2]  = XtCreateWidget("rowcol3", xmRowColumnWidgetClass, mainFormWidget, NULL, 0); 
rowcolWidget[3]  = XtCreateWidget("rowcol4", xmRowColumnWidgetClass, mainFormWidget, NULL, 0); 

for (index=0; index<=3; index++) {
   buttonWidget[index] = XtCreateWidget(btns[index], xmPushButtonWidgetClass, rowcolWidget[0], NULL, 0);
   XtManageChild(buttonWidget[index]);
   }

for (index=4; index<=7; index++) {
   buttonWidget[index] = XtCreateWidget(btns[index], xmPushButtonWidgetClass, rowcolWidget[1], NULL, 0);
   XtManageChild(buttonWidget[index]);
   }

for (index=8; index<=11; index++) {
   buttonWidget[index] = XtCreateWidget(btns[index], xmPushButtonWidgetClass, rowcolWidget[2], NULL, 0);
   XtManageChild(buttonWidget[index]);
   }

forwardButtonWidget = XtCreateWidget("forward", xmPushButtonWidgetClass, mainFormWidget, NULL, 0);

for (index=0; index<3; index++) {
   n = 0;
   XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_FORM); n++;
   XtSetArg(wargs[n], XmNtopWidget, rowcolWidget[index]); n++;
   XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
   XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
   XtSetValues(rowcolWidget[index], wargs, n);
   }

XtManageChild(rowcolWidget[0]);

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, rowcolWidget[0]); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetValues(rowcolWidget[3], wargs, n);

XtManageChild(rowcolWidget[3]);

n = 0;
XtSetArg(wargs[n], XmNtopAttachment, XmATTACH_WIDGET); n++;
XtSetArg(wargs[n], XmNtopWidget, rowcolWidget[3]); n++;
XtSetArg(wargs[n], XmNbottomAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNleftAttachment, XmATTACH_FORM); n++;
XtSetArg(wargs[n], XmNrightAttachment, XmATTACH_FORM); n++;
XtSetValues(forwardButtonWidget, wargs, n);

XtManageChild(forwardButtonWidget);

XtAddCallback(forwardButtonWidget, XmNactivateCallback, nextPanel, rowcolWidget);

XtRealizeWidget(mainLevel);
XtMainLoop();
}
