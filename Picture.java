/* Filename: Picture.java
* Created by: Judy Chun, cs8afug 
* Date: 11/05/17
*/ 
/*--------PROGRAM DESCRIPTION----------
 goes here
 
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /**
   * Horizontal flip method
   * In this method, I've given you the basic structure of how things will look.  There are a few incomplete assignments inside of the method.  It is your job to figure out how to complete those assignments!
   * This method works almost like the horizontal mirroring method you saw in your text book (pg 135), but instead of mirroring on the middle of the image, we want to flip it all the way.
   * Hint: Why do we need tempColor in this case?  I encourage you to reflect on this question if you find your method not working the way it should!**/
  public void flipHorizontal()
  {
    Color tempColor;   //storing the temporary color value
    Color color1; 
    int limit1 = this.getWidth()/2;
    int limit2 = this.getHeight();
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        tempColor = this.getPixel(getWidth()-1-i,j).getColor();  //storing the right pixel color value 
        leftPixel = this.getPixel(i,j);   
        rightPixel = this.getPixel(getWidth()-1-i,j);
        color1 = leftPixel.getColor();
        rightPixel.setColor(color1);
        leftPixel.setColor(tempColor);
        
      }
    }
    
  }
  
  /**
   * Vertical flip method
   */
  public void flipVertical()
  {
    Color tempColor;
    Color color1; 
    int limit1 = this.getWidth();
    int limit2 = this.getHeight()/2;
    Pixel bottomPixel = null;
    Pixel topPixel = null;
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        tempColor = this.getPixel(i,getHeight()-1-j).getColor();  //storing the right pixel color value 
        bottomPixel = this.getPixel(i,j);   
        topPixel = this.getPixel(i,getHeight()-1-j);
        color1 = topPixel.getColor();
        bottomPixel.setColor(color1);
        topPixel.setColor(tempColor);
        
      }
    }
  }
  
  /**
   * Grayscale method **/
  public void grayscale()
  { 
    Pixel[] pixelArray = this.getPixels();
    int limit1 = pixelArray.length-1;
      for (int index = 0; index < limit1; index++)
      {
        int value = (pixelArray[index].getRed() + pixelArray[index].getGreen() + pixelArray[index].getBlue())/3;
        
        pixelArray[index].setRed(value);
        pixelArray[index].setGreen(value);
        pixelArray[index].setBlue(value);
    }
  }
  
  /**The collage method
    * This method will create the collage of your modified pictures.  
    * Hint 1: Inside of the for loop here will be another 2 nested for loops, giving you a grand total of 3 nested for loops in this method
    * Hint 2: If you're clever about the way you decide to draw your pixels onto the canvas, you may only have to write ONE LINE OF CODE inside the inner-most for loop to achieve the desired collage effect!
    * However, more than one line inside of the nested for loops is perfectly fine, of course! **/
  public void collage(Picture [] pictures)
  {
    for (int index = 0; index < pictures.length; index++)
    {
     for(int sourceX = 0, targetX = 0; sourceX < pictures[0].getWidth(); sourceX++, targetX++)
    {
      for(int sourceY = 0, targetY = 0; sourceY < pictures[0].getHeight(); sourceY++, targetY++) {
       Pixel sourcePix = pictures[index].getPixel(sourceX,sourceY);
       Pixel targetPix = this.getPixel(targetX+index*pictures[0].getWidth(),targetY); 
        
       Color color1 = sourcePix.getColor();
       targetPix.setColor(color1);
       
     
       
       
         
        
      }
        
    }
  }
  }
  
  
  public void flipVerticalRectangle(int x, int y, int width, int height)
  {
    Color tempColor;
    Color color1; 
    int limit1 = (int)(x+width/2);
    int limit2 = y;
    int bottomPix = (int)(y+height/2); //y-value for the bottom pixel 
    int topPix = (int)(y-height/2);    //y-value for the top pixel 
    Pixel bottomPixel = null;
    Pixel topPixel = null;
    
    for(int i = x-width/2; i < limit1; i++)
    {
      for(int j= topPix; j < limit2; j++)
      {
        int realPixel = j - topPix;   //distance 
        tempColor = this.getPixel(i,bottomPix-1-realPixel).getColor();  //storing the temporary color value 
        topPixel = this.getPixel(i,j);   
        bottomPixel = this.getPixel(i,bottomPix-1-realPixel);
        color1 = topPixel.getColor();
        bottomPixel.setColor(color1);
        topPixel.setColor(tempColor);
        
      }
    }
  }
  
  public void flipHorizontalRectangle(int x, int y, int width, int height) 
  {
    Color tempColor;
    Color color1; 
    int limit1 = x;
    int limit2 = (int)(y+height/2);
    int leftPix = (int)(x-width/2); 
    int rightPix = (int)(x+width/2);
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    for(int i = leftPix; i < limit1; i++)
    {
      for(int j= y-height/2; j < limit2; j++)
      {
        int realPixel = i - leftPix; 
        tempColor = this.getPixel(rightPix-1-realPixel,j).getColor();  //storing the temporary color value 
        leftPixel = this.getPixel(i,j); 
        rightPixel = this.getPixel(rightPix-1-realPixel,j);
        color1 = leftPixel.getColor();
        rightPixel.setColor(color1);
        leftPixel.setColor(tempColor);
        
      }
    }
  }

  //public boolean testFlipRectangle(Picture result)
  
  
  
  
 
} // this } is the end of class Picture, put all new methods before this
 
