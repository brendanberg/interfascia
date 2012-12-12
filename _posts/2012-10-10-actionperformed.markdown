---
layout: page
title: actionPerformed
category: documentation
description: A delegate method to receive user interface event notifications

---

If it exists, the `actionPerfomed()` method is called every time a GUI component generates an event. It is passed a `GUIEvent`
as an argument. Events are generated on button click, checkbox state change, radio button state change, and text field focus
change.

The event notification is sent to the listener declared in the particular component's `addActionListener()` method.


Syntax
------

	void actionPerformed (GUIEvent e) {
		// Statements here will be executed whenever a GUIEvent is generated
	}


Example
-------

	import interfascia.*;
	
	GUIController c;
	IFButton b1, b2;
	
	void setup() {
	  c = new GUIController (this);
	  
	  b1 = new IFButton ("One", 30, 20, 40, 17);
	  b2 = new IFButton ("Two", 30, 60, 40, 17);
	
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	
	  c.add (b1);
	  c.add (b2);
	}
	
	void draw() {
	}
	
	void actionPerformed (GUIEvent e) {
	  if (e.getSource() == b1) {
	    println("Button one was clicked");
	  } else if (e.getSource() == b2) {
	    println("Button two was clicked");
	  }
	}

