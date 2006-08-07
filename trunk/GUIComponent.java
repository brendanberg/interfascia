// Interfascia -- ALPHA 001//// Interfacsia is graphical user interface library for the// Processing environment. Created by Brendan Berg.//// This software is released under the LGPL?

package interfascia;
import processing.core.*;
import java.awt.event.*;import java.lang.reflect.*;abstract class GUIComponent {	protected int x, y, wid, hgt;	protected String label;	protected boolean hasFocus = false, wasClicked = false;	protected PApplet parent;	protected Object listener;
	protected IFLookAndFeel lookAndFeel;
	protected int index;
	protected GUIController controller;
		protected PFont meta;		public GUIComponent () {	}		public void initWithParent () {	}	
	public void setIndex(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
		public void update(int argX, int argY) {	}		public void draw() {	}
	
	public void setController (GUIController c) {
		controller = c;
	}
	
	public GUIController getController() {
		return controller;
	}		public void setParent (PApplet argParent) {		parent = argParent;		meta = parent.loadFont ("FrutigerLight-12.vlw");
		initWithParent ();	}		public PApplet getParent () {		return parent;	}
	
	public void setLookAndFeel(IFLookAndFeel lf) {
		lookAndFeel = lf;
	}		public String getLabel() {		return label;	}		public void setLabel (String argLabel) {		label = argLabel;	}		public void setFocus (boolean argFocus) {		hasFocus = argFocus;	}		public boolean getFocus () {		return hasFocus;	}		public int getWidth() {		return wid;	}		public int getHeight() {		return hgt;	}		public void addActionListener (Object argListener) {		listener = argListener;	}		
	public void mouseEvent (MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {				 wasClicked = true;				 draw();			}		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {				 fireEventNotification(this, "Clicked");				 wasClicked = false;				 draw();			}		}
	}
	
	public void keyEvent (KeyEvent e) {
	}		public void fireEventNotification (GUIComponent argComponent, String argMessage) {		if (listener != null) {			try {				GUIEvent e = new GUIEvent(argComponent, argMessage);				Method m = listener.getClass().getDeclaredMethod("actionPerformed", new Class[] { e.getClass() });								try {					m.invoke(listener, new Object[] { e });				} catch (InvocationTargetException ex) {
					// Spit out the cause of the exception
					System.out.println(ex.getCause().getMessage());				} catch (IllegalAccessException ex) {				}							} catch (NoSuchMethodException ex) {				System.out.println( "NoSuchMethodException" );			}					}	}		public boolean isMouseOver (int mouseX, int mouseY) {		return ((mouseX >= x) && (mouseY >= y) && (mouseX <= (x + wid)) && (mouseY <= (y + hgt)));	}	}