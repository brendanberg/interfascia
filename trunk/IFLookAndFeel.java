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

		baseColor = parent.color(153, 153, 204);
		highlightColor = parent.color(102, 102, 204);
		activeColor = parent.color (255, 153, 51);
		selectionColor = parent.color (255, 255, 0);
		borderColor = parent.color (255);
		textColor = parent.color (0);
		lightGrayColor = parent.color(100);
		darkGrayColor = parent.color(50);
		
		// Set the color mode back
		parent.colorMode(cMode, cModeX, cModeY, cModeZ, cModeA);
	}
}