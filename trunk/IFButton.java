// Interfascia ALPHA 002 -- http://superstable.net/interfascia/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006 Brendan Berg
// interfascia (at) thbbpt (dot) net
//
// This library is free software; you can redistribute it and/or 
// modify it under the terms of the GNU Lesser General Public 
// License as published by the Free Software Foundation; either 
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful, 
// but WITHOUT ANY WARRANTY; without even the implied warranty of 
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public 
// License along with this library; if not, write to the Free Software 
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
// USA



package interfascia;
import processing.core.*;
import java.awt.event.*;

public class IFButton extends GUIComponent {
	private int currentColor;

	public IFButton (String newLabel, int newX, int newY) {
		this (newLabel, newX, newY, 100, 21);
	}

	public IFButton (String newLabel, int newX, int newY, int newWidth) {
		this (newLabel, newX, newY, newWidth, 21);
	}

	public IFButton (String newLabel, int newX, int newY, int newWidth, int newHeight) {
		setLabel(newLabel);
		setPosition(newX, newY);
		setSize(newWidth, newHeight);
	}

	public void initWithParent () {
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {
				wasClicked = true;
			}
		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {
				fireEventNotification(this, "Clicked");
				wasClicked = false;
			}
		}
	}

	public void draw () {
		boolean hasFocus = controller.getFocusStatusForComponent(this);
	
		if (wasClicked) {
			 currentColor = lookAndFeel.activeColor;
		} else if (isMouseOver (parent.mouseX, parent.mouseY) || hasFocus) {
			 currentColor = lookAndFeel.highlightColor;
		} else {
			 currentColor = lookAndFeel.baseColor;
		}

		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;
	
		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();
	
		parent.stroke(lookAndFeel.borderColor);
		parent.fill(currentColor);
		parent.rect(x, y, wid, hgt);
		parent.fill (lookAndFeel.textColor);
		parent.textFont (meta, 13);
		parent.textAlign (parent.CENTER);
		parent.text (getLabel(), x, y + 3, wid, hgt); // (wid / 2) + x, (hgt - 4) + y);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		if (textFont != null) {
			parent.textFont(textFont);
			parent.textAlign(textAlign);
		}
	}
		
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
		}
	}

}
