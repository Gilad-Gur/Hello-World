
/**
 * A program that calculates the area and perimeter of a triangle.
 * The calculation is done according to Heron's formula.
 * Heron's formula states that the area of a triangle whose sides have lengths a, b, and c is: 
 * Area = The square root of [s*(s-a)*(s-b)*(s-c)]
 * where s is the semiperimeter of the triangle; Semiperimeter = (a+b+c) / 2
 * 
 * @Gilad Gur 
 * @27/03/2016
 */
import java.util.Scanner; // Importing the Scanner library
public class Triangle // Creating the class Triangle
{
    public static void main (String [] args) // Creating the main method
    {
        Scanner scan = new Scanner (System.in); // Creating a scanner constructer
        System.out.println ("This program calculates the area " +
        "and the perimeter of a given triangle. "); // Greeting and explanation message for user
        System.out.println ("Please enter the three lengths of the " +
        "triangle's sides"); // Printing out user instructions
        int a = scan.nextInt(); // Creating variable for first side of the triangle according to user input
        int b = scan.nextInt(); // Creating variable for second side of the triangle according to user input
        int c = scan.nextInt(); // Creating variable for third side of the triangle according to user input
        int trianglePerimeter = (a+b+c); // the length total of the sides of the triangle 
        double s = (trianglePerimeter)/2.0;// s variable represents the Semiperimeter of the triangle
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c)); // calculating the area of the triangle by Heron's formula
        if (a+b<=c||a+c<=b||b+c<=a||a<=0||b<=0||c<=0)// conditions of valid triangle sides lengths
            System.out.println("Invalid triangle side length"); // Error message and program finish
        else // if triangle sides length is valid
        {
            System.out.println("The triangle perimeter is: " + trianglePerimeter); // Printing out the triangle's perimeter
            System.out.println("The area of the triangle is: " + area); // Printing out the triangle's area
        }
    }
}
