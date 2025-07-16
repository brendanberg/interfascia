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

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.util.ArrayList;

import interfascia.GUIComponent;

public class GUIController extends GUIComponent implements ClipboardOwner {
	private ArrayList<GUIComponent> contents;
	private int focusIndex = -1;
	private boolean visible;
	private IFLookAndFeel lookAndFeel;
	public IFPGraphicsState userState;
	private Clipboard clipboard;

	public PApplet parent;

	public boolean showBounds = false;

	public GUIController(PApplet newParent) {
		this(newParent, true);
	}

	public GUIController(PApplet newParent, int x, int y, int width, int height) {
		this(newParent, true);
		setPosition(x, y);
		setSize(width, height);
	}

	public GUIController(PApplet newParent, boolean newVisible) {
		setParent(newParent);
		setVisible(newVisible);
		contents = new ArrayList<GUIComponent>(5);

		lookAndFeel = new IFLookAndFeel(parent, IFLookAndFeel.DEFAULT);
		userState = new IFPGraphicsState();

		try {
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		} catch (Exception e) {
			clipboard = new Clipboard("Interfascia Clipboard");
		}

		newParent.registerMethod("keyEvent", this);
		newParent.registerMethod("draw", this);
	}

	public void setLookAndFeel(IFLookAndFeel lf) {
		lookAndFeel = lf;
	}

	public IFLookAndFeel getLookAndFeel() {
		return lookAndFeel;
	}

	public void add(GUIComponent component) {
		component.setController(this);
		component.setLookAndFeel(lookAndFeel);
		// component.setIndex(numItems);
		contents.add(component);
		component.initWithParent();
	}

	public void remove(GUIComponent component) {
		contents.remove(component);
	}

	public void setParent(PApplet argParent) {
		parent = argParent;
	}

	public PApplet getParent() {
		return parent;
	}

	public void setVisible(boolean newVisible) {
		visible = newVisible;
	}

	public boolean getVisible() {
		return visible;
	}

	public void requestFocus(GUIComponent c) {
		focusIndex = contents.indexOf(c);
	}

	// ****** LOOK AT THIS, I DON'T THINK IT'S RIGHT ******
	public void yieldFocus(GUIComponent c) {
		if (focusIndex > -1 && focusIndex < contents.size() && contents.get(focusIndex) == c) {
			focusIndex = -1;
		}
	}

	public GUIComponent getComponentWithFocus() {
		return contents.get(focusIndex);
	}

	public boolean getFocusStatusForComponent(GUIComponent c) {
		if (focusIndex >= 0 && focusIndex < contents.size())
			return c == contents.get(focusIndex);
		else
			return false;
	}

	public void lostOwnership(Clipboard parClipboard, Transferable parTransferable) {
		// System.out.println ("Lost ownership");
	}

	public void copy(String v) {
		StringSelection fieldContent = new StringSelection(v);
		clipboard.setContents(fieldContent, this);
	}

	public String paste() {
		Transferable clipboardContent = clipboard.getContents(this);

		if ((clipboardContent != null) &&
				(clipboardContent.isDataFlavorSupported(DataFlavor.stringFlavor))) {
			try {
				String tempString;
				tempString = (String) clipboardContent.getTransferData(DataFlavor.stringFlavor);
				return tempString;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public void keyEvent(KeyEvent e) {
		if (visible) {
			if (e.getAction() == KeyEvent.PRESS && e.getKeyCode() == java.awt.event.KeyEvent.VK_TAB) {
				if (focusIndex != -1 && contents.get(focusIndex) != null) {
					contents.get(focusIndex).actionPerformed(
							new GUIEvent(contents.get(focusIndex), "Lost Focus"));
				}

				if (e.isShiftDown())
					giveFocusToPreviousComponent();
				else
					giveFocusToNextComponent();

				if (focusIndex != -1 && contents.get(focusIndex) != null) {
					contents.get(focusIndex).actionPerformed(
							new GUIEvent(contents.get(focusIndex), "Received Focus"));
				}

			} else if (e.getKeyCode() != java.awt.event.KeyEvent.VK_TAB) {
				if (focusIndex >= 0 && focusIndex < contents.size())
					contents.get(focusIndex).keyEvent(e);
			}
		}
	}

	private void giveFocusToPreviousComponent() {
		int numItems = contents.size();

		if (numItems == 0)
			return;

		int oldFocus = focusIndex;
		focusIndex = (focusIndex - 1) % numItems;
		while (!contents.get(focusIndex).canReceiveFocus() && focusIndex != oldFocus) {
			focusIndex = (focusIndex - 1) % numItems;
		}
	}

	private void giveFocusToNextComponent() {
		int numItems = contents.size();

		if (numItems == 0)
			return;

		int oldFocus = focusIndex;
		focusIndex = (focusIndex + 1) % numItems;
		while (!contents.get(focusIndex).canReceiveFocus() && focusIndex != oldFocus) {
			focusIndex = (focusIndex + 1) % numItems;
		}
	}

	public void draw() {
		if (visible) {
			userState.saveSettingsForApplet(parent);
			lookAndFeel.defaultGraphicsState.restoreSettingsToApplet(parent);
			// parent.background(parent.g.backgroundColor);
			parent.fill(parent.color(0));
			parent.rect(getX(), getY(), getWidth(), getHeight());
			for (int i = 0; i < contents.size(); i++) {
				if (contents.get(i) != null) {
					// parent.smooth();
					contents.get(i).draw();
				}
			}
			userState.restoreSettingsToApplet(parent);
		}
	}
}
