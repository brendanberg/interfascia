// Interfascia -- ALPHA 001
//
// A graphical user interface library for the
// Processing environment.
//
// by Brendan Berg
//
// This software is released under the LGPL?

package interfascia;
import processing.core.*;

public class GUIEvent {  private GUIComponent source;  private String message;  public GUIEvent (GUIComponent argSource, String argMessage) {    source = argSource;    message = argMessage;  }  public GUIComponent getSource() {    return source;  }  public String getMessage() {    return message;  }}