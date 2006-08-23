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
import java.awt.event.*;

public class IFProgressBar extends GUIComponent {
	private int bgColor, progressColor, borderColor;
	private float progress = 0;
	
	public IFProgressBar (int newX, int newY, int newWidth) {
		setPosition(newX, newY);
		setSize(newWidth, 14);
	}

	public void initWithParent () {
		parent.registerDraw(this);
	}

	// Overriding the inherited mouseEvent because the progress bar doesn't 
	// need to react to them.

	public void mouseEvent (MouseEvent e) {
	}
	
	public boolean canReceiveFocus() {
		return false;
	}

	public void draw () {
		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		
		int x = getX(), y = getY(), wid = getWidth(), hgt = getHeight();
	
		parent.stroke (lookAndFeel.borderColor);
		parent.fill (lookAndFeel.baseColor);
		parent.rect (x, y, wid, hgt);
		parent.stroke (lookAndFeel.activeColor);
		parent.fill (lookAndFeel.activeColor);
		parent.rect (x + 1, y + 1, parent.floor(progress * (wid - 2)), hgt - 2);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
	}

	public void setProgress (float argProgress) {
		progress = argProgress;
	}

	public float getProgress () {
		return progress;
	}

}
