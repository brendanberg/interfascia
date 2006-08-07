// Interfascia -- ALPHA 001//// A graphical user interface library for the// Processing environment.//// by Brendan Berg//// This software is released under the LGPL?

package interfascia;
import processing.core.*;
import java.awt.event.*;
public class IFRadioButton extends GUIComponent {	private int currentColor;	private boolean selected;	private IFRadioController controller;	public IFRadioButton (String argLabel, int argX, int argY, IFRadioController argController) {		label = argLabel;		x = argX;		y = argY + 1;		wid = 15;		hgt = 15;		controller = argController;		controller.add (this);	}	public void initWithParent () {
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
		//parent.registerKeyEvent(this);
	}	public void mouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {				wasClicked = true;				draw();			}		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {				controller.buttonPressed(this);
				wasClicked = false;				draw();			}		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			//fireEventNotification(this, "Selected");
			controller.buttonPressed(this);
		}
	}
	public void draw () {		if (isMouseOver (parent.mouseX, parent.mouseY)) {			currentColor = lookAndFeel.highlightColor;		} else if (hasFocus) {			currentColor = lookAndFeel.highlightColor;		} else {			currentColor = lookAndFeel.baseColor;		}
		
		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		int ellipseMode = parent.g.ellipseMode;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;
		
		parent.stroke(lookAndFeel.borderColor);		parent.fill(currentColor);
		
		parent.ellipseMode(parent.CORNER);		parent.ellipse(x, y, wid, hgt);		if (selected == true) {			parent.fill (lookAndFeel.lightGrayColor);			parent.ellipse (x + 2, y + 2, wid - 4, hgt - 4);		}
				parent.fill (lookAndFeel.textColor);		parent.textFont (meta, 13);		parent.textAlign (parent.LEFT);		parent.text (label, wid + x + 5, (hgt - 3) + y);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		parent.ellipseMode(ellipseMode);
		parent.textFont(textFont);
		parent.textAlign(textAlign);
	}	public boolean isSelected () {		return selected;	}	public void setSelected (boolean argSelected) {		selected = argSelected;
	}}