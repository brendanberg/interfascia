// Interfascia ALPHA 004 -- http://interfascia.plusminusfive.com/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006-2016 Brendan Berg
// interfascia (at) plusminusfive (dot) com
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
// --------------------------------------------------------------------
//
// Updated for Processing 3 by Anna Terzaroli 2015
// anna.giw (at) libero (dot) it
//



package interfascia;
import processing.core.*;
import processing.event.*;

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
		controller.parent.registerMethod("mouseEvent", this);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getAction() == MouseEvent.PRESS) {
			if (isMouseOver (e.getX(), e.getY())) {
				wasClicked = true;
			}
		} else if (e.getAction() == MouseEvent.RELEASE) {
			if (wasClicked && isMouseOver (e.getX(), e.getY())) {
				fireEventNotification(this, "Clicked");
				wasClicked = false;
			}
		}
	}

	public void draw () {
		boolean hasFocus = controller.getFocusStatusForComponent(this);
	
		if (wasClicked) {
			 currentColor = lookAndFeel.activeColor;
		} else if (isMouseOver (controller.parent.mouseX, controller.parent.mouseY) || hasFocus) {
			 currentColor = lookAndFeel.highlightColor;
		} else {
			 currentColor = lookAndFeel.baseColor;
		}

		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();
	
		controller.parent.stroke(lookAndFeel.borderColor);
		controller.parent.fill(currentColor);
		controller.parent.rect(x, y, wid, hgt);
		controller.parent.fill (lookAndFeel.textColor);

		controller.parent.textAlign (PApplet.CENTER);
		controller.parent.text (getLabel(), x, y + 3, wid, hgt);
		controller.parent.textAlign (PApplet.LEFT);

		if (controller.showBounds) {
			controller.parent.noFill();
			controller.parent.stroke(255,0,0);
			controller.parent.rect(x, y, wid, hgt);
		}
	}
		
	public void keyEvent(KeyEvent e) {
		if (e.getAction() == KeyEvent.TYPE && e.getKey() == ' ') {
			fireEventNotification(this, "Selected");
		}
	}

}
