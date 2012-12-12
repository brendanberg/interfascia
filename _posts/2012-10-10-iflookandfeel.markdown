---
layout: page
title: IFLookAndFeel
category: documentation
description: Interfascia's IFLookAndFeel object

---

The IFLookAndFeel object specifies colors for Interfascia widgets.


Method Summary
--------------

<p class="method">
	<code>IFLookAndFeel(char type)</code>
</p>
<ul class="description">
	<li><code>type</code>, the type of look and feel to use (currently, only `DEFAULT` is implemented).</li>
</ul>

<p class="method">
	<code>IFLookAndFeel(PApplet parent, char type)</code>
</p>
<ul class="description">
	<li><code>parent</code>, the Processing applet that is using the Interfascia library.</li>
	<li><code>type</code>, the type of look and feel to use (currently, only `DEFAULT` is implemented).</li>
</ul>


Field Summary
-------------

<p class="method">
	<code>static final int DEFAULT</code>
</p>
<ul class="description">
	<li>The default look and feel color scheme.</li>
</ul>

<p class="method">
	<code>int baseColor</code>
</p>
<ul class="description">
	<li>The default background color for Interfascia components.</li>
</ul>

<p class="method">
	<code>int borderColor</code>
</p>
<ul class="description">
	<li>The border color for Interfascia components.</li>
</ul>

<p class="method">
	<code>int selectionColor</code>
</p>
<ul class="description">
	<li>The color used for selected text in an Interfascia text field.</li>
</ul>

<p class="method">
	<code>int highlightColor</code>
</p>
<ul class="description">
	<li>The color for the background of an Interfascia component with mouse or keyboard focus.</li>
</ul>

<p class="method">
	<code>int activeColor</code>
</p>
<ul class="description">
	<li>The color for the background of an Interfascia widget while it is clicked.</li>
</ul>

<p class="method">
	<code>int textColor</code>
</p>
<ul class="description">
	<li>The color for text in an Interfascia GUI component.</li>
</ul>

<p class="method">
	<code>int lightGrayColor</code>
</p>
<ul class="description">
	<li>Light gray, used for the selection dot in `IFRadioButton`.</li>
</ul>

<p class="method">
	<code>int darkGrayColor</code>
</p>
<ul class="description">
	<li>Dark gray, used for the insertion point in `IFTextField` and the check in `IFCheckBox`.</li>
</ul>


Example
-------

	greenLook = new IFLookAndFeel(this, IFLookAndFeel.DEFAULT);
	greenLook.baseColor = color(100, 180, 100);
	greenLook.highlightColor = color(70, 135, 70);

