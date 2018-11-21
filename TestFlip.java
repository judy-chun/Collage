/* Filename: TestFlip.java 
* Created by: Judy Chun, cs8afug 
* Date: 11/05/17
* 1) How would you use the height and width of the 3x3 section to find its
*    top left corner, given the coordinates of its center C? 
* To get the top left corner, you would use x-width/2 and y-height/2 
*
* 2) What if the grid of pixels we focus on is a 3x4 region? Pay attention to where
*    we define the center of the grid if a dimension is even.
* Regardless of the dimension, the top left corner can be found by using
* x-width/2 and y-height/2 
*
* 3) Can you generalize the finding if the region we focus on is a w by h region
* and the center has a coordinate of the center is (x, y). What is the coordinate 
* of the upper left corner of that region?
* The upper left corner is (x-w/2,y-h/2) 
* 
* 
*/ 


public class TestFlip {
 public static void main(String [] args)
 {
   //Choose a picture file
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.show();  //show original picture
   Picture copy1 = new Picture(sourcePicture);  //creating two copies of Picture objects
   Picture copy2 = new Picture(sourcePicture); 
   
   copy1.flipVerticalRectangle(100,100,200,200); //flipVerticleRectangle method
   copy2.flipHorizontalRectangle(100,100,200,200); 
   
   copy1.show(); //show both copies
   copy2.show(); 
   
 
   
 }  
  
}