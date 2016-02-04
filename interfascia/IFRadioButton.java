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

import processing.event.*;

public class IFRadioButton extends GUIComponent {
	private int currentColor;
	private IFRadioController radioController;

	public IFRadioButton (String newLabel, int newX, int newY, IFRadioController newController) {
		setLabel(newLabel);
		setPosition(newX, newY + 1);
		setSize(15, 15);

		radioController = newController;
		radioController.add (this);
	}

	public void initWithParent () {
		controller.parent.registerMethod("mouseEvent", this);
		
		if (lookAndFeel == null)
			return;
		
		controller.userState.saveSettingsForApplet(controller.parent);
		lookAndFeel.defaultGraphicsState.restoreSettingsToApplet(controller.parent);
		
		setSize((int) Math.ceil(controller.parent.textWidth(getLabel())) + getHeight() + 5, 14);

		controller.userState.restoreSettingsToApplet(controller.parent);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getAction() == MouseEvent.PRESS) {
			if (isMouseOver (e.getX(), e.getY())) {
				wasClicked = true;
			}
		} else if (e.getAction() == MouseEvent.RELEASE) {
			if (wasClicked && isMouseOver (e.getX(), e.getY())) {
				radioController.selectButton(this);
				wasClicked = false;
			}
		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getAction() == KeyEvent.TYPE && e.getKey() == ' ') {
			radioController.selectButton(this);
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
		
		controller.parent.ellipse(x, y, hgt, hgt);
		if (radioController.getSelectionStatusForButton(this)) {
			controller.parent.fill (lookAndFeel.lightGrayColor);
			controller.parent.ellipse (x + 2, y + 2, hgt - 4, hgt - 4);
		}
		
		controller.parent.fill (lookAndFeel.textColor);
		controller.parent.text (getLabel(), hgt + x + 5, (hgt - 3) + y);
		
		if (controller.showBounds) {
			controller.parent.noFill();
			controller.parent.stroke(255,0,0);
			controller.parent.rect(x, y, wid, hgt);
		}
	}

	public boolean isSelected () {
		return radioController.getSelectionStatusForButton(this);
	}

	public void setSelected () {
		radioController.selectButton(this);
	}

}
