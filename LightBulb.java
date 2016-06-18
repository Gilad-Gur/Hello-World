
/**
 * Class LightBulb, consists of a color and state which defines if the bulb is switched on or off.
 * 
 * @author Gilad Gur
 * @version 15/04/2016
 */
public class LightBulb
{
    // Instance variables:
    private RGBColor _color;
    private boolean _switchedOn;
    final int MAX_VAL = 255;
    final int MIN_VAL = 0; 
    // Constructors:
    /**
     * Construct a new LightBulb with the given color component values.
     * The switch is initialized to false.
     * If one (or more) of the given values is illegal (not in the range 0-255), 
     * it constructs a black RGBColor object. 
     * 
     * @param red The red color component value.
     * @param green The green color component value.
     * @param blue The blue color component value.
     */
    public LightBulb(int red, int green, int blue)
    {
        if (red>MAX_VAL||red<MIN_VAL||green>MAX_VAL||green<MIN_VAL||blue>MAX_VAL||blue<MIN_VAL)
        {
            this._color = new RGBColor();
                                                            // color values will be red=green=blue=0 (default black RGBColor)
        } 
        else
        {
            this._color = new RGBColor (red, green, blue);
                                                            // color values will be user input
        } 
        this._switchedOn = false;
    }
    
    /**
     * Construct a new LightBulb with a given color.
     * The switch is initialized to false.
     * Assumes the given color is not null. 
     * 
     * @param other The RGBColor to copy.
     */
    public LightBulb (RGBColor color)
    {
        this._color = new RGBColor(color);
        this._switchedOn = false;
                                                    // creates a lightBulb object with the color values of a RGBColor object, so need to exist a RGBColor object
    } 
        
    /**
     * Construct a new LightBulb which is a copy of the given bulb.
     * Assumes the given bulb is not null. 
     * 
     * @param other The LightBulb to copy.
     */
    public LightBulb (LightBulb other)
    {
        this._color = new RGBColor (other._color);
        this._switchedOn = false;
                                                    // creates a lightBulb object with the color values of a LightBulb object
    } 
    
    // Methods:
    /**
     * Returns the color component of this bulb.
     *   
     * @return The color component of this bulb.
     */
    public RGBColor getColor()
    {
        return new RGBColor (this._color);
                                                    // gets the color values of this LightBulb object
    } 
    
    /**
     * Sets the color component of this LightBulb.
     * 
     * @param color The color component to set.
     */
    public void setColor (RGBColor color)
    {
        this._color = new RGBColor(color);
                                                    // new color of LightBulb object will be user input
    } 
    
    /**
     * Returns true if this bulb is switched on.
     * Otherwise, returns false.
     * 
     * @return true if the bulb is switched on.
     */
    public boolean isSwitchedOn()
    {
        return this._switchedOn;
                                                    // LightBulb status - true for on & false for off
    } 
    
    /**
     * Changes the switch situation from true to false and vice versa.
     */
    public void switchLight()
    {
        this._switchedOn = !this._switchedOn;
                                                    // will switch the object's on/off status
    }  
    
    /**
     * Returns a string representation of this LightBulb.
     * For example (255,127,0) On
     * 
     * @return A string representation of this LightBulb.
     */
    public String toString()
    {
        String onOff;
        if  (isSwitchedOn()==true)
        {
            onOff = "On";
        }
        else 
        {
            onOff = "Off";
        }
        return  this._color + " " + onOff ;
        
                                                //  gets parentheses of color values from toString method in RGBColor class
                                                // prints color values and on/off status in a string
    }    
        
}
