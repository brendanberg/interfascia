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
import java.lang.reflect.*;

abstract class GUIComponent {
	private int x, y, wid, hgt;
	private String label;
	
	protected boolean wasClicked = false;
	
	//protected PApplet parent;
	protected Object listener;
	protected IFLookAndFeel lookAndFeel;
	protected GUIController controller;
	//protected PFont meta;
	// May not need this
	protected int index;

	
	public GUIComponent () {
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void update(int argX, int argY) {
	}
	
	public void draw() {
	}
	
	public void setController (GUIController c) {
		controller = c;
	}
	
	public GUIController getController() {
		return controller;
	}
	
	public void initWithParent () {
	}
	
	public void setLookAndFeel(IFLookAndFeel lf) {
		lookAndFeel = lf;
	}
	
	public IFLookAndFeel getLookAndFeel() {
		return lookAndFeel;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel (String argLabel) {
		label = argLabel;
	}
	
	public boolean canReceiveFocus() {
		return true;
	}
	
	public int getWidth() {
		return wid;
	}
	
	public void setWidth(int newWidth) {
		if (newWidth > 0) wid = newWidth;
	}
	
	public int getHeight() {
		return hgt;
	}
	
	public void setHeight(int newHeight) {
		if (newHeight > 0) hgt = newHeight;
	}
	
	public void addActionListener (Object newListener) {
		listener = newListener;
	}
	
	public void setSize(int newWidth, int newHeight) {
		if (newHeight > 0 && newWidth > 0) {
			hgt = newHeight;
			wid = newWidth;
		}
	}
	
	//public IFSize getSize() {
	//	return new IFRect(wid, hgt);
	//}
	
	public void setPosition(int newX, int newY) {
		if (newX > 0 && newY > 0) {
			x = newX;
			y = newY;
		}
	}
	
	//public IFPoint getPosition() {
	//	return new IFPoint(x, y);
	//}
		
	public void setX(int newX) {
		if (newX > 0) x = newX;
	}

	public int getX() {
		return x;
	}

	public void setY(int newY) {
		if (newY > 0) y = newY;
	}
	
	public int getY() {
		return y;
	}

	public void mouseEvent (MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (e.getX(), e.getY())) {
				 wasClicked = true;
			}
		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (e.getX(), e.getY())) {
				 fireEventNotification(this, "Clicked");
				 wasClicked = false;
			}
		}
	}
	
	public void keyEvent (KeyEvent e) {
	}
	
	public void actionPerformed (GUIEvent e) {
		
	}

	
	public void fireEventNotification (GUIComponent argComponent, String argMessage) {
		if (listener == null)
			return;
		
		try {
			GUIEvent e = new GUIEvent(argComponent, argMessage);
			Method m = listener.getClass().getDeclaredMethod("actionPerformed", new Class[] { e.getClass() });
			
			try {
				m.invoke(listener, new Object[] { e });
			} catch (InvocationTargetException ex) {
				// Spit out the cause of the exception
				System.out.println(ex.getCause().getMessage());
			} catch (IllegalAccessException ex) {
			}
			
		} catch (NoSuchMethodException ex) {
			System.out.println( "NoSuchMethodException" );
		}
			
	}
	
	public boolean isMouseOver (int mouseX, int mouseY) {
		return ((mouseX >= x) && (mouseY >= y) && (mouseX <= (x + wid)) && (mouseY <= (y + hgt)));
	}
	
}
