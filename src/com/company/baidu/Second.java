package com.company.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 2 || n > 50) {
            throw new Exception("input incorrect");
        }
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] < 1 || arr[i] > Math.pow(10,10)){
                throw new Exception("input incorrect");
            }
        }

        Arrays.sort(arr);

        System.out.println(find(count,n,arr));

    }

    public static int find(int count, int n, int[] arr) {
//        if(arr[0] < n) {
//
//        }
        do{
            count = count + 1;
            for (int i = 0; i < n; i++) {
                if(i == (n - 1)) {
                    arr[i] = arr[i] - n;
                }else {
                    arr[i] = arr[i] + 1;
                }


////
//                for (int j = 0; j < n; j++) {
//                    System.out.println(j+" "+arr[j]);
//                }

            }
            Arrays.sort(arr);
            if(arr[n - 1] < n) {
                return count;
            }



        }while (true);
    }
}
