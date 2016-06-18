
/**
 * This program imitates the famous Einstein math game.
 * Asking the user for a 3 digit positive number whose first and last digits are different.
 * Reverseing the number (example: if user input 234 - then new number is 432).
 * Calculating both numbers absolute difference (example: |234 - 432| = |-198| = 198).
 * Reversing the new number as well (example: 198 becomes 891)
 * Adding the last two numbers, it should always give the result of 1089 (example: 198 + 891 = 1089).
 * Message output according to procedure's success or failure.
 * @Gilad Gur
 * @29/03/2016
 */
import java.util.Scanner; // Importing the Scanner library
public class Einstein // Creating the class Einstein
{
    public static void main (String[]args) // Creating the main method
    {
        Scanner scan=new Scanner(System.in); // Creating scanner constructer
        System.out.println("Welcome to the Einstein magic game."); // Greeting message to user
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different:"); // User instructions
        int num1 = scan.nextInt(); // Declaring and creating the first number according to user input
        if (num1 > 999 || num1 < 100) // Checking if user input number is really a 3 digit number
            System.out.println("The number you entered is not a 3 digit positive number ");// Error message and program finish
        else // If user input number is valid
        {
            System.out.println("User number is: " +num1); // Acknowledgment message
            int onesNum1 = num1%10; // Seperating the ones digit in order to turn the number around
            int tensNum1 = num1/10%10; // Seperating the tens digit in order to turn the number around
            int hundredsNum1 = num1/100; // Seperating the hundreds in order to turn the number around
            if (onesNum1==hundredsNum1) // Checking if first and last digits are the same
                System.out.println("Invalid number. First and last digits are the same."); // error message and program finish
            else // if user input number is valid
            {
                int num2 = (onesNum1*100) + (tensNum1*10) + (hundredsNum1); // Creating the second number with opposite numbers
                int dif = Math.abs(num1-num2); // Creating the absolute difference number
                System.out.println("Difference: " + dif); // Announcement for the user about the difference number
                int onesDif = dif%10; // Seperating the ones digit in order to turn the difference number around
                int tensDif = dif/10%10; // Seperating the tens digit in order to turn the difference number around
                int hundredsDif = dif/100; // Seperating the hundreds digit in order to turn the difference number around
                int revDif = (onesDif*100) + (tensDif*10) + (hundredsDif); // Declaring and creating last number - the reversed difference
                System.out.println("Reversed difference: " + revDif); // Telling the user what the reversed number is
            if (revDif+dif==1089) // Checking if last two numbers add up to 1089
                System.out.println("Successfull"); // Success message to user
            else // if the last two number don't add up to 1089
                System.out.println("Failure"); // failure message to user
            }
        }
    }
}
