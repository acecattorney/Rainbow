// Yingli Sieh
// Chapter 6 Question 19

// ________________________________________________

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  Color skyColor = Color.cyan;
  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    int xCenter = (int)(width*0.5);
    int yCenter = (int)(height*0.75);
    int largeRadius = width/4; // Declares and initializes the radius of the large semicircle
    
    
    //MAKING THE RED, LARGE SEMICIRCLE
    g.setColor(Color.RED);
    g.fillArc(xCenter-width/4, yCenter-width/4, width/2, width/2, 0, 180); // makes the red semicircle
    
    
    //MAKING THE MEDIUM, GREEN SEMICIRCLE
    g.setColor(Color.GREEN);
    int makesMiddle = (int)Math.round(Math.sqrt(largeRadius*(height/4))); 
    	// largeRadius = radius of Red, (height/4) = radius of Magenta
    	// using makesMiddle and xCenter/yCenter, we can find the radius of the middle green ring
    g.fillArc(xCenter-makesMiddle, yCenter-makesMiddle, makesMiddle*2, makesMiddle*2, 0, 180); // makes the green semicircle
    
    
    //MAKING THE SMALL, MAGENTA SEMICIRCLE
    g.setColor(Color.MAGENTA);
    g.fillArc((int)(xCenter-(height/4.0)), (int)(yCenter-(height/4.0)), height/2, height/2, 0, 180);
    g.setColor(skyColor);
    
    
    //MAKING THE INNER, SKY COLORED SEMICIRCLE
    	// Calculate the radius of the innermost (sky-color) semicircle
    	// so that the width of the middle (green) ring is the
    	// arithmetic mean of the widths of the red and magenta rings:
    int makesCenter= (int)((height/4) - (Math.pow(makesMiddle - (height/4), 2)) / ((width/4) - makesMiddle)); 
    	//like makesMiddle, gives the value makesCenter that can be used to find the radius of the inner semicircle 
    	// Draw the sky-color semicircle:
    g.fillArc(xCenter-makesCenter, yCenter-makesCenter, makesCenter*2, makesCenter*2, 0, 180);
  }

public static void main(String[] args)
  {
	//Making a new window with name Rainbow
    JFrame w = new JFrame("Rainbow");
    //Setting the size of the window
    w.setBounds(300, 300, 300, 200);
    //Sets it so that the window will close with the program
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    //Adding a rainbow to the container
    c.add(new Rainbow());
    //Displaying the window
    w.setVisible(true);
   
  }
}