---
layout: page
title: Radio Buttons
category: examples
skill_level: easy
description: Create an IFRadioController object to manage IFRadioButton objects

---


<applet code="custom_color" archive="applets/radiobutton.jar" width="200" height="100" mayscript="true">
<param name="image" value="loading.gif">
<param name="boxmessage" value="Loading Processing software...">
<param name="boxbgcolor" value="#FFFFFF">
To view this content, you need to install Java from <a href="http://java.com">java.com</a>
</applet>


Source
------

	import interfascia.*;
	
	GUIController c;
	IFRadioController rc;
	
	IFRadioButton b1, b2, b3;
	
	void setup() {
	  size(200, 100);
	  background(150);
	  
	  c = new GUIController(this);
	  rc = new IFRadioController("Mode Selector");
	  
	  b1 = new IFRadioButton("Reality Distortion Field", 20, 20, rc);
	  b2 = new IFRadioButton("Infinite Improbability Drive", 20, 40, rc);
	  b3 = new IFRadioButton("Bistromathic Drive", 20, 60, rc);
	  
	  c.add(b1);
	  c.add(b2);
	  c.add(b3);
	}
	
	void draw() {
	}

