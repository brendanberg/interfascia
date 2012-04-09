---
layout: default
title: Interfascia &raquo; Documentation &raquo; GUIController
description: Interfascia's GUIController object

---

GUIController
=============

The GUIController object keeps track of all GUI components and handles the forwarding of events from the Processing applet to the individual GUI components. All you need to do is create a new GUIController that references the current PApplet and add desired GUIComponents to the controller.


Syntax
------

	GUIController c = new GUIController(this);
	c.add(button);
	c.requestFocus(button);


Methods
-------

<p class="method">GUIController(PApplet parent);<br />
GUIController(PApplet parent, boolean visible);</p>
<p class="description"><b><tt>parent,</tt></b> the Processing applet where the GUI components
will be drawn; usually the keyword 'this' is used.<br />
<span class="code">visible,</span> whether the components in the controller will be drawn.</p>

<p class="method">add(GUIComponent component);</p>
<p class="description">The add() method adds a GUI component to the 
controller's list of components it controls.<br />
<br />
<span class="code">component,</span> component to be added</p>

<p class="method">remove(GUIComponent component);</p>
<p class="description">The remove() method removes a GUI component 
to the controller's list of components it controls.<br />
<br />
<span class="code">component,</span> component to be removed</p>

<p class="method">requestFocus(GUIComponent component);</p>
<p class="description">The requestFocus() method requests that the 
controller send keyboard events to the specified component. <br />
<br />
<span class="code">component,</span> component to receive focus</p>

<p class="method">yieldFocus(GUIComponent component);</p>
<p class="description">The yieldFocus() method tells the controller 
to no longer forward keyboard events to the specified component.<br />
<br />
<span class="code">component,</span> component to lose focus</p>

<p class="method">getComponentWithFocus();</p>
<p class="description">The getComponentWithFocus() method returns 
the component that is currently receiving keyboard events.</p>

<p class="method">getFocusStatusForComponent(GUIComponent component);</p>
<p class="description">The getFocusStatusForComponent() method returns 
true if the specified component has keyboard focus, false otherwise. <br />
<br />
<span class="code">component,</span> component whose focus status is in question</p>

<p class="method">copy(String s);</p>
<p class="description">The copy() method copies the specified string to 
the system's clipboard. <br />
<br />
<span class="code">s,</span> the string to be copied to the clipboard</p>

<p class="method">paste();</p>
<p class="description">The paste() method returns the string that is 
currently in the system's clipboard.</p>


Example
-------

	GUIController c;
	Button b;

	void setup() {
	   c = new GUIController(this);
	   b = new Button("Click!", 20, 20, 40);

	   c.add(b);
	}

	void draw() {

	}