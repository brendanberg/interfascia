// Interfascia ALPHA 002 -- http://superstable.net/interfascia/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006 Brendan Berg
// nospam (at) thbbpt (dot) net
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

public class GUIController {
	private GUIComponent[] contents;
	private int numItems = 0;
	private int focusIndex = -1;
	private PApplet parent;
	private IFLookAndFeel lookAndFeel;

	public GUIController (PApplet newParent) {
		//this (10);
		parent = newParent;
		contents = new GUIComponent[5];
		lookAndFeel = new IFLookAndFeel(IFLookAndFeel.DEFAULT);
		lookAndFeel.initWithParent(parent);
		parent.registerKeyEvent(this);
	}

	//public GUIController (int argCapacity) {
	//	 contents = new GUIComponent[argCapacity];
	//}

	public void add (GUIComponent component) {
		if (numItems == contents.length) {
			GUIComponent[] temp = contents;
			contents = new GUIComponent[contents.length * 2];
			System.arraycopy(temp, 0, contents, 0, numItems);
		}
		component.setIndex(numItems);
		contents[numItems++] = component;
		component.setParent (parent);
		component.setController(this);
		component.setLookAndFeel(lookAndFeel);
	}

	public void remove (GUIComponent component) {
		
	}
	
	public void requestFocus(GUIComponent c) {
		if (focusIndex >= 0 && focusIndex < contents.length)
			contents[focusIndex].setFocus(false);
		c.setFocus(true);
		focusIndex = c.getIndex();
	}
	
	// ****** LOOK AT THIS, I DON'T THINK IT'S RIGHT ******
	public void yieldFocus(GUIComponent c) {
		if (focusIndex > -1 && focusIndex < numItems && contents[focusIndex] == c) {
			c.setFocus(false);
			focusIndex = -1;
		}
	}
	
	public GUIComponent getComponentWithFocus() {
		return contents[focusIndex];
	}
	
	public boolean getFocusStatusForComponent(GUIComponent c) {
		return c == contents[focusIndex];
	}
	
	public void keyEvent(KeyEvent e) {		
		if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_TAB) {
			if (focusIndex >= 0 && focusIndex < contents.length)
				contents[focusIndex].setFocus(false);
			
			if (focusIndex >= numItems - 1 || focusIndex < 0)
				focusIndex = 0;
			else
				focusIndex++;
			
			contents[focusIndex].setFocus(true);
		} else if (e.getKeyCode() != KeyEvent.VK_TAB) {
			if (focusIndex >= 0 && focusIndex < contents.length)
				contents[focusIndex].keyEvent(e);
		}
	}
}
