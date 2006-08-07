// Interfascia -- ALPHA 001
//
// A graphical user interface library for the
// Processing environment.
//
// by Brendan Berg
//
// This software is released under the LGPL?

package interfascia;
import processing.core.*;
import java.lang.reflect.*;

public class IFRadioController extends GUIComponent {	private IFRadioButton[] contents;	private int numItems = 0, selected = -1;	private String label;	private Object listener;	public IFRadioController() {		contents = new IFRadioButton[10];	}	public IFRadioController (String argLabel) {		label = argLabel;		contents = new IFRadioButton[10];	}
	
	public IFRadioController (String argLabel, Object l) {
		label = argLabel;
		listener = l;
		contents = new IFRadioButton[10];
	}	public void add (IFRadioButton button) {		contents[numItems++] = button;	}	public void remove (IFRadioButton button) {	}	public int getSelectedIndex () {		return selected;	}	public IFRadioButton getSelected () {		if (selected >= 0 && selected < numItems) {			return contents[selected];		} else {			return null;		}	}	public void buttonPressed (IFRadioButton button) {		for (int i = 0; i < numItems; i++) {			contents[i].setSelected (false);			if (contents[i] == button)			selected = i;		}		button.setSelected (true);		fireEventNotification (button, "Selected");	}
	
	public void setSelectedButton (IFRadioButton button) {
		buttonPressed(button);
	}	public void deselectAll () {		for (int i = 0; i < numItems; i++) {			contents[i].setSelected (false);		}		selected = -1;	}	public void addActionListener (Object arglistener) {		listener = arglistener;	}/*	public void fireEventNotification (GUIComponent argComponent, String argMessage) {		if (listener != null) {			try {				GUIEvent e = new GUIEvent(argComponent, argMessage);				Method m = listener.getClass().getDeclaredMethod("actionPerformed", new Class[] { e.getClass() });				try {					m.invoke(listener, new Object[] { e });				} catch (InvocationTargetException ex) {
					System.out.println(ex.getCause().getMessage());				} catch (IllegalAccessException ex) {				}			} catch (NoSuchMethodException ex) {				System.out.println( "NoSuchMethodException" );			}		}	}*/}