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
	* Convenience contstructor saves the applet's graphics state into
	* the newly created IFPGraphicsState object.
	*
	* @param applet the PApplet instance whose state we're saving
	*/
	public IFPGraphicsState(PApplet applet) {
		saveSettingsForApplet(applet);
	}
	
	
	/**
	* saves the graphics state for the specified PApplet
	*
	* @param applet the PApplet instance whose state we're saving
	*/
	
	public void saveSettingsForApplet(PApplet applet) {
		smooth = applet.g.smooth;
		
		rectMode = applet.g.rectMode;
		ellipseMode = applet.g.ellipseMode;
		
		textFont = applet.g.textFont;
		textAlign = applet.g.textAlign;
		textSize = applet.g.textSize;
		textMode = applet.g.textMode;
		
		tint = applet.g.tint;
		fill = applet.g.fill;
		stroke = applet.g.stroke;
		tintColor = applet.g.tintColor;
		fillColor = applet.g.fillColor;
		strokeColor = applet.g.strokeColor;
		strokeWeight = applet.g.strokeWeight;
		cMode = applet.g.colorMode;
		cModeX = applet.g.colorModeX;
		cModeY = applet.g.colorModeY;
		cModeZ = applet.g.colorModeZ;
		cModeA = applet.g.colorModeA;
	}

	
	/**
	* restores the saved graphics state to the specified PApplet
	*
	* @param applet the PApplet instance whose state we're restoring
	*/
	
	public void restoreSettingsToApplet(PApplet applet)
	{ 

		try {
			if (smooth > 0) {
				applet.smooth();
			} else {
				applet.noSmooth();
			}
		} catch (RuntimeException e) {
			// Can't smooth in P3D, throws exception
		}
		
		applet.rectMode(rectMode);
		applet.ellipseMode(ellipseMode);
		
		if(textFont != null){ 
			applet.textFont(textFont);
			applet.textSize(textSize);
		}
		applet.textAlign(textAlign);
		applet.textMode(textMode);
		
		// ***** I THINK YOU CAN SET A COLOR FOR A PROPERTY THAT'S NOT ENABLED *****
		if(tint) applet.tint(tintColor);
		else applet.noTint();
		
		if(fill) applet.fill(fillColor);
		else applet.noFill();
		
		if(stroke) applet.stroke(strokeColor);
		else applet.noStroke();
		
		applet.strokeWeight(strokeWeight);
		applet.colorMode(cMode, cModeX, cModeY, cModeZ, cModeA);		
	}
	
}
