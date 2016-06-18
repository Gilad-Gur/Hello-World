
/**
 * This class represents a color, defined by its red, green and blue components.
 * 
 * @author Gilad Gur
 * @version 15/04/2016
 */
public class RGBColor {
    // instance variables:
    private int _red;
    private int _green;
    private int _blue;
    final int MAX_VAL = 255; // The maximum color value
    final int MIN_VAL = 0; // The minimum color value
    
    // constructors:
    /**
     * Construct a default black RGBColor (red = green = blue = 0)
     */
    public RGBColor() {
        this(0,0,0);
    }
    
    /**
     * Construct a new RGBColor with the given color component values.
     * @param red  The red color component value.
     * @param green  The green color component value.
     * @param blue  The blue color component value.
     */
    public RGBColor(int red, int green, int blue) {
        if (red>MAX_VAL||red<MIN_VAL||green>MAX_VAL||green<MIN_VAL||blue>MAX_VAL||blue<MIN_VAL)
        {
            this._red = 0;
            this._green = 0;
            this._blue = 0;
            
                            // constructs default black object
        } 
        else {
            this._red = red;
            this._green = green;
            this._blue = blue;
                                
                            // constructs new object with given user values
        } 
    }
    
    /**
    * Construct a new RGBColor which is a copy of the given color.
    * @param other  The RGBColor to copy.
    */
    public RGBColor(RGBColor other) {
        this._red = other._red; // copies red value to new object
        this._green = other._green; // copies red value to new object
        this._blue = other._blue; // copies red value to new object
    }
    
    // methods:
    /**
     *  Returns the red color component value of this RGBColor.
     *  @return The red color component value of this RGBColor.
     */
    public int getRed() {
        return this._red;
    }
    
    /**
     * Returns the green color component value of this RGBColor.
     * @return The green color component value of this RGBColor.
     */
    public int getGreen() {
        return this._green;
    }
    
    /**
     * Returns the blue color component value of this RGBColor.
     * @return The blue color component value of this RGBColor.
     */
    public int getBlue() {
        return this._blue;
    }
    
    /**
     * Sets the red color component value of this RGBColor.
     * If the given value is not legal (in the range 0-255) the color remains unchanged.
     * @param num  The red color component value to set.
     */
    public void setRed(int num) {
        if (num < MAX_VAL && num > MIN_VAL) // checking if new user value is valid
        
            this._red = num;
    }

    /**
     * Sets the green color component value of this RGBColor.
     * If the given value is not legal (in the range 0-255) the color remains unchanged.
     * @param num The green color component value to set.
     */
    public void setGreen(int num) {
        if (num < MAX_VAL && num > MIN_VAL) // checking if new user value is valid
        
            this._green = num;
    }
    
    /**
     * Sets the blue color component value of this RGBColor.
     * If the given value is not legal (in the range 0-255) the color remains unchanged.
     * @param num The blue color component value to set.
     */
    public void setBlue(int num) {
        if (num < MAX_VAL && num > MIN_VAL) // checking if new user value is valid
        
            this._blue = num;
    }
    
    /**
     * Returns a string representation of this RGB triplet.
     * For example (255,127,0).
     * @return String representation of this RGB triplet.
     */
    public String toString() {
        return "(" + this._red + "," + this._green + "," + this._blue + ")"; 
        
                                                                            // printing the object's values in a string (_red,_green,_blue)
    } 
    
    /** 
     * Compares this and other color.
     * Returns true if this and other are the same RGBcolor, i.e. have the same red, green and blue components. 
     * Assumes the given bulb is not null. 
     * @return true if the RGBColors are equal, otherwise false.
     */
    public boolean equals(RGBColor other){
        if(this._red==other._red&&this._green==other._green&&this._blue==other._blue) // 2 objects are equal            
            return true;        
        else                // 2 objects NOT equal        
            return false;
    }
    
    /**
     * Changes this color to be a mix of this and other RGBColors.
     * The mixed color is simply the average (over the red, green and blue components) of this and other colors.
     * In case the average is fractional (e.g. 113.5) you should take only the integer part as the new value (e.g. 113).
     * For example if this color is red - (255,0,0) and other color is green - (0,255,0) after mix operation this 
     * color will be yellow = (127,127,0).
     * Assumes the given bulb is not null.
     * @param other The other color.
     */
    public void mix (RGBColor other) {
        this._red = (this._red + other._red)/2;          // average of the 2 reds
        this._green = (this._green + other._green)/2;    // average of the 2 greens
        this._blue = (this._blue + other._blue)/2;       // average of the 2 blues
    }
    
    /**
     * Returns the grayscale value of this RGBColor.
     * The grayscale value is defined as 30% the red value + 59% of the green value and 11% of the blue value. 
     * @return The grayscale value of this RGBColor.
     */
    public double convertToGrayscale() {
        final double PER_RED = 0.3;           // 30 percent of red value
        final double PER_GREEN = 0.59;      // 59 percent of green value
        final double PER_BLUE = 0.11;        // 11 percent of blue value
        final double GRAY = ((this._red*PER_RED) + (this._green*PER_GREEN) + (this._blue*PER_BLUE));
        return GRAY;
    }
    /**
     * Inverts the color of this RGBColor, by replacing each component value with its complement relative to 255.
     * For example, RGB values of (0,1,2) would be changed to (255,254,253).
     */
    public void invert() {
        this._red=(MAX_VAL-this._red);      // new complement value of red 
        this._green=(MAX_VAL-this._green);  // new complement value of green
        this._blue=(MAX_VAL-this._blue);    // new complement value of blue
    }
}