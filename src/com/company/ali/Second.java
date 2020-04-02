package com.company.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


    }

    public static void get(int[] arr) {
        List<List> list = new ArrayList<>();
        int a = 1;
        int m = arr.length;
        while (a <= m) {
            for (int i = 0; i < arr.length; i = i + a) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);

                list.add(list1);
            }
        }

    }
}
