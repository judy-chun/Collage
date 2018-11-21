/* Filename: TestCollage.java 
* Created by: Judy Chun, cs8afug 
* Date: 11/05/17
* Consider the following 3x3 Picture, each Pixel labeled 1-9.
* | 1 | 2 | 3 |
* | 4 | 5 | 6 |
* | 7 | 8 | 9 | 
* 1) Place the new location for each pixel if the Picture is flipped:
*  horizontally           vertically
* | 3  | 2  | 1  |          | 7  | 8  | 9  |
* | 6  | 5  | 4  |          | 4  | 5  | 6  |
* | 9  | 8  | 7  |          | 1  | 2  | 3  | 
* 2) When should you stop looping when performing a horizontal flip? How about
*    vertical?
* Stop looping when width/2 (horizontal flip)
* Stop looping when height/2 (vertical flip)
* 
*
* 3) If you wanted to place two 3x3 Picture side-by-side into a canvas, 
*    what width and height should destination canvas have?
* 6 by 3 destination canvas 
* 
* 
*/ 


/*I've given you a basic skeleton of how your code is going to look so you can get a basic idea of the workflow here*/
public class TestCollage {
 public static void main(String [] args)
 {
   //Choose a picture file
   String sourceFile = FileChooser.pickAFile(); //choose photo from media resources directory
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.show();   //show the original picture 
   int width = sourcePicture.getWidth()*3; 
   int height = sourcePicture.getHeight(); 
   Picture canvas = new Picture(width, height);   //create a canvas that is the same height, but 3x as wide
   Picture copy1 = new Picture(sourcePicture); //copy the original picture twice, so you have 3 picture objects 
   Picture copy2 = new Picture(sourcePicture); 

   
   //Call your transformtions here;
   sourcePicture.flipHorizontal();  //flip horizontal method 
   sourcePicture.show();    //display modified picture 
   
   copy1.flipVertical();    //flip vertical method 
   copy1.show();
   
   copy2.grayscale();       //grayscale method 
   copy2.show(); 
   
   Picture [] pictures = new Picture[3];   //creates empty array that store references to 3 Picture objects 
   pictures[0] = sourcePicture;  //set each position in the array to refer to 3 picture objects 
   pictures[1] = copy1;
   pictures[2] = copy2;
   canvas.collage(pictures);   //use canvas object to call collage(Picture [] pictures)
   canvas.show();  //show canvas with complete collage on it 
   
 }
 
}