/**
 *  This class represents an image using a 2 dimensional array of RGBColor objects.
 *  In an image with n rows and m columns, the rows are numbered from 0 to n-1 and the columns are 
 *  numbered from 0 to m-1.
 *  Each pixel represents the color in that coordinate.
 *  
 * @author Gilad Gur
 * @version 11/06/16
 */

public class RGBImage
{
    // Instance variable:
    private RGBColor[][] _image; 
    
    // Final variables:
    final int ZERO = 0;
    final int ONE = 1;

    // Constructors:
    /**
     * This constructor creates a new black image the size of rows and columns values it accepts as parameter.
     * Assumes that rows and cols are positive.
     * 
     * @param rows The rows value.
     * @param cols The columns value.
     */
    public RGBImage(int rows, int cols)
    {
        _image = new RGBColor[rows][cols]; // Initializing new 2D RGBImage to given height and width parameters
        
        for(int i = ZERO; i < rows; i++)
        {
            for(int j = ZERO; j < cols; j++)
            {
                _image[i][j] = new RGBColor(); // initializing every pixel to black color value
            }
        }
    }
    
    /**
     * This constructor creates a new image, identical to the 2D pixels array it accepts as parameter.
     * Assumes that the Array pixels is not null and that rows and columns are positive.
     * 
     * @param pixel An array of pixels.
     */
    public RGBImage(RGBColor[][] pixels) 
    {        
        _image = new RGBColor[pixels.length][pixels[0].length]; // new Image initialized to 2Dpixel array size
        
        for (int i = ZERO; i < pixels.length; i++)
        {
            for (int j = ZERO; j < pixels[0].length; j++)
            {
                _image[i][j] = new RGBColor(pixels[i][j]); // initializing every pixel to the same as 2D RGBColor array
            }
        }
    }
    
    /**
     * This constructor accepts an RGBimage object as parameter and creates a copy of it.
     * 
     * @param other The RGBImage object to copy.
     */
    public RGBImage(RGBImage other) 
    {
        this(other._image); // utilizes RGBImage(RGBColor[][] pixels) constructor
    }
    
    // Methods:
    /**
     * This method returns the height (number of rows) of the RGBImage 2D array.
     * 
     * @return The height of the image in pixels.
     */
    public int getHeight() 
    {
        return _image.length; // returns number of rows of 2D array 
    }
   
    /**
     * This method returns the width (number of columns) of the RGBImage 2D array.
     * 
     * @return The width of the image in pixels.
     */
    public int getWidth() 
    {
        return _image[0].length; // returns number of cols of 2D array
    }
    /**
     * This method returns the pixel in the row and column coordinate parameters it accepts.
     * If coordinate is out of bounds the method returns a black pixel.
     * 
     * @param row The row number of the pixel coordinate.
     * @param col The column number of the pixel coordinate.
     */
    public RGBColor getPixel(int row, int col)
    {
        if ((row >= getHeight()) || (row < ZERO) || (col >= getWidth()) || (col < ZERO))
        {
            return new RGBColor(); // returns black pixel because requested parameter is out of bounds
        }
        return new RGBColor (_image[row][col]); // returns requested parameter
    }
    
    /**
     * This method accepts an image coordinate and an RGBColor object, 
     * and sets this pixel into the given coordinate.
     * Method works only if the coordinate is in bounds.
     * 
     * @param row The row number of the image coordinate.
     * @param col The column number of the image coordinate.
     * @param pixel The RGBColor object to be set into given image coordinate.
     */
    public void setPixel (int row, int col, RGBColor pixel)
    {
        if ((row < getHeight()) && (row >= ZERO) && (col < getWidth()) && (col >= ZERO)) // check if search is inbounds
            _image[row][col] = new RGBColor(pixel);
    }
    
    /**
     * This method accepts an RGBImage object as parameter and returns true if both objects are 
     * identical.
     * 
     * @param other RGBImage object to compare if objects values are the same.
     * 
     * @return true if the RGBImages are equal, otherwise false.
     */
    public boolean equals (RGBImage other)
    {
        if (!(getHeight() == other.getHeight()) || !(getWidth() == other.getWidth()))  // check size equality of this Image and Image parameter
        {
            return false;       //  size of Images NOT equal
        }
        for (int i = ZERO; i < getHeight(); i++) 
        {
            for (int j = ZERO; j < getWidth(); j++) 
            {
                if (!_image[i][j].equals(other.getPixel(i, j)))  
                // check for each of this Object's pixel in i'th & j'th position if NOT equal to parameter's pixel
                {
                    return false; // not same Image values
                }
            }
        }
        return true; // the 2 Images have the same values
    }
    
