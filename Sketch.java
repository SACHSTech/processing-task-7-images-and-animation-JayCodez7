import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  // Initiate the images
  PImage sun;
  PImage imgBackground;

  // variables for the background image
  float fltBackgroundX = 0;
  float fltBackgroundY = 0;

  // variables for creating moon
  float moonX = 100;
  float moonY = 50;
  float xSpeed = 3;
  float ySpeed = 2;

  // variables for spinning sun
  float angle = 0;
  float radius = 100;

  float x;
  float y;
	
  public void settings() {
    size(400, 400);

  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    // Set background and size it
    imgBackground = loadImage("Space.jpg");
    imgBackground.resize(imgBackground.width / 2, imgBackground.height);

    // load sun
    sun = loadImage("sun.png");
    sun.resize(width/4, height/4);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // establish the background
    image(imgBackground, fltBackgroundX, fltBackgroundY);
    
    // speed of rotation
    angle += 0.05;

    // code so it rotates
    x = width / 2 + cos(angle) * radius;
    y = height / 2 + sin(angle) * radius;

    // put sun on screen
    image(sun, x, y);

    // speed and collision for moon
    moonX += xSpeed;
    moonY += ySpeed;

    if (moonX < 0 || moonX > width) {
      xSpeed *= -1;
    }

    if (moonY < 0 || moonY > height) {
      ySpeed *= -1;
    }

    // draw moon
    fill (230, 222, 202);
    stroke (0);
    ellipse (moonX, moonY, 65, 65);

  }
}