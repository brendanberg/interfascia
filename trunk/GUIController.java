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
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class GUIController implements ClipboardOwner {
	private GUIComponent[] contents;
	private int numItems = 0;
	private int focusIndex = -1;
	private boolean visible;
	private IFLookAndFeel lookAndFeel;
	public IFPGraphicsState userState;
	private Clipboard clipboard;

	public PApplet parent;

	public boolean showBounds = true;
	
	public GUIController (PApplet newParent) {
		this(newParent, true);
	}

	public GUIController (PApplet newParent, boolean newVisible) {
		setParent(newParent);
		setVisible(newVisible);
		contents = new GUIComponent[5];
		
		lookAndFeel = new IFLookAndFeel(parent, IFLookAndFeel.DEFAULT);
		userState = new IFPGraphicsState();
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		if (visible) {
			parent.registerKeyEvent(this);
			parent.registerDraw(this);
		}
	}
	
	public void setLookAndFeel(IFLookAndFeel lf) {
		lookAndFeel = lf;
	}
	
	public IFLookAndFeel getLookAndFeel() {
		return lookAndFeel;
	}

	public void add (GUIComponent component) {
		if (numItems == contents.length) {
			GUIComponent[] temp = contents;
			contents = new GUIComponent[contents.length * 2];
			System.arraycopy(temp, 0, contents, 0, numItems);
		}
		component.setController(this);
		component.setLookAndFeel(lookAndFeel);
		component.setIndex(numItems);
		contents[numItems++] = component;
		component.initWithParent();
	}

	public void remove (GUIComponent component) {
		
	}
	
	public void setParent (PApplet argParent) {
		parent = argParent;
	}
	
	public PApplet getParent () {
		return parent;
	}
	
	public void setVisible (boolean newVisible) {
		visible = newVisible;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public void requestFocus(GUIComponent c) {
		for (int i = 0; i < numItems; i++) {
			if (c == contents[i])
				focusIndex = i;
		}
	}
	
	// ****** LOOK AT THIS, I DON'T THINK IT'S RIGHT ******
	public void yieldFocus(GUIComponent c) {
		if (focusIndex > -1 && focusIndex < numItems && contents[focusIndex] == c) {
			focusIndex = -1;
		}
	}
	
	public GUIComponent getComponentWithFocus() {
		return contents[focusIndex];
	}
	
	public boolean getFocusStatusForComponent(GUIComponent c) {
		if (focusIndex >= 0 && focusIndex < numItems)
			return c == contents[focusIndex];
		else
			return false;
	}



	public void lostOwnership (Clipboard parClipboard, Transferable parTransferable) {
		System.out.println ("Lost ownership");
	}
	
	public void copy(String v)
	{
		StringSelection fieldContent = new StringSelection (v);
		clipboard.setContents (fieldContent, this);
	}
	
	public String paste()
	{
		Transferable clipboardContent = clipboard.getContents (this);
		
		if ((clipboardContent != null) &&
			(clipboardContent.isDataFlavorSupported (DataFlavor.stringFlavor))) {
			try {
				String tempString;
				tempString = (String) clipboardContent.getTransferData(DataFlavor.stringFlavor);
				return tempString;
			}
			catch (Exception e) {
				e.printStackTrace ();
			}
		}
		return "";
	}
	


	public void keyEvent(KeyEvent e) {		
		if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_TAB) {
			
			if ((e.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) == KeyEvent.SHIFT_DOWN_MASK)
				if (focusIndex >= numItems || focusIndex <= 0)
					focusIndex = numItems - 1;
				else
					focusIndex--;
			else
				if (focusIndex >= numItems - 1 || focusIndex < 0)
					focusIndex = 0;
				else
					focusIndex++;
			
		} else if (e.getKeyCode() != KeyEvent.VK_TAB) {
			if (focusIndex >= 0 && focusIndex < contents.length)
				contents[focusIndex].keyEvent(e);
		}
	}

	public void draw() {
		userState.saveSettingsForApplet(parent);
		lookAndFeel.defaultGraphicsState.restoreSettingsToApplet(parent);
		for(int i = 0; i < contents.length; i++){
			if(contents[i] != null){
				contents[i].draw();
			}
		}
		userState.restoreSettingsToApplet(parent);    
	}  
}