    /**
     * This method flips the image on its horizontal axis.
     * 1'st column becomes last column, 2'nd column becomes 2'nd last column etc.
     */
    public void flipHorizontal()
    {
        RGBColor[][] horizontalFlip = new RGBColor[getHeight()][getWidth()]; // creating new 2D RGBColor array to be set for horizontal flip

        for (int i = ZERO; i < horizontalFlip.length; i++) 
        {
            for (int j = ZERO; j < horizontalFlip[i].length; j++) 
            {
                horizontalFlip[i][j] = _image[i][getWidth()- ONE - j];  // setting new 2D array to the horizontal flipped Image 
            }
        }       
        _image = horizontalFlip;        //  setting this Image 2D array var to the values of new flipped 2D array
    }

    /**
     * This method flips the image on its vertical axis.
     * 1'st row becomes last row, 2'nd row becomes 2'nd last row etc.
     */
    public void flipVertical()
    {
        RGBColor[][] verticalFlip = new RGBColor[getHeight()][getWidth()];  // creating new 2D RGBColor array to be set for vertical flip
        
        for (int i = ZERO; i < verticalFlip.length; i++) 
        {
            for (int j = ZERO; j < verticalFlip[i].length; j++) 
            {
                verticalFlip[i][j] = _image[getHeight()- ONE - i][j];  // setting new 2D array to the vertical flipped Image
            }  
        }          
        _image = verticalFlip;    //  setting this Image 2D array var to the values of new flipped 2D array
    }
    
    /**
     * This method Inverts the color of each pixel of the image 
     * by replacing each component value with its complement, relative to 255.
     * For example, RGB values of (0,1,2) would be changed to (255,254,253).
     */
    public void invertColors()
    {
        for(int i = ZERO; i < getHeight(); i++)
        {
            for(int j = ZERO; j < getWidth(); j++)
            {
               _image[i][j].invert();   // using the invert RGBColor method for each pixel of the Image
            }
        }
    }
    
    /**
     * This method rotates the image 90 degrees clockwise.
     * This method might change the image dimensions if row and column values are not equal.
     */
    public void rotateClockwise()
    {
        RGBColor[][] clockwised = new RGBColor[getWidth()][getHeight()];    //   creating new 2D RGBColor array to be rotated
         for(int i = ZERO; i < clockwised.length; i++)
        {
            for(int j = ZERO; j < clockwised[0].length; j++)
            {
               clockwised[i][j] = toRGBColorArray()[getHeight() - ONE - j][i];  //  setting new 2D array to rotated Image
            }
        }
        _image = clockwised; //  setting this Image 2D array var to the values of new rotated 2D array
    }
    
    /**
     * This method rotates the image 90 degrees counterclockwise.
     * This method might change the image dimensions if row and column values are not equal.
     */
    public void rotateCounterClockwise()
    {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();        // executes rotateClockwise method 3 times
    }
    
    /**
     * This method shifts the image right (if positive parameter given) 
     * or left (if negative parameter given).
     * Column num. 0 becomes column num. offset, column num. 1 becomes column num. offset + 1 etc.
     * Offset can be either negative or positive.
     * The columns that have been moved to a new position will turn black.
     * If offset value is greater than num of columns, no action is taken.
     * If offset value equals 0, no action is taken.
     * If offset value equals to num of columns, image turns all black.
     * 
     * @param offset The number of columns to shift left or right.
     */
    public void shiftCol (int offset)
    {
        if (offset == ZERO || Math.abs(offset) > getWidth()) // check if parameter is legal to shift Image
        {
            return;     // parameter illegal
        }
        if (offset > ZERO)  //  moving Image right 
        {
            for(int j = getWidth() - ONE; j >= ZERO; j--)
            {
                for(int i = ZERO; i < getHeight(); i++)
                {
                    if (j - offset >= ZERO) 
                    {
                        _image[i][j] = _image[i][j-offset];
                    }
                    else
                    {
                        _image[i][j] = new RGBColor(); // setting moved pixels to black color
                    }
                }    
            }
        }
        else  // offset is negative so moving Image left
        {
            for(int j = ZERO; j <= getWidth() - ONE; j++)
            {
                for(int i = ZERO; i < getHeight(); i++)
                {
                    if (j - offset < getWidth()) 
                    {
                        _image[i][j] = _image[i][j-offset];
                    }
                    else
                    {
                        _image[i][j] = new RGBColor();    // setting moved pixels to black color
                    }
                }    
            }         
        } 
    }

