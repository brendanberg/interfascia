// Interfascia -- ALPHA 001
import processing.core.*;
import java.awt.event.*;
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
	}

	public void mouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver (parent.mouseX, parent.mouseY)) {
			if (wasClicked && isMouseOver (parent.mouseX, parent.mouseY)) {
	}


		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;
	
		parent.stroke(lookAndFeel.borderColor);

		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		parent.textFont(textFont);
		parent.textAlign(textAlign);
	}
	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == ' ') {
			fireEventNotification(this, "Selected");
		}
	}