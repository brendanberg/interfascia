// Interfascia -- ALPHA 001//// A graphical user interface library for the// Processing environment.//// by Brendan Berg//// This software is released under the LGPL?package interfascia;
import processing.core.*;
public class IFLabel extends GUIComponent {	private int textColor, textSize = 13;	public IFLabel (String argLabel, int argX, int argY) {		this (argLabel, argX, argY, 13);	}
	
	public IFLabel (String argLabel, int argX, int argY, int size) {
		label = argLabel;
		x = argX;
		y = argY;
		
		if (size > 8 && size < 20) 
			textSize = size;
		else
			textSize = 13;
	}
	
	public void setSize(int size) {
		if (size > 8 && size < 20) 
			textSize = size;
		else
			textSize = 13;
	}
	
	public int getSize() {
		return textSize;
	}	public void initWithParent () {
		parent.registerDraw(this);
	}	public void draw () {		parent.fill (lookAndFeel.textColor);		parent.textFont (meta, textSize);		parent.textAlign (parent.LEFT);		parent.text (label, x, y + textSize - 3);
	}}