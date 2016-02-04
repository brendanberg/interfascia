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
//import processing.core.*;

public class IFPasswordField extends IFTextField {
	private char displayChar;
	private String hiddenValue;
	
	public IFPasswordField (String newLabel, int newX, int newY) {
		super (newLabel, newX, newY, 100, "");
		setDisplayCharacter((char) 0x25CF);
	}

	public IFPasswordField (String argLabel, int argX, int argY, int argWidth) {
		super (argLabel, argX, argY, argWidth, "");
		setDisplayCharacter((char) 0x25CF);
	}
	
	public IFPasswordField (String argLabel, int argX, int argY, int argWidth, String label) {
		super (argLabel, argX, argY, argWidth, label);
		setDisplayCharacter((char) 0x25CF);
	}
	
	public IFPasswordField (String argLabel, int argX, int argY, int argWidth, String label, char c) {
		super (argLabel, argX, argY, argWidth, label);
		setDisplayCharacter(c);
	}
	
	public String getValue() {
		return hiddenValue;
	}
	
	public void appendToRightOfCursor(char c) {
		appendToRightOfCursor("" + c);
	}
	
	public void appendToRightOfCursor(String s){
		String t1, t2;
		int startSelect = super.getStartSelect();
		int endSelect = super.getEndSelect();
		int cursorPos = super.getCursorPosition();
		if (startSelect != -1 && endSelect != -1) {
			if (startSelect > endSelect) {
				int temp = startSelect;
				startSelect = endSelect;
				endSelect = temp;
			}
			if (endSelect > hiddenValue.length())
				endSelect = hiddenValue.length();
			t1 = hiddenValue.substring(0, startSelect);
			t2 = hiddenValue.substring(endSelect);
		} else {
			t1 = hiddenValue.substring(0, cursorPos);
			t2 = hiddenValue.substring(cursorPos);
		}
		hiddenValue = t1 + s + t2;
		super.appendToRightOfCursor(repeatChar(displayChar, s.length()));
		//fireEventNotification(this, "Modified");
	}
	
	public void backspaceChar() {
		String t1 = "", t2 = "";
		int startSelect = super.getStartSelect();
		int endSelect = super.getEndSelect();
		int cursorPos = super.getCursorPosition();
		
		if (startSelect != -1 && endSelect != -1) {
			if (startSelect > endSelect) {
				int temp = startSelect;
				startSelect = endSelect;
				endSelect = temp;
			}
			if (endSelect > hiddenValue.length())
				endSelect = hiddenValue.length();
			t1 = hiddenValue.substring(0, startSelect);
			t2 = hiddenValue.substring(endSelect);
			cursorPos = startSelect;
			startSelect = endSelect = -1;
			hiddenValue = t1 + t2;
		} else if (cursorPos > 0) {
			if (cursorPos > hiddenValue.length())
				cursorPos = hiddenValue.length();
			t1 = hiddenValue.substring(0, cursorPos - 1);
			t2 = hiddenValue.substring(cursorPos);
			hiddenValue = t1 + t2;
		}
		super.backspaceChar();
	}
	
	public void setValue(String value)
	{
		hiddenValue = value;
		super.setValue(repeatChar(displayChar,hiddenValue.length()));
	}
	
	protected void copySubstring(int start, int end) {
		return;
	}
	
	public void setDisplayCharacter(char character)
	{
		displayChar = character;
		setValue(hiddenValue);
	}
	
	private String repeatChar(char text, int number)
	{
		String repeatedString = "";
		for(int i = 0; i < number; i++)
			repeatedString += text;
		return repeatedString;
	}

}
