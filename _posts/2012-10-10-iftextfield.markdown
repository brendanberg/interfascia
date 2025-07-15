---
layout: page
title: IFTextField
category: documentation
description: Interfascia's IFTextField object

---

The IFTextField object creates a new text field GUI component. Text fields are single-line boxes that 
accept text input, mouse and keyboard selection of text, and cut/copy/paste to the system clipboard.


Syntax
------

	IFButton b = new IFButton("Label", _, _);


Method Summary
--------------

<p class="method">
	<code>IFTextField(String label, int x, int y);<br />
		IFTextField(String label, int x, int y, int width);<br />
		IFTextField(String label, int x, int y, int width, String contents);
	</code>
</p>
<ul class="description">
	<li><code>label</code>, the name of the text field (not displayed).</li>
	<li><code>x</code>, the X position of the text field's upper left hand corner.</li>
	<li><code>y</code>, the Y position of the text field's upper left hand corner.</li>
	<li><code>width</code>, the width of the text field, in pixels.</li>
	<li><code>contents</code>, the text to be displayed in the text field.</li>
</ul>

<p class="method">
	<code>setLabel(String newLabel)</code>
</p>
<ul class="description">
	<li>Sets the name of the text field. The text field name is used when submitting the interface's
		current state to a web server.</li>
	<li><code>newLabel</code>, the new name for the text field.</li>
</ul>

<p class="method">
	<code>getLabel()</code>
</p>
<ul class="description">
	<li>Returns the text field's name as a String.</li>
</ul>

<p class="method">
	<code>setValue(String contents)</code>
</p>
<ul class="description">
	<li>Sets the text displayed in the text field.</li>
	<li><code>contents</code>, the new text to be displayed in the text field.</li>
</ul>

<p class="method">
	<code>getValue()</code>
</p>
<ul class="description">
	<li>Returns the text field's contents as a String.</li>
</ul>

<p class="method">
	<code>setWidth(int width)</code>
</p>
<ul class="description">
	<li>Sets the width of the text field.</li>
	<li><code>width</code>, the new width for the text field.</li>
</ul>

<p class="method">
	<code>getWidth()</code>
</p>
<ul class="description">
	<li>Returns the width in pixels of the text field in integer form.</li>
</ul>

<p class="method">
	<code>setHeight(int height)</code>
</p>
<ul class="description">
	<li>Sets the height of the text field.</li>
	<li><code>height</code>, the new height for the text field.</li>
</ul>

<p class="method">
	<code>getHeight()</code>
</p>
<ul class="description">
	<li>Returns the height in pixels of the text field in integer form.</li>
</ul>

<p class="method">
	<code>setSize(int width, int height)</code>
</p>
<ul class="description">
	<li>A convenience method to set both dimensions of the text field.</li>
	<li><code>width</code>, the new width for the text field.</li>
	<li><code>height</code>, the new height for the text field.</li>
</ul>

<p class="method">
	<code>setX(int x)</code>
</p>
<ul class="description">
	<li>Sets the X position of the text field relative to its GUIController.</li>
	<li><code>x</code>, the new X position for the text field.</li>
</ul>

<p class="method">
	<code>getX()</code>
</p>
<ul class="description">
	<li>Returns the X position in pixels of the text field relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setY(int y)</code>
</p>
<ul class="description">
	<li>Sets the Y position of the text field relative to its GUIController.</li>
	<li><code>y</code>, the new Y position for the text field.</li>
</ul>

<p class="method">
	<code>getY()</code>
</p>
<ul class="description">
	<li>Returns the Y position in pixels of the text field relative to its GUIController.</li>
</ul>

<p class="method">
	<code>setPosition(int x, int y)</code>
</p>
<ul class="description">
	<li>A convenience method to set both the X and Y position of the text field.</li>
	<li><code>X</code>, the new X position for the text field.</li>
	<li><code>Y</code>, the new Y position for the text field.</li>
</ul>

<p class="method">
	<code>addActionListener(Object listener)</code>
</p>
<ul class="description">
	<li>Adds an action listener object which receives `GUIEvent` notifications when the text field is
		clicked or released. You must implement the [actionPerformed()](/documentation/actionperformed/)
		method in order to receive events from the text field.</li>
	<li><code>listener</code>, the object that events are sent to. (Usually `this`.)</li>
</ul>



Example
-------

	import interfascia.*;
	
	GUIController c;
	IFTextField t;
	
	void setup() {
	   size(160, 100);
	   c = new GUIController(this);
	   t = new IFTextField("Input", 30, 30);

	   c.add(t);
	}
	
	void draw() {
	}

