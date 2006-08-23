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



/** The IFTextField class is used for a simple one-line text field */

public class IFTextField extends GUIComponent {
	private int currentColor;
	private String contents;
	private int cursorPos = 0, visiblePortionStart = 0, visiblePortionEnd = 0;
	private int startSelect = -1, endSelect = -1;
	private float[] letterWidths = new float[100];


	/**
	* creates an empty IFTextField with the specified label, with specified position, and a default width of 100 pixels.
	* @param argLabel the text field's label
	* @param argX the text field's X location on the screen, relative to the PApplet.
	* @param argY the text filed's Y location on the screen, relative 
	* to the PApplet.
	*/
	
	public IFTextField (String newLabel, int newX, int newY) {
		this (newLabel, newX, newY, 100, "");
	}


	/**
	* creates an empty IFTextField with the specified label and with specified position and width.
	* @param argLabel the text field's label
	* @param argX the text field's X location on the screen, relative to the PApplet.
	* @param argY the text filed's Y location on the screen, relative to the PApplet.
	* @param argWidth the text field's width
	*/
	
	public IFTextField (String argLabel, int argX, int argY, int argWidth) {
		this (argLabel, argX, argY, argWidth, "");
	}


	/**
	* creates an IFTextField with the specified label, with specified position and width, and with specified contents.
	* @param argLabel the text field's label
	* @param argX the text field's X location on the screen, relative to the PApplet.
	* @param argY the text filed's Y location on the screen, relative to the PApplet.
	* @param argWidth the text field's width
	* @param argContents the default contents of the text field
	*/
	
	public IFTextField (String argLabel, int argX, int argY, int argWidth, String newValue) {
		setLabel(argLabel);
		setPosition(argX, argY);
		setSize(argWidth, 21);
		//setValue(newValue);
		contents = newValue;
	}
	
	public void initWithParent () {
		parent.registerDraw(this);
		parent.registerMouseEvent(this);
		if (contents != null) {
			setValue(contents);
		}
	}
	


	/**
	* adds a character to the immediate right of the insertion point or replaces the selected group of characters. This method is called by <pre>public void MouseEvent</pre> if a unicode character is entered via the keyboard.
	* @param c the character to be added
	*/
	
	private void addChar(char c) {
		String t1, t2;
		if (startSelect != -1 && endSelect != -1) {
			if (startSelect > endSelect) {
				int temp = startSelect;
				startSelect = endSelect;
				endSelect = temp;
			}
			if (endSelect > contents.length())
				endSelect = contents.length();
			t1 = contents.substring(0, startSelect);
			t2 = contents.substring(endSelect);
			cursorPos = startSelect;
			startSelect = endSelect = -1;
		} else {
			if (cursorPos > contents.length())
				cursorPos = contents.length();
			t1 = contents.substring(0, cursorPos);
			t2 = contents.substring(cursorPos);
		}
		setValue(t1 + c + t2);
		cursorPos++;
		
		fireEventNotification(this, "Modified");
	}
	
	
	
	/**
	* deletes either the character directly to the left of the insertion point or the selected group of characters. It automatically handles cases where there is no character to the left of the insertion point (when the insertion point is at the beginning of the string). It is called by <pre>public void keyEvent</pre> when the delete key is pressed.
	*/
	
	private void deleteChar() {
		String t1 = "", t2 = "";
		if (startSelect != -1 && endSelect != -1) {
			if (startSelect > endSelect) {
				int temp = startSelect;
				startSelect = endSelect;
				endSelect = temp;
			}
			if (endSelect > contents.length())
				endSelect = contents.length();
			t1 = contents.substring(0, startSelect);
			t2 = contents.substring(endSelect);
			cursorPos = startSelect;
			startSelect = endSelect = -1;
			setValue(t1 + t2);				
			fireEventNotification(this, "Modified");
		} else if (cursorPos > 0) {
			if (cursorPos > contents.length())
				cursorPos = contents.length();
			t1 = contents.substring(0, cursorPos - 1);
			t2 = contents.substring(cursorPos);
			setValue(t1 + t2);
			cursorPos--;
			fireEventNotification(this, "Modified");
		}
	}



	/**
	* given the X position of the mouse, findClosestGap(int x)
	* will return the index of the closest letter boundary in 
	* the letterWidths array.
	*/
	
	private int findClosestGap(int x) {
		if (x > 0) {
			int left = visiblePortionStart, right = visiblePortionEnd + 1, mid = (left + right) / 2;
			while (left <= right - 1) {
				mid = (left + right) / 2;
				if (x < letterWidths[mid] - letterWidths[visiblePortionStart])
					right = mid - 1;
				else if (x > letterWidths[mid] - letterWidths[visiblePortionStart])
					left = mid + 1;
				else {
					left = mid;
					right = mid;
				}
			}
			
			if (Math.abs(letterWidths[left] - x) < Math.abs(letterWidths[right] - x)) {
				return left;
			} else {
				return right;
			}
		} else {
			return 0;
		}
	}
	
	
	
	/**
	* sets the contents of the text box and displays the
	* specified string in the text box widget.
	* @param val the string to become the text field's contents
	*/
	
