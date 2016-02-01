import interfascia.*;

GUIController c;
IFRadioController rc;

IFRadioButton b1, b2, b3;

void setup() {
  size(200, 100);
  background(200);
  
  c = new GUIController(this);
  rc = new IFRadioController("Mode Selector");
  
  b1 = new IFRadioButton("Reality Distortion Field", 20, 20, rc);
  b2 = new IFRadioButton("Infinite Improbability Drive", 20, 40, rc);
  b3 = new IFRadioButton("Bistromathic Drive", 20, 60, rc);
  
  c.add(b1);
  c.add(b2);
  c.add(b3);
}

void draw() {
  background(200);
}
