package com.company.baidu;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;

        while (i <= n) {

        }
    }

    public static int getGongBei(int a, int b) {
        int n = Math.max(a, b);

        for (int i = n; ; i++) {
            if(i % a == 0 && i % b == 0) {
                n = i;
                break;
            }
        }

        return n;
    }

    public static int getGongYue(int a, int b) {
        int n = Math.min(a, b);

        for (int i = n; i >= 0; i--) {
            if(a % i == 0 && b % i == 0) {
                n = i;
                break;
            }
        }

        return n;
    }
}
