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

public class IFCheckBox extends GUIComponent {
	private int currentColor;
	private boolean selected = false;

	public IFCheckBox (String newLabel, int newX, int newY) {
		setLabel(newLabel);
		setPosition(newX, newY);
		setSize(14, 14);
	}

	public void initWithParent () {
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
	}

	public void mouseEvent (MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {
				 wasClicked = true;
			}
		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {
				if (selected) {
					fireEventNotification(this, "Unchecked");
					selected = false;
				} else {
					fireEventNotification(this, "Checked");
					selected = true;
				}
				wasClicked = false;
			}
		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
			if (selected) {
				fireEventNotification(this, "Unchecked");
				selected = false;
			} else {
				fireEventNotification(this, "Checked");
				selected = true;
			}
		}
	}

	public void draw () {
		if (isMouseOver (parent.mouseX, parent.mouseY)) {
			currentColor = lookAndFeel.highlightColor;
		} else if (controller.getFocusStatusForComponent(this)) {
			currentColor = lookAndFeel.highlightColor;
		} else {
			currentColor = lookAndFeel.baseColor;
		}

		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();

		parent.stroke(lookAndFeel.borderColor);
		parent.fill(currentColor);
		parent.rect(x, y, wid, hgt);
		if (selected == true) {
			parent.stroke (lookAndFeel.darkGrayColor);
			parent.line (x + 3, y + 3, wid + x - 3, hgt + y - 3);
			parent.line (x + 3, y + 4, wid + x - 4, hgt + y - 3);
			parent.line (x + 4, y + 3, wid + x - 3, hgt + y - 4);
			parent.line (x + 3, hgt + y - 3, wid + x - 3, y + 3 );
			parent.line (x + 4, hgt + y - 3, wid + x - 3, y + 4 );
			parent.line (x + 3, hgt + y - 4, wid + x - 4, y + 3);
		}
		
		parent.fill (lookAndFeel.textColor);
		parent.textFont (meta, 13);
		parent.textAlign (parent.LEFT);
		parent.text (getLabel(), wid + x + 5, (hgt - 2) + y);
	}

	public boolean isSelected() {
		return selected;
	}

}
