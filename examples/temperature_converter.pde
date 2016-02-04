import interfascia.*;
import java.text.DecimalFormat;

GUIController c;
IFTextField fahrenheit, celsius;
IFLabel label1, label2;

DecimalFormat format;

void setup() {
  size(200, 100);
  background(200);
  
  c = new GUIController(this);
  
  fahrenheit = new IFTextField("F", 20, 45, 50);
  celsius = new IFTextField("C", 110, 45, 50);
  
  label1 = new IFLabel("°F  = ", 75, 50);
  label2 = new IFLabel("°C", 165, 50);
  
  fahrenheit.addActionListener(this);
  celsius.addActionListener(this);
  
  c.add(fahrenheit);
  c.add(celsius);
  c.add(label1);
  c.add(label2);
  
  format = new DecimalFormat();
  format.setMaximumFractionDigits(2);
}

void draw() {
  background(200);
}

void actionPerformed(GUIEvent e) {
  float temp;
  if (e.getMessage().equals("Modified")) {
    if (e.getSource() == fahrenheit) {
      try {
        temp = Float.parseFloat(fahrenheit.getValue());
        celsius.setValue(format.format((temp - 32) * 5 / 9));
      } catch (Exception e2) { }
    } else {
      try {
        temp = Float.parseFloat(celsius.getValue());
        fahrenheit.setValue(format.format(temp * 9 / 5 + 32));
      } catch (Exception e2) { }
    }
  }
}
