// Interfascia -- ALPHA 002
//
// Interfacsia is graphical user interface library for the
// Processing environment. Created by Brendan Berg.
//
// This software is released under the LGPL?

package interfascia;
import processing.core.*;
import java.awt.event.*;

public class GUIController {	private GUIComponent[] contents;	private int numItems = 0;	private int focusIndex = -1;	private PApplet parent;
	private IFLookAndFeel lookAndFeel;	public GUIController (PApplet argParent) {		//this (10);		parent = argParent;		contents = new GUIComponent[5];
		lookAndFeel = new IFLookAndFeel(IFLookAndFeel.DEFAULT);
		lookAndFeel.initWithParent(parent);
		parent.registerKeyEvent(this);
	}	//public GUIController (int argCapacity) {	//	 contents = new GUIComponent[argCapacity];	//}	public void add (GUIComponent component) {		if (numItems == contents.length) {
			GUIComponent[] temp = contents;
			contents = new GUIComponent[contents.length * 2];
			System.arraycopy(temp, 0, contents, 0, numItems);
		}
		component.setIndex(numItems);		contents[numItems++] = component;		component.setParent (parent);
		component.setController(this);
		component.setLookAndFeel(lookAndFeel);	}	public void remove (GUIComponent component) {	}
	
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
	}}