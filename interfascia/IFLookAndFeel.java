// Interfascia BETA 006 -- http://interfascia.berg.industries/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006-2025 Brendan Berg
// interfascia (at) berg (dot) industries
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

	public void setFont(PFont font) {
		defaultGraphicsState.textFont = font;
	}

	public PFont getFont() {
		return defaultGraphicsState.textFont;
	}

	public IFLookAndFeel(char type) {
		defaultGraphicsState = new IFPGraphicsState();
	}

	// public IFLookAndFeel(PApplet sketch, char type) {
	// this(sketch, sketch.getGraphics(), type);
	// }

	public IFLookAndFeel(PApplet sketch, char type) {
		defaultGraphicsState = new IFPGraphicsState();

		if (type == DEFAULT) {
			// Play nicely with other people's draw methods. They
			// may have changed the color mode.
			IFPGraphicsState temp = new IFPGraphicsState(sketch);

			sketch.g.colorMode(PApplet.RGB, 255);

			baseColor = sketch.g.color(153, 153, 204);
			highlightColor = sketch.g.color(102, 102, 204);
			activeColor = sketch.g.color(255, 153, 51);
			selectionColor = sketch.g.color(255, 255, 0);
			borderColor = sketch.g.color(255);
			textColor = sketch.g.color(0, 0, 0);
			lightGrayColor = sketch.g.color(100);
			darkGrayColor = sketch.g.color(50);

			PFont font = sketch.loadFont("FrutigerLight-15.vlw");
			sketch.g.textFont(font, 15);
			sketch.g.textAlign(PApplet.LEFT, PApplet.BOTTOM);

			sketch.g.rectMode(PApplet.CORNER);
			sketch.g.ellipseMode(PApplet.CORNER);

			sketch.g.strokeWeight(1);

			sketch.g.colorMode(PApplet.RGB, 255);

			try {
				sketch.g.smooth();
			} catch (RuntimeException e) {
				// Can't smooth in P3D, throws exception
			}

			defaultGraphicsState.saveSettingsForGraphics(sketch.g);

			// Set the color mode back
			temp.restoreSettingsToApplet(sketch);
		}
	}
}
