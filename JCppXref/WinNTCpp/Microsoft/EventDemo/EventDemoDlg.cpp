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

// EventDemoDlg.cpp : implementation file
//

#include "stdafx.h"
#include "EventDemo.h"
#include "EventDemoDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CEventDemoDlg dialog

CEventDemoDlg::CEventDemoDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CEventDemoDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(CEventDemoDlg)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
	if (!rfile.Open("RESULTS.TXT", CFile::modeCreate | CFile::modeWrite)) {
	   MessageBox("Cannot open file RESULTS.TXT", NULL, MB_OK);
	   rfile.Abort();
	}
}

CEventDemoDlg::~CEventDemoDlg()
{
	rfile.Close();
}

BOOL CEventDemoDlg::OnWndMsg( UINT message, WPARAM wParam, LPARAM lParam, LRESULT* pResult )
{

	char buffer[256];
	switch (message) { // (1)

	case WM_COMMAND:
		strcpy(buffer, "Message = WM_COMMAND, Window Control = ");
		switch (wParam) {  // (2)
		case IDC_ICE_CREAM:
            strcat(buffer, "Ice Cream");
		    break;
		case IDC_FROZEN_YOGURT:
		    strcat(buffer, "Frozen Yogurt");
            break;
		case IDC_FLAVOR_SELECTION:
		    strcat(buffer, "Flavors");
            break;
        case IDC_CARAMEL_TOPPING:
		    strcat(buffer, "Caramel Topping");
            break;
        case IDC_CHERRIES:
		    strcat(buffer, "Cherries");
            break;
        case IDC_NUTS:
		    strcat(buffer, "Nuts");
            break;
        case IDC_OK:
		    strcat(buffer, "Ok");
            break;
        case IDC_CANCEL:
		    strcat(buffer, "Cancel");
            break;
		default:
			if (LOWORD(wParam) == IDC_ADD_TOPPING) {
			   strcat(buffer, "Add Topping, Code = ");
			   if (HIWORD(wParam) == EN_CHANGE)
				  strcat(buffer, "EN_CHANGE");
			   else
			   if (HIWORD(wParam) == EN_UPDATE)
				  strcat(buffer, "EN_UPDATE");
			   else
			   if (HIWORD(wParam) == EN_SETFOCUS)
				  strcat(buffer, "EN_SETFOCUS");
			   else
				  return CWnd::OnWndMsg(message, wParam, lParam, pResult);
			   }
			else
			if (LOWORD(wParam) == IDC_FLAVOR_SELECTION) {
			   strcat(buffer, "Flavors, Code = ");
			   if (HIWORD(wParam) == CBN_SELCHANGE)
				  strcat(buffer, "CBN_SELCHANGE");
			   else
			   if (HIWORD(wParam) == CBN_DROPDOWN)
				  strcat(buffer, "CBN_DROPDOWN");
			   else
			   if (HIWORD(wParam) == CBN_SETFOCUS)
				  strcat(buffer, "CBN_SETFOCUS");
			   else
			   if (HIWORD(wParam) == CBN_CLOSEUP)
			   	  strcat(buffer, "CBN_CLOSEUP");
			   else
				  return CWnd::OnWndMsg(message, wParam, lParam, pResult);
			   break;
		       }
			else
               return CWnd::OnWndMsg(message, wParam, lParam, pResult);
	    }  // (2)
	    strcat(buffer, "\n");
	    rfile.Write(buffer, strlen(buffer));
	    break;
	case WM_CREATE:
		strcpy(buffer, "Message = WM_CREATE");
	    strcat(buffer, "\n");
		rfile.Write(buffer, strlen(buffer));
		break;
	case WM_INITDIALOG:
		strcpy(buffer, "Message = WM_INITDIALOG");
	    strcat(buffer, "\n");
		rfile.Write(buffer, strlen(buffer));
		break;
	case WM_CLOSE:
		strcpy(buffer, "Message = WM_CLOSE");
	    strcat(buffer, "\n");
		rfile.Write(buffer, strlen(buffer));
		break;
	case WM_DESTROY:
		strcpy(buffer, "Message = WM_DESTROY");
	    strcat(buffer, "\n");
		rfile.Write(buffer, strlen(buffer));
		break;
	}  // (1)

	return CWnd::OnWndMsg(message, wParam, lParam, pResult);

}

void CEventDemoDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CEventDemoDlg)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CEventDemoDlg, CDialog)
	//{{AFX_MSG_MAP(CEventDemoDlg)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CEventDemoDlg message handlers

BOOL CEventDemoDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon
	CButton * pIceCreamButton = (CButton *) GetDlgItem(IDC_ICE_CREAM);
	pIceCreamButton->SetCheck(1);

	CComboBox * pFlavorsComboBox = (CComboBox *) GetDlgItem(IDC_FLAVOR_SELECTION);
	pFlavorsComboBox->SelectString(-1, "Dutch Apple");
	
	// TODO: Add extra initialization here
	
	return TRUE;  // return TRUE  unless you set the focus to a control
}

// If you add a minimize button to your dialog, you will need the code below
//  to draw the icon.  For MFC applications using the document/view model,
//  this is automatically done for you by the framework.

void CEventDemoDlg::OnPaint() 
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, (WPARAM) dc.GetSafeHdc(), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR CEventDemoDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

