// Interfascia -- ALPHA 001//// Interfacsia is graphical user interface library for the// Processing environment. Created by Brendan Berg.//// This software is released under the LGPL?package interfascia;
import processing.core.*;
import java.awt.event.*;public class IFButton extends GUIComponent {	private int currentColor;	public IFButton (String argLabel, int argX, int argY) {		this (argLabel, argX, argY, 100, 21);	}	public IFButton (String argLabel, int argX, int argY, int argWidth, int argHeight) {		label = argLabel;		x = argX;		y = argY;		wid = argWidth;		hgt = argHeight;	}	public void initWithParent () {
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {				wasClicked = true;				draw();			}		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {				fireEventNotification(this, "Clicked");				wasClicked = false;				draw();			}		}
	}
	public void draw () {		if (wasClicked) {			 currentColor = lookAndFeel.activeColor;		} else if (isMouseOver (parent.mouseX, parent.mouseY) || hasFocus) {			 currentColor = lookAndFeel.highlightColor;		} else {			 currentColor = lookAndFeel.baseColor;		}

		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;
	
		parent.stroke(lookAndFeel.borderColor);		parent.fill(currentColor);		parent.rect(x, y, wid, hgt);		parent.fill (lookAndFeel.textColor);		parent.textFont (meta, 13);		parent.textAlign (parent.CENTER);		parent.text (label, x, y + 3, wid, hgt); // (wid / 2) + x, (hgt - 4) + y);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		parent.textFont(textFont);
		parent.textAlign(textAlign);
	}		
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
		}
	}}