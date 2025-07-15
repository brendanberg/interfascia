---
layout: example
title: Text Field
category: examples
skill_level: easy
description: Capture live data input with a UITextField

---

```java
import interfascia.*;

GUIController c;
IFTextField t;
IFLabel l;

void setup() {
  size(200, 100);
  
  c = new GUIController(this);
  t = new IFTextField("Text Field", 25, 30, 150);
  l = new IFLabel("", 25, 70);
  
  c.add(t);
  c.add(l);
  
  t.addActionListener(this);
  
}

void draw() {
  background(200);
}

void actionPerformed(GUIEvent e) {
  if (e.getMessage().equals("Completed")) {
    l.setLabel(t.getValue());
  }
}
```

