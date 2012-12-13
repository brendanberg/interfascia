---
layout: page
title: Text Field
category: examples
skill_level: easy
description: Capture live data input with a UITextField

---


<applet code="custom_color" archive="applets/textfield.jar" width="200" height="100" mayscript="true">
<param name="image" value="loading.gif">
<param name="boxmessage" value="Loading Processing software...">
<param name="boxbgcolor" value="#FFFFFF">
To view this content, you need to install Java from <a href="http://java.com">java.com</a>
</applet>


Source
------

	import interfascia.*;
	
	GUIController c;
	IFTextField t;
	IFLabel l;
	
	void setup() {
	  size(200, 100);
	  background(150);
	  
	  c = new GUIController(this);
	  t = new IFTextField("Text Field", 25, 30, 150);
	  l = new IFLabel("", 25, 70);
	  
	  c.add(t);
	  c.add(l);
	  
	  t.addActionListener(this);
	  
	}
	
	void draw() {
	  
	}
	
	void actionPerformed(GUIEvent e) {
	  if (e.getMessage().equals("Completed")) {
	    l.setLabel(t.getValue());
	  }
	}

