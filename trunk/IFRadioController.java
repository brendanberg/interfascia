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
import java.lang.reflect.*;

public class IFRadioController extends GUIComponent {
	private IFRadioButton[] contents;
	private int numItems = 0, selected = -1;
	private String label;
	private Object listener;

	public IFRadioController() {
		contents = new IFRadioButton[5];
	}

	public IFRadioController (String argLabel) {
		label = argLabel;
		contents = new IFRadioButton[5];
	}
	
	public IFRadioController (String argLabel, Object l) {
		label = argLabel;
		addActionListener(l);
		contents = new IFRadioButton[5];
	}

	public void add (IFRadioButton button) {
		if (numItems == contents.length) {
			IFRadioButton[] temp = contents;
			contents = new IFRadioButton[contents.length * 2];
			System.arraycopy(temp, 0, contents, 0, numItems);
		}
		
		contents[numItems++] = button;
	}

	public void remove (IFRadioButton button) {

	}

	public int getSelectedIndex () {
		return selected;
	}

	public IFRadioButton getSelected () {
		if (selected >= 0 && selected < numItems) {
			return contents[selected];
		} else {
			return null;
		}
	}

	public void buttonPressed (IFRadioButton button) {
		for (int i = 0; i < numItems; i++) {
			contents[i].setSelected (false);
			if (contents[i] == button)
			selected = i;
		}
		button.setSelected (true);
		fireEventNotification (button, "Selected");
	}
	
	public void setSelectedButton (IFRadioButton button) {
		buttonPressed(button);
	}

	public void deselectAll () {
		for (int i = 0; i < numItems; i++) {
			contents[i].setSelected (false);
		}
		selected = -1;
	}

	public void addActionListener (Object arglistener) {
		listener = arglistener;
	}

}
