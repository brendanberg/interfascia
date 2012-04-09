---
layout: default
title: GUIController
description: Interfascia's GUIController object

---

The GUIController object keeps track of all GUI components and handles the forwarding of events from the Processing applet to the individual GUI components. All you need to do is create a new GUIController that references the current PApplet and add desired GUIComponents to the controller.


Syntax
------

	GUIController c = new GUIController(this);
	c.add(button);
	c.requestFocus(button);


Methods
-------

<p class="method">
	<code>GUIController(PApplet parent);<br />
		GUIController(PApplet parent, boolean visible);
	</code>
</p>
<ul class="description">
	<li><code>parent</code>, the Processing applet where the GUI components will be drawn; usually the keyword 'this' is used.</li>
	<li><code>visible</code>, whether the components in the controller will be drawn.</li>
</ul>

<p class="method"><code>add(GUIComponent component);</code></p>
<ul class="description">
	<li>The add() method adds a GUI component to the controller's list of components it controls.</li>
	<li><code>component</code>, component to be added</li>
</ul>

<p class="method"><code>remove(GUIComponent component);</code></p>
<ul class="description">
	<li>The remove() method removes a GUI component to the controller's list of components it controls.</li>
	<li><code>component</code>, component to be removed</li>
</ul>

<p class="method"><code>requestFocus(GUIComponent component);</code></p>
<ul class="description">
	<li>The requestFocus() method requests that the controller send keyboard events to the specified component.</li>
	<li><code>component</code>, component to receive focus</li>
</ul>

<p class="method"><code>yieldFocus(GUIComponent component);</code></p>
<ul class="description">
	<li>The yieldFocus() method tells the controller to no longer forward keyboard events to the specified component.</li>
	<li><code>component</code>, component to lose focus</li>
</ul>

<p class="method"><code>getComponentWithFocus();</code></p>
<ul class="description">
	<li>The getComponentWithFocus() method returns the component that is currently receiving keyboard events.</li>
</ul>

<p class="method"><code>getFocusStatusForComponent(GUIComponent component);</code></p>
<ul class="description">
	<li>The getFocusStatusForComponent() method returns true if the specified component has keyboard focus, false otherwise.</li>
	<li><code>component</code>, component whose focus status is in question</li>
</ul>

<p class="method"><code>copy(String s);</code></p>
<ul class="description">
	<li>The copy() method copies the specified string to the system's clipboard.</li>
	<li><code>s</code>, the string to be copied to the clipboard</li>
</ul>

<p class="method"><code>paste();</code></p>
<ul class="description">
	<li>The paste() method returns the string that is currently in the system's clipboard.</li>
</ul>


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
