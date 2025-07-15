---
layout: page
title: IFRadioButton
category: documentation
description: Interfascia's IFButton object

---

The `IFRadioButton` object creates a new radio button GUI component. Each radio button must
belong to an `IFRadioController`, which manages the behavior of a group of radio buttons.


Method Summary
--------------

<p class="method">
	<code>IFRadioButton(String label, int x, int y, IFRadioController controller)</code>
</p>
<ul class="description">
	<li><code>label</code>, the text displayed on the button.</li>
	<li><code>x</code>, the X position of the radio button's upper left corner.</li>
	<li><code>y</code>, the Y position of the radio button's upper left corner.</li>
	<li><code>controller</code>, the radio button manager for this button's button group.</li>
</ul>

<p class="method">
	<code>setLabel(String newLabel)</code>
</p>
<ul class="description">
	<li>Sets the name of the button. The button name is used when submitting the interface's
		current state to a web server.</li>
	<li><code>newLabel</code>, the new name for the button.</li>
</ul>

<p class="method">
	<code>getLabel()</code>
</p>
<ul class="description">
	<li>Returns the button's name as a String.</li>
</ul>

<p class="method">
	<code>setWidth(int width)</code>
</p>
<ul class="description">
	<li>Sets the width of the button.</li>
	<li><code>width</code>, the new width for the button.</li>
</ul>

<p class="method">
	<code>getWidth()</code>
</p>
<ul class="description">
	<li>Returns the width in pixels of the button in integer form.</li>
</ul>

<p class="method">
	<code>setHeight(int height)</code>
</p>
<ul class="description">
	<li>Sets the height of the button.</li>
	<li><code>height</code>, the new height for the button.</li>
</ul>

<p class="method">
	<code>getHeight()</code>
</p>
<ul class="description">
	<li>Returns the height in pixels of the button in integer form.</li>
</ul>

<p class="method">
	<code>setSize(int width, int height)</code>
</p>
<ul class="description">
	<li>A convenience method to set both dimensions of the button.</li>
	<li><code>width</code>, the new width for the button.</li>
	<li><code>height</code>, the new height for the button.</li>
</ul>

<p class="method">
	<code>setX(int x)</code>
</p>
<ul class="description">
	<li>Sets the X position of the button relative to its GUIController.</li>
	<li><code>x</code>, the new X position for the button.</li>
</ul>

<p class="method">
	<code>getX()</code>
</p>
<ul class="description">
	<li>Returns the X position in pixels of the button relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setY(int y)</code>
</p>
<ul class="description">
	<li>Sets the Y position of the button relative to its GUIController.</li>
	<li><code>y</code>, the new Y position for the button.</li>
</ul>

<p class="method">
	<code>getY()</code>
</p>
<ul class="description">
	<li>Returns the Y position in pixels of the button relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setPosition(int x, int y)</code>
</p>
<ul class="description">
	<li>A convenience method to set both the X and Y position of the button.</li>
	<li><code>X</code>, the new X position for the button.</li>
	<li><code>Y</code>, the new Y position for the button.</li>
</ul>

<p class="method">
	<code>isSelected()</code>
</p>
<ul class="description">
	<li>Returns whether the radio button is selected. Returns `true` if the button is selected,
		and `false` otherwise.</li>
</ul>


Example
-------

	import interfascia.*;
	
	GUIController c;
	IFRadioController rc;
	IFRadioButton b1, b2, b3;
	
	void setup() {
	   c = new GUIController(this);
	   rc = new IFRadioController("Selector");
	   b1 = new IFRadioButton("One", 30, 20, rc);
	   b2 = new IFRadioButton("Two", 30, 40, rc);
	   b3 = new IFRadioButton("Three", 30, 60, rc);
	
	   c.add(b1);
	   c.add(b2);
	   c.add(b3);
	}

	void draw() {
	   background(200);
	}
