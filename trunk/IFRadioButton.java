// Interfascia -- ALPHA 001

package interfascia;
import processing.core.*;
import java.awt.event.*;

		parent.registerDraw(this);
		parent.registerMouseEvent(this);
		//parent.registerKeyEvent(this);
	}
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {
				wasClicked = false;
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			//fireEventNotification(this, "Selected");
			controller.buttonPressed(this);
		}
	}

		
		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		int ellipseMode = parent.g.ellipseMode;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;
		
		parent.stroke(lookAndFeel.borderColor);
		
		parent.ellipseMode(parent.CORNER);
		

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		parent.ellipseMode(ellipseMode);
		parent.textFont(textFont);
		parent.textAlign(textAlign);
	}
	}