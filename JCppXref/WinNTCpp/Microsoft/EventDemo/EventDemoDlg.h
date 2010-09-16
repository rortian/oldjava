// EventDemoDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CEventDemoDlg dialog

class CEventDemoDlg : public CDialog
{
// Construction
public:
	CEventDemoDlg(CWnd* pParent = NULL);	// standard constructor
	~CEventDemoDlg();
	virtual BOOL OnWndMsg( UINT message, WPARAM wParam, LPARAM lParam, LRESULT* pResult );

// Dialog Data
	//{{AFX_DATA(CEventDemoDlg)
	enum { IDD = IDD_EVENTDEMO_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CEventDemoDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CEventDemoDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

private:

	CStdioFile  rfile;
};
