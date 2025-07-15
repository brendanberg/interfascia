---
layout: page
title: IFRadioController
category: documentation
description: Interfascia's IFRadioController object

---

The `IFRadioController` object keeps track of all [`IFRadioButton`](/documentation/ifradiobutton/) components in
one group and makes sure only one is selected. Radio buttons can be added to a group either by passing them to 
the radio controller through the `add()` method, or by specifying a controller when creating a new radio button.


Method Summary
--------------

<p class="method">
	<code>IFRadioController()<br />
		IFRadioController(String label)
	</code>
</p>
<ul class="description">
	<li><code>label</code>, the name of the radio button group.</li>
</ul>

<p class="method">
	<code>add(IFRadioButton button)</code>
</p>
<ul class="description">
	<li>Adds a radio button to the controller's list of buttons it manages.</li>
	<li><code>button</code>, the button to be added.</li>
</ul>

<p class="method">
	<code>remove(IFRadioButton button)</code>
</p>
<ul class="description">
	<li>Removes a radio button from the controller's list of buttons it controls.</li>
	<li><code>button</code>, the button to be removed.</li>
</ul>

<p class="method">
	<code>getSelected()</code>
</p>
<ul class="description">
	<li>Returns the currently selected `IFRadioButton` object. If none is selected, it returns `null`.</li>
</ul>

<p class="method">
	<code>getSelectedIndex()</code>
</p>
<ul class="description">
	<li>Returns the numerical index of the currently selected `IFRadioButton`. If none is selected, its value is `-1`.</li>
</ul>

<p class="method">
	<code>deselectAll()</code>
</p>
<ul class="description">
	<li>Deselects the currently selected radio button so no buttons are selected.</li>
</ul>

<p class="method">
	<code>addActionListener(Object listener)</code>
</p>
<ul class="description">
	<li>Adds an action listener object which receives `GUIEvent` notifications when the button is
		clicked or released. You must implement the [actionPerformed()](/documentation/actionperformed/)
		method in order to receive events from the button.</li>
	<li><code>listener</code>, the object that events are sent to. (Usually `this`.)</li>
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

