import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

// This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
// Copyright (c) 1997 by David Flanagan
// This example is provided WITHOUT ANY WARRANTY either expressed or implied.
// You may study, use, modify, and distribute it for non-commercial purposes.
// For any commercial use, see http://www.davidflanagan.com/javaexamples


/** A simple applet that uses the Java 1.0 event handling model. */
public class Scribble extends Applet {
  private int lastX, lastY;           // remember last mouse coordinates
  private Button clearButton;         // the Clear button
  private Graphics graphic;           // A Graphics object for drawing

  /** Initialize the button and the Graphics object. */
  @Override
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    graphic = this.getGraphics();
  }

  /**
   * Respond to mouse clicks.
   *
   * @param e the event which is a mouseDown.
   * @param x the new x position of the mouse.
   * @param y the new y position of the mouse.
   * @return a true when this event is triggered.
   */
  @Override
  public boolean mouseDown(Event e, int x, int y) {
    setXAndY(x, y);
    return true;
  }

  /**
   * Respond to mouse drags.
   *
   * @param e the event which is a mouseDrag.
   * @param x the new x position of the mouse.
   * @param y the new y position of the mouse.
   * @return a true when this event is triggered.
   */
  @Override
  public boolean mouseDrag(Event e, int x, int y) {
    graphic.setColor(Color.black);
    graphic.drawLine(lastX, lastY, x, y);
    setXAndY(x, y);
    return true;
  }

  /**
   * Respond to key presses.
   *
   * @param e the event which is a key press.
   * @param key the int value of the key press on the keyboard.
   * @return a true if the key is a c, else a false.
   */
  @Override
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to Button click on the clear button.
   *
   * @param e the event which is a button click.
   * @param arg ignored.
   * @return a true if the clearButton is click, else false.
   */
  @Override
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Convenience method to erase the scribble.
   */
  public void clear() {
    graphic.setColor(this.getBackground());
    graphic.fillRect(0, 0, bounds().width, bounds().height);
  }

  /**
   * Sets lastX and lastY to the given x and y coordinate.
   *
   * @param x the new x coordinate.
   * @param y the new y coordinate.
   */
  public void setXAndY(int x, int y) {
    lastX = x;
    lastY = y;
  }
}