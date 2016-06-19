import java.util.Scanner;
/**
 * This is a program that represents the Fibonacci sequence. It uses no arrays or String, only a simple loop.
 * The method gets an integer parameter, to represent the n'th Fibonacci number 
 * (examples: if n=3 => return 2, because 2 is the 3rd Fibo number. If n=7 => return 13, because 13 is the 7th Fibo number)
 * 
public class Fibonacci
{
    public static long fibo (int n) {
        if (n > 0) {
            if(n==1 || n==2)
                return 1;
            if (n >= 3) {
                long m = 2;
                long x = 1;
                long y = 1;
                for(int i=3; i <= n; i++) {
                    m = y + x;
                    x = y;
                    y = m;
                }
                return m;
            }
        }
        return 0;
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter the fibonacci sequence number:");
        int n = scan.nextInt();
        System.out.println("the value of fibo-n is: " + fibo(n));
    }
}
