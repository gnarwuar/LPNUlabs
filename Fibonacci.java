package LR1;

import java.util.*;

public class Fibonacci {
    /**
     * @param args
     */
    int n;

    public static int fib(int n) {
        int array[] = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int k = 2; k < n; k++)
            array[k] = array[k - 1] + array[k - 2];
        return array[n - 1];
    }

    public static void main(String args[]) {
        System.out.print("Type a sequence number of Fibonacci number, that you want printed: ");
        Scanner snr = new Scanner(System.in);
        int n = snr.nextInt();
        snr.close();
        System.out.print("Fibonacci number is: ");
        System.out.println(fib(n));
        if (fib(n) < Math.pow(1.75, n))

        {
            /**
             * Перевірка умови заданої в лабораторній роботі
             */
            System.out.print("Fn<1.75^n is true");
        } else {
            System.out.print("Fn<1.75^n is false");
        }
    }
}
