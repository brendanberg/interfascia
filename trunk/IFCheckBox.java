// Interfascia -- ALPHA 001//// A graphical user interface library for the// Processing environment.//// by Brendan Berg//// This software is released under the LGPL?

package interfascia;
import processing.core.*;
import java.awt.event.*;
public class IFCheckBox extends GUIComponent {	private int currentColor;	private boolean selected = false;	public IFCheckBox (String argLabel, int argX, int argY) {		label = argLabel;		x = argX;		y = argY;		wid = 14;		hgt = 14;	}	public void initWithParent () {		parent.registerDraw(this);
		parent.registerMouseEvent(this);
	}

	public void mouseEvent (MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {				 wasClicked = true;				 draw();			}		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {				if (selected) {
					fireEventNotification(this, "Unchecked");
					selected = false;
				} else {
					fireEventNotification(this, "Checked");
					selected = true;
				}				wasClicked = false;				draw();			}		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
			if (selected) {				fireEventNotification(this, "Unchecked");				selected = false;			} else {				fireEventNotification(this, "Checked");				selected = true;			}		}
	}	public void draw () {		if (isMouseOver (parent.mouseX, parent.mouseY)) {			currentColor = lookAndFeel.highlightColor;		} else if (hasFocus) {			currentColor = lookAndFeel.highlightColor;		} else {			currentColor = lookAndFeel.baseColor;		}

		parent.stroke(lookAndFeel.borderColor);		parent.fill(currentColor);		parent.rect(x, y, wid, hgt);		if (selected == true) {			parent.stroke (lookAndFeel.darkGrayColor);			parent.line (x + 3, y + 3, wid + x - 3, hgt + y - 3);			parent.line (x + 3, y + 4, wid + x - 4, hgt + y - 3);			parent.line (x + 4, y + 3, wid + x - 3, hgt + y - 4);			parent.line (x + 3, hgt + y - 3, wid + x - 3, y + 3 );			parent.line (x + 4, hgt + y - 3, wid + x - 3, y + 4 );			parent.line (x + 3, hgt + y - 4, wid + x - 4, y + 3);		}		parent.fill (lookAndFeel.textColor);		parent.textFont (meta, 13);		parent.textAlign (parent.LEFT);		parent.text (label, wid + x + 5, (hgt - 2) + y);	}	public boolean isSelected() {		return selected;	}}