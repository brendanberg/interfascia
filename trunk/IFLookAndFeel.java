// Interfascia -- ALPHA 001//// A graphical user interface library for the// Processing environment.//// by Brendan Berg//// This software is released under the LGPL?package interfascia;
import processing.core.*;

public class IFLookAndFeel {
	public int baseColor, borderColor, highlightColor, selectionColor, 
				activeColor, textColor, lightGrayColor, darkGrayColor;
	
	public static final char DEFAULT = 1;
	
	public IFLookAndFeel(char type) {
		
	}
	
	public void initWithParent(PApplet parent) {
		// Play nicely with other people's draw methods. They
		// may have changed the color mode.
		int cMode;
		float cModeX, cModeY, cModeZ, cModeA;

		cMode = parent.g.colorMode;
		cModeX = parent.g.colorModeX;
		cModeY = parent.g.colorModeY;
		cModeZ = parent.g.colorModeZ;
		cModeA = parent.g.colorModeA;
		parent.colorMode(parent.RGB, 255);
		baseColor = parent.color(153, 153, 204);		highlightColor = parent.color(102, 102, 204);		activeColor = parent.color (255, 153, 51);
		selectionColor = parent.color (255, 255, 0);
		borderColor = parent.color (255);
		textColor = parent.color (0);
		lightGrayColor = parent.color(100);
		darkGrayColor = parent.color(50);		
		// Set the color mode back
		parent.colorMode(cMode, cModeX, cModeY, cModeZ, cModeA);	}
}