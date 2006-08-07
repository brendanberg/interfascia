// Interfascia -- ALPHA 001
//
// A graphical user interface library for the
// Processing environment.
//
// by Brendan Berg
//
// This software is released under the LGPL?

package interfascia;
import processing.core.*;

public class IFProgressBar extends GUIComponent {	private int bgColor, progressColor, borderColor;	private float progress = 0;
		public IFProgressBar (int argX, int argY, int argWidth) {		x = argX;		y = argY;		wid = argWidth;		hgt = 14;	}

	public void initWithParent () {
		parent.registerDraw(this);
		
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
		bgColor = parent.color(153, 153, 204);
		progressColor = parent.color(255, 153, 51);
		borderColor = parent.color(255);
		
		// Set the color mode back
		parent.colorMode(cMode, cModeX, cModeY, cModeZ, cModeA);	}	public void update (int argMouseX, int argMouseY) {		draw ();	}

	// Overriding the inherited mousePressed and mouseReleased
	// because the progress bar doesn't need to react to them.

	public void mousePressed (int mouseX, int mouseY) {
	}

	public void mouseReleased (int mouseX, int mouseY) {
	}	public void draw () {
		parent.stroke (borderColor);		parent.fill (bgColor);		parent.rect (x, y, wid, hgt);		parent.stroke (progressColor);		parent.fill (progressColor);		parent.rect (x + 1, y + 1, parent.floor(progress * (wid - 2)), hgt - 2);
	}	public void setProgress (float argProgress) {		progress = argProgress;	}	public float getProgress () {		return progress;	}
}