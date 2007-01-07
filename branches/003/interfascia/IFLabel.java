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

public class IFLabel extends GUIComponent {
	private int textColor, textSize = 13;

	public IFLabel (String argLabel, int argX, int argY) {
		this (argLabel, argX, argY, 13);
	}
	
	public IFLabel (String newLabel, int newX, int newY, int size) {
		setLabel(newLabel);
		setPosition(newX, newY);
		
		if (size > 8 && size < 20) 
			textSize = size;
		else
			textSize = 13;
	}

	// ***** SET THE LABEL'S SIZE SO WE CAN GET ITS BOUNDING BOX *****
	
	public boolean canReceiveFocus() {
		return false;
	}
	
	public void setTextSize(int size) {
		if (size > 8 && size < 20) 
			textSize = size;
		else
			textSize = 13;
	}
	
	public int getTextSize() {
		return textSize;
	}

	public void draw () {
		controller.parent.fill (lookAndFeel.textColor);
		controller.parent.text (getLabel(), getX(), getY() + textSize - 3);
	}

}
