package com.company.ali;

import java.util.Arrays;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int k = 0;
        int arr[] = new int[0];

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        check(n,m,k,arr);

        arr = get(arr,k,m);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i];
        }
        System.out.println(res);


    }

    public static int[] get(int[] arr, int k, int m) {
        int a = 0;
        while (a < m) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + k;
            }
            Arrays.sort(arr);
            arr[arr.length - 1] = arr[arr.length - 1] / 2;
            a ++;
        }
        return arr;
    }

    public static void check(int n, int m, int k, int[] arr) throws Exception {
        if(m < 1 || m > 100000) {
            throw new Exception("input correct");
        }
        if(n < 1 || n > 100000) {
            throw new Exception("input correct");
        }
        if(k < 1 || k > 100000) {
            throw new Exception("input correct");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 1 || arr[i] > 100000){
                throw new Exception("input incorrect");
            }
        }
    }
}
