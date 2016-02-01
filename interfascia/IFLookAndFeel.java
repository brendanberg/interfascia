// Interfascia ALPHA 004 -- http://interfascia.plusminusfive.com/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006-2016 Brendan Berg
// interfascia (at) plusminusfive (dot) com
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
// --------------------------------------------------------------------



package interfascia;
import processing.core.*;

public class IFLookAndFeel {
	public int baseColor, borderColor, highlightColor, selectionColor, 
				activeColor, textColor, lightGrayColor, darkGrayColor;
	public IFPGraphicsState defaultGraphicsState;
	public static final char DEFAULT = 1;
	
	public IFLookAndFeel(char type) {
		defaultGraphicsState = new IFPGraphicsState();
	}
	
	public IFLookAndFeel(PApplet parent, char type) {
		defaultGraphicsState = new IFPGraphicsState();
		
		if (type == DEFAULT) {
			// Play nicely with other people's draw methods. They
			// may have changed the color mode.
			IFPGraphicsState temp = new IFPGraphicsState(parent);
			
			parent.colorMode(PApplet.RGB, 255);

			baseColor = parent.color(153, 153, 204);
			highlightColor = parent.color(102, 102, 204);
			activeColor = parent.color (255, 153, 51);
			selectionColor = parent.color (255, 255, 0);
			borderColor = parent.color (255);
			textColor = parent.color (0);
			lightGrayColor = parent.color(100);
			darkGrayColor = parent.color(50);

			/*
			System.out.println("===== DEFAULT GRAPHICS STATE =====\ntextAlign:\t" + parent.g.textAlign +
					"\nrectMode:\t" + parent.g.rectMode +
					"\nellipseMode:\t" + parent.g.ellipseMode +
					"\ncolorMode:\t" + parent.g.colorMode + ", " + parent.g.colorModeX + 
					"\nsmooth:\t" + parent.g.smooth);
			*/
			
			PFont tempFont = parent.loadFont ("FrutigerLight-13.vlw");
			parent.textFont(tempFont, 13);
			parent.textAlign(PApplet.LEFT);
			
			parent.rectMode(PApplet.CORNER);
			parent.ellipseMode(PApplet.CORNER);
			
			parent.strokeWeight(1);
			
			parent.colorMode(PApplet.RGB, 255);
			
			try {
				parent.smooth();
			} catch (RuntimeException e) {
				// Can't smooth in P3D, throws exception
			}

			/*
			System.out.println("\n===== INTERFASCIA SETUP ======\ntextAlign:\t" + parent.g.textAlign +
					"\nrectMode:\t" + parent.g.rectMode +
					"\nellipseMode:\t" + parent.g.ellipseMode +
					"\ncolorMode:\t" + parent.g.colorMode + ", " + parent.g.colorModeX +
					"\nsmooth:\t" + parent.g.smooth);
			*/
			
			defaultGraphicsState.saveSettingsForApplet(parent);
			// System.out.println("Class: " + parent.g.getClass() + "/n");
			// Set the color mode back
			temp.restoreSettingsToApplet(parent);
		}
	}
}