    /**
     * This method shifts the image down (if positive parameter given) 
     * or up (if negative parameter given).
     * Row num. 0 becomes row num. offset, row num. 1 becomes row num. offset + 1 etc.
     * Offset can be either negative or positive.
     * The rows that have been moved to a new position will turn black.
     * If offset value is greater than num of rows, no action is taken.
     * If offset value equals 0, no action is taken.
     * If offset value equals to num of rows, image turns all black.
     * 
     * @param offset The number of rows to shift down or up.
     */
    public void shiftRow(int offset) 
    {
        if (offset == ZERO || Math.abs(offset) > getHeight()) // check if parameter is legal to shift Image
        {
            return;       //  parameter illegal
        }
        if (offset > ZERO)  // moving Image down
        {
            for(int i = getHeight() - ONE; i >= ZERO; i--)
            {
                for(int j = ZERO; j < getWidth(); j++)
                {
                    if (i - offset >= ZERO) 
                    {
                        _image[i][j] = _image[i - offset][j];
                    }
                    else
                    {
                        _image[i][j] = new RGBColor();    // setting moved pixels to black color
                    }
                }    
            }
        }
        else  // offset is negative so moving Image up
        {
            for(int i = ZERO; i <= getHeight() - ONE; i++)
            {
                for(int j = ZERO; j < getWidth(); j++)
                {
                    if (i - offset < getHeight()) 
                    {
                        _image[i][j] = _image[i - offset][j];
                    }
                    else
                    {
                        _image[i][j] = new RGBColor();    // setting moved pixels to black color
                    }
                }    
            }         
        } 
    }
    
    /**
     * This method returns the grayscale value of this RGBImage.
     * The grayscale value is defined as 30% the red value + 59% of the green value and 11% of the blue value
     * of each pixel in the 2D array. 
     *
     * @return The grayscale value of this RGBImage.
     */
    public double[][] toGrayscaleArray() 
    {
        double[][] grayScaled = new double[getHeight()][getWidth()];   // creating new 2D array the size of this object to be set to gray
        for (int i = 0; i < getHeight(); i++) 
        {
            for (int j = 0; j < getWidth(); j++) 
            {
                grayScaled[i][j] = _image[i][j].convertToGrayscale();  // invoking RGBColor convertToGrayscale() method for each pixel in Image
            }
        }
        return grayScaled;   // return the new gray Image
    }
    
    /**
     * This method returns a string representation of this RGBImage.
     * 
     * @return String representation of this RGBImage.
     */
    public String toString()
    {
        String imageString = "";
        for (int i = 0; i < getHeight(); i++) 
        {
            for (int j = 0; j < getWidth(); j++) 
            {
                if (j != getWidth() - 1) 
                {
                    imageString += _image[i][j].toString() + " "; // using the RGBColor toString method for each pixel in Image 
                } 
                else 
                {
                    imageString += _image[i][j].toString() + "\n"; // starting a new line every row
                }
            }
        }
        return imageString;
    }
    /**
     * This method returns a copy of the pixels array.
     */
    public RGBColor[][] toRGBColorArray()
    {
        RGBColor[][] copyOfArray = new RGBColor[getHeight()][getWidth()]; // creating new 2D RGBColor array and copies this object size
        for (int i = 0; i < getHeight(); i++) 
        {
            for (int j = 0; j < getWidth(); j++) 
            {
                copyOfArray[i][j] = new RGBColor(_image[i][j]); // initializing each pixel in new 2D array to same pixel value of this Image object
            }
        }
        return copyOfArray;
    }
}