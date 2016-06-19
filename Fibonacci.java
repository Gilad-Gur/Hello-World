import java.util.Scanner;

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
        System.out.println("Please enter the fibonacci sequance number:");
        int n = scan.nextInt();
        System.out.println("the value of fibo-n is: " + fibo(n));
    }
}
