
/**
 * Disco class, repesents four light bulbs.
 * 
 * @author Gilad Gur
 * @version 15/04/2016
 */

public class Disco
{
    // instance variables:
    private LightBulb _bulb1;
    private LightBulb _bulb2;
    private LightBulb _bulb3;
    private LightBulb _bulb4;
    
    // Constructor:
    /**
     * Constructor of the Disco class, receives 4 light bulbs.
     * Assumes the given bulbs are not null.
     * 
     * @param b1 The first light bulb.
     * @param b2 The second light bulb.
     * @param b3 The third light bulb
     * @param b4 The forth light bulb.
     */
    public Disco(LightBulb b1, LightBulb b2, LightBulb b3, LightBulb b4)
    {
        this._bulb1 = new LightBulb (b1);
        this._bulb2 = new LightBulb (b2);
        this._bulb3 = new LightBulb (b3);
        this._bulb4 = new LightBulb (b4);
        
                            // need 4 existing LightBulb objects to create new Disco object
    }                                   
    
    // Methods:
    /**
     * Returns the first LightBulb.
     * 
     * @return The first LightBulb.
     */
    public LightBulb getFirstBulb()
    {
        return new LightBulb (this._bulb1);
        
                            // user input in parentheses will be Disco object
    }                                    
    
    /**
     * Returns the second LightBulb. 
     * 
     * @return The second LightBulb.
     */
    public LightBulb getSecondBulb()
    {
        return new LightBulb (this._bulb2);
        
                            // user input in parentheses will be Disco object
    }                                     
    
    /**
     * Returns the third LightBulb. 
     * 
     * @return 
     */
    public LightBulb getThirdBulb()
    {
        return new LightBulb (this._bulb3);
        
                            // user input in parentheses will be Disco object
    }                                    
    
    /**
     * Returns the fourth LightBulb
     *  
     * @return The fourth LightBulb.
     */
    public LightBulb getFourthBulb()
    {
        return new LightBulb (this._bulb4);
                            
                            // user input in parentheses will be Disco object
    }                                    
    
    /**
     * Switches the state of the light bulb with the given index. 
     * 
     * @param num The index of the light bulb whose state will change.
     */
    public void switchBulb(int num)
    {
        final int FIRST  = 1;
        final int SECOND = 2;
        final int THIRD  = 3;
        final int FOURTH = 4;
        switch (num) 
        {
        case FIRST: this._bulb1.switchLight();
                break;
        case SECOND: this._bulb2.switchLight();
                break;
        case THIRD: this._bulb3.switchLight();
                break;
        case FOURTH: this._bulb4.switchLight();
                break;                    // cases 1,2,3,4 invokes switchLight method from LightBulb class
        default:
                break;                    // default case changes nothing
        }
    } 
    
    
    /**
     * Turns all the light bulbs on.
     */
    public void turnAllOn()
    {
        if (!this._bulb1.isSwitchedOn())
            this._bulb1.switchLight();
        if (!this._bulb2.isSwitchedOn()) 
            this._bulb2.switchLight();
        if (!this._bulb3.isSwitchedOn()) 
            this._bulb3.switchLight();
        if (!this._bulb4.isSwitchedOn()) 
            this._bulb4.switchLight();
                                        // this method assigns true state to all bulbs 
                                        // this method invokes isSwitchedOn & switchLight methods from LightBulb class
    }
    
    /**
     * Turns all the light bulbs off.
     */
    public void turnAllOff()
    {
        if (this._bulb1.isSwitchedOn())
            this._bulb1.switchLight();
        if (this._bulb2.isSwitchedOn()) 
            this._bulb2.switchLight();
        if (this._bulb3.isSwitchedOn()) 
            this._bulb3.switchLight();
        if (this._bulb4.isSwitchedOn()) 
            this._bulb4.switchLight();
                                        // this method assigns false state to all bulbs 
                                        // this method invokes isSwitchedOn & switchLight methods from LightBulb class
    }
    
    /**
     * Checks if all the light bulbs are on. 
     * 
     * @return true if all the light bulbs are on, otherwise false. 
     */
    public boolean areAllOn()
    {
        return (this._bulb1.isSwitchedOn() && this._bulb2.isSwitchedOn() && this._bulb3.isSwitchedOn() && this._bulb4.isSwitchedOn());
                                        
                                                                            // this method invokes isSwitchedOn method from LightBulb class
    }                                   
    
    /**
     * Checks if all the light bulbs are off. 
     * 
     *@return true if all the light bulbs are off, otherwise false.
     */
    public boolean areAllOff()
    {
        return (!this._bulb1.isSwitchedOn() && !this._bulb2.isSwitchedOn() && !this._bulb3.isSwitchedOn() && !this._bulb4.isSwitchedOn());
        
                                                                           // this method invokes isSwitchedOn method from LightBulb class
    }                                   
    
    /**
     * Checks if all the light bulbs have the same color.
     * 
     * @return true if all the light bulbs have the same color, otherwise false.
     */
    public boolean allSameColor()
    {
        return  this._bulb1.getColor().equals(this._bulb2.getColor()) &&
                this._bulb2.getColor().equals(this._bulb3.getColor()) &&
                this._bulb3.getColor().equals(this._bulb4.getColor()) ;
                                                                        // uses .equals method and not == , otherwise will always return false
                                                                        // this method invokes the getColor method from LightBulb class
    }                                                                   
}
