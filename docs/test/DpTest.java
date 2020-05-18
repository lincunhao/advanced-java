package com.lch;

public class DpTest {

    public static int f(int n) {
        if (n < 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(f(10));
    }

}
