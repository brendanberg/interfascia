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
