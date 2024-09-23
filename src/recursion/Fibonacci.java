package recursion;

import java.util.Scanner;

public class Fibonacci {

    public static void Fibonacci(int fim) {
        int A = 0;
        int B = 1;

        Fibonacci(A, B, fim);
    }

    public static void Fibonacci(int A, int B, int fim) {
        if (fim == 0) {
            return;
        }
        int aux = A;
        System.out.print(aux + " ");
        A = B;
        B = aux + A;
        fim--;

        Fibonacci(A, B, fim);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fibonacci(15);

        sc.close();
    }

}
