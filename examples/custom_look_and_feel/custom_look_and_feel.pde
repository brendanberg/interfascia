import interfascia.*;

GUIController c;
IFButton startButton, stopButton;
IFProgressBar progress;
IFCheckBox global, nothing;

IFLookAndFeel defaultLook, redLook, greenLook;
boolean running = false;

void setup() {
  size(200, 100);
  frameRate(60);
  background(200);
  
  c = new GUIController (this);
  
  startButton = new IFButton ("Start", 10, 70, 40, 17);
  stopButton = new IFButton ("Stop", 60, 70, 40, 17);
  progress = new IFProgressBar (120, 72, 70);
  global = new IFCheckBox ("Use global look and feel", 10, 15);
  nothing = new IFCheckBox ("Cook breakfast", 10, 35);
  
  startButton.addActionListener(this);
  stopButton.addActionListener(this);
  global.addActionListener(this);
  
  c.add (progress);
  
  defaultLook = new IFLookAndFeel(this, IFLookAndFeel.DEFAULT);
  
  greenLook = new IFLookAndFeel(this, IFLookAndFeel.DEFAULT);
  greenLook.baseColor = color(100, 180, 100);
  greenLook.highlightColor = color(70, 135, 70);

  redLook = new IFLookAndFeel(this, IFLookAndFeel.DEFAULT);
  redLook.baseColor = color(175, 100, 100);
  redLook.highlightColor = color(175, 50, 50);
  
  c.setLookAndFeel(greenLook);

  c.add (global);
  c.add (nothing);
  c.add (startButton);
  c.add (stopButton);
  
  stopButton.setLookAndFeel(redLook);
}

void draw() {
  background(200);
  if (running) {
    progress.setProgress((progress.getProgress() + 0.01) % 1);
  }
}

void actionPerformed (GUIEvent e) {
  if (e.getSource() == startButton) {
    running = true;
  } else if (e.getSource() == stopButton) {
    running = false;
  } else if (e.getSource() == global && e.getMessage().equals("Checked")) {
      startButton.setLookAndFeel(defaultLook);
      stopButton.setLookAndFeel(defaultLook);
      global.setLookAndFeel(defaultLook);
      nothing.setLookAndFeel(defaultLook);
  } else if (e.getSource() == global && e.getMessage().equals("Unchecked")) {
      startButton.setLookAndFeel(greenLook);
      stopButton.setLookAndFeel(redLook);
      global.setLookAndFeel(greenLook);
      nothing.setLookAndFeel(greenLook);
  }
}
