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
		controller.parent.registerMouseEvent(this);
		
		if (lookAndFeel == null)
			return;
		
		controller.userState.saveSettingsForApplet(controller.parent);
		lookAndFeel.defaultGraphicsState.restoreSettingsToApplet(controller.parent);
		
		setSize((int) Math.ceil(controller.parent.textWidth(getLabel())) + getHeight() + 5, 14);

		controller.userState.restoreSettingsToApplet(controller.parent);
	}

	public void mouseEvent (MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (e.getX(), e.getY())) {
				 wasClicked = true;
			}
		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (e.getX(), e.getY())) {
				if (selected) {
					selected = false;
					fireEventNotification(this, "Unchecked");
				} else {
					selected = true;
					fireEventNotification(this, "Checked");
				}
				wasClicked = false;
			}
		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
			if (selected) {
				selected = false;
				fireEventNotification(this, "Unchecked");
			} else {
				selected = true;
				fireEventNotification(this, "Checked");
			}
		}
	}

	public void draw () {
		if (isMouseOver (controller.parent.mouseX, controller.parent.mouseY)) {
			currentColor = lookAndFeel.highlightColor;
		} else if (controller.getFocusStatusForComponent(this)) {
			currentColor = lookAndFeel.highlightColor;
		} else {
			currentColor = lookAndFeel.baseColor;
		}

		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();

		controller.parent.stroke(lookAndFeel.borderColor);
		controller.parent.fill(currentColor);
		controller.parent.rect(x, y, hgt, hgt);
		if (selected == true) {
			controller.parent.stroke (lookAndFeel.darkGrayColor);
			controller.parent.line (x + 3, y + 2, hgt + x - 3, hgt + y - 4);
			controller.parent.line (x + 3, y + 3, hgt + x - 4, hgt + y - 4);
			controller.parent.line (x + 4, y + 2, hgt + x - 3, hgt + y - 5);
			controller.parent.line (x + 3, hgt + y - 4, hgt + x - 3, y + 2);
			controller.parent.line (x + 4, hgt + y - 4, hgt + x - 3, y + 3);
			controller.parent.line (x + 3, hgt + y - 5, hgt + x - 4, y + 2);
		}
		
		controller.parent.fill (lookAndFeel.textColor);
		controller.parent.text (getLabel(), hgt + x + 5, (hgt - 2) + y);
		
		if (controller.showBounds) {
			controller.parent.noFill();
			controller.parent.stroke(255,0,0);
			controller.parent.rect(x, y, wid, hgt);
		}
	}

	public boolean isSelected() {
		return selected;
	}

}
