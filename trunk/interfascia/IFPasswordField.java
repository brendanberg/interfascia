//
//  IFPasswordField.java
//  interfascia
//
//  Created by Brendan Berg on 10/3/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//

package interfascia;
import processing.core.*;

public class IFPasswordField extends IFTextField {
	private char displayChar;
	private String hiddenValue;
	
	public IFPasswordField (String newLabel, int newX, int newY) {
		super (newLabel, newX, newY, 100, "");
		setCharacter('*');
	}

	public IFPasswordField (String argLabel, int argX, int argY, int argWidth) {
		super (argLabel, argX, argY, argWidth, "");
		setCharacter('*');
	}
	
	public IFPasswordField (String argLabel, int argX, int argY, int argWidth, String label) {
		super (argLabel, argX, argY, argWidth, label);
		setCharacter('*');
	}
	
	public IFPasswordField (String argLabel, int argX, int argY, int argWidth, String label, char c) {
		super (argLabel, argX, argY, argWidth, label);
		setCharacter(c);
	}
	
	public String getValue() {
		return hiddenValue;
	}
	
	public void addChar(char c){
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
		hiddenValue = t1 + c + t2;
		super.addChar(displayChar);
	}
	
	public void setValue(String value)
	{
		hiddenValue = value;
		super.setValue(value);
		contents = repeatChar(displayChar,hiddenValue.length());
	}
	
	public void setCharacter(char character)
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
