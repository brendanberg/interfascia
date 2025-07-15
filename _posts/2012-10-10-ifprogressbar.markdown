---
layout: page
title: IFProgressBar
category: documentation
description: Interfascia's IFProgressBar object

---

The `IFProgressBar` object creates a new progress bar GUI component. A progress bar is updated with
a value bwtween 0 and 1 representing a process's percent complete.


Method Summary
--------------

<p class="method">
	<code>IFProgressBar(int x, int y, int width)</code>
</p>
<ul class="description">
	<li><code>x</code>, the X position of the text field's upper left corner.</li>
	<li><code>y</code>, the Y position of the text field's upper left corner.</li>
	<li><code>width</code>, the width of the text field in pixels.</li>
</ul>

<p class="method">
	<code>setProgress(float progress)</code>
</p>
<ul class="description">
	<li>Updates the progress bar's length in proportion to the percentage complete.</li>
	<li><code>progress</code>, the percentage complete (must be between 0 and 1).</li>
</ul>

<p class="method">
	<code>getProgress()</code>
</p>
<ul class="description">
	<li>Returns the percentage complete, represented as a float between 0 and 1.</li>
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


Example
-------

	import interfascia.*;
	
	IFProgressBar p = new IFProgressBar(10, 10, 80);
	float percent = 0;
	
	void setup() {
	   GUIController c = new GUIController(this);
	
	   c.add(p);
	   p.setProgress(percent);
	}
	
	void draw() {
	   p.setProgress(percent);

	   if (percent < 1) {
	      percent += 0.01;
	   } else {
	      percent = 0;
	   }
	}

