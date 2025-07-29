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

public class IFPGraphicsState {
	public int smooth;

	public int rectMode, ellipseMode;

	public PFont textFont;
	public int textAlign;
	public float textSize;
	public int textMode;

	public boolean tint;
	public int tintColor;
	public boolean fill;
	public int fillColor;
	public boolean stroke;
	public int strokeColor;
	public float strokeWeight;

	public int cMode;
	public float cModeX, cModeY, cModeZ, cModeA;

	public IFPGraphicsState() {
	}

	/**
	 * Convenience contstructor saves the graphics state into
	 * the newly created IFPGraphicsState object.
	 *
	 * @param graphics the PGraphics instance whose state we're saving
	 */
	public IFPGraphicsState(PGraphics graphics) {
		saveSettingsForGraphics(graphics);
	}

	/**
	 * Convenience contstructor saves the sketch's graphics state into
	 * the newly created IFPGraphicsState object.
	 *
	 * @param sketch the PApplet instance whose state we're saving
	 */
	public IFPGraphicsState(PApplet sketch) {
		saveSettingsForApplet(sketch);
	}

	/**
	 * saves the graphics state for the specified PGraphics
	 *
	 * @param graphics the PGraphics instance whose state we're saving
	 */

	public void saveSettingsForGraphics(PGraphics graphics) {
		smooth = graphics.smooth;

		rectMode = graphics.rectMode;
		ellipseMode = graphics.ellipseMode;

		textFont = graphics.textFont;
		textAlign = graphics.textAlign;
		textSize = graphics.textSize;
		textMode = graphics.textMode;

		tint = graphics.tint;
		fill = graphics.fill;
		stroke = graphics.stroke;
		tintColor = graphics.tintColor;
		fillColor = graphics.fillColor;
		strokeColor = graphics.strokeColor;
		strokeWeight = graphics.strokeWeight;
		cMode = graphics.colorMode;
		cModeX = graphics.colorModeX;
		cModeY = graphics.colorModeY;
		cModeZ = graphics.colorModeZ;
		cModeA = graphics.colorModeA;
	}

	/**
	 * restores the saved graphics state to the specified PGraphics
	 *
	 * @param graphics the PGraphics instance whose state we're restoring
	 */

	public void restoreSettingsToGraphics(PGraphics graphics) {
		try {
			if (smooth > 0) {
				graphics.smooth();
			} else {
				graphics.noSmooth();
			}
		} catch (RuntimeException e) {
			// Can't smooth in P3D, throws exception
		}

		graphics.rectMode(rectMode);
		graphics.ellipseMode(ellipseMode);

		if (textFont != null) {
			graphics.textFont(textFont);
			graphics.textSize(textSize);
		}
		graphics.textAlign(textAlign);
		graphics.textMode(textMode);

		// ***** I THINK YOU CAN SET A COLOR FOR A PROPERTY THAT'S NOT ENABLED *****
		if (tint)
			graphics.tint(tintColor);
		else
			graphics.noTint();

		if (fill)
			graphics.fill(fillColor);
		else
			graphics.noFill();

		if (stroke)
			graphics.stroke(strokeColor);
		else
			graphics.noStroke();

		graphics.strokeWeight(strokeWeight);
		graphics.colorMode(cMode, cModeX, cModeY, cModeZ, cModeA);
	}

	/**
	 * saves the graphics state for the specified PApplet
	 *
	 * @param sketch the PApplet instance whose state we're saving
	 */

	public void saveSettingsForApplet(PApplet sketch) {
		saveSettingsForGraphics(sketch.g);
	}

	/**
	 * restores the saved graphics state to the specified PApplet
	 *
	 * @param sketch the PApplet instance whose state we're restoring
	 */

	public void restoreSettingsToApplet(PApplet sketch) {
		restoreSettingsToGraphics(sketch.g);
	}
}
