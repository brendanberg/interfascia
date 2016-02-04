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


import java.awt.event.*;

public class IFProgressBar extends GUIComponent {
	private float progress = 0;
	
	public IFProgressBar (int newX, int newY, int newWidth) {
		setPosition(newX, newY);
		setSize(newWidth, 14);
	}

	// Overriding the inherited mouseEvent because the progress bar doesn't 
	// need to react to them.

	public void mouseEvent (MouseEvent e) {
	}
	
	public boolean canReceiveFocus() {
		return false;
	}

	public void draw () {
		int x = getX(), y = getY(), wid = getWidth(), hgt = getHeight();
	
		controller.parent.stroke (lookAndFeel.borderColor);
		controller.parent.fill (lookAndFeel.baseColor);
		controller.parent.rect (x, y, wid, hgt);
		controller.parent.stroke (lookAndFeel.activeColor);
		controller.parent.fill (lookAndFeel.activeColor);
		controller.parent.rect (x + 1, y + 1, (int) Math.floor(progress * (wid - 2)), hgt - 2);

		if (controller.showBounds) {
			controller.parent.noFill();
			controller.parent.stroke(255,0,0);
			controller.parent.rect(x, y, wid, hgt);
		}
	}

	public void setProgress (float argProgress) {
		progress = (argProgress < 0) ? 0 : ((argProgress > 1) ? 1 : argProgress);
	}

	public float getProgress () {
		return progress;
	}

}