	public void setValue(String newValue) {
		if (parent == null)
			return;
			
		letterWidths = new float[100];
		letterWidths[0] = 0;
		float total = 0;
		
		PFont textFont = parent.g.textFont;
		parent.textFont(meta, 13);
		
		for (int i = 0; i < newValue.length(); i++) {
			total += parent.textWidth(newValue.charAt(i));
			letterWidths[i + 1] = total;
			letterWidths[i + 2] = total;
		}
		
		parent.g.textFont = textFont;
		
		contents = newValue;
		fireEventNotification(this, "Modified");
	}



	/**
	* returns the string that is displayed in the text area.
	* If the contents have not been initialized, getValue() 
	* returns NULL, if the contents have been initialized but
	* not set, it returns an empty string.
	* @return contents the contents of the text field
	*/
	
	public String getValue() {
		return contents;
	}



	/**
	* implemented to conform to Processing's mouse event handler
	* requirements. You shouldn't call this method directly, as
	* Processing will forward mouse events to this object directly.
	* mouseEvent() handles mouse clicks, drags, and releases sent
	* from the parent PApplet. 
	* @param e the MouseEvent to handle
	*/

	public void mouseEvent(MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			if (isMouseOver(parent.mouseX, parent.mouseY)) {
				controller.requestFocus(this);
				wasClicked = true;
				endSelect = -1;
				startSelect = cursorPos = findClosestGap(parent.mouseX - getX() - 4);
			} else {
				if (controller.getFocusStatusForComponent(this)) {
					wasClicked = false;
					controller.yieldFocus(this);
					startSelect = endSelect = -1;
				}
			}
		} else if (e.getID() == MouseEvent.MOUSE_DRAGGED) {
			endSelect = cursorPos = findClosestGap(parent.mouseX - getX() - 4);
		} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
			if (endSelect == startSelect) {
				startSelect = -1;
				endSelect = -1;
			}
		}
	}


	
	/**
	* receives KeyEvents forwarded to it by the GUIController
	* if the current instance is currently in focus.
	* @param e the KeyEvent to be handled
	*/

	public void keyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				cursorPos = contents.length();
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				cursorPos = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (startSelect != -1 && endSelect != -1)
					cursorPos = Math.min(startSelect, endSelect);
				else if (cursorPos > 0)
					cursorPos--;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (startSelect != -1 && endSelect != -1)
					cursorPos = Math.max(startSelect, endSelect);
				else if (cursorPos < contents.length())
					cursorPos++;
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				fireEventNotification(this, "Completed");
			}
		} else if (e.getID() == KeyEvent.KEY_TYPED) {
			if (e.getKeyChar() == '\b') {
				deleteChar();
			} else if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
				addChar(e.getKeyChar());
				startSelect = endSelect = -1;
			}
		}
	}
	
	
	
	/**
	* draws the text field, contents, selection, and cursor
	* to the screen.
	*/
	
	public void draw () {
		boolean hasFocus = controller.getFocusStatusForComponent(this);

		if (wasClicked) {
			 currentColor = lookAndFeel.activeColor;
		} else if (isMouseOver (parent.mouseX, parent.mouseY) || hasFocus) {
			 currentColor = lookAndFeel.highlightColor;
		} else {
			 currentColor = lookAndFeel.baseColor;
		}

		boolean stroke = parent.g.stroke;
		int strokeColor = parent.g.strokeColor;
		int fillColor = parent.g.fillColor;
		PFont textFont = parent.g.textFont;
		int textAlign = parent.g.textAlign;

		// Draw the surrounding box
		parent.stroke(lookAndFeel.highlightColor);
		parent.fill(lookAndFeel.borderColor);
		parent.rect(getX(), getY(), getWidth(), getHeight());
		parent.noStroke();

		// Draw the selection rectangle
		if (startSelect != -1 && endSelect != -1) {
			parent.fill(lookAndFeel.selectionColor);
			
			int tempStart, tempEnd;
			if (endSelect < startSelect) {
				tempStart = endSelect;
				tempEnd = startSelect;
			} else {
				tempStart = startSelect;
				tempEnd = endSelect;
			}
			
			parent.rect(getX() + letterWidths[tempStart] + 4, getY() + 3, letterWidths[tempEnd] - letterWidths[tempStart] + 1, 15);
		}

		// Draw the string
		parent.fill (lookAndFeel.textColor);
		parent.textFont (meta, 13);
		parent.textAlign (parent.LEFT);
		parent.text (contents.substring(visiblePortionStart, visiblePortionEnd), 
						getX() + 4, getY() + 5, getWidth() - 8, getHeight() - 6);

		// Draw the insertion point (it blinks!)
		if (hasFocus && (startSelect == -1 || endSelect == -1) && ((parent.millis() % 1000) > 500)) {
			parent.stroke(lookAndFeel.darkGrayColor);
			parent.line(getX() + letterWidths[cursorPos] + 4, getY() + 3, getX() + letterWidths[cursorPos] + 4, getY() + 18);
		}
		
		// Clean up when you're done
		parent.stroke(strokeColor);
		if (!stroke)
			parent.noStroke();
		parent.fill(fillColor);
		if (textFont != null) {
			parent.textFont(textFont);
			parent.textAlign(textAlign);
		}
	}

}
