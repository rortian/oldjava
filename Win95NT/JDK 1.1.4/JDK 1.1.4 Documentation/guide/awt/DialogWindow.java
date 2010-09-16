import java.awt.*;
import java.awt.event.*;

public class DialogWindow extends Frame 
			  implements WindowListener,
			             ActionListener {
    private boolean inAnApplet = true;
    private SimpleDialog dialog;
    private TextArea textArea;

    public DialogWindow() {
        textArea = new TextArea(5, 40);
        textArea.setEditable(false);
        add("Center", textArea);
        Button button = new Button("Click to bring up dialog");
	button.addActionListener(this);
        Panel panel = new Panel();
        panel.add(button);
        add("South", panel);
	addWindowListener(this);
    }

    public void windowClosed(WindowEvent event) {
    }

    public void windowDeiconified(WindowEvent event) {
    }

    public void windowIconified(WindowEvent event) {
    }

    public void windowActivated(WindowEvent event) {
    }

    public void windowDeactivated(WindowEvent event) {
    }

    public void windowOpened(WindowEvent event) {
    }

    public void windowClosing(WindowEvent event) {
        if (inAnApplet) {
            dispose();
        } else {
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) {
            dialog = new SimpleDialog(this, "A Simple Dialog");
        }
        dialog.setVisible(true);
    }

    public void setText(String text) {
        textArea.append(text + "\n");
    }

    public static void main(String args[]) {
        DialogWindow window = new DialogWindow();
        window.inAnApplet = false;

        window.setTitle("DialogWindow Application");
        window.pack();
        window.setVisible(true);
    }
}

class SimpleDialog extends Dialog implements ActionListener {
    TextField field;
    DialogWindow parent;
    Button setButton;

    SimpleDialog(Frame dw, String title) {
        super(dw, title, false);
        parent = (DialogWindow)dw;

        //Create middle section.
	Panel p1 = new Panel();
        Label label = new Label("Enter random text here:");
        p1.add(label);
        field = new TextField(40);
	field.addActionListener(this);
	p1.add(field);
        add("Center", p1);

        //Create bottom row.
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Button b = new Button("Cancel");
	b.addActionListener(this);
        setButton = new Button("Set");
	setButton.addActionListener(this);
        p2.add(b);
        p2.add(setButton);
        add("South", p2);

	//Initialize this dialog to its preferred size.
	pack();
    }

    public void actionPerformed(ActionEvent event) {
	Object source = event.getSource();
        if ( (source == setButton)
           | (source == field)) {
            parent.setText(field.getText());
        }
        field.selectAll();
        setVisible(false);
    }
}
