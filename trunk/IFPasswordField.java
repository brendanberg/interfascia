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
	String displayChars;
	
	public IFPasswordField (String newLabel, int newX, int newY) {
		super (newLabel, newX, newY, 100, "");
	}
	
	public IFPasswordField (String argLabel, int argX, int argY, int argWidth) {
		super (argLabel, argX, argY, argWidth, "");
	}

}
