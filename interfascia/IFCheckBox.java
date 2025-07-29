// Interfascia BETA 006 -- http://interfascia.berg.industries/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006-2025 Brendan Berg
// interfascia (at) berg (dot) industries
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

public class IFCheckBox extends GUIComponent {
	private int currentColor;
	private boolean selected = false;

	public IFCheckBox(String newLabel, int newX, int newY) {
		setLabel(newLabel);
		setPosition(newX, newY);
		setSize(14, 14);
	}

	public void initWithParent() {
		controller.parent.registerMethod("mouseEvent", this);

		if (lookAndFeel == null)
			return;

		controller.userState.saveSettingsForGraphics(controller.graphics);
		lookAndFeel.defaultGraphicsState.restoreSettingsToGraphics(controller.graphics);

		setSize((int) Math.ceil(controller.parent.textWidth(getLabel())) + getHeight() + 5, 14);

		controller.userState.restoreSettingsToGraphics(controller.graphics);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getAction() == MouseEvent.PRESS) {
			if (isMouseOver(e.getX(), e.getY())) {
				wasClicked = true;
			}
		} else if (e.getAction() == MouseEvent.RELEASE) {
			if (wasClicked && isMouseOver(e.getX(), e.getY())) {
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
		if (e.getAction() == KeyEvent.TYPE && e.getKey() == ' ') {
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

	public void render(PGraphics graphics) {
		if (isMouseOver(controller.parent.mouseX, controller.parent.mouseY)) {
			currentColor = lookAndFeel.highlightColor;
		} else if (controller.getFocusStatusForComponent(this)) {
			currentColor = lookAndFeel.highlightColor;
		} else {
			currentColor = lookAndFeel.baseColor;
		}

		int x = getX(), y = getY(), hgt = getHeight(), wid = getWidth();

		graphics.stroke(lookAndFeel.borderColor);
		graphics.fill(currentColor);
		graphics.rect(x, y, hgt, hgt);
		if (selected == true) {
			graphics.stroke(lookAndFeel.darkGrayColor);
			graphics.line(x + 3, y + 2, hgt + x - 3, hgt + y - 4);
			graphics.line(x + 3, y + 3, hgt + x - 4, hgt + y - 4);
			graphics.line(x + 4, y + 2, hgt + x - 3, hgt + y - 5);
			graphics.line(x + 3, hgt + y - 4, hgt + x - 3, y + 2);
			graphics.line(x + 4, hgt + y - 4, hgt + x - 3, y + 3);
			graphics.line(x + 3, hgt + y - 5, hgt + x - 4, y + 2);
		}

		graphics.fill(lookAndFeel.textColor);
		graphics.text(getLabel(), hgt + x + 5, (hgt - 2) + y);

		if (controller.showBounds) {
			graphics.noFill();
			graphics.stroke(255, 0, 0);
			graphics.rect(x, y, wid, hgt);
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
