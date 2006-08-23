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

public class IFRadioButton extends GUIComponent {
	private int currentColor;
	private boolean selected;
	private IFRadioController radioController;

	public IFRadioButton (String newLabel, int newX, int newY, IFRadioController newController) {
		setLabel(newLabel);
		setPosition(newX, newY + 1);
		setSize(15, 15);

		radioController = newController;
		radioController.add (this);
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
				radioController.selectButton(this);
				wasClicked = false;
			}
		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			radioController.selectButton(this);
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
		
		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		int ellipseMode = parent.g.ellipseMode;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;

		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();
		
		parent.stroke(lookAndFeel.borderColor);
		parent.fill(currentColor);
		
		parent.ellipseMode(parent.CORNER);
		parent.ellipse(x, y, wid, hgt);
		if (radioController.getSelectionStatusForButton(this)) {
			parent.fill (lookAndFeel.lightGrayColor);
			parent.ellipse (x + 2, y + 2, wid - 4, hgt - 4);
		}
		
		parent.fill (lookAndFeel.textColor);
		parent.textFont (meta, 13);
		parent.textAlign (parent.LEFT);
		parent.text (getLabel(), wid + x + 5, (hgt - 3) + y);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		parent.ellipseMode(ellipseMode);
		if (textFont != null) {
			parent.textFont(textFont);
			parent.textAlign(textAlign);
		}
	}

	public boolean isSelected () {
		return radioController.getSelectionStatusForButton(this);
	}

	public void setSelected () {
		radioController.selectButton(this);
	}

}
