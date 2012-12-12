---
layout: default
title: Button
category: examples
skill_level: easy
description: Attach action listeners to IFButton objects to react to click events

---


<applet code="custom_color" archive="applets/button.jar" width="200" height="100" mayscript="true">
<param name="image" value="loading.gif">
<param name="boxmessage" value="Loading Processing software...">
<param name="boxbgcolor" value="#FFFFFF">
To view this content, you need to install Java from <a href="http://java.com">java.com</a>
</applet>


Source
------

	import interfascia.*;
	
	GUIController c;
	IFButton b1, b2;
	IFLabel l;
	
	void setup() {
	  size(200, 100);
	  background(155);
	  
	  c = new GUIController (this);
	  
	  b1 = new IFButton ("Green", 40, 40, 40, 17);
	  b2 = new IFButton ("Blue", 120, 40, 40, 17);
	
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	
	  c.add (b1);
	  c.add (b2);
	}
	
	void draw() {
	
	}
	
	void actionPerformed (GUIEvent e) {
	  if (e.getSource() == b1) {
	    background(100, 155, 100);
	  } else if (e.getSource() == b2) {
	    background(100, 100, 130);
	  }
	}

