---
layout: page
title: IFCheckBox
category: documentation
description: Interfascia's IFCheckBox object

---

The IFCheckBox object creates a new check box GUI component.

Syntax
------

	IFCheckBox c = new IFCheckBox("Enable", 30, 30);
	c.addActionListener(this);


Method Summary
--------------

<p class="method">
	<code>IFCheckBox(String label, int x, int y);</code>
</p>
<ul class="description">
	<li><code>label</code>, the text displayed next to the check box.</li>
	<li><code>x</code>, the X position of the check box.</li>
	<li><code>y</code>, the Y position of the check box's upper .</li>
</ul>

<p class="method">
	<code>setLabel(String newLabel)</code>
</p>
<ul class="description">
	<li>Sets the name of the check box. The check box name is used when submitting the interface's
		current state to a web server.</li>
	<li><code>newLabel</code>, the new name for the check box.</li>
</ul>

<p class="method">
	<code>getLabel()</code>
</p>
<ul class="description">
	<li>Returns the check box's name as a String.</li>
</ul>

<p class="method">
	<code>setWidth(int width)</code>
</p>
<ul class="description">
	<li>Sets the width of the check box.</li>
	<li><code>width</code>, the new width for the check box.</li>
</ul>

<p class="method">
	<code>getWidth()</code>
</p>
<ul class="description">
	<li>Returns the width in pixels of the check box in integer form.</li>
</ul>

<p class="method">
	<code>setHeight(int height)</code>
</p>
<ul class="description">
	<li>Sets the height of the check box.</li>
	<li><code>height</code>, the new height for the check box.</li>
</ul>

<p class="method">
	<code>getHeight()</code>
</p>
<ul class="description">
	<li>Returns the height in pixels of the check box in integer form.</li>
</ul>

<p class="method">
	<code>setSize(int width, int height)</code>
</p>
<ul class="description">
	<li>A convenience method to set both dimensions of the check box.</li>
	<li><code>width</code>, the new width for the check box.</li>
	<li><code>height</code>, the new height for the check box.</li>
</ul>

<p class="method">
	<code>setX(int x)</code>
</p>
<ul class="description">
	<li>Sets the X position of the check box relative to its GUIController.</li>
	<li><code>x</code>, the new X position for the check box.</li>
</ul>

<p class="method">
	<code>getX()</code>
</p>
<ul class="description">
	<li>Returns the X position in pixels of the check box relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setY(int y)</code>
</p>
<ul class="description">
	<li>Sets the Y position of the check box relative to its GUIController.</li>
	<li><code>y</code>, the new Y position for the check box.</li>
</ul>

<p class="method">
	<code>getY()</code>
</p>
<ul class="description">
	<li>Returns the Y position in pixels of the check box relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setPosition(int x, int y)</code>
</p>
<ul class="description">
	<li>A convenience method to set both the X and Y position of the check box.</li>
	<li><code>X</code>, the new X position for the check box.</li>
	<li><code>Y</code>, the new Y position for the check box.</li>
</ul>

<p class="method">
	<code>addActionListener(Object listener)</code>
</p>
<ul class="description">
	<li>Adds an action listener object which receives `GUIEvent` notifications when the check box is
		clicked or released. You must implement the [actionPerformed()](/documentation/actionperformed/)
		method in order to receive events from the check box.</li>
	<li><code>listener</code>, the object that events are sent to. (Usually `this`.)</li>
</ul>

<p> class="method">
	<code>isSelected()</code>
</p>
<ul class="description">
	<li>Returns whether the check box is checked. The boolean value is true if the box is checked, and is false otherwise.</li>
</ul>


Example
-------

	import interfascia.*;
	
	IFCheckBox b = new IFCheckBox("Enable", 20, 20);
	
	void setup() {
	   GUIController c = new GUIController(this);
	
	   c.add(b);
	   b.addActionListener(this);
	}
	
	void draw() {
	   background(200);
	}
	
	void actionPerformed(GUIEvent e) {
	   if (e.getSource() == b) {
	      if (b.isSelected()) {
	         println("Checked");
	      } else {
	         println("Unchecked");
	      }
	   }
	}

